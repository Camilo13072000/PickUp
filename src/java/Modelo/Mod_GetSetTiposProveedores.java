
package Modelo;

public class Mod_GetSetTiposProveedores {
    private int tipo_codigo;
    private String tipo_nombre;
    private String tipo_descripcion;
    private String tipo_foto;

    public Mod_GetSetTiposProveedores(int tipo_codigo, String tipo_nombre, String tipo_descripcion, String tipo_foto) {
        this.tipo_codigo = tipo_codigo;
        this.tipo_nombre = tipo_nombre;
        this.tipo_descripcion = tipo_descripcion;
        this.tipo_foto = tipo_foto;
    }

    public Mod_GetSetTiposProveedores() {
    }

    public int getTipo_codigo() {
        return tipo_codigo;
    }

    public void setTipo_codigo(int tipo_codigo) {
        this.tipo_codigo = tipo_codigo;
    }

    public String getTipo_nombre() {
        return tipo_nombre;
    }

    public void setTipo_nombre(String tipo_nombre) {
        this.tipo_nombre = tipo_nombre;
    }

    public String getTipo_descripcion() {
        return tipo_descripcion;
    }

    public void setTipo_descripcion(String tipo_descripcion) {
        this.tipo_descripcion = tipo_descripcion;
    }

    public String getTipo_foto() {
        return tipo_foto;
    }

    public void setTipo_foto(String tipo_foto) {
        this.tipo_foto = tipo_foto;
    }

    
    
}
