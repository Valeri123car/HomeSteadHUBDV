import React, { useState } from "react";
//import emailjs from "emailjs-com";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import Navbar from "../Navbar/Navbar";
import { useNavigate } from "react-router-dom";
import emailjs from "@emailjs/browser";

const Registracija = () => {
  const [ime, setIme] = useState("");
  const [priimek, setPriimek] = useState("");
  const [gmail, setGmail] = useState("");
  const [telefonska, setTelefonska] = useState("");
  const [geslo, setGeslo] = useState("");
  const [tipUporabnika, setTipUporabnika] = useState(2);
  const navigate = useNavigate();

  //5 ur sem rabu za tole ta shit xD
  const sendEmail = () => {
    const templateParams = {
      to_name: ime,
      to_email: gmail,
      from_name: "HomeSteadHUBDV",
      message:
        "Uspešno ste se registrirali. Želimo Vam prijetno iskanje stereh nad glavo :)",
      subject: "Subject of the email",
      body: "Body of the email",
    };

    emailjs
      .send(
        "service_dflgghd",
        "template_klzzada",
        templateParams,
        "rlIAwJ47OVWhBqfdu"
      )
      .then(
        (response) => {
          console.log("Email sent successfully:", response);
        },
        (error) => {
          console.error("Error sending email:", error);
        }
      );
  };

  const dodajUporabnika = () => {
    const uporabnik = {
      ime,
      priimek,
      gmail,
      telefonska,
      geslo,
      tipUporabnika,
    };

    if (
      ime === "" ||
      priimek === "" ||
      gmail === "" ||
      telefonska === "" ||
      geslo === ""
    ) {
      alert("Izpolni vsa polja");
    } else {
      fetch("http://localhost:8080/api/v1/dodajUporabnika", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(uporabnik),
      }).then(() => {
        console.log("nov uporabnik dodan");
        alert("uspesno dodan uporabnik");
        sendEmail();
        navigate("/prijava");
      });
    }
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
            name="email_from"
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

          <Button className="prijavaButton" onClick={dodajUporabnika}>
            Registracija
          </Button>
        </div>
      </div>
    </div>
  );
};

export default Registracija;
