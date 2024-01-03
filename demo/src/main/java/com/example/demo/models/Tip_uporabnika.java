package com.example.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tip_uporabnika {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTip_uporabnika;

    private String tip_uporabnika;

    @OneToMany(mappedBy = "tip_uporabnika", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Uporabnik> uporabniki = new ArrayList<>();


    public Long getIdTip_uporabnika() {
        return idTip_uporabnika;
    }

    public void setIdTip_uporabnika(Long idTip_uporabnika) {
        this.idTip_uporabnika = idTip_uporabnika;
    }

    public String getTip_uporabnika() {
        return tip_uporabnika;
    }

    public void setTip_uporabnika(String tip_uporabnika) {
        this.tip_uporabnika = tip_uporabnika;
    }

    public List<Uporabnik> getUporabniki() {
        return uporabniki;
    }

    public void setUporabniki(List<Uporabnik> uporabniki) {
        this.uporabniki = uporabniki;
    }
}
