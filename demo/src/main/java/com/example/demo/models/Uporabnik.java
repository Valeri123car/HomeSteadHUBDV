package com.example.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Uporabnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUporabnik;

    private String ime;
    private String priimek;
    private String gmail;
    private String geslo;
    private String telefonska;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tip_uporabnika_idTip_uporabnika")
    private Tip_uporabnika tip_uporabnika;


    @OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Nepremicnine> nepremicnine = new ArrayList<>();

    @OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ocena> ocene = new ArrayList<>();
    @OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Priljubljena> priljubljene = new ArrayList<>();

    @OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Termin_rezervacija> rezervacije = new ArrayList<>();

}
