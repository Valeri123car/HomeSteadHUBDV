package com.example.demo.models;
import jakarta.persistence.*;

@Entity
public class Priljubljena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPriljubljena;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nepremicnine_idNepremicnine")
    private Nepremicnine nepremicnine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uporabnik_idUporabnik")
    private Uporabnik uporabnik;
}
