package feri.um.si.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//ima tuji ključ
@Entity
public class Ocena{
    
    private float ocena;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idNepremicnine")
    @JoinColumn(name = "idUporabnik")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Nepremicnine nepremicnine;
    Uporabnik uporabnik;


    public float getOcena() {
        return this.ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Nepremicnine getNepremicnine() {
        return this.nepremicnine;
    }

    public void setNepremicnine(Nepremicnine nepremicnine) {
        this.nepremicnine = nepremicnine;
    }

    public Uporabnik getUporabnik() {
        return this.uporabnik;
    }

    public void setUporabnik(Uporabnik uporabnik) {
        this.uporabnik = uporabnik;
    }

}