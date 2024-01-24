import React, { useEffect, useState } from "react";
// import axios from "axios";
import Navbar from "../Navbar/Navbar";
import Button from "@mui/material/Button";
import { useParams } from "react-router-dom";
import api from "../../services/api";

const NepremicnineApp = () => {
  const { id } = useParams();
  const [data, setData] = useState({});

  useEffect(() => {
    api
      .get(`http://localhost:8080/api/v1/nepremicnineVseKarJe/${id}`)
      .then((response) => {
        setData(response.data);
        //console.log(response.data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, [id]);

  //   console.log(data);

  //`http://localhost:8080/api/v1/ogledNepremicnine/${id}`
  return (
    <div className="oglednepremicnineStr">
      <Navbar />
      <div className="ogledBack">
        <div className="ogledNepremicnineContainer">
          {data.length > 0 ? (
            <div className="ogledItem">
              <div
                className="ogledSlika"
                style={{
                  backgroundImage: `url(${data[0].slika})`,
                }}
              ></div>
              <div className="ogledText">
                <h1>{data[0].naziv}</h1>
                <p>{data[0].opis}</p>
                <p>Cena : {data[0].cena}€</p>
                <p>Tip_nepremicnine:</p>
              </div>
            </div>
          ) : (
            <p>Loading data...</p>
          )}
          <div className="ogledItem2">
            <div className="ogledText2">
              <h2>Lokacija</h2>
              <div className="lokacijaCon">
                <div className="kraj">
                  <h3> Kraj: </h3>
                  <p>
                    {data[0].kraj}, {data[0].id}
                  </p>
                </div>
                <div className="naslov">
                  <h3>Naslov</h3>
                  <p>
                    {data[0].ulica}, {data[0].st}
                  </p>
                </div>
              </div>
            </div>
            <div className="ogledText2">
              <div className="kontaktCon">
                <div className="kontakt">
                  <h2>Kontakt</h2>
                  <p>Telefonska: {data[0].telefonska}</p>
                </div>

                <h2>Termini rezervacije:</h2>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default NepremicnineApp;
