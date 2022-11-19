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
