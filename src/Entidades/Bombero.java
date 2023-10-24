
package Entidades;

import java.time.LocalDate;


public class Bombero {
    private int idBombero;
    private int dni;
    private String nombreCompleto;
    private String grupoSanguineo;
    private LocalDate fechaNacimiento;
    private int celular;
    private Brigada idBrigada;

    public Bombero() {
    }

    public Bombero(int dni, String nombreCompleto, String grupoSanguineo, LocalDate fechaNacimiento, int celular,Brigada idBrigada) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.grupoSanguineo = grupoSanguineo;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.idBrigada=idBrigada;
    }

    public Bombero(int idBombero, int dni, String nombreCompleto, String grupoSanguineo, LocalDate fechaNacimiento, int celular,Brigada idBrigada) {
        this.idBombero = idBombero;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.grupoSanguineo = grupoSanguineo;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.idBrigada=idBrigada;
    }

    public int getIdBombero() {
        return idBombero;
    }

    public void setIdBombero(int idBombero) {
        this.idBombero = idBombero;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public Brigada getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(Brigada idBrigada) {
        this.idBrigada = idBrigada;
    }
    

    @Override
    public String toString() {
        return "Bombero{" + "dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", celular=" + celular + '}';
    }
    
}
