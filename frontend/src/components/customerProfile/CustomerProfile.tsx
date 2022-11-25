import {
  Button,
  Center,
  Container,
  Loader,
  Paper,
  Stack,
  Text,
  TextInput,
  Title,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { useMutation, useQuery } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useNotificationStore } from "../../store/notificationStore";
import { Customer } from "../../types/interfaces";

const CustomerProfile = () => {
  const notificationStore = useNotificationStore();

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
      onSuccess: (data) => {
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
      <Paper withBorder shadow={"md"} p={"xl"}>
        <Title
          order={1}
          transform="capitalize"
          color={"deepBlue"}
          align="center"
        >
          {"Profile Details"}
        </Title>

        <Stack>
          <div>
            <Text size={"lg"} align="left" fw={700} span>
              {"Email ID: "}
            </Text>
            <Text span>{profileDataQuery.data!.data.email}</Text>
          </div>
          <div>
            <Text size={"lg"} align="right" fw={700} span>
              {"Account Balance: "}
            </Text>
            <Text span align="right">
              ₹{profileDataQuery.data!.data.moneyInWallet}
            </Text>
          </div>
          <Text size={"xl"} fw={700}>
            {"Update Profile:"}
          </Text>
          <form
            onSubmit={form.onSubmit((values) => {
              updateProfile.mutate(values);
            })}
            id="profile-update-form"
          >
            <TextInput
              withAsterisk
              required
              label="Name"
              placeholder="John"
              {...form.getInputProps("name")}
              type={"text"}
              size="md"
            />
            <TextInput
              withAsterisk
              required
              label="Phone Number"
              placeholder="944143256"
              {...form.getInputProps("phoneNumber")}
              type={"text"}
              py="sm"
              size="md"
            />
            <Center>
              <Button type="submit">{"Update Details"}</Button>
            </Center>
          </form>
        </Stack>
      </Paper>
    </Container>
  );
};

export default CustomerProfile;
