import { Button, NumberInput, Stack } from "@mantine/core";
import { useMutation, useQuery } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useState } from "react";
import { useNotificationStore } from "../../store/notificationStore";

const TopupWallet = () => {
  const notificationStore = useNotificationStore();
  const [amount, setAmount] = useState(100);

  const profileDataQuery = useQuery(["customerProfile"], () =>
    axios.get(`${import.meta.env.VITE_APP_BACKEND_URL}/customers`)
  );

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
          console.log(amount);
          topupWalletMutation.mutate({ amount });
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
