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
@Table(name = "tipo_prestamo")
public class TipoPrestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_TIPO_PRESTAMO  ")
    private Integer codigo;

    @Column(name = "NOMBRE ")
    private String nombre;

    @Column(name = "DESCRIPCIOON ")
    private String descripcion;

}
