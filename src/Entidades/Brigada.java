
package Entidades;


public class Brigada {
    private int idBrigada;
    private String aliasBrigada;
    private String especialidad;
    private boolean estado;
    private Cuartel codCuartel;

    public Brigada() {
    }

    public Brigada(int idBrigada, String aliasBrigada, String especialidad, boolean estado, Cuartel codCuartel) {
        this.idBrigada = idBrigada;
        this.aliasBrigada = aliasBrigada;
        this.especialidad = especialidad;
        this.estado = estado;
        this.codCuartel = codCuartel;
    }

    public Brigada(String aliasBrigada, String especialidad, boolean estado, Cuartel codCuartel) {
        this.aliasBrigada = aliasBrigada;
        this.especialidad = especialidad;
        this.estado = estado;
        this.codCuartel = codCuartel;
    }

    public int getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(int idBrigada) {
        this.idBrigada = idBrigada;
    }

    public String getAliasBrigada() {
        return aliasBrigada;
    }

    public void setAliasBrigada(String aliasBrigada) {
        this.aliasBrigada = aliasBrigada;
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

    public Cuartel getCodCuartel() {
        return codCuartel;
    }

    public void setCodCuartel(Cuartel codCuartel) {
        this.codCuartel = codCuartel;
    }

    @Override
    public String toString() {
        return "Brigada{" + "aliasBrigada=" + aliasBrigada + ", especialidad=" + especialidad + ", estado=" + estado + ", codCuartel=" + codCuartel + '}';
    }

    
    
}
