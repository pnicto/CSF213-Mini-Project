import {
  Badge,
  Button,
  Center,
  Grid,
  Image,
  Loader,
  NumberInput,
  Stack,
  Text,
  Title,
} from "@mantine/core";
import axios from "axios";
import { useState } from "react";
import { useQuery } from "react-query";
import { useParams } from "react-router-dom";
import { useLoginStore } from "../store/loginStore";
import { Product } from "../types/interfaces";

const ProductDetails = () => {
  const { productId } = useParams<{ productId?: string }>();
  const [quantity, setQuantity] = useState(1);

  const { accessToken } = useLoginStore();
  axios.defaults.headers.common["Authorization"] = `Bearer ${accessToken}`;

  const { data: productData, isLoading } = useQuery(
    ["products", productId],
    () =>
      axios.get<Product>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/products/${productId}`
      )
  );

  if (isLoading) {
    return (
      <Center h={"80vh"}>
        <Loader size={"md"} />
      </Center>
    );
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
              {/* TODO:onClick for add to cart */}
              <Button>Add to cart</Button>
            </Stack>
          </Grid.Col>
        </Grid>
      </Center>
    );
  }
};

export default ProductDetails;
