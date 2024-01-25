package com.example.demo.dao;

import com.example.demo.DTO.NepremicninWithNaslovDTO;
import com.example.demo.models.Nepremicnine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NepremicnineRepository extends CrudRepository<Nepremicnine, Long> {
    //
    /*
     * @Query(
     * value="select id_nepremicnine, n.naziv, n.opis, n.cena, na.st, na.ulica from nepremicnine n INNER JOIN naslov na ON n.naslov_id_naslov = na.id_naslov"
     * , nativeQuery = true)
     * List<Nepremicnine> vrniVseNepremicnine();
     */

    // ogled nepremicnine
    @Query("select n from Nepremicnine n where n.idNepremicnine = :id")
    List<Nepremicnine> vrniNepremicnino(@Param("id") Long id);

    // @Query("SELECT n FROM Nepremicnine n JOIN n.naslov na WHERE n.idNepremicnine
    // = :id")
    // List<Nepremicnine> vrniNepremicnino(@Param("id") Long id);

    @Query("SELECT n FROM Nepremicnine n WHERE n.idNepremicnine = :id")
    List<Nepremicnine> vrniNepremicnine(@Param("id") Long id);

    //List<Nepremicnine> vrniNepremicninePoLokaciji(String kraj);

    @Query("SELECT n FROM Nepremicnine n WHERE n.naziv LIKE %:naziv%")
    List<Nepremicnine> vrniNepremicninePoNazivu(@Param("naziv") String naziv);



    @Query("SELECT n FROM Nepremicnine n WHERE n.cena <= :cena")
    List<Nepremicnine> vrniNepremicninePoCeni(@Param("cena") Long cena);

    @Query("SELECT n FROM Nepremicnine n WHERE n.naziv LIKE %:naziv% AND n.cena <= :cena")
    List<Nepremicnine> vrniNepremicninePoNazivuInCeni(@Param("naziv") String naziv, @Param("cena") Long cena);

    /*@Query("SELECT new com.example.NepremicninWithNaslovDTO(n) FROM Nepremicnine n WHERE n.naziv LIKE %:naziv% AND n.cena <= :cena AND n.tipNepremicnine = :tip_nepremicnine")
    List<NepremicninWithNaslovDTO> vrniNepremicninePoNazivuCeniTipu(@Param("naziv") String naziv, @Param("cena") Long cena, @Param("tip_nepremicnine") String tip_nepremicnine);
*/
}


