import React, { useEffect, useState } from "react";
import axios from "axios";
import Navbar from "../Navbar/Navbar";
import Button from "@mui/material/Button";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import CircularProgress from "@mui/material/CircularProgress";

const NepremicnineApp = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/v1/nepremicnine")
      .then((response) => {
        setData(response.data);
        // console.log(response.data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  return (
    <div className="nepremicnineStr">
      <div className="navbar">
        <Navbar></Navbar>
        <div className="podNav">HomesteadDV</div>
      </div>
      <div className="nepremicnineContainer">
        <h1 className="naslov">Nepremicnine</h1>
        {data.length > 0 ? (
          <div className="nepItemContainer">
            {data.map((item) => (
              <div key={item.idNepremicnine} className="nepItem">
                <div
                  className="nep_slika"
                  style={{
                    backgroundImage: 'url("' + item.slika + '")',
                  }}
                ></div>
                <div className="nep_text">
                  {/* <p>ID: {item.idNepremicnine}</p> */}
                  <h2>{item.naziv}</h2>
                  <p>{item.opis}</p>
                  <p>{item.cena} €</p>
                  <Link to={`/ogledNepremicnine/${item.idNepremicnine}`}>
                    <Button>Ogled</Button>
                  </Link>
                </div>
              </div>
            ))}
          </div>
        ) : (
          <CircularProgress />
        )}
      </div>
    </div>
  );
};

export default NepremicnineApp;
