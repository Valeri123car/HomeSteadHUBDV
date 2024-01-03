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
}
