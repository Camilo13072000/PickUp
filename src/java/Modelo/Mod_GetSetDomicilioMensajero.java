
package Modelo;

public class Mod_GetSetDomicilioMensajero {
    private int dom_id;
    private int dom_total_general;
    private String dom_estado;
    private int dom_costo_domicilio;
    private String dom_fecha_inicio;
    private String dom_fecha_salida;
    private String dom_fecha_entrega;
    private String cli_nombre;
    private String cli_direccion1;

    public Mod_GetSetDomicilioMensajero(int dom_id, int dom_total_general, String dom_estado, int dom_costo_domicilio, String dom_fecha_inicio, String dom_fecha_salida, String dom_fecha_entrega, String cli_nombre, String cli_direccion1) {
        this.dom_id = dom_id;
        this.dom_total_general = dom_total_general;
        this.dom_estado = dom_estado;
        this.dom_costo_domicilio = dom_costo_domicilio;
        this.dom_fecha_inicio = dom_fecha_inicio;
        this.dom_fecha_salida = dom_fecha_salida;
        this.dom_fecha_entrega = dom_fecha_entrega;
        this.cli_nombre = cli_nombre;
        this.cli_direccion1 = cli_direccion1;
    }

    public Mod_GetSetDomicilioMensajero() {
    }

    public int getDom_id() {
        return dom_id;
    }

    public void setDom_id(int dom_id) {
        this.dom_id = dom_id;
    }

    public int getDom_total_general() {
        return dom_total_general;
    }

    public void setDom_total_general(int dom_total_general) {
        this.dom_total_general = dom_total_general;
    }

    public String getDom_estado() {
        return dom_estado;
    }

    public void setDom_estado(String dom_estado) {
        this.dom_estado = dom_estado;
    }

    public int getDom_costo_domicilio() {
        return dom_costo_domicilio;
    }

    public void setDom_costo_domicilio(int dom_costo_domicilio) {
        this.dom_costo_domicilio = dom_costo_domicilio;
    }

    public String getDom_fecha_inicio() {
        return dom_fecha_inicio;
    }

    public void setDom_fecha_inicio(String dom_fecha_inicio) {
        this.dom_fecha_inicio = dom_fecha_inicio;
    }

    public String getDom_fecha_salida() {
        return dom_fecha_salida;
    }

    public void setDom_fecha_salida(String dom_fecha_salida) {
        this.dom_fecha_salida = dom_fecha_salida;
    }

    public String getDom_fecha_entrega() {
        return dom_fecha_entrega;
    }

    public void setDom_fecha_entrega(String dom_fecha_entrega) {
        this.dom_fecha_entrega = dom_fecha_entrega;
    }

    public String getCli_nombre() {
        return cli_nombre;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }

    public String getCli_direccion1() {
        return cli_direccion1;
    }

    public void setCli_direccion1(String cli_direccion1) {
        this.cli_direccion1 = cli_direccion1;
    }

    
}
