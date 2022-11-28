import { Center, Grid } from "@mantine/core";
import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { useParams } from "react-router-dom";
import LoadingSpinner from "../../components/display/LoadingSpinner";
import { useLoginStore } from "../../store/useLoginStore";
import { Product } from "../../types/interfaces";
import ProductDetailsAdminManagerView from "./ProductDetailsAdminManagerView";
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
      <>
        {authority === "CUSTOMER" && (
          <Center mih={"65vh"}>
            <Grid columns={13} maw={"100vw"} m={0}>
              <ProductDetailsCustomerView product={productData!.data} />
            </Grid>
          </Center>
        )}

        {authority !== "CUSTOMER" && (
          <Grid columns={13} m={0}>
            <ProductDetailsAdminManagerView product={productData!.data} />
          </Grid>
        )}
      </>
    );
  }
};

export default ProductDetails;
