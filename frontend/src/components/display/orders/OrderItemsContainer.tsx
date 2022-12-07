import { Badge, Container, Flex, Grid, Paper, Text } from "@mantine/core";
import { Order } from "../../../types/interfaces";
import OrderItemCard from "./OrderItemCard";

type Props = {
  order: Order;
};

const OrderItemsContainer = ({ order }: Props) => {
  const orderDate = new Date(order.createdAt);
  const deliveryDate = new Date(order.createdAt);
  deliveryDate.setDate(deliveryDate.getDate() + order.deliveryTime);
  const today = new Date();

  return (
    <Paper withBorder shadow={"lg"} mr={"xl"} mb={"md"} py={"xl"}>
      <Flex justify={"space-around"}>
        <Text size={"lg"}>
          <strong>Id:</strong> #{order.id}
        </Text>

        {today > deliveryDate && (
          <Badge color={"green"} variant="light">
            Delivered
          </Badge>
        )}

        {deliveryDate > today && (
          <Badge color={"red"} variant="light">
            Not delivered
          </Badge>
        )}

        <Text size={"lg"}>
          <strong>Ordered at:</strong> {orderDate.toLocaleString()}
        </Text>
        <Text size={"lg"}>
          <strong>Total price:</strong> &#8377;{order.totalPrice.toFixed(2)}
        </Text>
      </Flex>
      <Container p={"xl"} fluid>
        <Grid columns={3}>
          {order.orderItems.map((orderItem) => (
            <OrderItemCard key={orderItem.id} orderItem={orderItem} />
          ))}
        </Grid>
      </Container>
    </Paper>
  );
};

export default OrderItemsContainer;
