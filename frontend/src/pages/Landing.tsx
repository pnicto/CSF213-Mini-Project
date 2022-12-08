import { Button, Center, Flex, Group, Title } from "@mantine/core";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { ReactComponent as CartLogo } from "../assets/cart.svg";
import { useLoginStore } from "../store/useLoginStore";

const Landing = () => {
  const navigate = useNavigate();
  const { isLogged } = useLoginStore();

  useEffect(() => {
    if (isLogged) {
      navigate("/app");
    }
  }, [isLogged]);

  return (
    <Center h={"100vh"}>
      <Flex direction={"column"} align="center" gap={"md"}>
        <Title weight="bold" color="deepBlue" pb="xl" size={44}>
          Silkroad
        </Title>
        <CartLogo height={550} />
        <Group position="center">
          <Button
            type="button"
            mt="xl"
            onClick={() => {
              navigate("/login");
            }}
          >
            Click here to login/register
          </Button>
        </Group>
      </Flex>
    </Center>
  );
};

export default Landing;
