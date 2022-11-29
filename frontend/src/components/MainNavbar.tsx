import {
  ActionIcon,
  Anchor,
  Container,
  Flex,
  Menu,
  Title,
} from "@mantine/core";
import { IconDots, IconLogout } from "@tabler/icons";
import { Link, Outlet, useNavigate } from "react-router-dom";
import { useLoginStore } from "../store/useLoginStore";
import { useNavbarStore } from "../store/useNavbarStore";

const MainNavbar = () => {
  const loginStore = useLoginStore();
  const navigate = useNavigate();
  const { navbarElements } = useNavbarStore();

  return (
    <>
      <Container
        fluid
        mb={"sm"}
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
