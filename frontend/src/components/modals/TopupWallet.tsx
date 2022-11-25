import { Button, NumberInput, Stack } from "@mantine/core";
import { closeAllModals } from "@mantine/modals";
import { useMutation, useQuery } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useState } from "react";
import { useProfileDataQuery } from "../../hooks/useProfileDataQuery";
import { useNotificationStore } from "../../store/notificationStore";

const TopupWallet = () => {
  const notificationStore = useNotificationStore();
  const [amount, setAmount] = useState(100);

  const profileDataQuery = useProfileDataQuery();

  const topupWalletMutation = useMutation(
    (requestBody: { amount: number }) => {
      return axios.patch(
        `${import.meta.env.VITE_APP_BACKEND_URL}/customers/topup`,
        requestBody
      );
    },
    {
      onSuccess: (data) => {
        profileDataQuery.refetch();
        notificationStore.successNotification("Amount added successfully");
      },
      onError: (data: AxiosError) => {
        notificationStore.errorNotification(
          data.message,
          "Could not topup wallet"
        );
      },
    }
  );

  return (
    <>
      <form
        onSubmit={(event) => {
          event.preventDefault();
          topupWalletMutation.mutate({ amount });
          closeAllModals();
        }}
      >
        <Stack>
          <NumberInput
            min={100}
            required
            step={50}
            size="md"
            withAsterisk
            label="Amount in &#8377;"
            value={amount}
            onChange={(value) => setAmount(value as number)}
          />
          <Button type="submit">Submit</Button>
        </Stack>
      </form>
    </>
  );
};

export default TopupWallet;
