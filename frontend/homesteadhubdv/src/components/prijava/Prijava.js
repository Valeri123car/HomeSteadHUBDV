import React, { useRef, useEffect, useState } from "react";
import axios from "axios";
import Navbar from "../Navbar/Navbar";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { Link } from "react-router-dom";

function Prijava() {
  return (
    <div className="prijavaBackground">
      <Navbar></Navbar>
      <div className="prijavaMain">
        <div className="prijavaOkno">
          <h2>Prijava</h2>
          <TextField label="Mail" variant="outlined" />
          <TextField label="Geslo" variant="outlined" />
          <Link to={"/registracija"}>Nimate računa?</Link>
          <Button className="prijavaButton">Prijava</Button>
        </div>
      </div>
    </div>
  );
}

export default Prijava;
