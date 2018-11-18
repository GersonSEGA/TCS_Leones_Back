package edu.moduloalumno.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IAlumnoAlumnoProgramaDAO;
import edu.moduloalumno.entity.AlumnoAlumnoPrograma;
import edu.moduloalumno.rowmapper.AlumnoAlumnoProgramaRowMapper;

@Transactional
@Repository
public class AlumnoAlumnoProgramaDAOImpl implements IAlumnoAlumnoProgramaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public AlumnoAlumnoPrograma getAlumnoAlumnoProgramaById(int idAlum) {
		String sql = "SELECT * FROM alumno_alumno_programa WHERE id_alum = ?";
		RowMapper<AlumnoAlumnoPrograma> rowMapper = new AlumnoAlumnoProgramaRowMapper();
		AlumnoAlumnoPrograma alumnoAlumnoPrograma = jdbcTemplate.queryForObject(sql, rowMapper, idAlum);
		return alumnoAlumnoPrograma;
	}

	@Override
	public List<AlumnoAlumnoPrograma> getAllAlumnoAlumnoProgramas() {
		String sql = "SELECT id_alum, cod_alumno, id_programa FROM alumno_alumno_programa";
		// RowMapper<AlumnoAlumnoPrograma> rowMapper = new
		// BeanPropertyRowMapper<AlumnoAlumnoPrograma>(AlumnoAlumnoPrograma.class);
		RowMapper<AlumnoAlumnoPrograma> rowMapper = new AlumnoAlumnoProgramaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public AlumnoAlumnoPrograma addAlumnoAlumnoPrograma(AlumnoAlumnoPrograma alumnoAlumnoPrograma) {
		// Add alumnoAlumnoPrograma
		
		String sql = "INSERT INTO alumno_alumno_programa (id_alum, cod_alumno, id_programa) values (?, ?, ?)";
		jdbcTemplate.update(sql, alumnoAlumnoPrograma.getIdAlumno(), alumnoAlumnoPrograma.getCodAlumno(),alumnoAlumnoPrograma.getIdPrograma());

		sql = "SELECT * FROM alumno_alumno_programa WHERE id_alum = ? and cod_alumno = ? and id_programa = ?";
		RowMapper<AlumnoAlumnoPrograma> rowMapper = new AlumnoAlumnoProgramaRowMapper();
		AlumnoAlumnoPrograma alumnoAlumnoProgramaNew = jdbcTemplate.queryForObject(sql, rowMapper,
				alumnoAlumnoPrograma.getIdAlumno(), alumnoAlumnoPrograma.getCodAlumno(),
				alumnoAlumnoPrograma.getIdPrograma());
		
		System.out.println("holaaaaaaaaaaaaaaaaaa " + alumnoAlumnoProgramaNew);

		// get alumnoAlumnoPrograma
		return alumnoAlumnoProgramaNew;
	}

	@Override
	public void updateAlumnoAlumnoPrograma(Integer id_alum, String cod_alumno, Integer id_programa) {
		String sql = "UPDATE alumno_alumno_programa SET cod_alumno = ?, id_programa = ? WHERE id_alum = ?";
		jdbcTemplate.update(sql, cod_alumno, id_programa, id_alum);
	}

	@Override
	public void deleteAlumnoAlumnoPrograma(int id_alum) {
		String sql = "DELETE FROM alumno_alumno_programa WHERE id_alum = ?";
		jdbcTemplate.update(sql, id_alum);
	}

}