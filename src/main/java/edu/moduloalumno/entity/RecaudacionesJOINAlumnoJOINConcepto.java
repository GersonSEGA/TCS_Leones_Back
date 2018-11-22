package edu.moduloalumno.entity;

import java.util.Date;

public class RecaudacionesJOINAlumnoJOINConcepto {
    
    private String ape_nom;
    private String concepto;
    private Date fecha;
    private Integer id_rec;
    private String numero;
    private Integer id_alum;
    private String moneda;
    private Integer importe;

    public String getApe_nom() {
        return ape_nom;
    }

    public void setApe_nom(String ape_nom) {
        this.ape_nom = ape_nom;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId_rec() {
        return id_rec;
    }

    public void setId_rec(Integer id_rec) {
        this.id_rec = id_rec;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getId_alum() {
        return id_alum;
    }

    public void setId_alum(Integer id_alum) {
        this.id_alum = id_alum;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Integer getImporte() {
        return importe;
    }

    public void setImporte(Integer importe) {
        this.importe = importe;
    }
    
}
