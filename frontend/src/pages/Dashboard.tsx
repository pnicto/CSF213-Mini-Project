import { Button, Group } from "@mantine/core";
import { useState } from "react";
import ManageManagers from "../components/dashboard/ManageManagers";
import { useLoginStore } from "../store/useLoginStore";

const Dashboard = () => {
  type dashboardState = "manage managers" | "reports";
  const { authority } = useLoginStore();
  const [activeOption, setActiveOption] =
    useState<dashboardState>("manage managers");

  return (
    <>
      <Group position={"center"} m={"lg"}>
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
      </Group>
      {activeOption === "manage managers" && <ManageManagers />}
    </>
  );
};

export default Dashboard;
