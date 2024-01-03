package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import org.hibernate.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Naslov {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNaslov;


    private String ulica;
    private String st;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posta_id")
    private Posta posta;


    @OneToMany(mappedBy = "naslov", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Nepremicnine> nepremicnine = new ArrayList<>();

}
