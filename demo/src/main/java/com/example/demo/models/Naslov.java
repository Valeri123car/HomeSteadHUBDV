package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import org.hibernate.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Naslov {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNaslov;


    private String ulica;
    private String st;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posta_id")
    @JsonIgnore
    private Posta posta;


    @OneToMany(mappedBy = "naslov", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Nepremicnine> nepremicnine = new ArrayList<>();

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

    public Posta getPosta() {
        return posta;
    }

    public void setPosta(Posta posta) {
        this.posta = posta;
    }

    public List<Nepremicnine> getNepremicnine() {
        return nepremicnine;
    }

    public void setNepremicnine(List<Nepremicnine> nepremicnine) {
        this.nepremicnine = nepremicnine;
    }
}
