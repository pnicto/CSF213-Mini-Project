import {
  Button,
  Grid,
  Image,
  NumberInput,
  Select,
  Stack,
  Switch,
  Textarea,
  TextInput,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { useMutation } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useState } from "react";
import LoadingSpinner from "../../components/display/LoadingSpinner";
import { useCategoriesQuery } from "../../hooks/useCategoriesQuery";
import { useProductQueryWithId } from "../../hooks/useProductsQuery";
import { useNotificationStore } from "../../store/useNotificationStore";
import { Category, Product } from "../../types/interfaces";

type Props = {
  productId: string;
};

export interface UpdateProductRequest {
  id: number;
  name: string;
  description: string;
  price: number;
  imageUrl: string;
  isAvailable: boolean;
  deliveryTime: number;
  category: Category;
}

const ProductDetailsAdminManagerView = ({ productId }: Props) => {
  const categoriesQuery = useCategoriesQuery();
  const productQuery = useProductQueryWithId(productId!);

  if (categoriesQuery.isLoading || productQuery.isLoading) {
    return <LoadingSpinner />;
  }

  const product = productQuery.data!.data;

  const { name, description, price, deliveryTime } = product;
  const [isAvailable, setIsAvailable] = useState(product.isAvailable);
  const [imageUrl, setImageUrl] = useState(product.imageUrl);
  const notificationStore = useNotificationStore();
  const [selectCategory, setSelectCategory] = useState<string | null>(
    product.category.name
  );

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
        categoriesQuery.refetch();
        productQuery.refetch();
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

  const categories = categoriesQuery.data!.data.map((category) => {
    return category.name;
  });

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
            const category = categoriesQuery.data!.data.find(
              (category) => category.name === selectCategory
            ) as Category;

            updateProduct.mutate({
              ...values,
              id: product.id,
              isAvailable,
              imageUrl,
              category,
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
            <Textarea
              withAsterisk
              w={"70%"}
              required
              autosize
              label="Description"
              {...form.getInputProps("description")}
            />
            <Select
              label="Category"
              placeholder="Pick one"
              searchable
              value={selectCategory}
              onChange={setSelectCategory}
              data={categories}
              maxDropdownHeight={250}
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
            <Button type="submit">Apply edits</Button>
          </Stack>
        </form>
      </Grid.Col>
    </>
  );
};

export default ProductDetailsAdminManagerView;
