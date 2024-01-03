package com.example.demo.dao;

import com.example.demo.models.Nepremicnine;
import com.example.demo.models.Uporabnik;
import org.springframework.data.repository.CrudRepository;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long> {
}
