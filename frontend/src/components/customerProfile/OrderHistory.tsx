import { Center, Loader } from "@mantine/core";
import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { Customer } from "../../types/interfaces";

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

  return (
    <>
      <div>Order history</div>
    </>
  );
};

export default OrderHistory;
