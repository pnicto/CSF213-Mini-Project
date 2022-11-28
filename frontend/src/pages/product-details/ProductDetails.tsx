import { Center, Grid } from "@mantine/core";
import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { useParams } from "react-router-dom";
import LoadingSpinner from "../../components/display/LoadingSpinner";
import { useLoginStore } from "../../store/useLoginStore";
import { Product } from "../../types/interfaces";
import ProductDetailsCustomerView from "./ProductDetailsCustomerView";

const ProductDetails = () => {
  // Get route params
  const { productId } = useParams<{ productId?: string }>();
  const { authority } = useLoginStore();

  const { data: productData, isLoading } = useQuery(
    ["products", productId],
    () =>
      axios.get<Product>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/products/${productId}`
      )
  );

  if (isLoading) {
    return <LoadingSpinner />;
  } else {
    return (
      <Center mih={"65vh"}>
        <Grid
          style={{
            overflowY: "hidden",
          }}
          columns={13}
          maw={"100vw"}
        >
          {authority === "CUSTOMER" && (
            <ProductDetailsCustomerView product={productData!.data} />
          )}
        </Grid>
      </Center>
    );
  }
};

export default ProductDetails;
