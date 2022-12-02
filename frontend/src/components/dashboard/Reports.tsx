import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { ReportsInterface } from "../../types/interfaces";

const Reports = () => {
  const reportsQuery = useQuery(["reports"], () =>
    axios.get<ReportsInterface>(
      `${import.meta.env.VITE_APP_BACKEND_URL}/reports`
    )
  );

  return <div>Reports</div>;
};

export default Reports;
