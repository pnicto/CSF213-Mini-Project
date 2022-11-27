import { ActionIcon, Badge, Card, Group, Image, Text } from "@mantine/core";
import { IconTrash } from "@tabler/icons";
import { Link } from "react-router-dom";
import { useLoginStore } from "../../store/loginStore";
import { Product } from "../../types/interfaces";

type Props = {
  product: Product;
};

const ProductCard = ({ product }: Props) => {
  const { name, imageUrl, isAvailable, price } = product;
  const { authority } = useLoginStore();

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
          <ActionIcon color={"red"} onClick={() => {}}>
            <IconTrash />
          </ActionIcon>
        )}
      </Group>
      <Text weight={400}>{name}</Text>
    </Card>
  );
};

export default ProductCard;
