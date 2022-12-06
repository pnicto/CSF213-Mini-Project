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
import { openConfirmModal, openModal } from "@mantine/modals";
import { IconTrash, IconUserPlus } from "@tabler/icons";
import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import axios, { AxiosError } from "axios";
import { useNotificationStore } from "../../store/useNotificationStore";
import { Customer } from "../../types/interfaces";
import LoadingSpinner from "../display/LoadingSpinner";
import AddCustomerForm from "../forms/AddCustomerForm";

const ManageCustomers = () => {
  const notificationStore = useNotificationStore();
  const queryClient = useQueryClient();

  const customersDataQuery = useQuery(["customers"], () =>
    axios.get<Customer[]>(
      `${import.meta.env.VITE_APP_BACKEND_URL}/customers/all`
    )
  );

  const deleteCustomerMutation = useMutation(
    (customerId: number) => {
      return axios.delete<Customer[]>(
        `${import.meta.env.VITE_APP_BACKEND_URL}/customers/${customerId}`
      );
    },
    {
      onSuccess: (data) => {
        notificationStore.successNotification("Deleted customer successfully");
        queryClient.setQueryData(["customers"], data);
      },

      onError: (data: AxiosError) => {
        notificationStore.errorNotification(
          data.message,
          "Cannot delete customer"
        );
      },
    }
  );

  if (customersDataQuery.isLoading) {
    return <LoadingSpinner />;
  }

  return (
    <Container>
      <Paper withBorder shadow={"xl"} p={"xl"} m={"xl"}>
        <Title order={2} mb={"md"}>
          List of all customers
        </Title>
        <Group position="center">
          <Button
            type="button"
            leftIcon={<IconUserPlus />}
            variant="subtle"
            onClick={() => {
              openModal({
                title: "Add a new customer",
                children: <AddCustomerForm />,
                centered: true,
              });
            }}
          >
            Add new customer
          </Button>
        </Group>
        <List withPadding listStyleType={"none"}>
          {customersDataQuery.data!.data.length > 0 &&
            customersDataQuery.data!.data.map((customer) => {
              return (
                <List.Item key={customer.id}>
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
                            deleteCustomerMutation.mutate(customer.id);
                          },
                        });
                      }}
                    >
                      <IconTrash />
                    </ActionIcon>
                    <Text>{customer.name}</Text>
                  </Group>
                </List.Item>
              );
            })}
        </List>
      </Paper>
    </Container>
  );
};

export default ManageCustomers;
