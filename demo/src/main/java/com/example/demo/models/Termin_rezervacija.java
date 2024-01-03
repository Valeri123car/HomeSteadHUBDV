package com.example.demo.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Nepremicnine nepremicnine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uporabnik_idUporabnik")
    @JsonIgnore
    private Uporabnik uporabnik;

    public Long getIdTermin_rezervacija() {
        return idTermin_rezervacija;
    }

    public void setIdTermin_rezervacija(Long idTermin_rezervacija) {
        this.idTermin_rezervacija = idTermin_rezervacija;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalTime getCas() {
        return cas;
    }

    public void setCas(LocalTime cas) {
        this.cas = cas;
    }

    public Nepremicnine getNepremicnine() {
        return nepremicnine;
    }

    public void setNepremicnine(Nepremicnine nepremicnine) {
        this.nepremicnine = nepremicnine;
    }

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }
}
