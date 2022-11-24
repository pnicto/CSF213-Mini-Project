import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { Customer } from "../types/interfaces";

const CustomerProfile = () => {
  const profileDataQuery = useQuery(["customerProfile"], () =>
    axios.get<Customer>(`${import.meta.env.VITE_APP_BACKEND_URL}/customers`)
  );

  return <div>CustomerProfile</div>;
};

export default CustomerProfile;
