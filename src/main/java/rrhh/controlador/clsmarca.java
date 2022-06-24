package rrhh.controlador;

public class clsmarca {
    private int codigo_marca;
    private String  nombre_marca;
    private String estatus_marca;

    public clsmarca() {
    }

    public clsmarca(int codigodepa) {
        this.codigo_marca = codigodepa;
    }
    
    public clsmarca(String snombre, String sestado) {
        this.nombre_marca = snombre;
        this.estatus_marca = sestado;
    }
    
    public clsmarca(int codigodepa, String snombre, String sestado) {
        this.codigo_marca = codigodepa;
        this.nombre_marca = snombre;
        this.estatus_marca = sestado;
    }
    

    public int getcodigo_marca() {
        return codigo_marca;
    }

    public void setcodigo_marca(int codigodepa) {
        this.codigo_marca = codigodepa;
    }

    public String getnombre_marca() {
        return nombre_marca;
    }

    public void setnombre_marca(String snombre) {
        this.nombre_marca = snombre;
    }

    public String getestatus_marca() {
        return estatus_marca;
    }

    public void setestatus_marca(String sestado) {
        this.estatus_marca = sestado;
    }
    @Override
    public String toString() {
        return "marcas{" + "codigo_marca=" + codigo_marca + ", nombre_marca="  +  nombre_marca +", estatus_marca=" + estatus_marca+  "}";
    }
    
    
}
