import {
  Button,
  Container,
  Group,
  Paper,
  Stack,
  Text,
  Textarea,
  TextInput,
  Title,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { useMutation } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useProfileDataQuery } from "../../hooks/useProfileDataQuery";
import { useNotificationStore } from "../../store/useNotificationStore";
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
      address: profileDataQuery.data!.data.address,
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
    <Container p={"xl"} maw="50%">
      <Paper withBorder shadow={"xl"} p={"xl"} m={"xl"}>
        <Title
          order={2}
          transform="capitalize"
          color={"deepBlue"}
          align="center"
          mb={"md"}
        >
          Profile Details
        </Title>
        <Stack>
          <form
            onSubmit={form.onSubmit((values) => {
              updateProfile.mutate(values);
            })}
          >
            <Stack>
              <TextInput
                withAsterisk
                required
                label="Name"
                placeholder="New name"
                {...form.getInputProps("name")}
                type={"text"}
                size={"md"}
              />
              <Text>
                <strong>Email:</strong> {profileDataQuery.data!.data.email}
              </Text>
              <TextInput
                withAsterisk
                required
                label="Phone Number"
                placeholder="New phone number"
                {...form.getInputProps("phoneNumber")}
                type={"text"}
                size={"md"}
              />
              <Text>
                <strong>Account Balance: </strong>&#8377;
                {profileDataQuery.data!.data.moneyInWallet}
              </Text>
              <Textarea
                withAsterisk
                required
                label="Address"
                placeholder="New address"
                {...form.getInputProps("address")}
                type={"text"}
                size={"md"}
              />
              <Group position={"center"}>
                <Button type="submit" size="sm">
                  Update Details
                </Button>
              </Group>
            </Stack>
          </form>
        </Stack>
      </Paper>
    </Container>
  );
};

export default CustomerProfile;
