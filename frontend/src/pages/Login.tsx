import { Center, Container } from "@mantine/core";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import LoginForm from "../components/forms/LoginForm";
import { useLoginStore } from "../store/useLoginStore";

const Login = () => {
  const { isLogged } = useLoginStore();
  const navigate = useNavigate();

  useEffect(() => {
    if (isLogged) {
      navigate("/app");
    }
  }, [isLogged]);

  return (
    <Container h={"100vh"} bg="gray.1" fluid>
      <Center h={"90vh"} miw="30vw">
        <LoginForm />
      </Center>
    </Container>
  );
};

export default Login;
