package com.example.demo.controllers;

import com.example.demo.dao.UporabnikRepository;
import com.example.demo.models.Nepremicnine;
import com.example.demo.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/uporabniki")
public class UporabnikController {

    @Autowired
    private UporabnikRepository uporabnikDao;

    @GetMapping("/vsiUporabnik")
    public Iterable<Uporabnik> vrniUporabnik() {
        return uporabnikDao.findAll();
    }


    @PostMapping("/dodajUporabnika")
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik uporabnik) {
        return uporabnikDao.save(uporabnik);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("gmail");
        String password = credentials.get("geslo");

        Optional<Uporabnik> userOptional = uporabnikDao.vrniUporabnika(username, password);

        if (userOptional.isPresent()) {
            Uporabnik user = userOptional.get();

            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("userId", user.getIdUporabnik());
            responseMap.put("userType", user.getTipUporabnika());
            // return ResponseEntity.ok(Collections.singletonMap("userId",
            // user.getIdUporabnik()));

            return ResponseEntity.ok(responseMap);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // TOLE SEM DODAL
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> izbrisiUporabnika(@PathVariable("id") Long id) {
        try {
            uporabnikDao.deleteByIdUporabnik(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> posodobiUporabnika(@PathVariable("id") Long id, @RequestBody Uporabnik updatedUser) {
        try {
            uporabnikDao.updateUporabnik(id, updatedUser.getIme(), updatedUser.getGmail());
            return ResponseEntity.ok("User updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user");
        }
    }

}