import React, { useEffect, useState } from "react";
import axios from "axios";
import Navbar from "../Navbar/Navbar";
import Button from "@mui/material/Button";
import { useParams } from "react-router-dom";
import api from "../../services/api";

const UporabnikiApp = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    api
      .get("/uporabnik")  
      .then((response) => {
        setUsers(response.data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  const handleUpdate = (userId) => {

    console.log("Update user with ID:", userId);
  };

  const handleDelete = (userId) => {
    api
      .delete(`/uporabnik/${userId}`)  
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error("Error deleting user:", error);
      });
  };

  return (
    <>
      <Navbar />
      <div>
        <h2>User Table</h2>
        <table>
          <thead>
            <tr>
              <th>Gmail</th>
              <th>Ime</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user) => (
              <tr key={user.idUporabnik}>
                <td>{user.gmail}</td>
                <td>{user.ime}</td>
                <td>
                  <Button
                    variant="outlined"
                    onClick={() => handleUpdate(user.idUporabnik)}
                  >
                    Update
                  </Button>
                  <Button
                    variant="outlined"
                    onClick={() => handleDelete(user.idUporabnik)}
                  >
                    Delete
                  </Button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default UporabnikiApp;