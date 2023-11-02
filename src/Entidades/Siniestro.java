
package Entidades;

import java.sql.Date;


public class Siniestro {
    private int idSiniestro;
    private String tipoSiniestro;
    private Date fechaSiniestro;
    private int coordenadaX;
     private int coordenadaY;
     private String detalles;
     private Date fechaResolucion;
     private int calificacion;
     private int idBrigada;

    public Siniestro() {
    }

    public Siniestro(String tipoSiniestro, Date fechaSiniestro, int coordenadaX, int coordenadaY, String detalles, Date fechaResolucion, int calificacion, int idBrigada) {
        this.tipoSiniestro = tipoSiniestro;
        this.fechaSiniestro = fechaSiniestro;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.detalles = detalles;
        this.fechaResolucion = fechaResolucion;
        this.calificacion = calificacion;
        this.idBrigada = idBrigada;
    }

    public Siniestro(int idSiniestro, String tipoSiniestro, Date fechaSiniestro, int coordenadaX, int coordenadaY, String detalles, Date fechaResolucion, int calificacion, int idBrigada) {
        this.idSiniestro = idSiniestro;
        this.tipoSiniestro = tipoSiniestro;
        this.fechaSiniestro = fechaSiniestro;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.detalles = detalles;
        this.fechaResolucion = fechaResolucion;
        this.calificacion = calificacion;
        this.idBrigada = idBrigada;
    }

    public int getIdSiniestro() {
        return idSiniestro;
    }

    public void setIdSiniestro(int idSiniestro) {
        this.idSiniestro = idSiniestro;
    }

    public String getTipoSiniestro() {
        return tipoSiniestro;
    }

    public void setTipoSiniestro(String tipoSiniestro) {
        this.tipoSiniestro = tipoSiniestro;
    }

    public Date getFechaSiniestro() {
        return fechaSiniestro;
    }

    public void setFechaSiniestro(Date fechaSiniestro) {
        this.fechaSiniestro = fechaSiniestro;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(int idBrigada) {
        this.idBrigada = idBrigada;
    }


    @Override
    public String toString() {
        return "Siniestro{" + "tipoSinietsro=" + tipoSiniestro + ", fechaSiniestro=" + fechaSiniestro + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", detalles=" + detalles + ", fechaResolucion=" + fechaResolucion + ", calificacion=" + calificacion + ", idBrigada=" + idBrigada + '}';
    }

    
}
