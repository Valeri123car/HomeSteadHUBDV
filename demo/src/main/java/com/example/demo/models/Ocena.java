package com.example.demo.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Ocena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOcena;

    private int ocena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nepremicnine_idNepremicnine")
    @JsonIgnore
    private Nepremicnine nepremicnine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uporabnik_idUporabnik")
    @JsonIgnore
    private Uporabnik uporabnik;

    public Long getIdOcena() {
        return idOcena;
    }

    public void setIdOcena(Long idOcena) {
        this.idOcena = idOcena;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
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
