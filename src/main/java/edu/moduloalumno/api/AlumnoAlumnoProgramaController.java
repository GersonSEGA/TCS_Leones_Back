package edu.moduloalumno.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.AlumnoAlumnoPrograma;
import edu.moduloalumno.service.IAlumnoAlumnoProgramaService;
import javax.ws.rs.POST;

@RestController
@RequestMapping("/alumnoalumnoprograma")
public class AlumnoAlumnoProgramaController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IAlumnoAlumnoProgramaService service;
	
	@RequestMapping(value = "/buscar/{idAlum}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlumnoAlumnoPrograma> getAlumnoAlumnoProgramaById(@PathVariable("idAlum") Integer idAlum) {
		logger.info("> getAlumnoAlumnoProgramaById [AlumnoAlumnoPrograma]");

		AlumnoAlumnoPrograma alum = null;
		try {
			alum = service.getAlumnoAlumnoProgramaById(idAlum);

			if (alum == null) {
				alum = new AlumnoAlumnoPrograma();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<AlumnoAlumnoPrograma>(alum, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAlumnoAlumnoProgramaById [AlumnoAlumnoPrograma]");
		return new ResponseEntity<AlumnoAlumnoPrograma>(alum, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AlumnoAlumnoPrograma>> getAllAlumnoAlumnoProgramas() {
		logger.info("> getAllAlumnoAlumnoProgramas [AlumnoAlumnoPrograma]");

		List<AlumnoAlumnoPrograma> list = null;
		try {
			list = service.getAllAlumnoAlumnoProgramas();

			if (list == null) {
				list = new ArrayList<AlumnoAlumnoPrograma>();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<AlumnoAlumnoPrograma>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllAlumnoAlumnoProgramas [AlumnoAlumnoPrograma]");
		return new ResponseEntity<List<AlumnoAlumnoPrograma>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlumnoAlumnoPrograma> addAlumnoAlumnoPrograma(@RequestBody AlumnoAlumnoPrograma alumnoAlumnoPrograma) {

		logger.info("> addAlumnoAlumnoPrograma [AlumnoAlumnoPrograma]"+alumnoAlumnoPrograma);
		
		AlumnoAlumnoPrograma newAlumnoAlumnoPrograma = null;
		try {
			newAlumnoAlumnoPrograma = service.addAlumnoAlumnoPrograma(alumnoAlumnoPrograma);
			logger.info(">try [AlumnoAlumnoPrograma]"+newAlumnoAlumnoPrograma);
		} catch (Exception e) {
			logger.info("> catch [AlumnoAlumnoPrograma]"+alumnoAlumnoPrograma+" "+e.getMessage());
			return new ResponseEntity<AlumnoAlumnoPrograma>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("> addAlumnoAlumnoPrograma [AlumnoAlumnoPrograma]");
		return new ResponseEntity<AlumnoAlumnoPrograma>(newAlumnoAlumnoPrograma, HttpStatus.CREATED);
	}
        
        @RequestMapping(value = "/actualizar/{id_alum}/{cod_alumno}/{id_programa}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public void updateAlumnoAlumnoPrograma(@PathVariable("id_alum") Integer id_alum, @PathVariable("cod_alumno") String cod_alumno, @PathVariable("id_programa") Integer id_programa){
            
            logger.info("> Commo00n: " + id_alum + " " + cod_alumno + " " + id_programa);
            Integer response = 0;
            
            try{
                 service.updateAlumnoAlumnoPrograma(id_alum, cod_alumno, id_programa);
            } catch(Exception e){
                logger.error("Unexpected Exception caught. "+ e.getMessage());
            }
            
        } 
        
        @RequestMapping(value = "/eliminar/{id_alum}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        public void deleteAlumnoAlumnoPrograma(@PathVariable("id_alum") Integer id_alum){
            logger.info("> CommoOOn: " + id_alum);
            try{
                service.deleteAlumnoAlumnoPrograma(id_alum);
            } catch(Exception e){
                logger.error("Unexpected Exception caught. "+ e.getMessage());
            }
        }

}
