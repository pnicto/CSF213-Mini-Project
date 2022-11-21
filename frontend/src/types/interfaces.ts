export interface LoginState {
  accessToken: string | null;
  isLogged: boolean;
  setAccessToken: (accessToken: string) => void;
  logoutUser: () => void;
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
