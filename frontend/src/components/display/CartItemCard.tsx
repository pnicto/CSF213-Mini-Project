import {
  ActionIcon,
  Anchor,
  Center,
  Container,
  Grid,
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
        queryClient.setQueryData(["customerProfile"], data);
      },

      onError: (data: AxiosError) => {
        notificationStore.errorNotification(data.message, "Cannot delete item");
      },
    }
  );

  return (
    <Paper withBorder shadow={"md"} p={"xl"}>
      <Grid columns={7} m={0}>
        <Grid.Col span={2}>
          <Image
            alt={name}
            src={imageUrl}
            height={150}
            fit="contain"
            m={"lg"}
          />
        </Grid.Col>
        <Grid.Col span={4}>
          <Container>
            <Stack>
              <Anchor component={Link} to={`/app/product/${product.id}`}>
                <Title order={4}>{name}</Title>
              </Anchor>
              <div>
                <Text>&#8377; {price.toFixed(2)}</Text>
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
        </Grid.Col>
        <Grid.Col span={1}>
          <Center h={"100%"}>
            <ActionIcon
              color={"red"}
              size={"lg"}
              onClick={() => {
                deleteCartItemMutation.mutate();
              }}
            >
              <IconTrash size={32} />
            </ActionIcon>
          </Center>
        </Grid.Col>
      </Grid>
    </Paper>
  );
};

export default CartItemCard;
