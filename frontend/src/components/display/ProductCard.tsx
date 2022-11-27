import {
  ActionIcon,
  Anchor,
  Badge,
  Card,
  Group,
  Image,
  Text,
} from "@mantine/core";
import { openModal } from "@mantine/modals";
import { IconTrash } from "@tabler/icons";
import { UseMutationResult } from "@tanstack/react-query";
import { AxiosError, AxiosResponse } from "axios";
import { Link } from "react-router-dom";
import { useLoginStore } from "../../store/loginStore";
import { Product } from "../../types/interfaces";
import ProductFrom from "../forms/ProductFrom";

type Props = {
  product: Product;
  deleteProductMutation: UseMutationResult<
    AxiosResponse<Product[], any>,
    AxiosError<unknown, any>,
    number,
    unknown
  >;
};

const ProductCard = ({ product, deleteProductMutation }: Props) => {
  const { name, imageUrl, isAvailable, price } = product;
  const { authority } = useLoginStore();

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
              deleteProductMutation.mutate(product.id);
            }}
          >
            <IconTrash />
          </ActionIcon>
        )}
      </Group>
      {authority === "CUSTOMER" && (
        <Anchor component={Link} to={`product/${product.id}`}>
          <Text weight={400}>{name}</Text>
        </Anchor>
      )}

      {authority !== "CUSTOMER" && (
        <Anchor
          onClick={() => {
            openModal({
              title: "Edit product",
              children: <ProductFrom />,
            });
          }}
        >
          <Text weight={400}>{name}</Text>
        </Anchor>
      )}
    </Card>
  );
};

export default ProductCard;
