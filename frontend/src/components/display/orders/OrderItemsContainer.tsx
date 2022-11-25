import { Flex, Paper, Text } from "@mantine/core";
import { Order } from "../../../types/interfaces";
import OrderItemCard from "./OrderItemCard";

type Props = {
  order: Order;
};

const OrderItemsContainer = ({ order }: Props) => {
  const orderDate = new Date(order.createdAt);

  return (
    <Paper withBorder shadow={"lg"} p={"xl"}>
      <Flex justify={"space-around"}>
        <Text size={"lg"}>
          <strong>Id:</strong> #{order.id}
        </Text>
        <Text size={"lg"}>
          <strong>Ordered at:</strong> {orderDate.toLocaleString()}
        </Text>
        <Text size={"lg"}>
          <strong>Total price:</strong> &#8377;{order.totalPrice}
        </Text>
      </Flex>
      {order.orderItems.map((orderItem) => (
        <OrderItemCard key={orderItem.id} orderItem={orderItem} />
      ))}
    </Paper>
  );
};

export default OrderItemsContainer;