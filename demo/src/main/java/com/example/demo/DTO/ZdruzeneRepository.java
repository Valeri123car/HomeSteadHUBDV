package com.example.demo.DTO;

import com.example.demo.models.Nepremicnine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ZdruzeneRepository extends CrudRepository<NepremicninWithNaslovDTO, Long> {

/*
    @Query("SELECT n FROM Nepremicnine n WHERE n.naziv LIKE %:naziv% and n.cena <= :cena")
    List<NepremicninWithNaslovDTO> vrniNepremicninePoNazivuCeni(@Param("naziv") String naziv, @Param("cena") Long cena);
    }


    @Query("SELECT new com.example.NepremicninWithNaslovDTO(n) FROM Nepremicnine n WHERE n.naziv LIKE %:naziv% AND n.cena <= :cena AND n.tipNepremicnine = :tip_nepremicnine")
    List<NepremicninWithNaslovDTO> vrniNepremicninePoNazivuCeniTipu(@Param("naziv") String naziv, @Param("cena") Long cena, @Param("tip_nepremicnine") String tip_nepremicnine);
*/
}

