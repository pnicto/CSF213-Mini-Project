import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useLoginStore } from "../store/loginStore";

const Home = () => {
  const { isLogged } = useLoginStore();
  const navigate = useNavigate();

  useEffect(() => {
    if (!isLogged) {
      navigate("/login");
    }
  }, [isLogged]);

  return (
    <>
      <div>Home</div>
    </>
  );
};

export default Home;
