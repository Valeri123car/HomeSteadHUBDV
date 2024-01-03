package com.example.demo.dao;

import com.example.demo.models.Priljubljena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PriljubljenaRepository extends CrudRepository<Priljubljena, Long> {


    @Query(value = "select * from Priljubljena p", nativeQuery = true)
    List<Priljubljena> vrniPriljubljene();
}
