package com.example.demo.DTO;

import com.example.demo.dao.NepremicnineRepository;
import com.example.demo.models.Nepremicnine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NepremicnineService {

    @Autowired
    private NepremicnineRepository nepremicninRepository;
    private ZdruzeneRepository zdruzeneRepository;

    public List<NepremicninWithNaslovDTO> getAllNepremicninsWithNaslov() {
        Iterable<Nepremicnine> nepremicnine = nepremicninRepository.findAll();
        return mapNepremicnineEntitiesToDTOsWithNaslov(nepremicnine);
    }

    public List<NepremicninWithNaslovDTO> getNepremicninsWithNaslovById(Long id) {
        List<Nepremicnine> nepremicnine = nepremicninRepository.vrniNepremicnino(id);
        return mapNepremicnineEntitiesToDTOsWithNaslov(nepremicnine);
    }

    public List<NepremicninWithNaslovDTO> getNepPoNaziv(String naziv) {
        List<Nepremicnine> nepremicnine = nepremicninRepository.vrniNepremicninePoNazivu(naziv);
        return mapNepremicnineEntitiesToDTOsWithNaslov(nepremicnine);
    }


    public List<NepremicninWithNaslovDTO> getNepPoCen( Long cena) {
        List<Nepremicnine> nepremicnine = nepremicninRepository.vrniNepremicninePoCeni(cena);
        return mapNepremicnineEntitiesToDTOsWithNaslov(nepremicnine);
    }

    //vrniNepremicninePoNazivuInCeni

    public List<NepremicninWithNaslovDTO> getNepPoNazivInCeni(String naziv, Long cena) {
        List<Nepremicnine> nepremicnine = nepremicninRepository.vrniNepremicninePoNazivuInCeni(naziv,cena);
        return mapNepremicnineEntitiesToDTOsWithNaslov(nepremicnine);
    }

    //vrniNepremicninePoNazivuCeniTipu

    public List<NepremicninWithNaslovDTO> getNepPoNazivuCeniTipu(String naziv, Long cena, String tip_nepremicnine) {
        Iterable<NepremicninWithNaslovDTO> allData = zdruzeneRepository.findAll(); // Fetch all data

        // Convert iterator to a list
        List<NepremicninWithNaslovDTO> allDataList = StreamSupport.stream(allData.spliterator(), false)
                .collect(Collectors.toList());

        // Filter data based on criteria
        List<NepremicninWithNaslovDTO> filteredData = allDataList.stream()
                .filter(dto -> dto.getNaziv().contains(naziv)) // Example filter condition
                .filter(dto -> dto.getCena() <= cena)
                .filter(dto -> dto.getTip_nepremicnine().equals(tip_nepremicnine))
                .collect(Collectors.toList());

        return filteredData;
    }



    private List<NepremicninWithNaslovDTO> mapNepremicnineEntitiesToDTOsWithNaslov(Iterable<Nepremicnine> nepremicnins) {
        List<NepremicninWithNaslovDTO> dtoList = new ArrayList<>();
        for (Nepremicnine nepremicnin : nepremicnins) {
            if (nepremicnin.getNaslov() != null && nepremicnin.getUporabnik() != null && nepremicnin.getNaslov().getPosta() != null && nepremicnin.getTip_nepremicnine() != null) {
                NepremicninWithNaslovDTO dto = new NepremicninWithNaslovDTO(
                        nepremicnin.getIdNepremicnine(), nepremicnin.getNaziv(), nepremicnin.getOpis(),
                        nepremicnin.getSlika(), nepremicnin.getCena(),
                        nepremicnin.getNaslov().getIdNaslov(), nepremicnin.getNaslov().getUlica(),
                        nepremicnin.getNaslov().getSt(),
                        nepremicnin.getUporabnik().getIdUporabnik(), nepremicnin.getUporabnik().getTelefonska(),
                        nepremicnin.getNaslov().getPosta().getId(), nepremicnin.getNaslov().getPosta().getKraj(),
                        nepremicnin.getTip_nepremicnine().getIdTip_Nepremicnine(), nepremicnin.getTip_nepremicnine().getTip_nepremicnine()
                );
                dtoList.add(dto);
            } else {
                // Handle null values or log a warning
            }
        }
        return dtoList;
    }
}