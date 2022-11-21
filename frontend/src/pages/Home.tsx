import axios from "axios";
import { useEffect } from "react";
import { useQuery } from "react-query";
import { useNavigate } from "react-router-dom";
import { useLoginStore } from "../store/loginStore";

const Home = () => {
  // Hooks
  const { isLogged, accessToken } = useLoginStore();
  const navigate = useNavigate();

  // Axios default header setting
  axios.defaults.headers.common["Authorization"] = `Bearer ${accessToken}`;

  // Queries for data
  const productsQuery = useQuery("products", () =>
    axios.get(`${import.meta.env.VITE_APP_BACKEND_URL}/products`)
  );
  const categoriesQuery = useQuery("categories", () =>
    axios.get(`${import.meta.env.VITE_APP_BACKEND_URL}/categories`)
  );

  // Navigate to login route if the user is not logged in
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
