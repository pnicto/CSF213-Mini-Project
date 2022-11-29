import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { useLoginStore } from "../store/useLoginStore";
import { Customer } from "../types/interfaces";

export const useProfileDataQuery = () => {
  const { authority } = useLoginStore();
  let queryKeys: string[];
  switch (authority) {
    case "CUSTOMER":
      queryKeys = ["customerProfile"];
      break;
    case "MANAGER":
      queryKeys = ["managerProfile"];
      break;
    default:
      queryKeys = ["adminProfile"];
  }
  return useQuery(queryKeys, () =>
    axios.get<Customer>(
      `${import.meta.env.VITE_APP_BACKEND_URL}/${authority?.toLowerCase()}s`
    )
  );
};
