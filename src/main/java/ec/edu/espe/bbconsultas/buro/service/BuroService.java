package ec.edu.espe.bbconsultas.buro.service;

import ec.edu.espe.bbconsultas.buro.exception.DataNotFoundException;
import ec.edu.espe.bbconsultas.buro.model.Buro;
import ec.edu.espe.bbconsultas.buro.model.Persona;
import ec.edu.espe.bbconsultas.buro.repository.BuroRepository;
import ec.edu.espe.bbconsultas.buro.repository.PersonaRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author soyjo
 */
@Slf4j
@Service
public class BuroService {

    private final PersonaRepository personaRepository;
    private final BuroRepository buroRepository;

    public BuroService(PersonaRepository personaRepository, BuroRepository buroRepository) {
        this.personaRepository = personaRepository;
        this.buroRepository = buroRepository;
    }

    public Buro findByCedula(String cedula) throws DataNotFoundException {
        Optional<Persona> findPerson = this.personaRepository.findById(cedula);
        if (findPerson.isPresent()) {
            Optional<Buro> findBuro = this.buroRepository.findById(findPerson.get().getCodigo());
            return findBuro.get();
        } else {
            throw new DataNotFoundException("Buro de Crédito de persona " + cedula + " no encontrado");
        }
    }
}
