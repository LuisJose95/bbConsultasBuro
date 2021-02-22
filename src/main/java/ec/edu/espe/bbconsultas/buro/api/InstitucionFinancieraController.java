package ec.edu.espe.bbconsultas.buro.api;

import ec.edu.espe.bbconsultas.buro.exception.DataNotFoundException;
import ec.edu.espe.bbconsultas.buro.service.InstitucionFinancieraService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author soyjo
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/bbConsultas/buro")
@Slf4j
public class InstitucionFinancieraController {

    private final InstitucionFinancieraService institucionFinancieraService;

    public InstitucionFinancieraController(InstitucionFinancieraService institucionFinancieraService) {
        this.institucionFinancieraService = institucionFinancieraService;
    }

    @GetMapping("institucionFinanciera")
    @ApiOperation(value = "Lista las instituciones financieras", notes = "Despliega una lista de las instituciones financieras registradas en el sitema")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista De Instituciones Financieras")
    })
    public ResponseEntity get() {
        return ResponseEntity.ok(this.institucionFinancieraService.findAll());
    }

    @GetMapping(path = "institucionFinanciera/{id}")
    @ApiOperation(value = "Busca una institución financiera", notes = "Busca una institución financiera mediante su código único .")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Institución Financiera encontrada"),
        @ApiResponse(code = 404, message = "No se encontraron coincidencias")
    })
    public ResponseEntity findById(@PathVariable("id") String id) throws DataNotFoundException {
        try {
            return ResponseEntity.ok(this.institucionFinancieraService.findById(id));
        } catch (DataNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
