import {
  Anchor,
  Container,
  Flex,
  Image,
  Stack,
  Text,
  Title
} from "@mantine/core";
import { Link } from "react-router-dom";
import { OrderItem } from "../../../types/interfaces";

type Props = {
  orderItem: OrderItem;
};

const OrderItemCard = ({ orderItem }: Props) => {
  const { name, price, quantity, imageUrl, productId } = orderItem;
  return (
    <Container>
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
            <Anchor component={Link} to={`/app/product/${productId}`}>
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
      </Flex>
    </Container>
  );
};

export default OrderItemCard;
