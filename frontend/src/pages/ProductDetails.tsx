import { useParams } from "react-router-dom";

const ProductDetails = () => {
  const { productId } = useParams<{ productId?: string }>();

  return <div>ProductDetails</div>;
};

export default ProductDetails;
