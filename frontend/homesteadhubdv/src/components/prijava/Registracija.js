import React, { useEffect, useState } from "react";
import axios from "axios";
import api from "../../services/api";
import Navbar from "../Navbar/Navbar";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import { Link } from "react-router-dom";
import Select from "@mui/material/Select";
import MenuItem from "@mui/material/MenuItem";

function Registracija() {
  const [ime, setIme] = useState("");
  const [priimek, setPriimek] = useState("");
  const [gmail, setGmail] = useState("");
  const [telefonska, setTelefonska] = useState("");
  const [geslo, setGeslo] = useState("");
  //nevem kako naredit da fking tuj ključ se vpise
  const [tipUporabnika, setTipUporabnika] = useState(2);

  //   const dodajUporabnika = () => {
  //     api
  //       .post("/api/v1/uporabniki", {
  //         //http://localhost:8080/api/v1/uporabniki
  //         ime: ime,
  //         priimek: priimek,
  //         gmail: email,
  //         telefonska: telefonska,
  //         geslo: geslo,
  //       })
  //       .then((result) => console.log(result.data));
  //   };

  //tak bs ej

  const dodajUporabnika = () => {
    //howwwwwwww

    const uporabnik = {
      ime,
      priimek,
      gmail,
      telefonska,
      geslo,
      tipUporabnika,
    };

    fetch("http://localhost:8080/api/v1/uporabniki/dodajUporabnika", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(uporabnik),
    }).then(() => {
      console.log("nov uporabnik dodan");
      alert("uspesno dodan uporabnik");
    });
  };

  return (
    <div className="prijavaBackground">
      <Navbar></Navbar>
      <div className="prijavaMain">
        <div className="prijavaOkno">
          <h2>Registracija</h2>

          <TextField
            label="Ime"
            variant="outlined"
            value={ime}
            onChange={(event) => setIme(event.target.value)}
          />
          <TextField
            label="Priimek"
            variant="outlined"
            value={priimek}
            onChange={(event) => setPriimek(event.target.value)}
          />
          <TextField
            label="Mail"
            variant="outlined"
            value={gmail}
            onChange={(event) => setGmail(event.target.value)}
          />
          <TextField
            label="Telefonska"
            variant="outlined"
            value={telefonska}
            onChange={(event) => setTelefonska(event.target.value)}
          />
          <TextField
            label="Geslo"
            variant="outlined"
            value={geslo}
            onChange={(event) => setGeslo(event.target.value)}
          />

          {/* <TextField
            label="Tip uporabnika"
            variant="outlined"
            value={tip_uporabnika}
            onChange={(event) => setIdTip_uporabnika(event.target.value)}
          /> */}

          <Button className="prijavaButton" onClick={dodajUporabnika}>
            Registracija
          </Button>
        </div>
      </div>
    </div>
  );
}

export default Registracija;
