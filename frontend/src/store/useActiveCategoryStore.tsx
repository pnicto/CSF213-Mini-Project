import create from "zustand";
import { ActiveCategoryStore, Category } from "../types/interfaces";

export const useActiveCategoryStore = create<ActiveCategoryStore>()((set) => ({
  activeCategory: null,
  setActiveCategory: (activeCategory: Category | null) =>
    set((state) => ({ activeCategory })),
}));
