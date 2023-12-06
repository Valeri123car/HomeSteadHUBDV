package si.um.feri.ris.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import si.um.feri.ris.models.Hisa;

public interface HisaRepository extends CrudRepository<Hisa, Long> {

    @Query("select h from Hisa h, Soba s where s.hisa = h and s.velikost >= ?1")
    List<Hisa> vrniHisePoVelikostSob(double velikost);

    
}