package ec.edu.espe.bbconsultas.buro.api;

import ec.edu.espe.bbconsultas.buro.exception.DataNotFoundException;
import ec.edu.espe.bbconsultas.buro.service.BuroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author soyjo
 */
@RestController
@RequestMapping("/api/bbConsultas/buro")
@Slf4j
public class BuroController {

    private final BuroService buroService;

    public BuroController(BuroService buroService) {
        this.buroService = buroService;
    }

    @GetMapping(path = "/{cedula}")
    public ResponseEntity findById(@PathVariable("cedula") String cedula) throws DataNotFoundException {
        try {
            return ResponseEntity.ok(this.buroService.findByCedula(cedula));
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
