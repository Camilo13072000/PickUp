
package Modelo;

public class Mod_GetSetDomicilio {
    private int Dom_id;
    private String dom_total_general;
    private String dom_estado;
    private String dom_costo_domicilio;
    private String dom_fecha_inicio;
    private String dom_fecha_salida;
    private String dom_fecha_entrega;
    private String dom_cli_id;
    private String dom_men_id;
    private String Cli_id;

    public Mod_GetSetDomicilio(int Dom_id, String dom_total_general, String dom_estado, String dom_costo_domicilio, String dom_fecha_inicio, String dom_fecha_salida, String dom_fecha_entrega, String dom_cli_id, String dom_men_id, String Cli_id) {
        this.Dom_id = Dom_id;
        this.dom_total_general = dom_total_general;
        this.dom_estado = dom_estado;
        this.dom_costo_domicilio = dom_costo_domicilio;
        this.dom_fecha_inicio = dom_fecha_inicio;
        this.dom_fecha_salida = dom_fecha_salida;
        this.dom_fecha_entrega = dom_fecha_entrega;
        this.dom_cli_id = dom_cli_id;
        this.dom_men_id = dom_men_id;
        this.Cli_id = Cli_id;
    }

    public Mod_GetSetDomicilio(int Dom_id, String dom_total_general, String dom_estado, String dom_costo_domicilio, String dom_fecha_inicio, String dom_fecha_salida, String dom_fecha_entrega, String dom_cli_id, String dom_men_id) {
        this.Dom_id = Dom_id;
        this.dom_total_general = dom_total_general;
        this.dom_estado = dom_estado;
        this.dom_costo_domicilio = dom_costo_domicilio;
        this.dom_fecha_inicio = dom_fecha_inicio;
        this.dom_fecha_salida = dom_fecha_salida;
        this.dom_fecha_entrega = dom_fecha_entrega;
        this.dom_cli_id = dom_cli_id;
        this.dom_men_id = dom_men_id;
    }

    public Mod_GetSetDomicilio(String Dom_cli_id) {
        this.dom_cli_id = Dom_cli_id;
    }

    public Mod_GetSetDomicilio() {
    }

    public int getDom_id() {
        return Dom_id;
    }

    public void setDom_id(int Dom_id) {
        this.Dom_id = Dom_id;
    }

    public String getDom_total_general() {
        return dom_total_general;
    }

    public void setDom_total_general(String dom_total_general) {
        this.dom_total_general = dom_total_general;
    }

    public String getDom_estado() {
        return dom_estado;
    }

    public void setDom_estado(String dom_estado) {
        this.dom_estado = dom_estado;
    }

    public String getDom_costo_domicilio() {
        return dom_costo_domicilio;
    }

    public void setDom_costo_domicilio(String dom_costo_domicilio) {
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

    public String getDom_cli_id() {
        return dom_cli_id;
    }

    public void setDom_cli_id(String dom_cli_id) {
        this.dom_cli_id = dom_cli_id;
    }

    public String getDom_men_id() {
        return dom_men_id;
    }

    public void setDom_men_id(String dom_men_id) {
        this.dom_men_id = dom_men_id;
    }

    public String getCli_id() {
        return Cli_id;
    }

    public void setCli_id(String Cli_id) {
        this.Cli_id = Cli_id;
    }
    
    
                    
}
