package com.example.demo.controllers;

import com.example.demo.dao.NaslovRepository;
import com.example.demo.dao.NepremicnineRepository;
import com.example.demo.models.Naslov;
import com.example.demo.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaslovController {


    @Autowired
    private NaslovRepository naslovDao;


    @PostMapping("/dodajNaslov")
    public Naslov dodajNaslov(@RequestBody Naslov naslov){
        return naslovDao.save(naslov);
    }
}
