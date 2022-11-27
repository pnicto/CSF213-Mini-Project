import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { Category } from "../types/interfaces";

export const useCategoriesQuery = () =>
  useQuery(["categories"], () =>
    axios.get<Category[]>(`${import.meta.env.VITE_APP_BACKEND_URL}/categories`)
  );
