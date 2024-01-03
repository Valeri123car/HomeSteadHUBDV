package com.example.demo.models;

import jakarta.persistence.*;

import java.util.*;
@Entity
public class Posta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kraj;
    @OneToMany(mappedBy = "posta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Naslov> naslovi = new ArrayList<>();


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

    public List<Naslov> getNaslovi() {
        return naslovi;
    }

    public void setNaslovi(List<Naslov> naslovi) {
        this.naslovi = naslovi;
    }
}
