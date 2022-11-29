import { Button, Center, Group, Loader } from "@mantine/core";
import { openConfirmModal, openModal } from "@mantine/modals";
import { useMutation } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import CustomerProfile from "../components/customerProfile/CustomerProfile";
import OrderHistory from "../components/customerProfile/OrderHistory";
import ChangePassword from "../components/modals/ChangePassword";
import TopupWallet from "../components/modals/TopupWallet";
import { useProfileDataQuery } from "../hooks/useProfileDataQuery";
import { useLoginStore } from "../store/useLoginStore";
import { useNotificationStore } from "../store/useNotificationStore";

const UserProfile = () => {
  const profileDataQuery = useProfileDataQuery();

  type profileState = "profile" | "orderHistory";
  const navigate = useNavigate();
  const loginStore = useLoginStore();

  const [activeOption, setActiveOption] = useState<profileState>("profile");
  const notificationStore = useNotificationStore();
  const deleteAccountMutation = useMutation(
    () => axios.delete(`${import.meta.env.VITE_APP_BACKEND_URL}/customers`),
    {
      onSuccess: () => {
        notificationStore.successNotification("Account deleted successfully");
        loginStore.logoutUser();
        navigate("/");
      },
      onError: (data: AxiosError) => {
        notificationStore.errorNotification(
          data.message,
          `Could not delete account`
        );
      },
    }
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
        <Button
          type="button"
          size="md"
          variant="outline"
          color={"red"}
          onClick={() => {
            openConfirmModal({
              centered: true,
              title: "Are you sure?",
              labels: {
                confirm: "Confirm",
                cancel: "Cancel",
              },
              confirmProps: {
                color: "red",
              },
              onConfirm: () => {
                deleteAccountMutation.mutate();
              },
            });
          }}
        >
          Delete account
        </Button>
      </Group>
      {activeOption === "profile" && <CustomerProfile />}
      {activeOption === "orderHistory" && <OrderHistory />}
    </>
  );
};

export default UserProfile;
