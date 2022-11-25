import { Center, Container, Stack, Title } from "@mantine/core";
import { useProfileDataQuery } from "../../hooks/useProfileDataQuery";
import LoadingSpinner from "../display/LoadingSpinner";
import OrderItemsContainer from "../display/orders/OrderItemsContainer";

const OrderHistory = () => {
  const profileDataQuery = useProfileDataQuery();

  if (profileDataQuery.isLoading) {
    return <LoadingSpinner />;
  }

  const { orders } = profileDataQuery.data!.data;

  return (
    <>
      <Container>
        <Stack>
          {orders.length === 0 && (
            <Center m={"sm"}>
              <Title color={"blue.3"}>No orders placed</Title>
            </Center>
          )}
          {orders.map((order) => (
            <OrderItemsContainer key={order.id} order={order} />
          ))}
        </Stack>
      </Container>
    </>
  );
};

export default OrderHistory;
