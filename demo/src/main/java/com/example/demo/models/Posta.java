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




}
