import { Title, TextInput, Group, Anchor, Button, Text } from "@mantine/core";
import { useForm } from "@mantine/form";
import { useState } from "react";

type Props = {};

const LoginForm = ({}: Props) => {
  const [pageMode, setPageMode] = useState<"Login" | "Register">("Login");

  const form = useForm({
    initialValues:
      pageMode === "Login"
        ? {
            email: "",
            password: "",
            username: "",
          }
        : { email: "", password: "" },

    validate: {
      email: (value: string) =>
        /^\S+@\S+$/.test(value) ? null : "Invalid email",
      password: (value: string) =>
        value.trim().length < 8 ? "Invalid password" : null,
    },
  });

  return (
    <form
      onSubmit={form.onSubmit((values) => console.log(values))}
      id="login-form"
    >
      <Title order={2} transform="capitalize" color={"deepBlue"} py="md">
        {pageMode}
      </Title>
      {pageMode === "Register" && (
        <TextInput
          withAsterisk
          label="Name"
          placeholder="John"
          {...form.getInputProps("username")}
          type={"text"}
          py="sm"
        ></TextInput>
      )}
      <TextInput
        withAsterisk
        label="Email"
        placeholder="your@email.com"
        {...form.getInputProps("email")}
        type="email"
        py="sm"
      />
      <TextInput
        withAsterisk
        label="Password"
        placeholder="**********"
        {...form.getInputProps("password")}
        type="password"
        py="sm"
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
  );
};

export default LoginForm;
