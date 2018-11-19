package edu.moduloalumno.api;

import edu.moduloalumno.entity.Programa;
import edu.moduloalumno.service.IProgramaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/programa")
public class ProgramaController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private IProgramaService service;
    
    @RequestMapping(value = "/buscarPrograma/{id_programa}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Programa> getProgramaById(@PathVariable("id_programa") Integer id_programa) {
        
        logger.info("> getProgramaById [Programa]");
        Programa programa = null;
        try{
            programa = service.getProgramaById(id_programa);
            if(programa == null){
                programa = new Programa();
            }
        } catch(Exception e){
            logger.error("Unexpected Exception caught.", e);
            return new ResponseEntity<Programa>(programa, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info("< getProgramaById [Programa]");
        return new ResponseEntity<Programa>(programa, HttpStatus.OK);
        
    }
    
}
