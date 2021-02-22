package ec.edu.espe.bbconsultas.buro.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "prestamo")
public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_PRESTAMO")
    private Integer codigo;
   
    @Column(name = "COD_PERSONA")
    private Integer codPersona;

    @JoinColumn(name = "COD_INSITUCION", referencedColumnName = "COD_INSITUCION", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private InstitucionFinanciera institucionFinanciera;

    @JoinColumn(name = "COD_TIPO_PRESTAMO", referencedColumnName = "COD_TIPO_PRESTAMO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoPrestamo tipoPrestamo;

    @Column(name = "MONTO_INICIAL")
    private BigDecimal montoInicial;

    @Column(name = "MONTO_ACTUAL")
    private BigDecimal montoActual;

    @Column(name = "FECHA_PRESTAMO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrestamo;

    @Column(name = "DIAS_MORA")
    private Integer diasMora;
}
