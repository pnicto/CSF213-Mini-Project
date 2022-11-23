import {
  Button,
  Center,
  Container,
  Group,
  Loader,
  Stack,
  Title,
} from "@mantine/core";
import { useMutation, useQuery } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import CartItemCard from "../components/display/CartItemCard";
import { useNotificationStore } from "../store/notificationStore";
import { CustomerCart } from "../types/interfaces";

const Cart = () => {
  const notificationStore = useNotificationStore();
  const { data: cartData, isLoading } = useQuery(["cart"], () =>
    axios.get<CustomerCart>(
      `${import.meta.env.VITE_APP_BACKEND_URL}/customers/cart`
    )
  );

  const clearCartMutation = useMutation(
    () => {
      return axios.delete(
        `${import.meta.env.VITE_APP_BACKEND_URL}/customers/cart/clear`
      );
    },
    {
      onSuccess: (data) => {
        notificationStore.successNotification("Cleared cart successfully");
      },

      onError: (data: AxiosError) => {
        notificationStore.errorNotification(
          data.message,
          "Clearing cart failed"
        );
      },
    }
  );

  if (isLoading) {
    return (
      <Center h={"80vh"}>
        <Loader size={"md"} />
      </Center>
    );
  } else {
    const { cartItems, totalPrice, totalQuantity } = cartData!.data;
    return (
      <Container mb={"xl"}>
        <Group position="apart" mb={"md"}>
          <Title>Your cart</Title>
          <div>
            <Title order={3}>Total price: &#8377;{totalPrice.toFixed(2)}</Title>
            <Title order={3}>Total quantity: {totalQuantity}</Title>
          </div>
        </Group>

        <Stack>
          {cartItems.map((cartItem) => {
            const { product, quantity, id } = cartItem;

            return (
              <CartItemCard product={product} quantity={quantity} key={id} />
            );
          })}
        </Stack>
        <Group mt={"lg"} position="right">
          <Button
            color={"red"}
            onClick={() => {
              clearCartMutation.mutate();
            }}
          >
            Clear cart
          </Button>
          <Button color={"green"}>Checkout</Button>
        </Group>
      </Container>
    );
  }
};

export default Cart;
