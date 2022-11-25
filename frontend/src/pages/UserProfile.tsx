import { Button, Center, Group, Loader } from "@mantine/core";
import { openModal } from "@mantine/modals";
import { useState } from "react";
import CustomerProfile from "../components/customerProfile/CustomerProfile";
import OrderHistory from "../components/customerProfile/OrderHistory";
import ChangePassword from "../components/modals/ChangePassword";
import TopupWallet from "../components/modals/TopupWallet";
import { useProfileDataQuery } from "../hooks/useProfileDataQuery";

const UserProfile = () => {
  const profileDataQuery = useProfileDataQuery();

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
    <>
      <Group position={"center"} m={"lg"}>
        <Button
          onClick={() => {
            setActiveOption("profile");
          }}
          variant="outline"
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
              centered: true,
            });
          }}
          variant="outline"
          size="md"
          type="button"
        >
          Change password
        </Button>
      </Group>
      {activeOption === "profile" && <CustomerProfile />}
      {activeOption === "orderHistory" && <OrderHistory />}
    </>
  );
};

export default UserProfile;
