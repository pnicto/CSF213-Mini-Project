import { Stack } from "@mantine/core";
import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { Customer } from "../../types/interfaces";
import LoadingSpinner from "../display/LoadingSpinner";
import OrderItemsContainer from "../display/orders/OrderItemsContainer";

const OrderHistory = () => {
  const profileDataQuery = useQuery(["customerProfile"], () =>
    axios.get<Customer>(`${import.meta.env.VITE_APP_BACKEND_URL}/customers`)
  );

  if (profileDataQuery.isLoading) {
    return <LoadingSpinner />;
  }

  const { orders } = profileDataQuery.data!.data;

  return (
    <>
      <Stack>
        {orders.map((order) => (
          <OrderItemsContainer key={order.id} order={order} />
        ))}
      </Stack>
    </>
  );
};

export default OrderHistory;
