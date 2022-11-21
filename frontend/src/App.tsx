import { MantineProvider, Navbar } from "@mantine/core";
import { Route, Routes } from "react-router-dom";
import { BrowserRouter } from "react-router-dom";
import Login from "./pages/Login";
import { QueryClient, QueryClientProvider } from "react-query";
import Home from "./pages/Home";
import Landing from "./pages/Landing";
import MainNavbar from "./components/MainNavbar";

const queryClient = new QueryClient();

export default function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <BrowserRouter>
        <MantineProvider
          withGlobalStyles
          withNormalizeCSS
          theme={{
            fontFamily: "Inter",
            colors: {
              blue: [
                "#F4F5F9",
                "#D6DAEA",
                "#B6C0E1",
                "#95A5DD",
                "#7189E0",
                "#476AEB",
                "#1749FF",
                "#1944E1",
                "#2948B9",
                "#314899",
              ],
              deepBlue: [
                "#9DA5C0",
                "#8590B8",
                "#6B7BB5",
                "#4F66B7",
                "#3954B6",
                "#2644B3",
                "#1235B3",
                "#1F3893",
                "#26387A",
                "#2A3766",
              ],
              orange: [
                "#EAE4DA",
                "#DED2BD",
                "#D7C29F",
                "#D5B67E",
                "#DBAC5A",
                "#E8A530",
                "#FFA200",
                "#CF8C17",
                "#A97925",
                "#8D6A2D",
              ],
            },
            headings: {
              fontFamily: "Inter",
            },
            primaryColor: "deepBlue",
          }}
        >
          <Routes>
            <Route path="/login" element={<Login />} />
            <Route path="/" element={<Landing />} />
            <Route path="/app" element={<MainNavbar />}>
              <Route index element={<Home />} />
            </Route>
          </Routes>
        </MantineProvider>
      </BrowserRouter>
    </QueryClientProvider>
  );
}
