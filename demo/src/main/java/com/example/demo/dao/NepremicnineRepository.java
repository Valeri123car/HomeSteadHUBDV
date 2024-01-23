package com.example.demo.dao;

import com.example.demo.models.Nepremicnine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NepremicnineRepository extends CrudRepository<Nepremicnine, Long> {
    //
    /*@Query(value="select id_nepremicnine, n.naziv, n.opis, n.cena, na.st, na.ulica from nepremicnine n INNER JOIN naslov na ON n.naslov_id_naslov = na.id_naslov", nativeQuery = true)
    List<Nepremicnine> vrniVseNepremicnine();*/


    @Query("select n from Nepremicnine n where n.idNepremicnine = :id")
    List<Nepremicnine> vrniNepremicnino(@Param("id") Long id);

    //@Query("SELECT n FROM Nepremicnine n JOIN n.naslov na WHERE n.idNepremicnine = :id")
    //List<Nepremicnine> vrniNepremicnino(@Param("id") Long id);
}
