import { Button, Group, TextInput } from "@mantine/core";
import { useForm } from "@mantine/form";

const AddManagerForm = () => {
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

  return (
    <form onSubmit={form.onSubmit((values) => {})}>
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
