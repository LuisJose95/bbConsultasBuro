package ec.edu.espe.bbconsultas.buro.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author soyjo
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "buro")
public class Buro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_BURO")
    private Integer codigo;

    @Column(name = "COD_PERSONA ")
    private Integer persona;

    @Column(name = "CALIFICACION")
    private String calificacion;

    @Column(name = "CANTIDAD_ADEUDADA")
    private BigDecimal cantidadAdeudada;

    @Column(name = "CALIFICACION_ALTERNA")
    private BigDecimal calificacionAlterna;
}
