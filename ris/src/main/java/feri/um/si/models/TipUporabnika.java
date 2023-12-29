package feri.um.si.models;
import java.util.*;
import java.util.Collection;
import jakarta.persistence.*;

//niam tujega ključa
@Entity
public class TipUporabnika{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "tipUporabnika", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Uporabnik> Uporabnik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String tipUporabnika;


    public Collection<Uporabnik> getUporabnik() {
        return this.Uporabnik;
    }

    public void setUporabnik(Collection<Uporabnik> Uporabnik) {
        this.Uporabnik = Uporabnik;
    }

    public String getTipUporabnika() {
        return this.tipUporabnika;
    }

    public void setTipUporabnika(String tipUporabnika) {
        this.tipUporabnika = tipUporabnika;
    }

}