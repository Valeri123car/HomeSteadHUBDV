package com.example.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Nepremicnine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNepremicnine;

    private String naziv;
    private String opis;
    private String slika;
    private String cena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tip_nepremicnine_idTip_nepremicnine")
    private Tip_nepremicnine tip_nepremicnine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uporabnik_idUporabnik")
    private Uporabnik uporabnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "naslov_idNaslov")
    private Naslov naslov;


    @OneToMany(mappedBy = "nepremicnine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ocena> ocene = new ArrayList<>();

    @OneToMany(mappedBy = "nepremicnine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Priljubljena> priljubljene = new ArrayList<>();

    @OneToMany(mappedBy = "nepremicnine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Termin_rezervacija> rezervacije = new ArrayList<>();


}

