import { Navigate, Outlet } from "react-router-dom";
import { useLoginStore } from "../../store/loginStore";

const ProtectedRoute = () => {
  const { isLogged } = useLoginStore();

  return isLogged ? <Outlet /> : <Navigate to={"/login"} />;
};

export default ProtectedRoute;
