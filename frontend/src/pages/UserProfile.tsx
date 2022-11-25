import { Button, Center, Grid, Loader, Stack } from "@mantine/core";
import { openModal } from "@mantine/modals";
import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { useState } from "react";
import CustomerProfile from "../components/customerProfile/CustomerProfile";
import OrderHistory from "../components/customerProfile/OrderHistory";
import ChangePassword from "../components/modals/ChangePassword";
import TopupWallet from "../components/modals/TopupWallet";
import { Customer } from "../types/interfaces";

const UserProfile = () => {
  const profileDataQuery = useQuery(["customerProfile"], () =>
    axios.get<Customer>(`${import.meta.env.VITE_APP_BACKEND_URL}/customers`)
  );

  type profileState = "profile" | "orderHistory";

  const [activeOption, setActiveOption] = useState<profileState>("profile");

  if (profileDataQuery.isLoading) {
    return (
      <Center h={"80vh"}>
        <Loader size={"md"} />
      </Center>
    );
  }

  return (
    <Grid mih={"92vh"} m={0} columns={10}>
      <Grid.Col span={2}>
        <Stack mx={"lg"}>
          <Button
            onClick={() => {
              setActiveOption("profile");
            }}
            variant="outline"
            fullWidth
            size="md"
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
            type="button"
          >
            Order history
          </Button>
          <Button
            onClick={() => {
              openModal({
                title: "Topup wallet",
                children: <TopupWallet />,
                centered: true,
              });
            }}
            variant="outline"
            fullWidth
            size="md"
            type="button"
          >
            Top-up wallet
          </Button>
          <Button
            onClick={() => {
              openModal({
                title: "Change password",
                children: <ChangePassword />,
              });
            }}
            variant="outline"
            fullWidth
            size="md"
            type="button"
          >
            Change password
          </Button>
        </Stack>
      </Grid.Col>
      <Grid.Col span={8}>
        {activeOption === "profile" && <CustomerProfile />}
        {activeOption === "orderHistory" && <OrderHistory />}
      </Grid.Col>
    </Grid>
  );
};

export default UserProfile;
