import { Button, Group } from "@mantine/core";
import { useState } from "react";
import ManageCategories from "../components/dashboard/ManageCategories";
import ManageManagers from "../components/dashboard/ManageManagers";

const Dashboard = () => {
  type dashboardState = "manage managers" | "manage categories" | "reports";

  const [activeOption, setActiveOption] =
    useState<dashboardState>("manage managers");

  return (
    <>
      <Group position={"center"} m={"lg"}>
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
        <Button
          onClick={() => {
            setActiveOption("manage categories");
          }}
          variant="outline"
          size="md"
          type="button"
        >
          Manage categories
        </Button>
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
      {activeOption === "manage categories" && <ManageCategories />}
    </>
  );
};

export default Dashboard;
