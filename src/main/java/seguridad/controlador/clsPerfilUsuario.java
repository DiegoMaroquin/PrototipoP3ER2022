package seguridad.controlador;

public class clsPerfilUsuario {
    int perusuid;
    String pernombre;
    String usunombre;

    public clsPerfilUsuario() {
    }

    public clsPerfilUsuario(int id_perfilusuario) {
        this.perusuid= id_perfilusuario;
    }

    public clsPerfilUsuario(String nombreperfil, String nombreusuario) {
        this.pernombre = nombreperfil;
        this.usunombre = nombreusuario;
    }

    public int getId_PerfilUsuario() {
        return perusuid;
    }

    public void setId_PerfilUsuario(int id_perfilusuario) {
        this.perusuid = id_perfilusuario;
    }

    public String getNombrePerfil() {
        return pernombre;
    }

    public void setNombrePerfil(String nombreperfil) {
        this.pernombre = nombreperfil;
    }

    public String getNombreUsuario() {
        return usunombre;
    }

    public void setNombreUsuario(String nombreusuario) {
        this.usunombre = nombreusuario;
    }

    @Override
    public String toString() {
        return "tbl_perfilusuario{" + "perusuid=" + perusuid + ", pernombre=" + pernombre + ", usunombre=" + usunombre + '}';
    }
    
}
