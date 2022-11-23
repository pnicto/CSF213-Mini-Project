import { showNotification } from "@mantine/notifications";
import { IconCheck, IconX } from "@tabler/icons";
import create from "zustand";
import { NotificationStore } from "../types/interfaces";

export const useNotificationStore = create<NotificationStore>()((set) => ({
  successNotification: (message: string, title?: string) => {
    showNotification({
      message,
      icon: <IconCheck />,
      color: "green",
      title,
    });
  },
  errorNotification: (message: string, title?: string) => {
    showNotification({
      message,
      color: "red",
      icon: <IconX />,
    });
  },
}));
