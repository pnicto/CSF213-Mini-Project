import {
  Button,
  NumberInput,
  Switch,
  Textarea,
  TextInput,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { useMutation } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useState } from "react";
import { useProductQuery } from "../../hooks/useProductsQuery";
import { useNotificationStore } from "../../store/notificationStore";
import { Category, Product } from "../../types/interfaces";

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
  const notificationStore = useNotificationStore();

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
  const productsQuery = useProductQuery(activeCategory);

  const addProductMutation = useMutation(
    (requestBody: AddProductRequest) => {
      return axios.post<Product[]>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/products/`,
        requestBody
      );
    },
    {
      onSuccess: () => {
        productsQuery.refetch();
        notificationStore.successNotification("Added product successfully");
      },

      onError: (data: AxiosError) => {
        notificationStore.errorNotification(data.message, "Cannot add product");
      },
    }
  );

  return (
    <form
      onSubmit={productForm.onSubmit((values) =>
        addProductMutation.mutate({
          ...values,
          isAvailable,
        })
      )}
    >
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
