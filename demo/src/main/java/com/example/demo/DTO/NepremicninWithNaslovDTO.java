package com.example.demo.DTO;

import com.example.demo.models.Naslov;

public class NepremicninWithNaslovDTO {

    //nepremicnine
    private Long idNepremicnine;
    private String naziv;
    private String opis;
    private String slika;
    private String cena;

    //naslov
    private Long idNaslov;
    private String ulica;
    private String st;

    //uporabnik
    private Long idUporabnik;
    private String telefonska;

    //posta
    private Long id;

    private String kraj;


    public NepremicninWithNaslovDTO() {
    }

    public NepremicninWithNaslovDTO(Long idNepremicnine, String naziv, String opis, String slika, String cena, Long idNaslov, String ulica, String st, Long idUporabnik, String telefonska, Long id, String kraj) {
        this.idNepremicnine = idNepremicnine;
        this.naziv = naziv;
        this.opis = opis;
        this.slika = slika;
        this.cena = cena;
        this.idNaslov = idNaslov;
        this.ulica = ulica;
        this.st = st;
        this.idUporabnik = idUporabnik;
        this.telefonska = telefonska;
        this.id = id;
        this.kraj = kraj;
    }

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

    public Long getIdNaslov() {
        return idNaslov;
    }

    public void setIdNaslov(Long idNaslov) {
        this.idNaslov = idNaslov;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public Long getIdUporabnik() {
        return idUporabnik;
    }

    public void setIdUporabnik(Long idUporabnik) {
        this.idUporabnik = idUporabnik;
    }

    public String getTelefonska() {
        return telefonska;
    }

    public void setTelefonska(String telefonska) {
        this.telefonska = telefonska;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }
}
