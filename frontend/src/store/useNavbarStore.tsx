import create from "zustand";
import { NavbarStore } from "../types/interfaces";

export const useNavbarStore = create<NavbarStore>()((set) => ({
  navbarElements: ["cart", "my profile"],
  setNavbarElements: (navbarElements: string[]) =>
    set((state) => ({ navbarElements })),
}));
