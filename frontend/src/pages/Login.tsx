import { Center, Divider, Flex, Title } from "@mantine/core";
import { ReactComponent as CartLogo } from "../assets/cart.svg";
import LoginForm from "../components/forms/LoginForm";

const Login = () => {
  return (
    <Flex id="login-page" direction={"row"} align="center">
      <div id="login-left">
        <Title size={"h1"} weight="bold" align="left" color={"deepBlue"}>
          Silkroad
        </Title>
        <CartLogo className="svg-logo" height={500} />
      </div>

      <Center>
        <LoginForm />
      </Center>
    </Flex>
  );
};

export default Login;
