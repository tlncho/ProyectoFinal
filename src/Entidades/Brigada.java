
package Entidades;


public class Brigada {
    private int idBrigada;
    private String nombre;
    private String especialidad;
    private boolean estado;
    private Cuartel nroCuartel;

    public Brigada() {
    }

    public Brigada(String nombre, String especialidad, boolean estado, Cuartel nroCuartel) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.estado = estado;
        this.nroCuartel = nroCuartel;
    }

    public Brigada(int idBrigada, String nombre, String especialidad, boolean estado, Cuartel nroCuartel) {
        this.idBrigada = idBrigada;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.estado = estado;
        this.nroCuartel = nroCuartel;
    }

    public int getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(int idBrigada) {
        this.idBrigada = idBrigada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Cuartel getNroCuartel() {
        return nroCuartel;
    }

    public void setNroCuartel(Cuartel nroCuartel) {
        this.nroCuartel = nroCuartel;
    }

    @Override
    public String toString() {
        return "Brigada{" + "idBrigada=" + idBrigada + ", nombre=" + nombre + ", especialidad=" + especialidad + ", estado=" + estado + ", nroCuartel=" + nroCuartel + '}';
    }
    
}
