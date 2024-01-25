package com.example.demo.controllers;

import com.example.demo.DTO.NepremicninWithNaslovDTO;
import com.example.demo.DTO.NepremicnineService;
import com.example.demo.DTO.ZdruzeneRepository;
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

    //private ZdruzeneRepository zdruzeneRepository;

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

    //vrniFiltr

    /*
    @GetMapping("/vseKarJe")
    public ResponseEntity<List<Nepremicnine>> vrniFiltr() {
        List<Nepremicnine> nepremicnineList = nepremicninaDao.vrniFiltr();
        return new ResponseEntity<>(nepremicnineList, HttpStatus.OK);
    }
*/

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


    @Autowired
    private NepremicnineService nepremicninService;
/*
    @GetMapping("/nepremicnineVseKarJe")
    public ResponseEntity<List<NepremicninWithNaslovDTO>> getAllNepremicninsWithNaslov() {
        List<NepremicninWithNaslovDTO> nepremicnins = nepremicninService.getAllNepremicninsWithNaslov();
        return new ResponseEntity<>(nepremicnins, HttpStatus.OK);
    }
*/

    @GetMapping("/nepremicnineVseKarJe/{id}")
    public ResponseEntity<List<NepremicninWithNaslovDTO>> getNepremicninsWithNaslovById(@PathVariable Long id) {
        List<NepremicninWithNaslovDTO> nepremicnins = nepremicninService.getNepremicninsWithNaslovById(id);
        return new ResponseEntity<>(nepremicnins, HttpStatus.OK);
    }

    @GetMapping("/nepremicnineVseKarJee/{naziv}")
    public ResponseEntity<List<NepremicninWithNaslovDTO>> getNepByNaziv(@PathVariable String naziv) {
        List<NepremicninWithNaslovDTO> nepremicnins = nepremicninService.getNepPoNaziv(naziv);
        return new ResponseEntity<>(nepremicnins, HttpStatus.OK);
    }

    @GetMapping("/nepremicnineVseKarJeee/{cena}")
    public ResponseEntity<List<NepremicninWithNaslovDTO>> getNepByCena(@PathVariable Long cena) {
        List<NepremicninWithNaslovDTO> nepremicnins = nepremicninService.getNepPoCen(cena);
        return new ResponseEntity<>(nepremicnins, HttpStatus.OK);
    }

    //getNepPoNazivInCeni

    @GetMapping("/nepremicineNazivCena/{naziv}/{cena}")
    public ResponseEntity<List<NepremicninWithNaslovDTO>> getNepByNazivCena(@PathVariable String naziv,@PathVariable Long cena) {
        List<NepremicninWithNaslovDTO> nepremicnins = nepremicninService.getNepPoNazivInCeni(naziv, cena);
        return new ResponseEntity<>(nepremicnins, HttpStatus.OK);
    }

    //tole ne dela
    @GetMapping("/nepremicineNazivCenaTip/{naziv}/{cena}/{tip_nepremicnine}")
    public ResponseEntity<List<NepremicninWithNaslovDTO>> getNepByNazivCenaTip(
            @PathVariable String naziv,
            @PathVariable Long cena,
            @PathVariable String tip_nepremicnine
    ) {
        List<NepremicninWithNaslovDTO> nepremicnins = nepremicninService.getNepPoNazivuCeniTipu(naziv, cena, tip_nepremicnine);
        return new ResponseEntity<>(nepremicnins, HttpStatus.OK);
    }

}
