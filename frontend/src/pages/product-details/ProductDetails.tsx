import { Center, Grid } from "@mantine/core";
import { useParams } from "react-router-dom";
import { useLoginStore } from "../../store/useLoginStore";
import ProductDetailsAdminManagerView from "./ProductDetailsAdminManagerView";
import ProductDetailsCustomerView from "./ProductDetailsCustomerView";

const ProductDetails = () => {
  // Get route params
  const { productId } = useParams<{ productId?: string }>();
  const { authority } = useLoginStore();

  return (
    <>
      {authority === "CUSTOMER" && (
        <Center mih={"65vh"}>
          <Grid columns={13} maw={"100vw"} m={0}>
            <ProductDetailsCustomerView productId={productId!} />
          </Grid>
        </Center>
      )}

      {authority !== "CUSTOMER" && (
        <Grid columns={13} m={0}>
          <ProductDetailsAdminManagerView productId={productId!} />
        </Grid>
      )}
    </>
  );
};

export default ProductDetails;
