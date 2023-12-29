package feri.um.si.dao;

import feri.um.si.models.Posta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PostaRepository extends CrudRepository<Posta, Long> {

        @Query("Select * Posta")
        List<Posta> vrniPoste(String posta);
    
}