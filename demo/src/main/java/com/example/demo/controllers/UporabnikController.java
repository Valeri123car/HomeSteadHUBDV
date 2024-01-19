package com.example.demo.controllers;

import com.example.demo.dao.UporabnikRepository;
import com.example.demo.models.Nepremicnine;
import com.example.demo.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uporabniki")
public class UporabnikController {

    @Autowired
    private UporabnikRepository uporabnikDao;

    @GetMapping("/uporabnik")
    public Iterable<Uporabnik> vrniUporabnike(){
        return uporabnikDao.findAll();
    }

    @PostMapping
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik uporabnik){
        return uporabnikDao.save(uporabnik);
    }
}
