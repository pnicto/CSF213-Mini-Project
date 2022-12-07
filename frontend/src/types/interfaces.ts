export type Authority = "ADMIN" | "CUSTOMER" | "MANAGER";

export interface LoginStore {
  accessToken: string | null;
  isLogged: boolean;
  authority: Authority | null;
  setAccessToken: (accessToken: string) => void;
  logoutUser: () => void;
  setAuthority: (authority: Authority) => void;
}

export interface LoginResponse {
  scope: Authority;
  accessToken: string;
}
export interface NavbarStore {
  navbarElements: string[];
  setNavbarElements: (navbarElements: string[]) => void;
}

export interface ActiveCategoryStore {
  activeCategory: Category | null;
  setActiveCategory: (activeCategory: Category | null) => void;
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
  address: string;
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
  category: { id: number; name: string };
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
  deliveryTime: number;
  totalQuantity: number;
}

export interface CartItem {
  id: number;
  product: Product;
  quantity: number;
}

export interface Customer {
  id: number;
  name: string;
  email: string;
  address: string;
  role: string;
  phoneNumber: string;
  createdAt: Date;
  moneyInWallet: number;
  cart: CustomerCart;
  orders: Order[];
}

export interface Order {
  id: number;
  orderItems: OrderItem[];
  totalPrice: number;
  createdAt: Date;
  deliveryTime: number;
}

export interface OrderItem {
  id: number;
  name: string;
  quantity: number;
  imageUrl: string;
  price: number;
  productId: number;
}

export interface User {
  id: number;
  name: string;
  email: string;
  role: string;
  phoneNumber: string;
  createdAt: Date;
}

export interface ReportsInterface {
  newlyRegisteredCustomersLastSixMonths: LastSixMonth[];
  totalRevenue: number;
  totalRevenueLastSixMonths: LastSixMonth[];
  totalProductsSoldLastSixMonths: LastSixMonth[];
  totalRegisteredCustomers: number;
  totalProductsSold: number;
}

export interface LastSixMonth {
  label: string;
  value: number | null;
}
