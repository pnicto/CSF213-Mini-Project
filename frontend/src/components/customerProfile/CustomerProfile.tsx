import {
  Button,
  Container,
  Group,
  Paper,
  Stack,
  Text,
  TextInput,
  Title,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { useMutation } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useProfileDataQuery } from "../../hooks/useProfileDataQuery";
import { useNotificationStore } from "../../store/notificationStore";
import { Customer } from "../../types/interfaces";
import LoadingSpinner from "../display/LoadingSpinner";

const CustomerProfile = () => {
  const notificationStore = useNotificationStore();
  const profileDataQuery = useProfileDataQuery();

  if (profileDataQuery.isLoading) {
    return <LoadingSpinner />;
  }

  const form = useForm({
    initialValues: {
      id: profileDataQuery.data!.data.id,
      name: profileDataQuery.data!.data.name,
      email: profileDataQuery.data!.data.email,
      role: profileDataQuery.data!.data.role,
      phoneNumber: profileDataQuery.data!.data.phoneNumber,
      createdAt: profileDataQuery.data!.data.createdAt,
      moneyInWallet: profileDataQuery.data!.data.moneyInWallet,
      cart: profileDataQuery.data!.data.cart,
      orders: profileDataQuery.data!.data.orders,
    },
    validate: {
      email: (value: string) =>
        /^\S+@\S+$/.test(value) ? null : "Invalid email",
    },
  });

  const updateProfile = useMutation(
    (requestBody: Customer) => {
      return axios.patch(
        `${import.meta.env.VITE_APP_BACKEND_URL}/customers`,
        requestBody
      );
    },
    {
      onSuccess: () => {
        notificationStore.successNotification("Profile Update Successful");
        profileDataQuery.refetch();
      },
      onError: (data: AxiosError) => {
        notificationStore.errorNotification(
          data.message,
          `Profile Update Failed`
        );
      },
    }
  );

  return (
    <Container py={"md"} px={"xl"}>
      <Paper withBorder shadow={"lg"} p={"xl"}>
        <Title
          order={2}
          transform="capitalize"
          color={"deepBlue"}
          align="center"
        >
          Profile Details
        </Title>
        <Stack>
          <Text>
            <strong>Email:</strong> {profileDataQuery.data!.data.email}
          </Text>
          <Text>
            <strong>Account Balance:</strong> &#8377;
            {profileDataQuery.data!.data.moneyInWallet}
          </Text>
          <form
            onSubmit={form.onSubmit((values) => {
              updateProfile.mutate(values);
            })}
          >
            <Text size={"lg"} fw={700}>
              Update Profile:
            </Text>
            <Stack>
              <TextInput
                withAsterisk
                required
                label="Name"
                placeholder="John"
                {...form.getInputProps("name")}
                type={"text"}
              />
              <TextInput
                withAsterisk
                required
                label="Phone Number"
                placeholder="944143256"
                {...form.getInputProps("phoneNumber")}
                type={"text"}
              />
              <Group>
                <Button type="submit">Update Details</Button>
              </Group>
            </Stack>
          </form>
        </Stack>
      </Paper>
    </Container>
  );
};

export default CustomerProfile;
