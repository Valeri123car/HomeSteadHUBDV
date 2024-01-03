package com.example.demo.controllers;

import com.example.demo.dao.NepremicnineRepository;
import com.example.demo.dao.Termin_rezervacijaRepository;
import com.example.demo.models.Nepremicnine;
import com.example.demo.models.Termin_rezervacija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Termin_rezervacijaController {
    @Autowired
    private Termin_rezervacijaRepository TerRezDao;
    @GetMapping("/termin_rezervacija")
    public Iterable<Termin_rezervacija> vrniHise(){
        return TerRezDao.findAll();
    }
}
