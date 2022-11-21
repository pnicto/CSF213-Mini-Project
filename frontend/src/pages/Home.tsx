import axios from "axios";
import { useEffect } from "react";
import { useQuery } from "react-query";
import { useNavigate } from "react-router-dom";
import { useLoginStore } from "../store/loginStore";

const Home = () => {
  const { isLogged } = useLoginStore();
  const navigate = useNavigate();

  const { accessToken } = useLoginStore();
  axios.defaults.headers.common["Authorization"] = `Bearer ${accessToken}`;

  const { data, isLoading } = useQuery("products", () =>
    axios.get(`${import.meta.env.VITE_APP_BACKEND_URL}/products`)
  );

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
