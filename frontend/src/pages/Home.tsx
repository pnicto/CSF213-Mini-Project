import { Container, Grid, List, Title } from "@mantine/core";
import axios from "axios";
import { useEffect } from "react";
import { useQuery } from "react-query";
import { useNavigate } from "react-router-dom";
import { useLoginStore } from "../store/loginStore";
import { Category, Product } from "../types/interfaces";

const Home = () => {
  // Hooks
  const { isLogged, accessToken } = useLoginStore();
  const navigate = useNavigate();

  // Axios default header setting
  axios.defaults.headers.common["Authorization"] = `Bearer ${accessToken}`;

  // Queries for data
  const productsQuery = useQuery("products", () =>
    axios.get<Product[]>(`${import.meta.env.VITE_APP_BACKEND_URL}/products`)
  );
  const categoriesQuery = useQuery("categories", () =>
    axios.get<Category[]>(`${import.meta.env.VITE_APP_BACKEND_URL}/categories`)
  );

  // Navigate to login route if the user is not logged in
  useEffect(() => {
    if (!isLogged) {
      navigate("/login");
    }
  }, [isLogged]);

  return (
    <Container fluid px={8}>
      <Grid p={0} columns={14}>
        <Grid.Col span={2}>
          <Container pos={"fixed"}>
            <Title pb="xs" order={2} color={"deepBlue"}>
              Categories
            </Title>
            <List withPadding>
              {categoriesQuery.data?.data.map((category) => (
                <List.Item key={category.id}>{category.name}</List.Item>
              ))}
            </List>
          </Container>
        </Grid.Col>
        <Grid.Col
          span={12}
          style={{
            borderLeft: "solid 1px #9DA5C0",
          }}
        >
          <Grid columns={3}>
            {productsQuery.data?.data.map((product) => {
              return (
                <Grid.Col key={product.id} span={1}>
                  {product.name}
                </Grid.Col>
              );
            })}
          </Grid>
        </Grid.Col>
      </Grid>
    </Container>
  );
};

export default Home;
