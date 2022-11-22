import { Card, Group, Image, Text, Badge } from "@mantine/core";
import { Link } from "react-router-dom";
import { Product } from "../types/interfaces";

type Props = {
  product: Product;
};

const ProductCard = ({ product }: Props) => {
  const { name, imageUrl, isAvailable, price } = product;

  return (
    <Card
      shadow={"md"}
      withBorder
      h={"100%"}
      component={Link}
      to={`product/${product.id}`}
    >
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
        <Text weight={300}>{price}</Text>
        {isAvailable ? (
          <Badge color="green" variant="light">
            In stock
          </Badge>
        ) : (
          <Badge color="red" variant="light">
            Out of stock
          </Badge>
        )}
      </Group>
      <Text weight={400}>{name}</Text>
    </Card>
  );
};

export default ProductCard;
