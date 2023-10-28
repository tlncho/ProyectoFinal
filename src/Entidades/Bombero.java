
package Entidades;

import java.time.LocalDate;


public class Bombero {
   
    private int idBombero;
    private int codBombero;
    private String dni;
    private String nombreCompleto;
    private String grupoSang;
    private LocalDate fechaNac;
    private String celular;
    private String observaciones;
    private boolean estado;
    private Brigada aliasBrigada;

    public Bombero() {
    }

    public Bombero(int idBombero, int codBombero, String dni, String nombreCompleto, String grupoSang, LocalDate fechaNac, String celular, String observaciones, boolean estado, Brigada aliasBrigada) {
        this.idBombero = idBombero;
        this.codBombero = codBombero;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.grupoSang = grupoSang;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.observaciones = observaciones;
        this.estado = estado;
        this.aliasBrigada = aliasBrigada;
    }

    public Bombero(int codBombero, String dni, String nombreCompleto, String grupoSang, LocalDate fechaNac, String celular, String observaciones, boolean estado, Brigada aliasBrigada) {
        this.codBombero = codBombero;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.grupoSang = grupoSang;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.observaciones = observaciones;
        this.estado = estado;
        this.aliasBrigada = aliasBrigada;
    }

    public int getIdBombero() {
        return idBombero;
    }

    public void setIdBombero(int idBombero) {
        this.idBombero = idBombero;
    }

    public int getCodBombero() {
        return codBombero;
    }

    public void setCodBombero(int codBombero) {
        this.codBombero = codBombero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getGrupoSang() {
        return grupoSang;
    }

    public void setGrupoSang(String grupoSang) {
        this.grupoSang = grupoSang;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Brigada getAliasBrigada() {
        return aliasBrigada;
    }

    public void setAliasBrigada(Brigada aliasBrigada) {
        this.aliasBrigada = aliasBrigada;
    }

    @Override
    public String toString() {
        return "Bombero{" + "codBombero=" + codBombero + ", dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", grupoSang=" + grupoSang + ", fechaNac=" + fechaNac + ", celular=" + celular + ", observaciones=" + observaciones + ", estado=" + estado + ", aliasBrigada=" + aliasBrigada + '}';
    }
    
    
}
