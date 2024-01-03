package com.example.demo.models;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class Termin_rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTermin_rezervacija;

    private LocalDate datum;
    private LocalTime cas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nepremicnine_idNepremicnine")
    private Nepremicnine nepremicnine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uporabnik_idUporabnik")
    private Uporabnik uporabnik;
}
