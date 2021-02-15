package ec.edu.espe.bbconsultas.buro.api.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author luisj
 */
@Builder
@Data
public class BuroRQ {

    private PersonaRQ persona;

    private String calificacion;

    private BigDecimal cantidadAdeudada;

    private BigDecimal calificacionAlterna;
}
