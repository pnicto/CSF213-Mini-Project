import {
  ActionIcon,
  Button,
  Container,
  Group,
  List,
  Paper,
  Text,
  Title,
} from "@mantine/core";
import { openConfirmModal } from "@mantine/modals";
import { IconTrash, IconUserPlus } from "@tabler/icons";
import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useNotificationStore } from "../../store/useNotificationStore";
import { User } from "../../types/interfaces";
import LoadingSpinner from "../display/LoadingSpinner";

const ManageManagers = () => {
  const notificationStore = useNotificationStore();
  const queryClient = useQueryClient();
  const managersDataQuery = useQuery(["managers"], () =>
    axios.get<User[]>(`${import.meta.env.VITE_APP_BACKEND_URL}/managers/all`)
  );

  const deleteManagerMutation = useMutation(
    (managerId: number) => {
      return axios.delete<User[]>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/managers/${managerId}`
      );
    },
    {
      onSuccess: (data) => {
        notificationStore.successNotification("Deleted manager successfully");
        queryClient.setQueryData(["managers"], data);
      },

      onError: (data: AxiosError) => {
        notificationStore.errorNotification(
          data.message,
          "Cannot delete manager"
        );
      },
    }
  );

  if (managersDataQuery.isLoading) {
    return <LoadingSpinner />;
  }

  return (
    <Container>
      <Paper withBorder shadow={"xl"} p={"xl"} m={"xl"}>
        <Title order={2} mb={"md"}>
          List of all managers
        </Title>
        <List withPadding listStyleType={"none"}>
          {managersDataQuery.data!.data.length > 0 &&
            managersDataQuery.data!.data.map((manager) => {
              return (
                <List.Item key={manager.id}>
                  <Group>
                    <ActionIcon
                      color={"red"}
                      size={"lg"}
                      onClick={() => {
                        openConfirmModal({
                          title: "Are you sure",
                          labels: {
                            confirm: "Yes",
                            cancel: "No",
                          },
                          centered: true,
                          confirmProps: {
                            color: "red",
                          },
                          onConfirm: () => {
                            deleteManagerMutation.mutate(manager.id);
                          },
                        });
                      }}
                    >
                      <IconTrash />
                    </ActionIcon>
                    <Text>{manager.name}</Text>
                  </Group>
                </List.Item>
              );
            })}
        </List>
        <Group position="center">
          <Button type="button" leftIcon={<IconUserPlus />} variant="subtle">
            Add new manager
          </Button>
        </Group>
      </Paper>
    </Container>
  );
};

export default ManageManagers;
