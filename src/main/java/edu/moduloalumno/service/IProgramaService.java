package edu.moduloalumno.service;

import java.util.List;

import edu.moduloalumno.entity.Programa;

public interface IProgramaService {
	
	List<Programa> getAllProgramas();

	Programa getProgramaById(int id_Programa);

	void addPrograma(Programa programa);

	void updatePrograma(Programa programa);

	void deletePrograma(int idPrograma);
}