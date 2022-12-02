import { Container, Group, Paper, Text, Title } from "@mantine/core";
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
        <Group position="center">
          <Text>
            <strong>Total revenue:</strong> &#8377;{" "}
            {data.totalRevenue.toFixed(2)}
          </Text>
          <Text>
            <strong>Total products sold:</strong> {data.totalProductsSold}
          </Text>
          <Text>
            <strong>Total customers:</strong> {data.totalRegisteredCustomers}
          </Text>
        </Group>
        <Title order={2} mt={"md"}>
          Products sold in last 6 months
        </Title>
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
