import { MantineProvider } from "@mantine/core";
import { Route, Routes } from "react-router-dom";
import { Home } from "./pages/Home";
import { BrowserRouter } from "react-router-dom";

export default function App() {
  return (
    <BrowserRouter>
      <MantineProvider withGlobalStyles withNormalizeCSS>
        <Routes>
          <Route path="/" element={<Home />} />
        </Routes>
      </MantineProvider>
    </BrowserRouter>
  );
}
