export interface LoginStore {
  accessToken: string | null;
  isLogged: boolean;
  setAccessToken: (accessToken: string) => void;
  logoutUser: () => void;
}

export interface NotificationStore {
  successNotification: (message: string, title?: string) => void;
  errorNotification: (message: string, title?: string) => void;
}

export interface LoginUserRequestBody {
  email: string;
  password: string;
}

export interface RegisterUserRequestBody extends LoginUserRequestBody {
  name: string;
  phoneNumber: string;
}

export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
  imageUrl: string;
  isAvailable: boolean;
  deliveryTime: number;
}

export interface Category {
  id: number;
  name: string;
  products: Product[];
}

export interface CustomerCart {
  id: number;
  cartItems: CartItem[];
  totalPrice: number;
  totalQuantity: number;
}

export interface CartItem {
  id: number;
  product: Product;
  quantity: number;
}
