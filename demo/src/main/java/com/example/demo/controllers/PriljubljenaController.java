package com.example.demo.controllers;

import com.example.demo.dao.PriljubljenaRepository;
import com.example.demo.models.Priljubljena;
import com.example.demo.models.Termin_rezervacija;
import com.example.demo.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriljubljenaController {

    @Autowired
    private PriljubljenaRepository priljubljenaDao;

    @GetMapping("/priljubljena")
    public Iterable<Priljubljena> vrniPriljubljene(){
        return priljubljenaDao.vrniPriljubljene();
    }

/*
    @GetMapping("/uporabniki")
    public Iterable<Priljubljena> vrniUporabnike(){
        return priljubljenaDao.findAll();
    }*/


}
