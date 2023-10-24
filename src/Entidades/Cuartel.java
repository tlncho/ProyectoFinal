
package Entidades;


public class Cuartel {
    private int idCuartel;
    private String nombre;
    private String direccion;
    private int coordenadaX;
     private int coordenadaY;
     private int celular;
     private String correo;

    public Cuartel() {
    }

    public Cuartel(String nombre, String direccion, int coordenadaX, int coordenadaY, int celular, String correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.celular = celular;
        this.correo = correo;
    }

    public Cuartel(int idCuartel, String nombre, String direccion, int coordenadaX, int coordenadaY, int celular, String correo) {
        this.idCuartel = idCuartel;
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.celular = celular;
        this.correo = correo;
    }

    public int getIdCuartel() {
        return idCuartel;
    }

    public void setIdCuartel(int idCuartel) {
        this.idCuartel = idCuartel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cuartel{" + "idCuartel=" + idCuartel + ", nombre=" + nombre + ", celular=" + celular + '}';
    }
    
     
}
