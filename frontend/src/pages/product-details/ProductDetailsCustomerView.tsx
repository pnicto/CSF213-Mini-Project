import {
  Badge,
  Button,
  Grid,
  Image,
  NumberInput,
  Stack,
  Text,
  Title,
} from "@mantine/core";
import { useMutation } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useState } from "react";
import LoadingSpinner from "../../components/display/LoadingSpinner";
import { useProductQueryWithId } from "../../hooks/useProductsQuery";
import { useNotificationStore } from "../../store/useNotificationStore";
import { CustomerCart, Product } from "../../types/interfaces";

type Props = {
  product: Product;
};

interface CartItemRequest {
  product: Product;
  quantity: number;
}

const ProductDetailsCustomerView = ({ product }: Props) => {
  const [quantity, setQuantity] = useState(1);
  const notificationStore = useNotificationStore();

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

  const { name, description, imageUrl, isAvailable, price } = product;

  return (
    <>
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
          <Title>&#8377; {price.toFixed(2)}</Title>
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
                product: product,
                quantity,
              });
            }}
            disabled={!isAvailable}
          >
            Add to cart
          </Button>
        </Stack>
      </Grid.Col>
    </>
  );
};

export default ProductDetailsCustomerView;
