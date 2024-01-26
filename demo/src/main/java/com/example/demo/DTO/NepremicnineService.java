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

            }
        }
        return dtoList;
    }
}