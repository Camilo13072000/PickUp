
package Modelo;

public class Mod_GetSetLoginCliente {
      private String Cli_id;
      private String Cli_documento;
      private String Cli_nombre;
      private String Cli_fecha_naci;
      private String Cli_genero;
      private String Cli_telefono;
      private String Cli_email;
      private String Cli_direccion_1;
      private String Cli_barrio_1;
      private String Cli_descripcion_1;
      private String Cli_direccion_2;
      private String Cli_barrio_2;
      private String Cli_descripcion_2;
      private String Cli_usu_id;

    public Mod_GetSetLoginCliente(String Cli_id, String Cli_documento, String Cli_nombre, String Cli_fecha_naci, String Cli_genero, String Cli_telefono, String Cli_email, String Cli_direccion_1, String Cli_barrio_1, String Cli_descripcion_1, String Cli_direccion_2, String Cli_barrio_2, String Cli_descripcion_2, String Cli_usu_id) {
        this.Cli_id = Cli_id;
        this.Cli_documento = Cli_documento;
        this.Cli_nombre = Cli_nombre;
        this.Cli_fecha_naci = Cli_fecha_naci;
        this.Cli_genero = Cli_genero;
        this.Cli_telefono = Cli_telefono;
        this.Cli_email = Cli_email;
        this.Cli_direccion_1 = Cli_direccion_1;
        this.Cli_barrio_1 = Cli_barrio_1;
        this.Cli_descripcion_1 = Cli_descripcion_1;
        this.Cli_direccion_2 = Cli_direccion_2;
        this.Cli_barrio_2 = Cli_barrio_2;
        this.Cli_descripcion_2 = Cli_descripcion_2;
        this.Cli_usu_id = Cli_usu_id;
    }

    public Mod_GetSetLoginCliente(String Cli_documento, String Cli_nombre, String Cli_fecha_naci, String Cli_genero, String Cli_telefono, String Cli_email, String Cli_direccion_1, String Cli_barrio_1, String Cli_descripcion_1, String Cli_usu_id) {
        this.Cli_documento = Cli_documento;
        this.Cli_nombre = Cli_nombre;
        this.Cli_fecha_naci = Cli_fecha_naci;
        this.Cli_genero = Cli_genero;
        this.Cli_telefono = Cli_telefono;
        this.Cli_email = Cli_email;
        this.Cli_direccion_1 = Cli_direccion_1;
        this.Cli_barrio_1 = Cli_barrio_1;
        this.Cli_descripcion_1 = Cli_descripcion_1;
        this.Cli_usu_id = Cli_usu_id;
    }

    public Mod_GetSetLoginCliente(String Cli_documento, String Cli_nombre, String Cli_fecha_naci, String Cli_genero, String Cli_telefono, String Cli_email, String Cli_direccion_1, String Cli_barrio_1, String Cli_descripcion_1, String Cli_direccion_2, String Cli_barrio_2, String Cli_descripcion_2) {
        this.Cli_documento = Cli_documento;
        this.Cli_nombre = Cli_nombre;
        this.Cli_fecha_naci = Cli_fecha_naci;
        this.Cli_genero = Cli_genero;
        this.Cli_telefono = Cli_telefono;
        this.Cli_email = Cli_email;
        this.Cli_direccion_1 = Cli_direccion_1;
        this.Cli_barrio_1 = Cli_barrio_1;
        this.Cli_descripcion_1 = Cli_descripcion_1;
        this.Cli_direccion_2 = Cli_direccion_2;
        this.Cli_barrio_2 = Cli_barrio_2;
        this.Cli_descripcion_2 = Cli_descripcion_2;
    }

    public Mod_GetSetLoginCliente(String Cli_usu_id) {
        this.Cli_usu_id = Cli_usu_id;
    }
    
    public Mod_GetSetLoginCliente() {
    }

    public String getCli_id() {
        return Cli_id;
    }

    public void setCli_id(String Cli_id) {
        this.Cli_id = Cli_id;
    }

    public String getCli_documento() {
        return Cli_documento;
    }

    public void setCli_documento(String Cli_documento) {
        this.Cli_documento = Cli_documento;
    }

    public String getCli_nombre() {
        return Cli_nombre;
    }

    public void setCli_nombre(String Cli_nombre) {
        this.Cli_nombre = Cli_nombre;
    }

    public String getCli_fecha_naci() {
        return Cli_fecha_naci;
    }

    public void setCli_fecha_naci(String Cli_fecha_naci) {
        this.Cli_fecha_naci = Cli_fecha_naci;
    }

    public String getCli_genero() {
        return Cli_genero;
    }

    public void setCli_genero(String Cli_genero) {
        this.Cli_genero = Cli_genero;
    }

    public String getCli_telefono() {
        return Cli_telefono;
    }

    public void setCli_telefono(String Cli_telefono) {
        this.Cli_telefono = Cli_telefono;
    }

    public String getCli_email() {
        return Cli_email;
    }

    public void setCli_email(String Cli_email) {
        this.Cli_email = Cli_email;
    }

    public String getCli_direccion_1() {
        return Cli_direccion_1;
    }

    public void setCli_direccion_1(String Cli_direccion_1) {
        this.Cli_direccion_1 = Cli_direccion_1;
    }

    public String getCli_barrio_1() {
        return Cli_barrio_1;
    }

    public void setCli_barrio_1(String Cli_barrio_1) {
        this.Cli_barrio_1 = Cli_barrio_1;
    }

    public String getCli_descripcion_1() {
        return Cli_descripcion_1;
    }

    public void setCli_descripcion_1(String Cli_descripcion_1) {
        this.Cli_descripcion_1 = Cli_descripcion_1;
    }

    public String getCli_direccion_2() {
        return Cli_direccion_2;
    }

    public void setCli_direccion_2(String Cli_direccion_2) {
        this.Cli_direccion_2 = Cli_direccion_2;
    }

    public String getCli_barrio_2() {
        return Cli_barrio_2;
    }

    public void setCli_barrio_2(String Cli_barrio_2) {
        this.Cli_barrio_2 = Cli_barrio_2;
    }

    public String getCli_descripcion_2() {
        return Cli_descripcion_2;
    }

    public void setCli_descripcion_2(String Cli_descripcion_2) {
        this.Cli_descripcion_2 = Cli_descripcion_2;
    }

    public String getCli_usu_id() {
        return Cli_usu_id;
    }

    public void setCli_usu_id(String Cli_usu_id) {
        this.Cli_usu_id = Cli_usu_id;
    }
    
}