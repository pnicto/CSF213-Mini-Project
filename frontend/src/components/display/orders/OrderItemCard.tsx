import { Anchor, Grid, Image, Stack, Text, Title } from "@mantine/core";
import { Link } from "react-router-dom";
import { OrderItem } from "../../../types/interfaces";

type Props = {
  orderItem: OrderItem;
};

const OrderItemCard = ({ orderItem }: Props) => {
  const { name, price, quantity, imageUrl, productId } = orderItem;
  return (
    <>
      <Grid.Col span={1}>
        <Image alt={name} src={imageUrl} height={150} fit="contain" m={"md"} />
      </Grid.Col>
      <Grid.Col span={2}>
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
                {quantity * price}
              </Text>
            </div>
          </div>
        </Stack>
      </Grid.Col>
    </>
  );
};

export default OrderItemCard;
