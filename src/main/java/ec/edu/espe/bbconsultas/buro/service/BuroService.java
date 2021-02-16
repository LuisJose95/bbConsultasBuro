package ec.edu.espe.bbconsultas.buro.service;

import ec.edu.espe.bbconsultas.buro.exception.DataNotFoundException;
import ec.edu.espe.bbconsultas.buro.model.Buro;
import ec.edu.espe.bbconsultas.buro.model.Persona;
import ec.edu.espe.bbconsultas.buro.repository.BuroRepository;
import ec.edu.espe.bbconsultas.buro.repository.PersonaRepository;
import ec.edu.espe.bbconsultas.buro.api.dto.PersonaRQ;
import ec.edu.espe.bbconsultas.buro.api.dto.BuroRQ;
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

    private PersonaRQ buildPersona(Persona per) {
        if (per != null) {
            return PersonaRQ.builder()
                    .cedula(per.getCedula())
                    .nombres(per.getNombres())
                    .apellidos(per.getApellidos())
                    .nombreCompleto(per.getNombreCompleto())
                    .genero(per.getGenero())
                    .fechaNacimiento(per.getFechaNacimiento())
                    .nacionalidad(per.getNacionalidad()).build();
        }
        return null;
    }

    public BuroRQ findByCedula(String cedula) throws DataNotFoundException {
        Optional<Persona> findPerson = this.personaRepository.findById(cedula);
        if (findPerson.isPresent()) {
            Optional<Buro> findBuro = this.buroRepository.findById(findPerson.get().getCodigo());
            log.info("Se busco el buro de {}",cedula);
            return BuroRQ.builder()
                    .persona(buildPersona(findPerson.get()))
                    .calificacion(findBuro.get().getCalificacion())
                    .cantidadAdeudada(findBuro.get().getCantidadAdeudada())
                    .calificacionAlterna(findBuro.get().getCalificacionAlterna()).build();
            
        } else {
            log.info("No se econtro el buro de {}",cedula);
            throw new DataNotFoundException("Buro de Crédito de persona " + cedula + " no encontrado");
        }
    }
}
