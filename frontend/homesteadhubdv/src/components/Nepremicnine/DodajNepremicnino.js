import React, { useEffect, useState } from "react";
import axios from "axios";
import Navbar from "../Navbar/Navbar";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import MenuItem from "@mui/material/MenuItem";
import Select from "@mui/material/Select";
import { Link, useNavigate } from "react-router-dom";

const App = () => {
  const navigate = useNavigate();

  useEffect(() => {
    if (sessionStorage.getItem("tip_uporabnik") !== "2") {
      navigate("/");
    }
  }, []);

  const [naziv, setNaziv] = useState("");
  const [opis, setOpis] = useState("");
  const [cena, setCena] = useState("");
  const [slika, setSlika] = useState("");
  const [ulica, setUlica] = useState("");
  const [st, setSt] = useState("");
  const [tip_nepremicnine_idTip_nepremicnine, setTip_nepremicnine] =
    useState(0);
  //   const [posta_id, setPosta_id] = useState(0);

  const dodajNaslov = () => {
    const naslov = {
      ulica,
      st,
      //   posta_id,
    };

    fetch("http://localhost:8080/api/v1/dodajNaslov", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(naslov),
    }).then(() => {
      console.log("nov uporabnik dodan");
      alert("uspesno dodan uporabnik");
    });
  };

  const dodajNepremicnino = () => {
    const nepremicnina = {
      naziv,
      opis,
      cena,
      slika,
      tip_nepremicnine_idTip_nepremicnine,
    };

    fetch("http://localhost:8080/api/v1/dodajNepremicnino", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(nepremicnina),
    }).then(() => {
      console.log("nov uporabnik dodan");
      alert("uspesno dodan uporabnik");
    });
  };

  const dodaja = () => {
    dodajNepremicnino();
    dodajNaslov();
  };

  return (
    <div className="prijavaBackground">
      <Navbar></Navbar>
      <div className="dodajNepMain">
        <div className="dodajOkno">
          <h2>Dodaj nepremicnino</h2>
          <TextField
            label="Naziv nepremicnine"
            variant="outlined"
            onChange={(event) => setNaziv(event.target.value)}
          />
          <TextField
            label="Opis"
            variant="outlined"
            onChange={(event) => setOpis(event.target.value)}
          />
          <TextField
            label="Cena"
            variant="outlined"
            onChange={(event) => setCena(event.target.value)}
          />
          <TextField
            label="Slika"
            variant="outlined"
            onChange={(event) => setSlika(event.target.value)}
          />
          <TextField
            label="Ulica"
            variant="outlined"
            onChange={(event) => setUlica(event.target.value)}
          />
          <TextField
            label="Hisna st"
            variant="outlined"
            onChange={(event) => setSt(event.target.value)}
          />
          <Select
            // value={selectedValue}
            // onChange={handleChange}
            label="Kraj"
            className="selecti"
          >
            <MenuItem value="1000">Ljubljana</MenuItem>
            <MenuItem value="2000">Maribor</MenuItem>
            <MenuItem value="3000">Celje</MenuItem>
            <MenuItem value="3230">Šentjur</MenuItem>
            <MenuItem value="3240">Šmarje pri Jelšah</MenuItem>
            <MenuItem value="3254">Podčetrtek</MenuItem>
            <MenuItem value="3270">Laško</MenuItem>
            <MenuItem value="3305">Vransko</MenuItem>
            <MenuItem value="3325">Šoštanj</MenuItem>
            <MenuItem value="9000">Murska Sobota</MenuItem>
          </Select>
          <Select
            // value={selectedValue}
            // onChange={handleChange}
            label="Tip nepremicnine"
          >
            <MenuItem value="1">Novogradnja</MenuItem>
            <MenuItem value="2">Javna dražba</MenuItem>
            <MenuItem value="3">Montazna hiša</MenuItem>
          </Select>
          <Button className="prijavaButton" onClick={dodaja}>
            Dodaj
          </Button>
        </div>
      </div>
    </div>
  );
};

export default App;
