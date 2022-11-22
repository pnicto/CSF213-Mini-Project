import { Center, Loader } from "@mantine/core";
import axios from "axios";
import { useQuery } from "react-query";
import { useParams } from "react-router-dom";
import { Product } from "../types/interfaces";

const ProductDetails = () => {
  const { productId } = useParams<{ productId?: string }>();

  const { data: productData, isLoading } = useQuery(
    ["products", productId],
    () =>
      axios.get<Product>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/products/${productId}`
      )
  );

  return isLoading ? (
    <Center h={"80vh"}>
      <Loader size={"md"} />
    </Center>
  ) : (
    <div>{productData?.data.name}</div>
  );
};

export default ProductDetails;
