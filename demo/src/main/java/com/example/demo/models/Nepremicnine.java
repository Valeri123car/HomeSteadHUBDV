package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Tip_nepremicnine tip_nepremicnine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uporabnik_id_uporabnik")
    @JsonIgnore
    private Uporabnik uporabnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "naslov_idNaslov")
    @JsonIgnore
    private Naslov naslov;


    @OneToMany(mappedBy = "nepremicnine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ocena> ocene = new ArrayList<>();

    @OneToMany(mappedBy = "nepremicnine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Priljubljena> priljubljene = new ArrayList<>();

    @OneToMany(mappedBy = "nepremicnine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Termin_rezervacija> rezervacije = new ArrayList<>();

    public Long getIdNepremicnine() {
        return idNepremicnine;
    }

    public void setIdNepremicnine(Long idNepremicnine) {
        this.idNepremicnine = idNepremicnine;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Tip_nepremicnine getTip_nepremicnine() {
        return tip_nepremicnine;
    }

    public void setTip_nepremicnine(Tip_nepremicnine tip_nepremicnine) {
        this.tip_nepremicnine = tip_nepremicnine;
    }

    public Uporabnik getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }

    public Naslov getNaslov() {
        return naslov;
    }

    public void setNaslov(Naslov naslov) {
        this.naslov = naslov;
    }

    public List<Ocena> getOcene() {
        return ocene;
    }

    public void setOcene(List<Ocena> ocene) {
        this.ocene = ocene;
    }

    public List<Priljubljena> getPriljubljene() {
        return priljubljene;
    }

    public void setPriljubljene(List<Priljubljena> priljubljene) {
        this.priljubljene = priljubljene;
    }

    public List<Termin_rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Termin_rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }
}

