import { Center, Container, Group, Loader, Stack, Title } from "@mantine/core";
import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import CartItemCard from "../components/display/CartItemCard";
import { CustomerCart } from "../types/interfaces";

const Cart = () => {
  const { data: cartData, isLoading } = useQuery(["cart"], () =>
    axios.get<CustomerCart>(
      `${import.meta.env.VITE_APP_BACKEND_URL}/customers/cart`
    )
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
      <Container>
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
      </Container>
    );
  }
};

export default Cart;
