import {
  ActionIcon,
  Anchor,
  Container,
  Flex,
  Menu,
  Select,
  Title,
} from "@mantine/core";
import { IconDots, IconLogout, IconSearch } from "@tabler/icons";
import axios from "axios";
import { useState } from "react";
import { Link, Outlet, useNavigate } from "react-router-dom";
import { useProductQuery } from "../hooks/useProductsQuery";
import { useLoginStore } from "../store/useLoginStore";
import { useNavbarStore } from "../store/useNavbarStore";

const MainNavbar = () => {
  const loginStore = useLoginStore();

  axios.defaults.headers.common[
    "Authorization"
  ] = `Bearer ${loginStore.accessToken}`;

  const navigate = useNavigate();
  const { navbarElements } = useNavbarStore();
  const [selectValue, setSelectValue] = useState<string | null>(null);
  const productsQuery = useProductQuery();

  if (productsQuery.isLoading) {
    return <></>;
  }

  const selectData = productsQuery.data!.data.map((product) => {
    return { value: product.id.toString(), label: product.name };
  });

  return (
    <>
      <Container
        fluid
        bg="blue.1"
        mah={"10vh"}
        pos={"sticky"}
        top={0}
        style={{ zIndex: 1 }}
      >
        <nav>
          <Flex justify={"space-between"} p={"xs"}>
            <div>
              <Anchor component={Link} to="/app">
                <Title size="h1" weight="bold" color="deepBlue" order={1}>
                  Silkroad
                </Title>
              </Anchor>
            </div>

            <Select
              data={selectData}
              maxDropdownHeight={280}
              clearable
              nothingFound="Nothing found"
              icon={<IconSearch />}
              searchable
              value={selectValue}
              onChange={(value) => {
                setSelectValue(value);
                if (value === null) {
                  navigate("/app");
                } else {
                  navigate(`/app/product/${value}`);
                }
              }}
              miw={"40%"}
              radius="xl"
              selectOnBlur
            />

            <Flex dir="row" justify={"space-around"} align="center" miw={"20%"}>
              {navbarElements.map((ele, idx) => (
                <Anchor
                  fw="bold"
                  key={idx}
                  component={Link}
                  to={`/app/${ele}`}
                  tt="capitalize"
                  size="lg"
                >
                  {ele}
                </Anchor>
              ))}
              <Menu position="bottom" shadow={"lg"}>
                <Menu.Target>
                  <ActionIcon
                    color={"deepBlue"}
                    variant="transparent"
                    size={"lg"}
                  >
                    <IconDots />
                  </ActionIcon>
                </Menu.Target>

                <Menu.Dropdown>
                  <Menu.Item
                    icon={<IconLogout />}
                    fw="bold"
                    color="red"
                    title="more options menu"
                    onClick={() => {
                      loginStore.logoutUser();
                      navigate("/login");
                    }}
                  >
                    Log out
                  </Menu.Item>
                </Menu.Dropdown>
              </Menu>
            </Flex>
          </Flex>
        </nav>
      </Container>
      <Outlet />
    </>
  );
};

export default MainNavbar;
