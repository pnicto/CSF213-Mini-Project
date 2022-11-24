import {
  Button,
  Center,
  Container,
  Group,
  Loader,
  Stack,
  Title,
} from "@mantine/core";
import { openConfirmModal } from "@mantine/modals";
import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import CartItemCard from "../components/display/CartItemCard";
import { useNotificationStore } from "../store/notificationStore";
import { Customer, CustomerCart } from "../types/interfaces";

const Cart = () => {
  const notificationStore = useNotificationStore();

  const cartDataQuery = useQuery(["cart"], () =>
    axios.get<CustomerCart>(
      `${import.meta.env.VITE_APP_BACKEND_URL}/customers/cart`
    )
  );
  const profileDataQuery = useQuery(["customerProfile"], () =>
    axios.get<Customer>(`${import.meta.env.VITE_APP_BACKEND_URL}/customers`)
  );

  const queryClient = useQueryClient();

  const clearCartMutation = useMutation(
    () => {
      return axios.delete<CustomerCart>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/customers/cart/clear`
      );
    },
    {
      onSuccess: (data) => {
        notificationStore.successNotification("Cleared cart successfully");
        queryClient.setQueryData(["cart"], data);
      },

      onError: (data: AxiosError) => {
        notificationStore.errorNotification(
          data.message,
          "Clearing cart failed"
        );
      },
    }
  );

  const checkoutMutation = useMutation(
    () => {
      return axios.post<CustomerCart>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/customers/cart/checkout`
      );
    },
    {
      onSuccess: (data) => {
        cartDataQuery.refetch();
        notificationStore.successNotification("Order placed successfully!");
      },

      onError: (data: AxiosError) => {
        notificationStore.errorNotification(
          data.message,
          "Placing order failed"
        );
      },
    }
  );

  const handleCheckout = (totalPrice: number) => {
    profileDataQuery.refetch();

    if (
      profileDataQuery.data &&
      profileDataQuery.data.data.moneyInWallet < totalPrice
    ) {
      notificationStore.errorNotification(
        "Insufficient money in wallet",
        "Placing order failed!"
      );
    } else {
      openConfirmModal({
        title: "Confirm order?",
        labels: {
          confirm: "Yes",
          cancel: "No",
        },
        centered: true,
        confirmProps: {
          color: "green",
        },
        cancelProps: {
          color: "red",
        },
        children: (
          <>
            <Title order={4}>
              Wallet balance: {profileDataQuery.data?.data.moneyInWallet}
            </Title>
            <Title order={4}>Total price: &#8377;{totalPrice}</Title>
          </>
        ),
        onConfirm: () => {
          checkoutMutation.mutate();
        },
      });
    }
  };

  if (cartDataQuery.isLoading) {
    return (
      <Center h={"80vh"}>
        <Loader size={"md"} />
      </Center>
    );
  } else {
    const { cartItems, totalPrice, totalQuantity } = cartDataQuery.data!.data;
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
          {cartItems.length === 0 && (
            <Center>
              <Title color={"blue.3"}>Cart is empty</Title>
            </Center>
          )}
          {cartItems.map((cartItem) => (
            <CartItemCard cartItem={cartItem} key={cartItem.id} />
          ))}
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
          <Button
            color={"green"}
            onClick={() => {
              handleCheckout(totalPrice);
            }}
          >
            Checkout
          </Button>
        </Group>
      </Container>
    );
  }
};

export default Cart;
