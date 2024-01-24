import React, { useRef, useEffect, useState } from "react";
import axios from "axios";
import Navbar from "../Navbar/Navbar";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { Link, useNavigate } from "react-router-dom";

function Prijava() {
  const [gmail, setGmail] = useState("");
  const [geslo, setGeslo] = useState("");
  const navigate = useNavigate();

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
      const userType = data.userType;
      //console.log(`Uspešna prijava. id: ${userId}`);
      //console.log(`Uspešna prijava. id: ${userType}`);
      alert("Uspesna prijava");
      sessionStorage.setItem("uporabnik", userId);
      sessionStorage.setItem("tip_uporabnik", userType);
      navigate("/");
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
          {/* <Link to={"/"}> */}
          <Button className="prijavaButton" onClick={handleLogin}>
            Prijava
          </Button>
          {/* </Link> */}
        </div>
      </div>
    </div>
  );
}

export default Prijava;
