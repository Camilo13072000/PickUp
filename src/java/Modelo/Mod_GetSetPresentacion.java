
package Modelo;

public class Mod_GetSetPresentacion {
    private int pre_codigo;
    private String pre_marca;
    private String pre_descripcion;
    private int pre_unidades;
    private int pre_precio;
    private String pre_foto;
    private String pre_pro_codigo;
    private String pre_estado;

    public Mod_GetSetPresentacion(int pre_codigo, String pre_marca, String pre_descripcion, int pre_unidades, int pre_precio, String pre_foto, String pre_pro_codigo, String pre_estado) {
        this.pre_codigo = pre_codigo;
        this.pre_marca = pre_marca;
        this.pre_descripcion = pre_descripcion;
        this.pre_unidades = pre_unidades;
        this.pre_precio = pre_precio;
        this.pre_foto = pre_foto;
        this.pre_pro_codigo = pre_pro_codigo;
        this.pre_estado = pre_estado;
    }

    public Mod_GetSetPresentacion() {
    }

    public int getPre_codigo() {
        return pre_codigo;
    }

    public void setPre_codigo(int pre_codigo) {
        this.pre_codigo = pre_codigo;
    }

    public String getPre_marca() {
        return pre_marca;
    }

    public void setPre_marca(String pre_marca) {
        this.pre_marca = pre_marca;
    }

    public String getPre_descripcion() {
        return pre_descripcion;
    }

    public void setPre_descripcion(String pre_descripcion) {
        this.pre_descripcion = pre_descripcion;
    }

    public int getPre_unidades() {
        return pre_unidades;
    }

    public void setPre_unidades(int pre_unidades) {
        this.pre_unidades = pre_unidades;
    }

    public int getPre_precio() {
        return pre_precio;
    }

    public void setPre_precio(int pre_precio) {
        this.pre_precio = pre_precio;
    }

    public String getPre_foto() {
        return pre_foto;
    }

    public void setPre_foto(String pre_foto) {
        this.pre_foto = pre_foto;
    }

    public String getPre_pro_codigo() {
        return pre_pro_codigo;
    }

    public void setPre_pro_codigo(String pre_pro_codigo) {
        this.pre_pro_codigo = pre_pro_codigo;
    }

    public String getPre_estado() {
        return pre_estado;
    }

    public void setPre_estado(String pre_estado) {
        this.pre_estado = pre_estado;
    }

    
    
    
}
