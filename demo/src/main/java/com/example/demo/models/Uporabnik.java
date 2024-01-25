package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String tipUporabnika;

    public String getTipUporabnika() {
        return tipUporabnika;
    }

    public void setTipUporabnika(String tipUporabnika) {
        this.tipUporabnika = tipUporabnika;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tip_uporabnika_idTip_uporabnika")
    @JsonIgnore
    private Tip_uporabnika tip_uporabnika;

    @OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Nepremicnine> nepremicnine = new ArrayList<>();

    @OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ocena> ocene = new ArrayList<>();
    @OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Priljubljena> priljubljene = new ArrayList<>();

    @OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Termin_rezervacija> rezervacije = new ArrayList<>();

    public Long getIdUporabnik() {
        return idUporabnik;
    }

    public void setIdUporabnik(Long idUporabnik) {
        this.idUporabnik = idUporabnik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getGeslo() {
        return geslo;
    }

    public void setGeslo(String geslo) {
        this.geslo = geslo;
    }

    public String getTelefonska() {
        return telefonska;
    }

    public void setTelefonska(String telefonska) {
        this.telefonska = telefonska;
    }

    public Tip_uporabnika getTip_uporabnika() {
        return tip_uporabnika;
    }

    public void setTip_uporabnika(Tip_uporabnika tip_uporabnika) {
        this.tip_uporabnika = tip_uporabnika;
    }

    public List<Nepremicnine> getNepremicnine() {
        return nepremicnine;
    }

    public void setNepremicnine(List<Nepremicnine> nepremicnine) {
        this.nepremicnine = nepremicnine;
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
