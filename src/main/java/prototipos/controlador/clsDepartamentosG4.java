package prototipos.controlador;

import seguridad.controlador.*;

public class clsDepartamentosG4 {

    private String apl_idPerfil;
    private String apl_idaplicacion;

    public clsDepartamentosG4() {
    }


    
    public clsDepartamentosG4(String apl_idPerfil, String apl_idaplicacion) {
        this.apl_idPerfil = apl_idPerfil;
        this.apl_idaplicacion = apl_idaplicacion;
    }
    
 
   

    public String getUsername() {
        return apl_idPerfil;
    }

    public void setUsername(String apl_idPerfil) {
        this.apl_idPerfil= apl_idPerfil;
    }

    public String getPassword() {
        return apl_idaplicacion;
    }

    public void setPassword(String apl_idaplicacion) {
        this.apl_idaplicacion = apl_idaplicacion;
    }

    @Override
    public String toString() {
        return "PerfilAplicacion{"  + " Pefil=" + apl_idPerfil + ", aplicacion=" + apl_idaplicacion + '}';
    }
    
    
}
