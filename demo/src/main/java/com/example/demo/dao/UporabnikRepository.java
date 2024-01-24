package com.example.demo.dao;

import com.example.demo.models.Nepremicnine;
import com.example.demo.models.Uporabnik;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long> {

    // TULE SEM DODAL DVA MODIFIJERJA
    @Modifying
    @Query("DELETE FROM Uporabnik u WHERE u.idUporabnik = :id")
    void deleteByIdUporabnik(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Uporabnik u SET u.ime = :ime, u.gmail = :gmail WHERE u.idUporabnik = :id")
    void updateUporabnik(@Param("id") Long id, @Param("ime") String ime, @Param("gmail") String gmail);

    // LOGIN
    @Query("select u from Uporabnik u where u.gmail = :gmail and u.geslo = :geslo")
    Optional<Uporabnik> vrniUporabnika(@Param("gmail") String gmail, @Param("geslo") String geslo);
}