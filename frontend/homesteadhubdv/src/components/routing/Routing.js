import React from "react";
import { Route } from "react-router";
import { Routes } from "react-router-dom";
import Nepremicnie from "../Nepremicnine/Nepremicnine";
import DodajNepremicnino from "../Nepremicnine/DodajNepremicnino";
import Prijava from "../prijava/Prijava";
import Registracija from "../prijava/Registracija";
import PageNotFound from "../PageNotFound/PageNotFound";
import OgledNepremicnine from "../Nepremicnine/ogledNepremicnine";
import Nepremicnine from "../Nepremicnine/odstraniNepremicnine";
import Uporabniki from "../Nepremicnine/uporabniki";

export default function Routing() {
  return (
    <Routes>
      <Route path="/" element={<Nepremicnie />} />
      <Route path="/prijava" element={<Prijava />} />
      <Route path="/registracija" element={<Registracija />} />
      <Route path="/dodajNepremicnino" element={<DodajNepremicnino />} />
      <Route path="/ogledNepremicnine/:id" element={<OgledNepremicnine />} />
      <Route path="*" element={<PageNotFound />} />
      <Route path="/nepremicnine" element={<Nepremicnine />} />
      <Route path="/uporabniki" element={<Uporabniki />} />
    </Routes>
  );
}
