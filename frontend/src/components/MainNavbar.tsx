import { Container } from "@mantine/core";
import { Outlet } from "react-router-dom";
type Props = {};

const MainNavbar = (props: Props) => {
  return (
    <>
      <Container fluid mb={"xs"}>
        <nav></nav>
      </Container>
      <Outlet />
    </>
  );
};

export default MainNavbar;
