package com.example.demo.controllers;

import com.example.demo.dao.NepremicnineRepository;
import com.example.demo.models.Naslov;
import com.example.demo.models.Nepremicnine;
import com.example.demo.models.Priljubljena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class NepremicnineController {

    @Autowired
    private NepremicnineRepository nepremicninaDao;

    @GetMapping("/nepremicnine")
    public Iterable<Nepremicnine> vrniHise() {
        return nepremicninaDao.findAll();
    }

    /*
     * @GetMapping("/nepremicnineVse")
     * public Iterable<Nepremicnine> vrniVseNepremicnine(){
     * return nepremicninaDao.vrniVseNepremicnine();
     * }
     */

    //

    @PostMapping("/dodajNepremicnino")
    public Nepremicnine dodajNepremicnino(@RequestBody Nepremicnine nepremicnine) {
        return nepremicninaDao.save(nepremicnine);
    }

    @GetMapping("/ogledNepremicnine/{id}")
    public ResponseEntity<List<Nepremicnine>> vrniNepremicnino(@PathVariable("id") Long id) {
        List<Nepremicnine> nepremicnineList = nepremicninaDao.vrniNepremicnino(id);
        return new ResponseEntity<>(nepremicnineList, HttpStatus.OK);
    }

    @DeleteMapping("/nepremicnine/{id}")
    public ResponseEntity<Object> izbrisiNepremicnino(@PathVariable("id") Long id) {
        if (!nepremicninaDao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nepremicnina not found");
        }

        try {
            nepremicninaDao.deleteById(id);
            return ResponseEntity.ok("Nepremicnina deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting nepremicnina");
        }
    }

    @PutMapping("/nepremicnine/{id}")
    public ResponseEntity<Object> updateNepremicnino(@PathVariable long id,
            @RequestBody Nepremicnine nepremicnineAtributi) {
        Nepremicnine obstojeceNepremicnine = nepremicninaDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "nepremicnina ni najdena"));

        obstojeceNepremicnine.setNaziv(nepremicnineAtributi.getNaziv());
        obstojeceNepremicnine.setOpis(nepremicnineAtributi.getOpis());
        obstojeceNepremicnine.setCena(nepremicnineAtributi.getCena());

        nepremicninaDao.save(obstojeceNepremicnine);
        return ResponseEntity.ok("nepremicnina posodobljena uspesno");
    }

}
