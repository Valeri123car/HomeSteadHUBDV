package com.example.demo.dao;

import com.example.demo.models.Naslov;
import com.example.demo.models.Nepremicnine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface NaslovRepository extends CrudRepository<Naslov, Long> {

    @Query("SELECT n.idNaslov FROM Naslov n WHERE n.ulica = :ulica AND n.st = :st")
    List<Long> vrniIdNaslova(@Param("ulica") String naziv, @Param("st") String cena);
/*
    @Query("SELECT n.idNaslov FROM Naslov n WHERE n.ulica = Hanover AND n.st = 12")
    List<Naslov> vrniIdNaslovaa();*/
}
