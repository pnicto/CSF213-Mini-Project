import { MantineProvider } from "@mantine/core";
import { ModalsProvider } from "@mantine/modals";
import { NotificationsProvider } from "@mantine/notifications";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ProtectedRoute from "./components/auth/ProtectedRoute";
import MainNavbar from "./components/MainNavbar";
import Cart from "./pages/Cart";
import Dashboard from "./pages/Dashboard";
import Home from "./pages/Home";
import Landing from "./pages/Landing";
import Login from "./pages/Login";
import ProductDetails from "./pages/product-details/ProductDetails";
import UserProfile from "./pages/UserProfile";

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
          <NotificationsProvider autoClose={4000}>
            <ModalsProvider
              modalProps={{
                overlayBlur: 5,
              }}
            >
              <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/" element={<Landing />} />
                <Route element={<ProtectedRoute />}>
                  <Route path="/app" element={<MainNavbar />}>
                    <Route index element={<Home />} />
                    <Route
                      path="product/:productId"
                      element={<ProductDetails />}
                    />
                    <Route path="cart" element={<Cart />} />
                    <Route path="my profile" element={<UserProfile />} />
                    <Route path="dashboard" element={<Dashboard />} />
                  </Route>
                </Route>
              </Routes>
            </ModalsProvider>
          </NotificationsProvider>
        </MantineProvider>
      </BrowserRouter>
    </QueryClientProvider>
  );
}
