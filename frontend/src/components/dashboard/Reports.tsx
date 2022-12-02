import { Container, Paper, Title } from "@mantine/core";
import { useMemo } from "react";
import { AxisOptions, Chart } from "react-charts";
import { LastSixMonth, ReportsInterface } from "../../types/interfaces";

type Props = {
  data: ReportsInterface;
};

const Reports = ({ data }: Props) => {
  const productsSoldData = useMemo(
    () => [
      {
        label: "Products sold",
        data: data.totalProductsSoldLastSixMonths,
      },
    ],
    []
  );

  const revenueData = useMemo(
    () => [
      {
        label: "Revenue generated",
        data: data.totalRevenueLastSixMonths,
      },
    ],
    []
  );

  const customersData = useMemo(
    () => [
      {
        label: "Customers registered",
        data: data.newlyRegisteredCustomersLastSixMonths,
      },
    ],
    []
  );

  const primaryAxis = useMemo(
    (): AxisOptions<LastSixMonth> => ({
      getValue: (datum) => datum.label,
    }),
    []
  );

  const secondaryAxes = useMemo(
    (): AxisOptions<LastSixMonth>[] => [
      {
        getValue: (datum) => {
          if (datum.value) {
            return datum.value;
          } else {
            return 0;
          }
        },
      },
    ],
    []
  );

  return (
    <>
      <Container>
        <Title order={2}>Products sold in last 6 months</Title>
        <Paper mih={300} shadow={"md"} withBorder>
          <Chart
            options={{
              data: productsSoldData,
              primaryAxis,
              secondaryAxes,
            }}
          />
        </Paper>
        <Title order={2} mt={"md"}>
          Revenue generated in last 6 months
        </Title>
        <Paper mih={300} shadow={"md"} withBorder>
          <Chart
            options={{
              data: revenueData,
              primaryAxis,
              secondaryAxes,
            }}
          />
        </Paper>
        <Title order={2} mt={"md"}>
          New customers registered in last 6 months
        </Title>
        <Paper mih={300} shadow={"md"} withBorder>
          <Chart
            options={{
              data: customersData,
              primaryAxis,
              secondaryAxes,
            }}
          />
        </Paper>
      </Container>
    </>
  );
};

export default Reports;
