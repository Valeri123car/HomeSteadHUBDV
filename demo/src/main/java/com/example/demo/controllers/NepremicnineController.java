package com.example.demo.controllers;

import com.example.demo.dao.NepremicnineRepository;
import com.example.demo.models.Naslov;
import com.example.demo.models.Nepremicnine;
import com.example.demo.models.Priljubljena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // @PostMapping("/izbrisiNepremicnino")

}
