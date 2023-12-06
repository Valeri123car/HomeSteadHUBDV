package si.um.feri.ris.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import si.um.feri.ris.models.Soba;
import si.um.feri.ris.repository.HisaRepository;
import si.um.feri.ris.repository.SobaRepository;

@RestController
@RequestMapping("/sobe")
public class SobaControler {
    @Autowired
    private SobaRepository sobaRepository;
    @Autowired
    private HisaRepository hisaRepository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello sobe";
    }

    @PostMapping("/{id_hise}")
    public Optional<Soba> dodajSobo(@RequestBody Soba soba, @PathVariable(name = "id_hise") Long id){
        return hisaRepository.findById(id).map(hisa -> {
            soba.setHisa(hisa);
            return sobaRepository.save(soba);
            
        });
    }

}
