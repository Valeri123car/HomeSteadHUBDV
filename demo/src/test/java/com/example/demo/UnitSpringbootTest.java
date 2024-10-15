package com.example.demo;

import com.example.demo.controllers.NaslovController;
import com.example.demo.controllers.NepremicnineController;
import com.example.demo.controllers.UporabnikController;
import com.example.demo.dao.NaslovRepository;
import com.example.demo.dao.NepremicnineRepository;
import com.example.demo.dao.UporabnikRepository;
import com.example.demo.models.Naslov;
import com.example.demo.models.Nepremicnine;
import com.example.demo.models.Uporabnik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UnitSpringbootTest {

        @Autowired
        UporabnikController uporabnikController;

        @Autowired
         UporabnikRepository uporabnikDao;

        @Autowired
         NepremicnineRepository nepremicnineDao;
        @Autowired
        NepremicnineController neprmeicnineController;

        @Autowired
         NaslovRepository naslovDao;
        @Autowired
        NaslovController naslovController;

        @Test
        public void dodajanjeUporabnikaTest(){
            Uporabnik u = new Uporabnik();
            Long stUporabnikov = uporabnikDao.count();
            uporabnikController.dodajUporabnika(u);
            Assertions.assertEquals(stUporabnikov + 1,uporabnikDao.count());
        }
    @Test
    public void dodajanjeNepremicnineTest(){
        Nepremicnine n = new Nepremicnine();
        Long stNepremicnin = nepremicnineDao.count();
        neprmeicnineController.dodajNepremicnino(n);
        Assertions.assertEquals(stNepremicnin + 1,nepremicnineDao.count());
    }
    @Test
    public void dodajanjeNaslovaTest(){
        Naslov n = new Naslov();
        Long stNaslovov = naslovDao.count();
        naslovController.dodajNaslov(n);
        Assertions.assertEquals(stNaslovov + 1,naslovDao.count());
    }

        @Test
        void preverjanjeDelovanjeFiltraTest(){
            Nepremicnine n = new Nepremicnine();
            Long filtrCena =Long.valueOf(210000);
            Long stNepremicnin = nepremicnineDao.vrniNepremicninePoCeni(Long.valueOf(filtrCena)).stream().count();
            n.setCena(Long.valueOf(200000));
            neprmeicnineController.dodajNepremicnino(n);
            Assertions.assertEquals(stNepremicnin + 1, nepremicnineDao.vrniNepremicninePoCeni(Long.valueOf(filtrCena)).stream().count());

        }



        @Test
        void zbrisiNepremicninoTest(){
            Nepremicnine n = new Nepremicnine();
            neprmeicnineController.dodajNepremicnino(n);
            Long stNepremicnin = nepremicnineDao.count();
//            Iterable<Nepremicnine> nepremicnine = nepremicnineDao.findAll();
//            System.out.println(stNepremicnin);
//            System.out.println(n.getIdNepremicnine());
            neprmeicnineController.izbrisiNepremicnino(n.getIdNepremicnine());
//            System.out.println(nepremicnineDao.count());
            Assertions.assertNotEquals(stNepremicnin, nepremicnineDao.count());
        }

//    @Autowired
//    private MockMvc mockMvc;

//    @Test
//    public void endpointNaslovTest() throws Exception {
//        Naslov n = new Naslov();
//        Long naslovCount =naslovDao.count();
//        naslovController.dodajNaslov(n);
//
//        mockMvc.perform(get("/api/v1/naslov"))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) jsonPath("$.length()").value(naslovCount + 1));
////                .andExpect( jsonPath("$").isNotEmpty());
//
//    }


}
