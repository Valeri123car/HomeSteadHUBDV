package feri.um.si.controllers;

import feri.um.si.dao.PostaRepository;
import feri.um.si.models.Posta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posta")

public class PostaController{

    @Autowired
    private PostaRepository postaDao;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping
    public Iterable<Posta> vrniPoste(){
        return postaDao.findAll();
    }

}

