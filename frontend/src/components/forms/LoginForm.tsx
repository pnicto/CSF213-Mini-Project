import {
  Anchor,
  Button,
  Container,
  Group,
  Text,
  TextInput,
  Title,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { useMutation } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useLoginStore } from "../../store/loginStore";
import { useNotificationStore } from "../../store/notificationStore";
import { RegisterUserRequestBody } from "../../types/interfaces";

const LoginForm = () => {
  const [pageMode, setPageMode] = useState<"Login" | "Register">("Login");

  const loginStore = useLoginStore();
  const notificationStore = useNotificationStore();

  const navigate = useNavigate();

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

  const performAuth = useMutation(
    (requestBody: RegisterUserRequestBody) => {
      delete axios.defaults.headers.common["Authorization"];

      return axios.post(
        `${
          import.meta.env.VITE_APP_BACKEND_URL
        }/auth/${pageMode.toLowerCase()}`,
        requestBody
      );
    },
    {
      onSuccess: (data) => {
        if (pageMode === "Login") {
          loginStore.setAccessToken(data.data.accessToken);
          notificationStore.successNotification("Login Successful");
          navigate("/");
        } else {
          notificationStore.successNotification(
            "Registration successful",
            "Login to continue"
          );
          setPageMode("Login");
        }
      },
      onError: (data: AxiosError) => {
        notificationStore.errorNotification(data.message, `${pageMode} failed`);
      },
    }
  );

  return (
    <Container fluid miw={"25%"}>
      <form
        onSubmit={form.onSubmit((values) => {
          performAuth.mutate(values);
        })}
        id="login-form"
      >
        <Title order={1} transform="capitalize" color={"deepBlue"} py="md">
          {pageMode}
        </Title>
        {pageMode === "Register" && (
          <>
            <TextInput
              withAsterisk
              label="Name"
              placeholder="John"
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
          </>
        )}
        <TextInput
          withAsterisk
          label="Email"
          placeholder="your@email.com"
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
        <Group position="apart">
          {pageMode === "Login" ? (
            <Text fz="xs" align="left">
              First time? Click{" "}
              <Anchor
                onClick={() => {
                  setPageMode("Register");
                }}
              >
                here
              </Anchor>{" "}
              to register
            </Text>
          ) : (
            <Text fz="xs" align="left">
              Already a registered user? Click{" "}
              <Anchor
                onClick={() => {
                  setPageMode("Login");
                }}
              >
                here
              </Anchor>{" "}
              to login
            </Text>
          )}
          <Button type="submit">{pageMode}</Button>
        </Group>
      </form>
    </Container>
  );
};

export default LoginForm;
