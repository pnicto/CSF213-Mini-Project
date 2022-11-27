import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { Category, Product } from "../types/interfaces";

export const useProductQuery = (activeCategory: Category | null) =>
  useQuery(["products", activeCategory], () =>
    axios.get<Product[]>(
      // If no category is selected set the request param to 0 to get all products
      `${import.meta.env.VITE_APP_BACKEND_URL}/products?name=${
        activeCategory ? activeCategory.id : 0
      }`
    )
  );
