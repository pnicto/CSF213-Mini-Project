import {
  Anchor,
  Button,
  Container,
  Grid,
  Group,
  List,
  Title,
} from "@mantine/core";
import { openModal } from "@mantine/modals";
import { useMutation } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import LoadingSpinner from "../components/display/LoadingSpinner";
import ProductCard from "../components/display/ProductCard";
import ProductFrom from "../components/forms/ProductFrom";
import { useCategoriesQuery } from "../hooks/useCategoriesQuery";
import { useProductQuery } from "../hooks/useProductsQuery";
import { useActiveCategoryStore } from "../store/useActiveCategoryStore";
import { useLoginStore } from "../store/useLoginStore";
import { useNotificationStore } from "../store/useNotificationStore";
import { Product } from "../types/interfaces";

const Home = () => {
  // Hooks
  const { accessToken, authority } = useLoginStore();
  const notificationStore = useNotificationStore();
  const { activeCategory, setActiveCategory } = useActiveCategoryStore();
  // Axios default header setting
  axios.defaults.headers.common["Authorization"] = `Bearer ${accessToken}`;

  // Queries for data
  const productsQuery = useProductQuery(activeCategory);

  const categoriesQuery = useCategoriesQuery();

  const deleteProductMutation = useMutation(
    (productId: number) => {
      return axios.delete<Product[]>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/products/${productId}`
      );
    },
    {
      onSuccess: () => {
        notificationStore.successNotification("Deleted product successfully");
        productsQuery.refetch();
      },

      onError: (data: AxiosError) => {
        notificationStore.errorNotification(data.message, "Cannot delete item");
      },
    }
  );

  return productsQuery.isLoading && categoriesQuery.isLoading ? (
    <LoadingSpinner />
  ) : (
    <Container fluid>
      <Grid p={0} columns={13} mih={"92vh"}>
        <Grid.Col
          span={2}
          bg={"blue.0"}
          style={{
            borderRight: "solid 1px #9DA5C0",
          }}
        >
          <Container pos={"fixed"}>
            <Title pb="xs" order={2} color={"deepBlue"}>
              Categories
            </Title>
            <List withPadding>
              <List.Item
                onClick={() => {
                  setActiveCategory(null);
                }}
              >
                <Anchor color={"deepBlue.4"}>All products</Anchor>
              </List.Item>
              {categoriesQuery.data?.data.map((category) => (
                <List.Item
                  key={category.id}
                  onClick={() => {
                    setActiveCategory(category);
                  }}
                >
                  <Anchor color={"deepBlue.4"}>{category.name}</Anchor>
                </List.Item>
              ))}
            </List>
          </Container>
        </Grid.Col>
        <Grid.Col span={11}>
          <Group position="apart">
            <Title order={2} mb={"md"} ml={"sm"} color="deepBlue">
              {activeCategory ? activeCategory.name : "All products: "}
            </Title>
            {authority !== "CUSTOMER" && (
              <Button
                type="button"
                onClick={() => {
                  openModal({
                    title: "Add new product",
                    children: <ProductFrom />,
                    centered: true,
                  });
                }}
              >
                Add a product
              </Button>
            )}
          </Group>
          <Grid columns={4} gutter={"lg"} mx={"xs"}>
            {
              // Display loading spinner if the data is being re-fetched
              productsQuery.isFetching ? (
                <Grid.Col span={4}>
                  <LoadingSpinner />
                </Grid.Col>
              ) : (
                productsQuery.data?.data.map((product) => {
                  return (
                    <Grid.Col key={product.id} span={1}>
                      <ProductCard
                        key={product.id}
                        product={product}
                        deleteProductMutation={deleteProductMutation}
                      />
                    </Grid.Col>
                  );
                })
              )
            }
          </Grid>
        </Grid.Col>
      </Grid>
    </Container>
  );
};

export default Home;
