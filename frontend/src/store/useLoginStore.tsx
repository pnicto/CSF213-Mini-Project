import create from "zustand";
import { Authority, LoginStore } from "../types/interfaces";

export const useLoginStore = create<LoginStore>()((set) => ({
  accessToken: null,
  isLogged: false,
  authority: null,
  setAccessToken: (accessToken: string) =>
    set((state) => ({ accessToken, isLogged: true })),
  logoutUser: () => set((state) => ({ accessToken: null, isLogged: false })),
  setAuthority: (authority: Authority) => set((state) => ({ authority })),
}));
