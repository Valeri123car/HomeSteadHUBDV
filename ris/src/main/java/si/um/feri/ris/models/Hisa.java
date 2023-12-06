package si.um.feri.ris.models;


import org.hibernate.mapping.Collection;
import org.hibernate.mapping.OneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Hisa {
    
    OneToMany(mappedBy = "hisa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    
    @Id
    @GeneratedValue(strategy = Gene)
    
    
    
    Collection <Soba> sobe;
}
