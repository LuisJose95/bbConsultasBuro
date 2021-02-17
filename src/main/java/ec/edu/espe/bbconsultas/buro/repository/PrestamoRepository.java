package ec.edu.espe.bbconsultas.buro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.edu.espe.bbconsultas.buro.model.Prestamo;
import java.util.List;

/**
 *
 * @author soyjo
 */
@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    List<Prestamo> findByCodPersona(Integer codPersona);
}
