package com.example.demo.dao;

import com.example.demo.models.Nepremicnine;
import com.example.demo.models.Termin_rezervacija;
import org.springframework.data.repository.CrudRepository;

public interface Termin_rezervacijaRepository extends CrudRepository<Termin_rezervacija, Long> {
}
