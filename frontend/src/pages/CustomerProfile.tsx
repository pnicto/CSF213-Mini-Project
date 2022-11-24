import { Button, Center, Grid, Loader, Stack } from "@mantine/core";
import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { useState } from "react";
import OrderHistory from "../components/customerProfile/OrderHistory";
import UserProfile from "../components/customerProfile/UserProfile";
import { Customer } from "../types/interfaces";

const CustomerProfile = () => {
  const profileDataQuery = useQuery(["customerProfile"], () =>
    axios.get<Customer>(`${import.meta.env.VITE_APP_BACKEND_URL}/customers`)
  );

  type profileState = "profile" | "orderHistory" | "wallet" | "updatePassword";

  const [activeOption, setActiveOption] = useState<profileState>("profile");

  if (profileDataQuery.isLoading) {
    return (
      <Center h={"80vh"}>
        <Loader size={"md"} />
      </Center>
    );
  }

  return (
    <Grid p={0} mih={"92vh"} px={"md"}>
      <Grid.Col span={2}>
        <Stack>
          <Button
            onClick={() => {
              setActiveOption("profile");
            }}
            variant="outline"
            fullWidth
            size="md"
            color={"deepBlue"}
            type="button"
          >
            Profile
          </Button>
          <Button
            onClick={() => {
              setActiveOption("orderHistory");
            }}
            variant="outline"
            fullWidth
            size="md"
            color={"deepBlue"}
            type="button"
          >
            Order history
          </Button>
          <Button
            onClick={() => {
              setActiveOption("wallet");
            }}
            variant="outline"
            fullWidth
            size="md"
            color={"deepBlue"}
            type="button"
          >
            Top-up wallet
          </Button>
          <Button
            onClick={() => {
              setActiveOption("updatePassword");
            }}
            variant="outline"
            fullWidth
            size="md"
            color={"deepBlue"}
            type="button"
          >
            Change password
          </Button>
        </Stack>
      </Grid.Col>
      <Grid.Col span={10}></Grid.Col>
    </Grid>
  );
};

export default CustomerProfile;