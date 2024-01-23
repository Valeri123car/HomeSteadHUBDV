import React, { useEffect, useState } from "react";
import axios from "axios";
import Navbar from "../Navbar/Navbar";
import Button from "@mui/material/Button";
import { useParams } from "react-router-dom";

const NepremicnineApp = () => {
  const [nepremicnineData, setNepremicnineData] = useState([]);
  const idNepremicnine = 2;
  const { id } = useParams();
  //console.log(id);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/api/v1/ogledNepremicnine/${id}`
        );

        const data = await response.json();
        setNepremicnineData(data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchData();
  }, [idNepremicnine]);

  return (
    <div className="oglednepremicnineStr">
      <Navbar></Navbar>
      <div className="ogledBack">
        <div className="ogledNepremicnineContainer">
          <div className="ogledItem">
            <div className="ogledSlika"></div>
            <div className="ogledText">
              <h1>Naziv</h1>
              <p>
                sadsad asds adsadsadsadsad sad asd sad sad asd asds adsa sad sa
              </p>
              <p>Cena : 200000000€</p>
            </div>
          </div>
          <div className="ogledItem2">
            <div className="ogledText2">
              <h2>Lokacija</h2>
              <p>Kraj, posta</p>
              <p>Ulica, st</p>
            </div>
            <div className="ogledText2">
              <h2>Termini rezervacije:</h2>
              <h2>Kontakt:</h2>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default NepremicnineApp;
