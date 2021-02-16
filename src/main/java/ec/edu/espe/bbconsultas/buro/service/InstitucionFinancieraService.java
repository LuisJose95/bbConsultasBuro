package ec.edu.espe.bbconsultas.buro.service;

import ec.edu.espe.bbconsultas.buro.exception.DataNotFoundException;
import ec.edu.espe.bbconsultas.buro.repository.InstitucionFinancieraRepository;
import ec.edu.espe.bbconsultas.buro.model.InstitucionFinanciera;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author soyjo
 */
@Slf4j
@Service
public class InstitucionFinancieraService {

    private final InstitucionFinancieraRepository institucionFinancieraRepo;

    public InstitucionFinancieraService(InstitucionFinancieraRepository institucionFinancieraRepo) {
        this.institucionFinancieraRepo = institucionFinancieraRepo;
    }

    public List<InstitucionFinanciera> findAll() {
        log.info("Se listo todas las instituciones financieras");
        return this.institucionFinancieraRepo.findAll();
    }

    public InstitucionFinanciera findById(String id) throws DataNotFoundException {
        Optional<InstitucionFinanciera> inst = this.institucionFinancieraRepo.findById(id);
        if (inst.isPresent()) {
            log.info("Se busco Institucion Financiera: {}", id);
            return inst.get();
        } else {
            log.info("Se busco Institucion Financiera: {} sin exito", id);
            throw new DataNotFoundException("Institucion Financiera con id " + id + " no encontrada");
        }
    }
}
