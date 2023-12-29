package feri.um.si.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//ima tuji ključ
@Entity
public class Nepremicnine{

    private String naziv;
    private String opis;
    private String slika;
    private String cena;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "nepremicnine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Priljubljene> priljubljene;

    @OneToMany(mappedBy = "nepremicnine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Ocena> ocena;

    @OneToMany(mappedBy = "nepremicnine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<TerminRezervacija> terminRezervacija;

    @ManyToOne
    @JoinColumn(name = "idNaslov")
    @JoinColumn(name = "idTipNepremicnine")
    @JoinColumn(name = "idUporabnik")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Naslov naslov;
    TipNepremicnine tipNepremicnine;
    TipUporabnika tipUporabnika;


    public String getNaziv() {
        return this.naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return this.opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSlika() {
        return this.slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getCena() {
        return this.cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Priljubljene> getPriljubljene() {
        return this.priljubljene;
    }

    public void setPriljubljene(Collection<Priljubljene> priljubljene) {
        this.priljubljene = priljubljene;
    }

    public Collection<Ocena> getOcena() {
        return this.ocena;
    }

    public void setOcena(Collection<Ocena> ocena) {
        this.ocena = ocena;
    }

    public Collection<TerminRezervacija> getTerminRezervacija() {
        return this.terminRezervacija;
    }

    public void setTerminRezervacija(Collection<TerminRezervacija> terminRezervacija) {
        this.terminRezervacija = terminRezervacija;
    }

    public Naslov getNaslov() {
        return this.naslov;
    }

    public void setNaslov(Naslov naslov) {
        this.naslov = naslov;
    }

    public TipNepremicnine getTipNepremicnine() {
        return this.tipNepremicnine;
    }

    public void setTipNepremicnine(TipNepremicnine tipNepremicnine) {
        this.tipNepremicnine = tipNepremicnine;
    }

    public TipUporabnika getTipUporabnika() {
        return this.tipUporabnika;
    }

    public void setTipUporabnika(TipUporabnika tipUporabnika) {
        this.tipUporabnika = tipUporabnika;
    }

}