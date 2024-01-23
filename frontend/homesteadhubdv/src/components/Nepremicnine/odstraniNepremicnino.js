import React, { useEffect, useState } from "react";
import axios from "axios";
import Navbar from "../Navbar/Navbar";
import Button from "@mui/material/Button";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

const NepremicnineApp = () => {
    const [data, setData] = useState([]);
  
    useEffect(() => {
      // Replace with your Spring Boot backend URL
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
  
    return "hello world"
  };
  
  export default NepremicnineApp;