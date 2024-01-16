package com.example.demo.controllers;

import com.example.demo.dao.NepremicnineRepository;
import com.example.demo.models.Nepremicnine;
import com.example.demo.models.Priljubljena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NepremicnineController {

    @Autowired
    private NepremicnineRepository nepremicninaDao;
    @GetMapping("/nepremicnine")
    public Iterable<Nepremicnine> vrniHise(){
        return nepremicninaDao.findAll();
    }

    /*@GetMapping("/nepremicnineVse")
    public Iterable<Nepremicnine> vrniVseNepremicnine(){
        return nepremicninaDao.vrniVseNepremicnine();
    }*/


}
