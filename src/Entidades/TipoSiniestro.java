
package Entidades;

/**
 
 * @author Julian Rios
 */
public class TipoSiniestro {
    
    private int idTipoSiniestro;
    private String tipoSiniestro;

    public TipoSiniestro() {
    }

    public TipoSiniestro(int idTipoSiniestro, String tipoSiniestro) {
        this.idTipoSiniestro = idTipoSiniestro;
        this.tipoSiniestro = tipoSiniestro;
    }

    public int getIdTipoSiniestro() {
        return idTipoSiniestro;
    }

    public void setIdTipoSiniestro(int idTipoSiniestro) {
        this.idTipoSiniestro = idTipoSiniestro;
    }

    public String getTipoSiniestro() {
        return tipoSiniestro;
    }

    public void setTipoSiniestro(String tipoSiniestro) {
        this.tipoSiniestro = tipoSiniestro;
    }
    
    

}
