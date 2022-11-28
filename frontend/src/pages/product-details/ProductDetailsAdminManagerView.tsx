import {
  Button,
  Grid,
  Image,
  NumberInput,
  Stack,
  Switch,
  Textarea,
  TextInput,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { useMutation } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useState } from "react";
import { useNotificationStore } from "../../store/useNotificationStore";
import { Product } from "../../types/interfaces";

type Props = {
  product: Product;
};

export interface UpdateProductRequest {
  id: number;
  name: string;
  description: string;
  price: number;
  imageUrl: string;
  isAvailable: boolean;
  deliveryTime: number;
}

const ProductDetailsAdminManagerView = ({ product }: Props) => {
  const { name, description, price, deliveryTime } = product;
  const [isAvailable, setIsAvailable] = useState(product.isAvailable);
  const [imageUrl, setImageUrl] = useState(product.imageUrl);
  const notificationStore = useNotificationStore();

  const form = useForm({
    initialValues: {
      name,
      description,
      price,
      deliveryTime,
    },
  });

  const updateProduct = useMutation(
    (requestBody: UpdateProductRequest) => {
      return axios.patch<Product>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/products/${product.id}`,
        requestBody
      );
    },
    {
      onSuccess: () => {
        notificationStore.successNotification("Product updated successfully");
      },
      onError: (data: AxiosError) => {
        notificationStore.errorNotification(
          data.message,
          `Could not update product details`
        );
      },
    }
  );

  return (
    <>
      <Grid.Col span={3} offset={2}>
        <TextInput
          withAsterisk
          required
          label="Link to image"
          value={imageUrl}
          onChange={(event) => setImageUrl(event.currentTarget.value)}
        />
        <Image
          alt={name}
          src={imageUrl}
          withPlaceholder
          height={500}
          fit="contain"
        />
      </Grid.Col>
      <Grid.Col span={7} offset={1}>
        <form
          onSubmit={form.onSubmit((values) => {
            updateProduct.mutate({
              ...values,
              id: product.id,
              isAvailable,
              imageUrl,
            });
          })}
        >
          <Stack align={"flex-start"}>
            <TextInput
              withAsterisk
              required
              label="Name"
              {...form.getInputProps("name")}
              w={"40%"}
            />
            <Switch
              label="Is in stock?"
              checked={isAvailable}
              onChange={(event) => setIsAvailable(event.currentTarget.checked)}
            />
            <NumberInput
              withAsterisk
              required
              precision={2}
              label="Price in &#8377;"
              min={1}
              step={50}
              {...form.getInputProps("price")}
            />
            <NumberInput
              withAsterisk
              required
              label="Delivery time in days"
              min={1}
              {...form.getInputProps("deliveryTime")}
            />
            <Textarea
              withAsterisk
              w={"70%"}
              required
              autosize
              label="Description"
              {...form.getInputProps("description")}
            />
            <Button type="submit">Apply edits</Button>
          </Stack>
        </form>
      </Grid.Col>
    </>
  );
};

export default ProductDetailsAdminManagerView;
