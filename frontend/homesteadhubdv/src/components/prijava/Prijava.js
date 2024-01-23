import React, { useRef, useEffect, useState } from "react";
import axios from "axios";
import Navbar from "../Navbar/Navbar";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { Link } from "react-router-dom";

function Prijava() {
  const [gmail, setGmail] = useState("");
  const [geslo, setGeslo] = useState("");

  const handleLogin = async () => {
    const response = await fetch(
      "http://localhost:8080/api/v1/uporabniki/login",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ gmail, geslo }),
      }
    );

    if (response.ok) {
      const data = await response.json();
      const userId = data.userId;
      console.log(`Uspešna prijava. id: ${userId}`);
      alert("Uspesna prijava");
      sessionStorage.setItem("uporabnik", data.userId);
    } else {
      alert("Neuspesna prijava");
    }
  };

  return (
    <div className="prijavaBackground">
      <Navbar></Navbar>
      <div className="prijavaMain">
        <div className="prijavaOkno">
          <h2>Prijava</h2>
          <TextField
            label="Mail"
            variant="outlined"
            onChange={(e) => setGmail(e.target.value)}
          />
          <TextField
            label="Geslo"
            variant="outlined"
            type="password"
            onChange={(e) => setGeslo(e.target.value)}
          />
          <Link to={"/registracija"}>Nimate računa?</Link>
          <Button className="prijavaButton" onClick={handleLogin}>
            Prijava
          </Button>
        </div>
      </div>
    </div>
  );
}

export default Prijava;
