import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import {
  AppShell,
  Navbar,
  Header,
  Aside,
  Grid,
  Center,
  Loader,
} from "@mantine/core";
import { Customer } from "../types/interfaces";

const CustomerProfile = () => {
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
};

export default CustomerProfile;
