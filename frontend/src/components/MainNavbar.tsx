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
import { useLoginStore } from "../store/loginStore";

type Props = {
  navbarElements?: string[];
};

const MainNavbar = ({ navbarElements = ["cart", "my profile"] }: Props) => {
  const loginStore = useLoginStore();
  const navigate = useNavigate();

  return (
    <>
      <Container fluid mb={"sm"} bg="blue.1" mah={"10vh"}>
        <nav>
          <Flex justify={"space-between"} p={"xs"}>
            <div>
              <Title size="h1" weight="bold" color="deepBlue" order={1}>
                Silkroad
              </Title>
            </div>

            <Flex dir="row" justify={"space-around"} align="center" miw={"20%"}>
              {navbarElements.map((ele, idx) => (
                <Anchor
                  fw="bold"
                  key={idx}
                  component={Link}
                  to={`/${ele}`}
                  tt="capitalize"
                  size="lg"
                >
                  {ele}
                </Anchor>
              ))}
              <Menu position="bottom" trigger="hover" shadow={"lg"}>
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
