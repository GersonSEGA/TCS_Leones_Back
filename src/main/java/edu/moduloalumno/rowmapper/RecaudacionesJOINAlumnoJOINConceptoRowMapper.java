/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moduloalumno.rowmapper;

import edu.moduloalumno.entity.RecaudacionesJOINAlumnoJOINConcepto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author gerso
 */
public class RecaudacionesJOINAlumnoJOINConceptoRowMapper implements RowMapper<RecaudacionesJOINAlumnoJOINConcepto>{

    @Override
    public RecaudacionesJOINAlumnoJOINConcepto mapRow(ResultSet rs, int rowNum) throws SQLException {
        RecaudacionesJOINAlumnoJOINConcepto recaudaciones = new RecaudacionesJOINAlumnoJOINConcepto();
        recaudaciones.setApe_nom(rs.getString("ape_nom"));
        recaudaciones.setConcepto(rs.getString("concepto"));
        recaudaciones.setFecha(rs.getDate("fecha"));
        recaudaciones.setId_rec(rs.getInt("id_rec"));
        recaudaciones.setNumero(rs.getString("numero"));
        recaudaciones.setId_alum(rs.getInt("id_alum"));
        recaudaciones.setMoneda((rs.getString("moneda")));
        recaudaciones.setImporte(rs.getInt("importe"));
        return recaudaciones;
    }
    
}
