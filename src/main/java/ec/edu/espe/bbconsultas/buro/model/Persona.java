package ec.edu.espe.bbconsultas.buro.model;

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
import javax.persistence.UniqueConstraint;
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
@Table(name = "persona", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CEDULA"})})
public class Persona {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_PERSONA")
    private Integer codigo;

    @Id
    @Column(name = "CEDULA")
    private String cedula;

    @Column(name = "NOMBRES")
    private String nombres;

    @Column(name = "APELLIDOS")
    private String apellidos;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name = "GENERO")
    private String genero;

    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;

    @JoinColumn(name = "NACIONALIDAD", referencedColumnName = "COD_PAIS", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pais nacionalidad;
}
