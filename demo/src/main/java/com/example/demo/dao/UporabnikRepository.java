package com.example.demo.dao;

import com.example.demo.models.Nepremicnine;
import com.example.demo.models.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long> {
    //public interface NepremicnineRepository extends CrudRepository<Nepremicnine, Long> {


    @Query("select u from Uporabnik u where u.gmail = :gmail and u.geslo = :geslo")
    Optional<Uporabnik> vrniUporabnika(@Param("gmail") String gmail, @Param("geslo")String geslo);

}
