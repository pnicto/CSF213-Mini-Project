import { Center, Loader } from "@mantine/core";
import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { Customer } from "../../types/interfaces";
import OrderItemsContainer from "../display/orders/OrderItemsContainer";

const OrderHistory = () => {
  const profileDataQuery = useQuery(["customerProfile"], () =>
    axios.get<Customer>(`${import.meta.env.VITE_APP_BACKEND_URL}/customers`)
  );

  if (profileDataQuery.isLoading) {
    return (
      <Center h={"80vh"}>
        <Loader size={"md"} />
      </Center>
    );
  }

  const { orders } = profileDataQuery.data!.data;

  return (
    <>
      {orders.map((order) => (
        <OrderItemsContainer key={order.id} order={order} />
      ))}
    </>
  );
};

export default OrderHistory;
