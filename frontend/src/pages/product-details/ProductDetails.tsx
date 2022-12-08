import { Center, Container, Grid, Space } from "@mantine/core";
import { useParams } from "react-router-dom";
import LoadingSpinner from "../../components/display/LoadingSpinner";
import { useProductQueryWithId } from "../../hooks/useProductsQuery";
import { useLoginStore } from "../../store/useLoginStore";
import ProductDetailsAdminManagerView from "./ProductDetailsAdminManagerView";
import ProductDetailsCustomerView from "./ProductDetailsCustomerView";

const ProductDetails = () => {
  // Get route params
  const { productId } = useParams<{ productId?: string }>();
  const { authority } = useLoginStore();
  const { data, isLoading } = useProductQueryWithId(productId!);
  if (isLoading) {
    return <LoadingSpinner />;
  }

  return (
    <>
      <Container fluid mt={"lg"}>
        <Space h="xl" />
        <Space h="xl" />
        {authority === "CUSTOMER" && (
          <Center mih={"65vh"}>
            <Grid columns={13} maw={"100vw"} m={0}>
              <ProductDetailsCustomerView product={data!.data} />
            </Grid>
          </Center>
        )}

        {authority !== "CUSTOMER" && (
          <Grid columns={13} m={0}>
            <ProductDetailsAdminManagerView product={data!.data} />
          </Grid>
        )}
      </Container>
    </>
  );
};

export default ProductDetails;
