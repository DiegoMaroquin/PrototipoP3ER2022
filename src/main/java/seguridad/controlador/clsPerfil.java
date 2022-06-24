package seguridad.controlador;

public class clsPerfil {
    int perid;
    String pernombre;
    String perestatus;

    public clsPerfil() {
    }

    public clsPerfil(int id_perfil) {
        this.perid= id_perfil;
    }

    public clsPerfil(String nombreperfil, String estadoperfil) {
        this.pernombre = nombreperfil;
        this.perestatus = estadoperfil;
    }

    public int getId_Perfil() {
        return perid;
    }

    public void setId_Perfil(int id_perfil) {
        this.perid = id_perfil;
    }

    public String getNombrePerfil() {
        return pernombre;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.pernombre = nombrePerfil;
    }

    public String getEstadoPerfil() {
        return perestatus;
    }

    public void setEstadoPerfil(String estadoPerfil) {
        this.perestatus = estadoPerfil;
    }

    @Override
    public String toString() {
        return "tbl_perfil{" + "perid=" + perid + ", pernombre=" + pernombre + ", perestatus=" + perestatus + '}';
    }
    
}