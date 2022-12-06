import { TextInput, Group, Button } from "@mantine/core";
import { useForm } from "@mantine/form";
import { closeAllModals } from "@mantine/modals";
import { useQueryClient, useMutation } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useNotificationStore } from "../../store/useNotificationStore";
import { RegisterUserRequestBody, User } from "../../types/interfaces";

const AddCustomerForm = () => {
  const queryClient = useQueryClient();
  const notificationStore = useNotificationStore();

  const form = useForm({
    initialValues: {
      email: "",
      password: "",
      name: "",
      phoneNumber: "",
    },
    validate: {
      email: (value: string) =>
        /^\S+@\S+$/.test(value) ? null : "Invalid email",
      password: (value: string) =>
        value.trim().length < 4 ? "Invalid password" : null,
    },
  });

  const createNewCustomerMutation = useMutation(
    (requestBody: RegisterUserRequestBody) =>
      axios.post<User[]>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/customers`,
        requestBody
      ),
    {
      onSuccess: (data) => {
        notificationStore.successNotification("Added customer successfully");
        queryClient.setQueryData(["customers"], data);
        closeAllModals();
      },
      onError: (data: AxiosError) => {
        notificationStore.errorNotification(
          data.message,
          "Cannot add customer"
        );
      },
    }
  );

  return (
    <form
      onSubmit={form.onSubmit((values) => {
        createNewCustomerMutation.mutate({ ...values });
      })}
    >
      <TextInput
        withAsterisk
        label="Name"
        {...form.getInputProps("name")}
        type={"text"}
        py="sm"
        size="md"
      />
      <TextInput
        withAsterisk
        label="Phone Number"
        placeholder="944143256"
        {...form.getInputProps("phoneNumber")}
        type={"text"}
        py="sm"
        size="md"
      />
      <TextInput
        withAsterisk
        label="Email"
        {...form.getInputProps("email")}
        type="email"
        py="sm"
        size="md"
      />
      <TextInput
        withAsterisk
        label="Password"
        placeholder="**********"
        {...form.getInputProps("password")}
        type="password"
        py="sm"
        size="md"
      />
      <Group position="right">
        <Button type="submit">Submit</Button>
      </Group>
    </form>
  );
};

export default AddCustomerForm;
