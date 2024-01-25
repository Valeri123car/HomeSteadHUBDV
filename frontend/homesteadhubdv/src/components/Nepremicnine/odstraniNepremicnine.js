import React, { useEffect, useState } from "react";
import axios from "axios";
import Navbar from "../Navbar/Navbar";
import Button from "@mui/material/Button";
import { useParams, Link, useNavigate } from "react-router-dom";
import "../../css/odstraniNepremicnino.css";

const NepremicnineApp = () => {
  const [data, setData] = useState([]);
  const [updateData, setUpdateData] = useState({
    idNepremicnine: "",
    naziv: "",
    opis: "",
    cena: "",
  });
  const navigate = useNavigate();

  useEffect(() => {
    if (sessionStorage.getItem("tip_uporabnik") !== "1") {
      navigate("/");
    }

    axios
      .get("http://localhost:8080/api/v1/nepremicnine")
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  const handleDelete = (id) => {
    axios
      .delete(`http://localhost:8080/api/v1/nepremicnine/${id}`)
      .then(() => {
        fetchData();
      })
      .catch((error) => {
        console.error("Error deleting data:", error);
      });
  };

  const handleUpdate = (nepremicnina) => {
    setUpdateData({
      idNepremicnine: nepremicnina.idNepremicnine,
      naziv: nepremicnina.naziv,
      opis: nepremicnina.opis,
      cena: nepremicnina.cena,
    });
  };

  const handleUpdateSubmit = () => {
    axios
      .put(
        `http://localhost:8080/api/v1/nepremicnine/${updateData.idNepremicnine}`,
        updateData
      )
      .then(() => {
        fetchData();

        setUpdateData({
          idNepremicnine: "",
          naziv: "",
          opis: "",
          cena: "",
        });
      })
      .catch((error) => {
        console.error("Error updating data:", error);
      });
  };

  const fetchData = () => {
    axios
      .get("http://localhost:8080/api/v1/nepremicnine")
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
              <th>Naziv</th>
              <th>Opis</th>
              <th>Cena</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {data.map((nepremicnina) => (
              <tr key={nepremicnina.idNepremicnine}>
                <td>{nepremicnina.idNepremicnine}</td>
                <td>{nepremicnina.naziv}</td>
                <td>{nepremicnina.opis}</td>
                <td>{nepremicnina.cena}</td>
                <td>
                  <Link
                    to={`/ogledNepremicnine/${nepremicnina.idNepremicnine}`}
                  >
                    View
                  </Link>{" "}
                  <button onClick={() => handleUpdate(nepremicnina)}>
                    Update
                  </button>{" "}
                  <button
                    onClick={() => handleDelete(nepremicnina.idNepremicnine)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        <div>
          <h2>Update Nepremicnina</h2>
          <form>
            <label>ID:</label>
            <input type="text" value={updateData.idNepremicnine} readOnly />

            <label>Naziv:</label>
            <input
              type="text"
              value={updateData.naziv}
              onChange={(e) =>
                setUpdateData({ ...updateData, naziv: e.target.value })
              }
            />

            <label>Opis:</label>
            <input
              type="text"
              value={updateData.opis}
              onChange={(e) =>
                setUpdateData({ ...updateData, opis: e.target.value })
              }
            />

            <label>Cena:</label>
            <input
              type="number"
              value={updateData.cena}
              onChange={(e) =>
                setUpdateData({ ...updateData, cena: e.target.value })
              }
            />

            <button type="button" onClick={handleUpdateSubmit}>
              Update Nepremicnina
            </button>
          </form>
        </div>
      </div>
    </>
  );
};

export default NepremicnineApp;
//update nepremicnine
//delete nepremicnine
