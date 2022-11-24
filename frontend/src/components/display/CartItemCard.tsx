import {
  ActionIcon,
  Anchor,
  Container,
  Flex,
  Image,
  Paper,
  Stack,
  Text,
  Title,
} from "@mantine/core";
import { IconTrash } from "@tabler/icons";
import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { Link } from "react-router-dom";
import { useNotificationStore } from "../../store/notificationStore";
import { CartItem, CustomerCart } from "../../types/interfaces";

type Props = {
  cartItem: CartItem;
};

const CartItemCard = ({ cartItem }: Props) => {
  const { product, quantity } = cartItem;
  const { name, price, imageUrl } = product;
  const notificationStore = useNotificationStore();
  const queryClient = useQueryClient();

  const deleteCartItemMutation = useMutation(
    () => {
      return axios.delete<CustomerCart>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/customers/cart/${cartItem.id}`
      );
    },
    {
      onSuccess: (data) => {
        notificationStore.successNotification("Deleted item successfully");
        queryClient.setQueryData(["cart"], data);
      },

      onError: (data: AxiosError) => {
        notificationStore.errorNotification(data.message, "Cannot delete item");
      },
    }
  );

  return (
    <Paper withBorder shadow={"md"} p={"xl"}>
      <Flex direction={"row"} justify="space-between" align={"center"}>
        <Image
          alt={name}
          src={imageUrl}
          height={150}
          width={150}
          fit="contain"
          m={"lg"}
        />
        <Container maw={"40%"}>
          <Stack>
            <Anchor component={Link} to={`/app/product/${product.id}`}>
              <Title order={4}>{name}</Title>
            </Anchor>
            <div>
              <Text>&#8377; {price}</Text>
              <div>
                <Text span>Quantity: </Text>
                <Text span color={"blue"}>
                  {quantity}
                </Text>
              </div>
              <div>
                <Text span>Total price: </Text>
                <Text span color={"blue"}>
                  {(quantity * price).toFixed(2)}
                </Text>
              </div>
            </div>
          </Stack>
        </Container>
        <ActionIcon
          color={"red"}
          size="lg"
          onClick={() => {
            deleteCartItemMutation.mutate();
          }}
        >
          <IconTrash size={32} />
        </ActionIcon>
      </Flex>
    </Paper>
  );
};

export default CartItemCard;
