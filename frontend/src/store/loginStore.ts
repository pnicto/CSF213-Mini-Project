import create from "zustand";
import { LoginStore } from "../types/interfaces";

export const useLoginStore = create<LoginStore>()((set) => ({
  accessToken: null,
  isLogged: false,
  setAccessToken: (accessToken: string) =>
    set((state) => ({ accessToken, isLogged: true })),
  logoutUser: () => set((state) => ({ accessToken: null, isLogged: false })),
}));
