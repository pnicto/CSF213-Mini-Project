import {
  Container,
  Paper,
  Title,
  Stack,
  TextInput,
  Group,
  Button,
  Text,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { useMutation } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useProfileDataQuery } from "../../hooks/useProfileDataQuery";
import { useLoginStore } from "../../store/useLoginStore";
import { useNotificationStore } from "../../store/useNotificationStore";
import { User } from "../../types/interfaces";
import LoadingSpinner from "../display/LoadingSpinner";

const AdminManagerProfile = () => {
  const profileDataQuery = useProfileDataQuery();
  const { authority } = useLoginStore();
  const notificationStore = useNotificationStore();

  const updateProfile = useMutation(
    (requestBody: User) => {
      return axios.patch(
        `${import.meta.env.VITE_APP_BACKEND_URL}/${authority?.toLowerCase()}s`,
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
    },
    validate: {
      email: (value: string) =>
        /^\S+@\S+$/.test(value) ? null : "Invalid email",
    },
  });
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
          <Text size={"lg"}>
            <strong>Name:</strong> {profileDataQuery.data!.data.name}
          </Text>
          <Text size={"lg"}>
            <strong>Phone number:</strong>{" "}
            {profileDataQuery.data!.data.phoneNumber}
          </Text>
          <Text size={"lg"}>
            <strong>Email:</strong> {profileDataQuery.data!.data.email}
          </Text>
          <Text size={"lg"} fw={700}>
            Update Profile:
          </Text>
          <form
            onSubmit={form.onSubmit((values) => {
              console.log(values);
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
              <TextInput
                withAsterisk
                required
                label="Phone Number"
                placeholder="New phone number"
                {...form.getInputProps("phoneNumber")}
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

export default AdminManagerProfile;
