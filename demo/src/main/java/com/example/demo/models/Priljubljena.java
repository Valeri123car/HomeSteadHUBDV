package com.example.demo.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Priljubljena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPriljubljena;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nepremicnine_idNepremicnine")
    @JsonIgnore
    private Nepremicnine nepremicnine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uporabnik_idUporabnik")
    @JsonIgnore
    private Uporabnik uporabnik;

    public Long getIdPriljubljena() {
        return idPriljubljena;
    }

    public void setIdPriljubljena(Long idPriljubljena) {
        this.idPriljubljena = idPriljubljena;
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
