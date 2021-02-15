package ec.edu.espe.bbconsultas.buro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "iso_pais")
public class Pais {

    @Id
    @Column(name = "COD_PAIS")
    private String id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "COD_ALTERNO")
    private String codAlterno;
    
}
