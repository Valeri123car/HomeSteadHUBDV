import React, { useEffect, useState } from "react";
import axios from "axios";
import Navbar from "../Navbar/Navbar";
import Button from "@mui/material/Button";
import { useParams } from "react-router-dom";
import api from "../../services/api";
import { Link } from "react-router-dom";
const NepremicnineApp = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    
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
      .then((response) => {

        axios.get("http://localhost:8080/api/v1/nepremicnine")
          .then((response) => {
            setData(response.data);
          })
          .catch((error) => {
            console.error("Error fetching data:", error);
          });
      })
      .catch((error) => {
        console.error("Error deleting data:", error);
      });
  };

  return (
    <div>
      <Navbar />
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Naziv</th>
            <th>Opis</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {data.map((nepremicnina) => (
            <tr key={nepremicnina.idNepremicnine}>
              <td>{nepremicnina.idNepremicnine}</td>
              <td>{nepremicnina.naziv}</td>
              <td>{nepremicnina.opis}</td>
              <td>
                <Link to={`/ogledNepremicnine/${nepremicnina.idNepremicnine}`}>View</Link>{" "}
                <button onClick={() => handleDelete(nepremicnina.idNepremicnine)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default NepremicnineApp;