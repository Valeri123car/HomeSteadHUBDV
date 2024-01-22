package com.example.demo.dao;

import com.example.demo.models.Naslov;
import org.springframework.data.repository.CrudRepository;

public interface NaslovRepository extends CrudRepository<Naslov, Long> {
}
