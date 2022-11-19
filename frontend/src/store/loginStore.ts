import create from "zustand";
import { LoginState } from "../types/interfaces";

export const useLoginStore = create<LoginState>()((set) => ({
  accessToken: null,
  isLogged: false,
  setAccessToken: (accessToken: string) =>
    set((state) => ({ accessToken, isLogged: true })),
  logoutUser: () => set((state) => ({ accessToken: null, isLogged: false })),
}));
