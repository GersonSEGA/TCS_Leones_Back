package edu.moduloalumno.dao;

import java.util.List;

import edu.moduloalumno.entity.AlumnoAlumnoPrograma;

public interface IAlumnoAlumnoProgramaDAO {

	List<AlumnoAlumnoPrograma> getAllAlumnoAlumnoProgramas();

	AlumnoAlumnoPrograma getAlumnoAlumnoProgramaById(int idAlum);

	AlumnoAlumnoPrograma addAlumnoAlumnoPrograma(AlumnoAlumnoPrograma alumnoAlumnoPrograma);

	void updateAlumnoAlumnoPrograma(Integer id_alum, String cod_alumno, Integer id_programa);

	void deleteAlumnoAlumnoPrograma(int id_alumno);

}