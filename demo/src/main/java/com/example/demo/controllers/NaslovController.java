package com.example.demo.controllers;

import com.example.demo.dao.NaslovRepository;
import com.example.demo.dao.NepremicnineRepository;
import com.example.demo.models.Naslov;
import com.example.demo.models.Nepremicnine;
import com.example.demo.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NaslovController {


    @Autowired
    private NaslovRepository naslovDao;

    @GetMapping("/naslov")
    public Iterable<Naslov> vrniNaslov() {
        return naslovDao.findAll();
    }

    @PostMapping("/dodajNaslov")
    public Naslov dodajNaslov(@RequestBody Naslov naslov){
        return naslovDao.save(naslov);
    }



    @GetMapping("/naslovNepremicnine/{ulica}/{st}")
    public ResponseEntity<List<Long>> vrniIdNaslova(@PathVariable("ulica") String ulica,
                                                    @PathVariable("st") String st) {
        List<Long> idNaslovList = naslovDao.vrniIdNaslova(ulica, st);
        return new ResponseEntity<>(idNaslovList, HttpStatus.OK);
    }

}
