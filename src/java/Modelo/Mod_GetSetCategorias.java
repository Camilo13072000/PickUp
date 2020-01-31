
package Modelo;

public class Mod_GetSetCategorias {
    private String Cate_codigo;
    private String Cate_nombre;
    private String Cate_foto;

    public Mod_GetSetCategorias(String Cate_codigo, String Cate_nombre, String Cate_foto) {
        this.Cate_codigo = Cate_codigo;
        this.Cate_nombre = Cate_nombre;
        this.Cate_foto = Cate_foto;
    }

    public Mod_GetSetCategorias(String Cate_nombre, String Cate_foto) {
        this.Cate_nombre = Cate_nombre;
        this.Cate_foto = Cate_foto;
    }

    public Mod_GetSetCategorias() {
    }

    public String getCate_codigo() {
        return Cate_codigo;
    }

    public void setCate_codigo(String Cate_codigo) {
        this.Cate_codigo = Cate_codigo;
    }

    public String getCate_nombre() {
        return Cate_nombre;
    }

    public void setCate_nombre(String Cate_nombre) {
        this.Cate_nombre = Cate_nombre;
    }

    public String getCate_foto() {
        return Cate_foto;
    }

    public void setCate_foto(String Cate_foto) {
        this.Cate_foto = Cate_foto;
    }
    
    
}
