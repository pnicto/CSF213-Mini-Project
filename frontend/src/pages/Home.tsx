import { Anchor, Container, Grid, List, Title } from "@mantine/core";
import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { useState } from "react";
import LoadingSpinner from "../components/display/LoadingSpinner";
import ProductCard from "../components/display/ProductCard";
import { useLoginStore } from "../store/loginStore";
import { Category, Product } from "../types/interfaces";

const Home = () => {
  // Hooks
  const { accessToken } = useLoginStore();
  const [activeCategory, setActiveCategory] = useState<Category | null>(null);

  // Axios default header setting
  axios.defaults.headers.common["Authorization"] = `Bearer ${accessToken}`;

  // Queries for data
  const productsQuery = useQuery(["products", activeCategory], () =>
    axios.get<Product[]>(
      // If not category is selected set the request param to 0 to get all products
      `${import.meta.env.VITE_APP_BACKEND_URL}/products?name=${
        activeCategory ? activeCategory.id : 0
      }`
    )
  );

  const categoriesQuery = useQuery(["categories"], () =>
    axios.get<Category[]>(`${import.meta.env.VITE_APP_BACKEND_URL}/categories`)
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
          <Title order={2} mb={"md"} ml={"sm"} color="deepBlue">
            {activeCategory ? activeCategory.name : "All products: "}
          </Title>
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
                        activeCategory={activeCategory}
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
