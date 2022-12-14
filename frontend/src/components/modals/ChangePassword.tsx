import { Button, PasswordInput, Stack, TextInput } from "@mantine/core";
import { useForm } from "@mantine/form";
import { closeAllModals } from "@mantine/modals";
import { useMutation } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useNotificationStore } from "../../store/useNotificationStore";

type Props = {};

const ChangePassword = ({}: Props) => {
  const notificationStore = useNotificationStore();

  const passwordForm = useForm({
    initialValues: {
      oldPassword: "",
      newPassword: "",
      confirmNewPassword: "",
    },
    validate: {
      oldPassword: (value: string) =>
        value.trim().length < 4 ? "Password is too short" : null,
      newPassword: (value: string) =>
        value.trim().length < 4 ? "Password is too short" : null,
    },
  });

  const updateProfile = useMutation(
    (requestBody: { oldPassword: string; newPassword: string }) => {
      return axios.patch(
        `${import.meta.env.VITE_APP_BACKEND_URL}/users/changePassword`,
        requestBody
      );
    },
    {
      onSuccess: () => {
        closeAllModals();
        notificationStore.successNotification("Password changed successfully!");
      },
      onError: (data: AxiosError) => {
        notificationStore.errorNotification(
          data.message,
          `Cannot change password`
        );
      },
    }
  );
  return (
    <>
      <form
        onSubmit={passwordForm.onSubmit((values) => {
          if (values.confirmNewPassword === values.newPassword) {
            updateProfile.mutate({
              oldPassword: values.oldPassword,
              newPassword: values.newPassword,
            });
          } else {
            notificationStore.errorNotification("New password does not match");
          }
        })}
      >
        <Stack>
          <TextInput
            size={"md"}
            type={"password"}
            withAsterisk
            label="Old password"
            {...passwordForm.getInputProps("oldPassword")}
          />
          <TextInput
            size={"md"}
            type={"password"}
            withAsterisk
            label="New password"
            {...passwordForm.getInputProps("newPassword")}
          />
          <TextInput
            size={"md"}
            type={"password"}
            withAsterisk
            label="Confirm new password"
            {...passwordForm.getInputProps("confirmNewPassword")}
          />
          <Button type="submit">Submit</Button>
        </Stack>
      </form>
    </>
  );
};

export default ChangePassword;
