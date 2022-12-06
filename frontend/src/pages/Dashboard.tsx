import { Button, Group } from "@mantine/core";
import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { useState } from "react";
import ManageCustomers from "../components/dashboard/ManageCustomers";
import ManageManagers from "../components/dashboard/ManageManagers";
import Reports from "../components/dashboard/Reports";
import LoadingSpinner from "../components/display/LoadingSpinner";
import { useLoginStore } from "../store/useLoginStore";
import { ReportsInterface } from "../types/interfaces";

const Dashboard = () => {
  type dashboardState = "manage managers" | "manage customers" | "reports";
  const { authority } = useLoginStore();
  const [activeOption, setActiveOption] = useState<dashboardState>("reports");

  const reportsQuery = useQuery(["reports"], () =>
    axios.get<ReportsInterface>(
      `${import.meta.env.VITE_APP_BACKEND_URL}/reports`
    )
  );

  if (reportsQuery.isLoading) {
    return <LoadingSpinner />;
  }

  return (
    <>
      <Group position={"center"} m={"lg"}>
        <Button
          onClick={() => {
            setActiveOption("reports");
          }}
          variant="outline"
          size="md"
          type="button"
        >
          Generate reports
        </Button>
        <Button
          onClick={() => {
            setActiveOption("manage customers");
          }}
          variant="outline"
          size="md"
          type="button"
        >
          Manage customers
        </Button>
        {authority === "ADMIN" && (
          <Button
            onClick={() => {
              setActiveOption("manage managers");
            }}
            variant="outline"
            size="md"
            type="button"
          >
            Manage managers
          </Button>
        )}
      </Group>
      {activeOption === "reports" && <Reports data={reportsQuery.data!.data} />}
      {activeOption === "manage managers" && authority === "ADMIN" && (
        <ManageManagers />
      )}
      {activeOption === "manage customers" && <ManageCustomers />}
    </>
  );
};

export default Dashboard;
