package edu.moduloalumno.service;

import java.util.List;

import edu.moduloalumno.entity.AlumnoAlumnoPrograma;

public interface IAlumnoAlumnoProgramaService {
	
	List<AlumnoAlumnoPrograma> getAllAlumnoAlumnoProgramas();

	AlumnoAlumnoPrograma getAlumnoAlumnoProgramaById(int idAlum);
	
	AlumnoAlumnoPrograma addAlumnoAlumnoPrograma(AlumnoAlumnoPrograma alumnoAlumnoPrograma);

	void updateAlumnoAlumnoPrograma(Integer id_alum, String cod_alumno, Integer id_programa);

	void deleteAlumnoAlumnoPrograma(int idAlum);
}
