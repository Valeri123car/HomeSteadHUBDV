import React, { useEffect, useState } from "react";
import axios from "axios";
import Navbar from "../Navbar/Navbar";
import Button from "@mui/material/Button";
import { useParams, Link } from "react-router-dom";
import "../../css/odstraniNepremicnino.css";
import api from "../../services/api";

const UporabnikiApp = () => {
  const [data, setData] = useState([]);
  const [updateData, setUpdateData] = useState({
    idUporabnik: "",
    ime: "",
    priimek: "",
    gmail: "",
    geslo: "",
    tipUporabnika: "",
    telefonska: "",
  });

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/v1/uporabnikiTest")
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  const handleDelete = (id) => {
    axios
      .delete(`http://localhost:8080/api/v1/uporabnikiTest/${id}`)
      .then(() => {
        fetchData();
      })
      .catch((error) => {
        console.error("Error deleting data:", error);
      });
  };

  const handleUpdate = (uporabnik) => {
    setUpdateData({
      idUporabnik: uporabnik.idUporabnik,
      ime: uporabnik.ime,
      priimek: uporabnik.priimek,
      gmail: uporabnik.gmail,
      geslo: uporabnik.geslo,
      tipUporabnika: uporabnik.tipUporabnika,
      telefonska: uporabnik.telefonska,
    });
  };

  const handleUpdateSubmit = () => {
    axios
      .put(
        `http://localhost:8080/api/v1/uporabnikiTest/${updateData.idUporabnik}`,
        updateData
      )
      .then(() => {
        fetchData();

        setUpdateData({
          idUporabnik: "",
          ime: "",
          priimek: "",
          gmail: "",
          geslo: "",
          tipUporabnika: "",
          telefonska: "",
        });
      })
      .catch((error) => {
        console.error("Error updating data:", error);
      });
  };

  const fetchData = () => {
    axios
      .get("http://localhost:8080/api/v1/uporabnikiTest")
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  };

  return (
    <>
      <Navbar />
      <div class="okence1">
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>ime</th>
              <th>priimek</th>
              <th>gmail</th>
              <th>geslo</th>
              <th>tipUporabnika</th>
              <th>telefonska</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {data.map((uporabnik) => (
              <tr key={uporabnik.idUporabnik}>
                <td>{uporabnik.idUporabnik}</td>
                <td>{uporabnik.ime}</td>
                <td>{uporabnik.priimek}</td>
                <td>{uporabnik.gmail}</td>
                <td>{uporabnik.geslo}</td>
                <td>{uporabnik.tipUporabnika}</td>
                <td>{uporabnik.telefonska}</td>
                <td>
                  <button onClick={() => handleUpdate(uporabnik)}>
                    Update
                  </button>{" "}
                  <button onClick={() => handleDelete(uporabnik.idUporabnik)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        <div>
          <h2>Update uporabnik</h2>
          <form>
            <label>ID:</label>
            <input type="text" value={updateData.idUporabnik} readOnly />

            <label>Naziv:</label>
            <input
              type="text"
              value={updateData.ime}
              onChange={(e) =>
                setUpdateData({ ...updateData, ime: e.target.value })
              }
            />

            <label>Opis:</label>
            <input
              type="text"
              value={updateData.priimek}
              onChange={(e) =>
                setUpdateData({ ...updateData, priimek: e.target.value })
              }
            />

            <label>Cena:</label>
            <input
              type="number"
              value={updateData.gmail}
              onChange={(e) =>
                setUpdateData({ ...updateData, gmail: e.target.value })
              }
            />

            <label>Geslo:</label>
            <input
              type="text"
              value={updateData.geslo}
              onChange={(e) =>
                setUpdateData({ ...updateData, geslo: e.target.value })
              }
            />

            <label>tipUporabnika:</label>
            <input
              type="text"
              value={updateData.tipUporabnika}
              onChange={(e) =>
                setUpdateData({ ...updateData, tipUporabnika: e.target.value })
              }
            />

            <label>telefonska:</label>
            <input
              type="text"
              value={updateData.telefonska}
              onChange={(e) =>
                setUpdateData({ ...updateData, telefonska: e.target.value })
              }
            />

            <button type="button" onClick={handleUpdateSubmit}>
              Update uporabnik
            </button>
          </form>
        </div>
      </div>
    </>
  );
};

export default UporabnikiApp;
//update nepremicnine
//delete nepremicnine
