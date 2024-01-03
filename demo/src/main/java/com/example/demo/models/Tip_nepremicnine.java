package com.example.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tip_nepremicnine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTip_Nepremicnine;

    private String Tip_nepremicnine;

    @OneToMany(mappedBy = "tip_nepremicnine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Nepremicnine> nepremicnine = new ArrayList<>();

    public Long getIdTip_Nepremicnine() {
        return idTip_Nepremicnine;
    }

    public void setIdTip_Nepremicnine(Long idTip_Nepremicnine) {
        this.idTip_Nepremicnine = idTip_Nepremicnine;
    }

    public String getTip_nepremicnine() {
        return Tip_nepremicnine;
    }

    public void setTip_nepremicnine(String tip_nepremicnine) {
        Tip_nepremicnine = tip_nepremicnine;
    }

    public List<Nepremicnine> getNepremicnine() {
        return nepremicnine;
    }

    public void setNepremicnine(List<Nepremicnine> nepremicnine) {
        this.nepremicnine = nepremicnine;
    }
}
