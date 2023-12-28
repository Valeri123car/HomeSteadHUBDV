package main.java.feri.um.si.models;

import javax.persistence.*;

import java.util.Collection;

@Entity
public class Posta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "posta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Naslov> naslov;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Naslov> getNaslov() {
        return naslov;
    }

    public void setNaslov(Collection<Naslov> naslov) {
        this.naslov = naslov;
    }

    private String kraj;

    public String getKraj() {
        return this.kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }
}