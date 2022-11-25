import {
  Badge,
  Button,
  Center,
  Grid,
  Image,
  NumberInput,
  Stack,
  Text,
  Title,
} from "@mantine/core";
import { useMutation, useQuery } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useState } from "react";
import { useParams } from "react-router-dom";
import LoadingSpinner from "../components/display/LoadingSpinner";
import { useNotificationStore } from "../store/notificationStore";
import { CustomerCart, Product } from "../types/interfaces";

interface CartItemRequest {
  product: Product;
  quantity: number;
}

const ProductDetails = () => {
  // Get route params
  const { productId } = useParams<{ productId?: string }>();
  const [quantity, setQuantity] = useState(1);

  const notificationStore = useNotificationStore();

  const { data: productData, isLoading } = useQuery(
    ["products", productId],
    () =>
      axios.get<Product>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/products/${productId}`
      )
  );

  const addProductToCartMutation = useMutation(
    (requestBody: CartItemRequest) => {
      return axios.patch<CustomerCart>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/customers/cart`,
        requestBody
      );
    },
    {
      onSuccess: () => {
        notificationStore.successNotification("Successfully added to cart");
      },

      onError: (data: AxiosError) => {
        notificationStore.errorNotification(
          data.message,
          "Adding to cart failed"
        );
      },
    }
  );

  if (isLoading) {
    return <LoadingSpinner />;
  } else {
    const { name, description, imageUrl, isAvailable, price } =
      productData!.data;

    return (
      <Center mih={"65vh"}>
        <Grid
          style={{
            overflowY: "hidden",
          }}
          columns={13}
          maw={"100vw"}
        >
          <Grid.Col span={3} offset={2}>
            <Image
              alt={name}
              src={imageUrl}
              withPlaceholder
              height={500}
              fit="contain"
            />
          </Grid.Col>
          <Grid.Col span={5} offset={1}>
            <Stack align={"flex-start"}>
              <div>
                <Title>{name}</Title>
                <Badge
                  color={`${isAvailable ? "green" : "red"}`}
                  variant="filled"
                  size="lg"
                >
                  {isAvailable ? "In stock" : "Out of stock"}
                </Badge>
              </div>
              <Title>&#8377; {price}</Title>
              <Text>{description}</Text>

              <NumberInput
                label="Quantity"
                defaultValue={1}
                min={1}
                value={quantity}
                onChange={(value) => setQuantity(value as number)}
              />
              <Button
                onClick={() => {
                  addProductToCartMutation.mutate({
                    product: productData!.data,
                    quantity,
                  });
                }}
              >
                Add to cart
              </Button>
            </Stack>
          </Grid.Col>
        </Grid>
      </Center>
    );
  }
};

export default ProductDetails;
