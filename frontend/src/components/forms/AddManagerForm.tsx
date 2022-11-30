import { Button, Group, TextInput } from "@mantine/core";
import { useForm } from "@mantine/form";
import { closeAllModals } from "@mantine/modals";
import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useNotificationStore } from "../../store/useNotificationStore";
import { User } from "../../types/interfaces";

interface NewManagerRequestBody {
  role: string;
  email: string;
  password: string;
  name: string;
  phoneNumber: string;
}

const AddManagerForm = () => {
  const queryClient = useQueryClient();
  const notificationStore = useNotificationStore();

  const form = useForm({
    initialValues: {
      email: "ram@email.com",
      password: "password",
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

  const createNewManagerMutation = useMutation(
    (requestBody: NewManagerRequestBody) =>
      axios.post<User[]>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/managers`,
        requestBody
      ),
    {
      onSuccess: (data) => {
        notificationStore.successNotification("Added manager successfully");
        queryClient.setQueryData(["managers"], data);
        closeAllModals();
      },
      onError: (data: AxiosError) => {
        notificationStore.errorNotification(data.message, "Cannot add manager");
      },
    }
  );

  return (
    <form
      onSubmit={form.onSubmit((values) => {
        createNewManagerMutation.mutate({ ...values, role: "MANAGER" });
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

export default AddManagerForm;
