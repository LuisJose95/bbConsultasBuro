package ec.edu.espe.bbconsultas.buro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.edu.espe.bbconsultas.buro.model.InstitucionFinanciera;

/**
 *
 * @author soyjo
 */
@Repository
public interface InstitucionFinancieraRepository extends JpaRepository<InstitucionFinanciera, String> {

}
