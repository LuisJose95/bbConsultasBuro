package ec.edu.espe.bbconsultas.buro.api.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import ec.edu.espe.bbconsultas.buro.model.Pais;

/**
 *
 * @author luisj
 */
@Builder
@Data
public class PersonaRQ {

    private String cedula;

    private String nombres;

    private String apellidos;

    private String nombreCompleto;

    private String genero;

    private Date fechaNacimiento;

    private Pais nacionalidad;
}
