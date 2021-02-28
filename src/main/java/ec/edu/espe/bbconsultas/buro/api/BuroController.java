package ec.edu.espe.bbconsultas.buro.api;

import ec.edu.espe.bbconsultas.buro.exception.DataNotFoundException;
import ec.edu.espe.bbconsultas.buro.service.BuroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author soyjo
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/bbConsultas/buro")
@Slf4j
public class BuroController {

    private final BuroService buroService;

    public BuroController(BuroService buroService) {
        this.buroService = buroService;
    }

    @GetMapping(path = "/{cedula}")
    @ApiOperation(value = "Busca una persona", notes = "Busca una persona por su cedula dentró del buró de crédito.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Persona Encontrada"),
        @ApiResponse(code = 404, message = "No se encontraron coincidencias")
    })
    public ResponseEntity findById(@PathVariable("cedula") String cedula) throws DataNotFoundException {
        try {
            return ResponseEntity.ok(this.buroService.findByCedula(cedula));
        } catch (DataNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(path = "cantidadAdeudada/{cantidadAdeudada}")
    public ResponseEntity findByCantidadAdeudadaGreaterThan(@PathVariable("cantidadAdeudada") BigDecimal cantidadAdeudada) {
        try {
            return ResponseEntity.ok(this.buroService.findByCantidadAdeudadaGreaterThan(cantidadAdeudada));
        } catch (DataNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(path = "calificacion/{calificacion}")
    public ResponseEntity findByCalificacion(@PathVariable("calificacion") String calificacion) {
        try {
            return ResponseEntity.ok(this.buroService.findByCalificacion(calificacion));
        } catch (DataNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/calificacionAndAdeudada")
    public ResponseEntity findByCalificacionAndCantidadAdeudadaGreaterThan(@RequestParam("calificacion") String calificacion,
            @RequestParam("cantidadAdeudada") BigDecimal cantidadAdeudada) {
        try {
            return ResponseEntity.ok(this.buroService.findByCalificacionAndCantidadAdeudadaGreaterThan(calificacion, cantidadAdeudada));
        } catch (DataNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}