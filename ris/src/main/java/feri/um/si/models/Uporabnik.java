package feri.um.si.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//ima tuji ključ
@Entity
public class Uporabnik{

    private String ime;
    private String priimek;
    private String email;
    private String geslo;
    private String telefonska;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "uporabik", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Nepremicnine> nepremicnine;

    @OneToMany(mappedBy = "uporabnik", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Ocena> ocena;

    @OneToMany(mappedBy = "uporabnik", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Priljubljene> priljubljene;

    @OneToMany(mappedBy = "uporabnik", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<TerminRezervacija> terminRezervacija;

    //tuji kljuc
    @ManyToOne
    @JoinColumn(name = "idTipUporabnika")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    TipUporabnika tipUporabnika;


    public String getIme() {
        return this.ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return this.priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGeslo() {
        return this.geslo;
    }

    public void setGeslo(String geslo) {
        this.geslo = geslo;
    }

    public String getTelefonska() {
        return this.telefonska;
    }

    public void setTelefonska(String telefonska) {
        this.telefonska = telefonska;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Nepremicnine> getNepremicnine() {
        return this.nepremicnine;
    }

    public void setNepremicnine(Collection<Nepremicnine> nepremicnine) {
        this.nepremicnine = nepremicnine;
    }

    public Collection<Ocena> getOcena() {
        return this.ocena;
    }

    public void setOcena(Collection<Ocena> ocena) {
        this.ocena = ocena;
    }

    public Collection<Priljubljene> getPriljubljene() {
        return this.priljubljene;
    }

    public void setPriljubljene(Collection<Priljubljene> priljubljene) {
        this.priljubljene = priljubljene;
    }

    public Collection<TerminRezervacija> getTerminRezervacija() {
        return this.terminRezervacija;
    }

    public void setTerminRezervacija(Collection<TerminRezervacija> terminRezervacija) {
        this.terminRezervacija = terminRezervacija;
    }

    public TipUporabnika getTipUporabnika() {
        return this.tipUporabnika;
    }

    public void setTipUporabnika(TipUporabnika tipUporabnika) {
        this.tipUporabnika = tipUporabnika;
    }

}