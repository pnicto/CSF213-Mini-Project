import {
  Paper,
  Flex,
  Container,
  Stack,
  Title,
  Image,
  Text,
} from "@mantine/core";
import { Link } from "react-router-dom";
import { Product } from "../../types/interfaces";

type Props = {
  product: Product;
  quantity: number;
};

const CartItemCard = ({ product, quantity }: Props) => {
  const { id, name, imageUrl, price } = product;

  return (
    <Paper
      withBorder
      shadow={"md"}
      key={id}
      p={"xl"}
      component={Link}
      to={`/app/product/${id}`}
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
      </Flex>
    </Paper>
  );
};

export default CartItemCard;
