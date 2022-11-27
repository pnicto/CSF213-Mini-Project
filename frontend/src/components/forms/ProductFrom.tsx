import {
  Button,
  NumberInput,
  Switch,
  Textarea,
  TextInput
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { useState } from "react";
import { Category } from "../../types/interfaces";

interface AddProductRequest {
  name: string;
  description: string;
  price: number;
  deliveryTime: number;
  imageUrl: string;
  isAvailable: boolean;
}

type Props = {
  activeCategory: Category | null;
};
const ProductFrom = ({ activeCategory }: Props) => {
  const [isAvailable, setIsAvailable] = useState(true);

  const productForm = useForm({
    initialValues: {
      name: "",
      description: "",
      price: 0,
      deliveryTime: 2,
      imageUrl: "",
    },
    validate: {
      price: (value: number) => (value > 0 ? null : "Price cannot be negative"),
    },
  });

  return (
    <form onSubmit={productForm.onSubmit((values) => {})}>
      <TextInput
        withAsterisk
        required
        label="Name"
        {...productForm.getInputProps("name")}
        type="text"
      />
      <Textarea
        withAsterisk
        required
        label="Description"
        {...productForm.getInputProps("description")}
        autosize
        minRows={2}
      />
      <NumberInput
        withAsterisk
        required
        label="Price in &#8377;"
        {...productForm.getInputProps("price")}
      />
      <NumberInput
        withAsterisk
        required
        label="Delivery time in days"
        {...productForm.getInputProps("deliveryTime")}
      />
      <TextInput
        withAsterisk
        required
        label="Image url"
        {...productForm.getInputProps("imageUrl")}
      />
      <Switch
        required
        label="Is in stock?"
        checked={isAvailable}
        onChange={(event) => setIsAvailable(event.currentTarget.checked)}
      />
      <Button type="submit" mt={"lg"}>
        Submit
      </Button>
    </form>
  );
};

export default ProductFrom;
