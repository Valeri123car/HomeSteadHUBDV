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
}
