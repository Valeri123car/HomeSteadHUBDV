package feri.um.si.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//razredi ki imajo tuji ključ zgledajo takole
@Entity
public class Naslov{
    private String ulica;
    private String st;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPosta")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Posta posta;

    public String getUlica() {
        return this.ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getSt() {
        return this.st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Posta getPosta() {
        return this.posta;
    }

    public void setPosta(Posta posta) {
        this.posta = posta;
    }

}