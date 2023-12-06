package si.um.feri.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import si.um.feri.ris.models.Hisa;
import si.um.feri.ris.repository.HisaRepository;

@RestController
@RequestMapping("/hise")

public class HisaControler {
    @Autowired
    private HisaRepository hisaRepository;

    @GetMapping("/hise")

    @GetMapping
    public Iterable<Hisa> vrniHise(){
        return hisaRepository.findAll()
    }

    @PostMapping
    public Hisa dodajHiso(@RequestBody Hisa hisa){
        return hisaRepository.save(hisa);
    }
}
