import {
  Button,
  NumberInput,
  Select,
  Switch,
  Textarea,
  TextInput,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { closeAllModals } from "@mantine/modals";
import { useMutation } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useState } from "react";
import { useCategoriesQuery } from "../../hooks/useCategoriesQuery";
import { useProductQuery } from "../../hooks/useProductsQuery";
import { useNotificationStore } from "../../store/useNotificationStore";
import { Category, Product } from "../../types/interfaces";

interface AddProductRequest {
  name: string;
  description: string;
  price: number;
  deliveryTime: number;
  imageUrl: string;
  isAvailable: boolean;
  category: Category | undefined;
}

const ProductFrom = () => {
  const [isAvailable, setIsAvailable] = useState(true);
  const notificationStore = useNotificationStore();
  const [selectCategory, setSelectCategory] = useState<string | null>(null);

  const productForm = useForm({
    initialValues: {
      name: "",
      description: "",
      price: 0,
      deliveryTime: 2,
      imageUrl: "",
    },
    validate: {
      price: (value: number) =>
        value > 0 ? null : "Price cannot be less than 0",
    },
  });

  const productsQuery = useProductQuery(false);
  const categoriesQuery = useCategoriesQuery();

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
        closeAllModals();
        notificationStore.successNotification("Added product successfully");
      },

      onError: (data: AxiosError) => {
        notificationStore.errorNotification(data.message, "Cannot add product");
      },
    }
  );

  const createCategoryMutation = useMutation(
    (requestBody: { name: string }) =>
      axios.post<Category[]>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/categories`,
        requestBody
      ),
    {
      onSuccess: () => {
        categoriesQuery.refetch();
        notificationStore.successNotification("Category created successfully");
      },
      onError: (data: AxiosError) => {
        notificationStore.errorNotification(
          data.message,
          `Could not create new category`
        );
      },
    }
  );

  if (categoriesQuery.isLoading) {
    return <></>;
  }

  const categories = categoriesQuery.data!.data.map((category) => {
    return category.name;
  });

  return (
    <form
      onSubmit={productForm.onSubmit((values) =>
        addProductMutation.mutate({
          ...values,
          isAvailable,
          category: categoriesQuery.data!.data.find(
            (category) => category.name === selectCategory
          ),
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
      <Select
        label="Category"
        placeholder="Pick one"
        searchable
        value={selectCategory}
        onChange={setSelectCategory}
        data={categories}
        maxDropdownHeight={250}
        creatable
        getCreateLabel={(query) => `+ Create ${query}`}
        onCreate={(query) => {
          setSelectCategory(query);
          createCategoryMutation.mutate({
            name: query,
          });
          return query;
        }}
      />
      <TextInput
        withAsterisk
        required
        label="Image url"
        {...productForm.getInputProps("imageUrl")}
      />
      <Switch
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
