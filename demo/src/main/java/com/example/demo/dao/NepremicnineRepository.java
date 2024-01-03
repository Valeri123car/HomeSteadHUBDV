package com.example.demo.dao;

import com.example.demo.models.Nepremicnine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NepremicnineRepository extends CrudRepository<Nepremicnine, Long> {
   /* @Query("select n from Nepremicnine n")
    List<Nepremicnine> vrniVseNepremicnine();*/
}
