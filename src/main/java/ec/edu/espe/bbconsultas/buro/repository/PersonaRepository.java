package ec.edu.espe.bbconsultas.buro.repository;

import org.springframework.stereotype.Repository;
import ec.edu.espe.bbconsultas.buro.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author soyjo
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {

}
