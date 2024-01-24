import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";
import {
  BrowserRouter as Router,
  Route,
  Link,
  useNavigate,
} from "react-router-dom";
import HomeIcon from "@mui/icons-material/Home";

export default function Navbar() {
  const navigate = useNavigate();
  function odjava() {
    sessionStorage.clear();
    navigate("/");
  }
  console.log(sessionStorage.getItem("tip_uporabnik"));
  if (sessionStorage.getItem("tip_uporabnik") == 2) {
    return (
      <Box sx={{ flexGrow: 1 }} className="navbar">
        <AppBar position="static">
          <Toolbar>
            <IconButton
              size="large"
              edge="start"
              color="inherit"
              aria-label="menu"
              sx={{ mr: 2 }}
            >
              <Link to="/" className="linki">
                <HomeIcon />
              </Link>
            </IconButton>
            <Typography
              variant="h6"
              component="div"
              sx={{ flexGrow: 1 }}
            ></Typography>
            <Button color="inherit">
              <Link className="linki" to={"/dodajNepremicnino"}>
                Dodaj nepremicnino
              </Link>
            </Button>
            <Button color="inherit">
              <Link className="linki" to={"/"} onClick={odjava}>
                Odjava
              </Link>
            </Button>
          </Toolbar>
        </AppBar>
      </Box>
    );
  } else if (sessionStorage.getItem("tip_uporabnik") == 1) {
    return (
      <Box sx={{ flexGrow: 1 }} className="navbar">
        <AppBar position="static">
          <Toolbar>
            <IconButton
              size="large"
              edge="start"
              color="inherit"
              aria-label="menu"
              sx={{ mr: 2 }}
            >
              <Link to="/" className="linki">
                <HomeIcon />
              </Link>
            </IconButton>
            <Typography
              variant="h6"
              component="div"
              sx={{ flexGrow: 1 }}
            ></Typography>
            <Button color="inherit">
              <Link className="linki" to={"/nepremicnine"}>
                Upravljanje nepremicnin
              </Link>
            </Button>
            <Button color="inherit">
              <Link className="linki" onClick={odjava}>
                Odjava
              </Link>
            </Button>
          </Toolbar>
        </AppBar>
      </Box>
    );
  } else
    return (
      <Box sx={{ flexGrow: 1 }} className="navbar">
        <AppBar position="static">
          <Toolbar>
            <IconButton
              size="large"
              edge="start"
              color="inherit"
              aria-label="menu"
              sx={{ mr: 2 }}
            >
              <Link to="/" className="linki">
                <HomeIcon />
              </Link>
            </IconButton>
            <Typography
              variant="h6"
              component="div"
              sx={{ flexGrow: 1 }}
            ></Typography>
            <Button color="inherit">
              <Link className="linki" to={"/prijava"}>
                Prijava
              </Link>
            </Button>
          </Toolbar>
        </AppBar>
      </Box>
    );
}
