package feri.um.si.models;
import java.util.*;
import java.util.Collection;
import jakarta.persistence.*;

//nima tujega kljuca
public class TipNepremicnine{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "tipNepremicnine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Nepremicnine> nepremcinine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String tipNepremicnine;

    public Collection<Nepremicnine> getNepremcinine() {
        return this.nepremcinine;
    }

    public void setNepremcinine(Collection<Nepremicnine> nepremcinine) {
        this.nepremcinine = nepremcinine;
    }

    public String getTipNepremicnine() {
        return this.tipNepremicnine;
    }

    public void setTipNepremicnine(String tipNepremicnine) {
        this.tipNepremicnine = tipNepremicnine;
    }



}