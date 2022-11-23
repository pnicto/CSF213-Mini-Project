import {
  ActionIcon,
  Container,
  Flex,
  Image,
  Paper,
  Stack,
  Text,
  Title,
} from "@mantine/core";
import { IconTrash } from "@tabler/icons";
import { Link } from "react-router-dom";
import { CartItem } from "../../types/interfaces";

type Props = {
  cartItem: CartItem;
};

const CartItemCard = ({ cartItem }: Props) => {
  const { product, quantity } = cartItem;
  const { name, price, imageUrl } = product;

  return (
    <Paper
      withBorder
      shadow={"md"}
      p={"xl"}
      component={Link}
      to={`/app/product/${product.id}`}
    >
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
            <Title order={4}>{name}</Title>
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
        <ActionIcon color={"red"} size="lg">
          <IconTrash size={32} />
        </ActionIcon>
      </Flex>
    </Paper>
  );
};

export default CartItemCard;
