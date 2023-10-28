
package Entidades;


public class Cuartel {
    private int idCuartel;
    private int codCuartel;
    private String nombre;
    private String domicilio;
    private int coordenadaX;
     private int coordenadaY;
     private int telefono;
     private String correo;

    public Cuartel() {
    }

    public Cuartel(int idCuartel, int codCuartel, String nombre, String domicilio, int coordenadaX, int coordenadaY, int telefono, String correo) {
        this.idCuartel = idCuartel;
        this.codCuartel = codCuartel;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cuartel(int codCuartel, String nombre, String domicilio, int coordenadaX, int coordenadaY, int telefono, String correo) {
        this.codCuartel = codCuartel;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdCuartel() {
        return idCuartel;
    }

    public void setIdCuartel(int idCuartel) {
        this.idCuartel = idCuartel;
    }

    public int getCodCuartel() {
        return codCuartel;
    }

    public void setCodCuartel(int codCuartel) {
        this.codCuartel = codCuartel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cuartel{" + "codCuartel=" + codCuartel + ", nombre=" + nombre + ", domicilio=" + domicilio + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", telefono=" + telefono + ", correo=" + correo + '}';
    }

   
     
}
