import React from "react";
import { Route } from "react-router";
import { Routes } from "react-router-dom";
import Nepremicnie from "../Nepremicnine/Nepremicnine";
import Prijava from "../prijava/Prijava";
import Registracija from "../prijava/Registracija";
import PageNotFound from "../PageNotFound/PageNotFound";

export default function Routing() {
  return (
    <Routes>
      <Route path="/" element={<Nepremicnie />} />
      <Route path="/prijava" element={<Prijava />} />
      <Route path="/registracija" element={<Registracija />} />
      <Route path="*" element={<PageNotFound />} />
    </Routes>
  );
}
