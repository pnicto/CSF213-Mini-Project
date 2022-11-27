import {
  ActionIcon,
  Anchor,
  Badge,
  Card,
  Group,
  Image,
  Text,
} from "@mantine/core";
import { IconTrash } from "@tabler/icons";
import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { Link } from "react-router-dom";
import { useLoginStore } from "../../store/loginStore";
import { useNotificationStore } from "../../store/notificationStore";
import { Category, Product } from "../../types/interfaces";

type Props = {
  product: Product;
  activeCategory: Category | null;
};

const ProductCard = ({ product, activeCategory }: Props) => {
  const { name, imageUrl, isAvailable, price } = product;
  const { authority } = useLoginStore();
  const notificationStore = useNotificationStore();
  const queryClient = useQueryClient();

  const deleteProductMutation = useMutation(
    () => {
      return axios.delete<Product[]>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/products/${product.id}`
      );
    },
    {
      onSuccess: (data) => {
        notificationStore.successNotification("Deleted product successfully");
        queryClient.setQueryData(["products", activeCategory], data);
      },

      onError: (data: AxiosError) => {
        notificationStore.errorNotification(data.message, "Cannot delete item");
      },
    }
  );

  return (
    <Card shadow={"md"} withBorder h={"100%"}>
      <Card.Section withBorder>
        <Image
          src={imageUrl}
          alt={name}
          height={160}
          fit="contain"
          withPlaceholder
        />
      </Card.Section>
      <Group position="apart" mt="md" mb="xs">
        <Text weight={300}>&#8377; {price.toFixed(2)}</Text>
        {isAvailable ? (
          <Badge color="green" variant="light">
            In stock
          </Badge>
        ) : (
          <Badge color="red" variant="light">
            Out of stock
          </Badge>
        )}
        {authority !== "CUSTOMER" && (
          <ActionIcon
            color={"red"}
            onClick={() => {
              deleteProductMutation.mutate();
            }}
          >
            <IconTrash />
          </ActionIcon>
        )}
      </Group>
      <Anchor component={Link} to={`product/${product.id}`}>
        <Text weight={400}>{name}</Text>
      </Anchor>
    </Card>
  );
};

export default ProductCard;
