package ec.edu.espe.bbconsultas.buro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.espe.bbconsultas.buro.model.Buro;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author soyjo
 */
@Repository
public interface BuroRepository extends JpaRepository<Buro, Integer> {

    Buro findByPersona(Integer persona);
    List<Buro> findByCantidadAdeudadaGreaterThan(BigDecimal cantidadAdeudada );
    List<Buro> findByCalificacion(String calificacion );
    List<Buro> findByCalificacionAndCantidadAdeudadaGreaterThan(String calificacion, BigDecimal cantidadAdeudada);
    
}
