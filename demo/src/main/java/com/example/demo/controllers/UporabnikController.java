package com.example.demo.controllers;

import com.example.demo.dao.UporabnikRepository;
import com.example.demo.models.Nepremicnine;
import com.example.demo.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//zbris     "origins"
@RestController
public class UporabnikController {

    @Autowired
    private UporabnikRepository uporabnikDao;

    // @GetMapping("/vsiUporabniki")
    // public Iterable<Uporabnik> vrniVseUporabnika1() {
    // return uporabnikDao.findAll();
    // }

    @GetMapping("/uporabnikiTest")
    public ResponseEntity<List<Uporabnik>> vrniUporabnikaTest() {
        List<Object[]> uporabnikList = uporabnikDao.vrniUporabnikaTest();

        List<Uporabnik> convertedList = convertToObjectList(uporabnikList);

        return new ResponseEntity<>(convertedList, HttpStatus.OK);
    }

    private List<Uporabnik> convertToObjectList(List<Object[]> objectList) {
        List<Uporabnik> uporabnikList = new ArrayList<>();

        for (Object[] objects : objectList) {

            Uporabnik uporabnik = new Uporabnik();
            uporabnik.setIdUporabnik((Long) objects[0]);
            uporabnik.setIme((String) objects[1]);
            uporabnik.setPriimek((String) objects[2]);
            uporabnik.setGmail((String) objects[3]);
            uporabnik.setGeslo((String) objects[4]);
            uporabnik.setTelefonska((String) objects[5]);
            uporabnik.setTipUporabnika((String) objects[6]);
            uporabnikList.add(uporabnik);
        }

        return uporabnikList;
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

    @DeleteMapping("/uporabnikiTest/{id}")
    public ResponseEntity<Object> izbrisiUporabnika(@PathVariable("id") Long id) {
        if (!uporabnikDao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("uporabnik ni najden?");
        }

        try {
            uporabnikDao.deleteById(id);
            return ResponseEntity.ok("uporabnik uspesno zbrisan");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting nepremicnina");
        }
    }

    @PutMapping("/uporabnikiTest/{id}")
    public ResponseEntity<Object> updateUporabnika(@PathVariable long id,
            @RequestBody Uporabnik uporabnikAtributi) {
        Uporabnik obstojociUporabniki = uporabnikDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "nepremicnina ni najdena"));

        obstojociUporabniki.setIme(uporabnikAtributi.getIme());
        obstojociUporabniki.setPriimek(uporabnikAtributi.getPriimek());
        obstojociUporabniki.setGmail(uporabnikAtributi.getGmail());
        obstojociUporabniki.setGeslo(uporabnikAtributi.getGeslo());
        obstojociUporabniki.setTelefonska(uporabnikAtributi.getTelefonska());

        uporabnikDao.save(obstojociUporabniki);
        return ResponseEntity.ok("uporabnik okay :D");
    }
}