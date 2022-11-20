import { ActionIcon, Container, Flex, Menu, Title } from "@mantine/core";
import { Outlet } from "react-router-dom";
import { IconDots, IconLogout } from "@tabler/icons";
import { useLoginStore } from "../store/loginStore";

type Props = {};

const MainNavbar = ({}: Props) => {
  const loginStore = useLoginStore();

  return (
    <>
      <Container fluid mb={"xs"}>
        <nav>
          <Flex justify={"space-between"} p={"xs"}>
            <div>
              <Title size="h1" weight="bold" color="deepBlue" order={1}>
                Silkroad
              </Title>
            </div>

            <div>
              <Menu position="bottom-start">
                <Menu.Target>
                  <ActionIcon variant="filled" color={"deepBlue"}>
                    <IconDots />
                  </ActionIcon>
                </Menu.Target>

                <Menu.Dropdown>
                  <Menu.Item
                    icon={<IconLogout />}
                    fw="bold"
                    color="red"
                    onClick={() => {
                      loginStore.logoutUser();
                    }}
                  >
                    Log out
                  </Menu.Item>
                </Menu.Dropdown>
              </Menu>
            </div>
          </Flex>
        </nav>
      </Container>
      <Outlet />
    </>
  );
};

export default MainNavbar;
