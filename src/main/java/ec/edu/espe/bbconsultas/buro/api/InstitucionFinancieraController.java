package ec.edu.espe.bbconsultas.buro.api;

import ec.edu.espe.bbconsultas.buro.service.InstitucionFinancieraService;
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
public class InstitucionFinancieraController {
    private final InstitucionFinancieraService institucionFinancieraService;

    public InstitucionFinancieraController(InstitucionFinancieraService institucionFinancieraService) {
        this.institucionFinancieraService = institucionFinancieraService;
    }
    
    @GetMapping("institucionFinanciera")
    public ResponseEntity get() {
        return ResponseEntity.ok(this.institucionFinancieraService.findAll());
    }
    
    @GetMapping(path = "institucionFinanciera/{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id){
         return ResponseEntity.ok(this.institucionFinancieraService.findById(id));
    }
      
}
