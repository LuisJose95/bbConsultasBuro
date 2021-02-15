package ec.edu.espe.bbconsultas.buro.model;

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
@Table(name = "institucion_financiera")
public class InstitucionFinanciera {
    
    @Id
    @Column(name = "COD_INSITUCION ")
    private String codigo;
    
    @Column(name = "NOMBRE ")
    private String nombre;
    
    @Column(name = "TIPO ")
    private String tipo;
    
    @Column(name = "CALIFICACION_RIESGO ")
    private String calificacionRiesgo;
}
