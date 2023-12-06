package si.um.feri.ris.models;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;


@Entity
public class Soba {
    private double velikost;
    private String ime;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "hisa_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Hisa hisa;

    public Long getId(){
        return id;
    }


    public Soba() {
    }

    public Soba(double velikost, String ime, Long id, Hisa hisa) {
        this.velikost = velikost;
        this.ime = ime;
        this.id = id;
        this.hisa = hisa;
    }

    public double getVelikost() {
        return this.velikost;
    }

    public void setVelikost(double velikost) {
        this.velikost = velikost;
    }

    public String getIme() {
        return this.ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Hisa getHisa() {
        return this.hisa;
    }

    public void setHisa(Hisa hisa) {
        this.hisa = hisa;
    }

    public Soba velikost(double velikost) {
        setVelikost(velikost);
        return this;
    }

    public Soba ime(String ime) {
        setIme(ime);
        return this;
    }

    public Soba id(Long id) {
        setId(id);
        return this;
    }

    public Soba hisa(Hisa hisa) {
        setHisa(hisa);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Soba)) {
            return false;
        }
        Soba soba = (Soba) o;
        return velikost == soba.velikost && Objects.equals(ime, soba.ime) && Objects.equals(id, soba.id) && Objects.equals(hisa, soba.hisa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(velikost, ime, id, hisa);
    }

    @Override
    public String toString() {
        return "{" +
            " velikost='" + getVelikost() + "'" +
            ", ime='" + getIme() + "'" +
            ", id='" + getId() + "'" +
            ", hisa='" + getHisa() + "'" +
            "}";
    }
    
    
}
