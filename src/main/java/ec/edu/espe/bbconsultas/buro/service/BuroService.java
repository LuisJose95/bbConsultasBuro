package ec.edu.espe.bbconsultas.buro.service;

import ec.edu.espe.bbconsultas.buro.exception.DataNotFoundException;
import ec.edu.espe.bbconsultas.buro.model.Buro;
import ec.edu.espe.bbconsultas.buro.model.Persona;
import ec.edu.espe.bbconsultas.buro.model.Prestamo;
import ec.edu.espe.bbconsultas.buro.repository.BuroRepository;
import ec.edu.espe.bbconsultas.buro.repository.PersonaRepository;
import ec.edu.espe.bbconsultas.buro.api.dto.PersonaRQ;
import ec.edu.espe.bbconsultas.buro.api.dto.PrestamoRQ;
import ec.edu.espe.bbconsultas.buro.api.dto.BuroRQ;
import ec.edu.espe.bbconsultas.buro.repository.PrestamoRepository;
import java.util.ArrayList;
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
public class BuroService {

    private final PersonaRepository personaRepository;
    private final BuroRepository buroRepository;
    private final PrestamoRepository prestamoRepository;

    public BuroService(PersonaRepository personaRepository, BuroRepository buroRepository, PrestamoRepository prestamoRepository) {
        this.personaRepository = personaRepository;
        this.buroRepository = buroRepository;
        this.prestamoRepository = prestamoRepository;
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

    private List<PrestamoRQ> buildPrestamo(List<Prestamo> prestamo) {
        List<PrestamoRQ> prestamos = new ArrayList();
        if (!prestamo.isEmpty()) {
            for (int i = 0; i < prestamo.size(); i++) {
                prestamos.add(PrestamoRQ.builder()
                        .institucionFinanciera(prestamo.get(i).getInstitucionFinanciera())
                        .tipoPrestamo(prestamo.get(i).getTipoPrestamo())
                        .montoInicial(prestamo.get(i).getMontoInicial())
                        .montoActual(prestamo.get(i).getMontoActual())
                        .fechaPrestamo(prestamo.get(i).getFechaPrestamo())
                        .diasMora(prestamo.get(i).getDiasMora()).build());
            }
        }
        return prestamos;
    }

    public BuroRQ findByCedula(String cedula) throws DataNotFoundException {
        Optional<Persona> findPerson = this.personaRepository.findById(cedula);
        if (findPerson.isPresent()) {
            Optional<Buro> findBuro = this.buroRepository.findById(findPerson.get().getCodigo());
            List<Prestamo> findPrestamo = this.prestamoRepository.findByCodPersona(findPerson.get().getCodigo());
            log.info("Se busco el buro de {}", cedula);
            return BuroRQ.builder()
                    .persona(buildPersona(findPerson.get()))
                    .calificacion(findBuro.get().getCalificacion())
                    .cantidadAdeudada(findBuro.get().getCantidadAdeudada())
                    .calificacionAlterna(findBuro.get().getCalificacionAlterna())
                    .detallePrestamos(findPrestamo.isEmpty() ? null : buildPrestamo(findPrestamo)).build();

        } else {
            log.info("No se econtro el buro de {}", cedula);
            throw new DataNotFoundException("Buro de Crédito de persona " + cedula + " no encontrado");
        }
    }
}
