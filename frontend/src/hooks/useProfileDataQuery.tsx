import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { Customer } from "../types/interfaces";

export const useProfileDataQuery = () =>
  useQuery(["customerProfile"], () =>
    axios.get<Customer>(`${import.meta.env.VITE_APP_BACKEND_URL}/customers`)
  );
