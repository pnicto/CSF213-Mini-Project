import axios from "axios";
import { useQuery } from "react-query";
import { useParams } from "react-router-dom";
import { Product } from "../types/interfaces";

const ProductDetails = () => {
  const { productId } = useParams<{ productId?: string }>();

  const productQuery = useQuery(["products", productId], () =>
    axios.get<Product>(
      `${import.meta.env.VITE_APP_BACKEND_URL}/products/${productId}`
    )
  );

  return <div>ProductDetails</div>;
};

export default ProductDetails;
