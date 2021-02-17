package ec.edu.espe.bbconsultas.buro.api.dto;

import lombok.Data;
import ec.edu.espe.bbconsultas.buro.model.InstitucionFinanciera;
import ec.edu.espe.bbconsultas.buro.model.TipoPrestamo;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Builder;

/**
 *
 * @author soyjo
 */
@Builder
@Data
public class PrestamoRQ {

    private InstitucionFinanciera institucionFinanciera;

    private TipoPrestamo tipoPrestamo;

    private BigDecimal montoInicial;

    private BigDecimal montoActual;

    private Date fechaPrestamo;

    private Integer diasMora;
}
