
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mod_LoginCliente {
    Conexion con=new Conexion();
    Connection cnn=con.Conexionpickup();
    PreparedStatement ps=null;
    ResultSet rs=null;
    public ArrayList<Mod_GetSetLoginCliente>consultaUnCliente(int Cli_usu_id){
        ArrayList<Mod_GetSetLoginCliente> Uncliente=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("Select *from tb_cliente where cli_usu_id='"+Cli_usu_id+"'");
            rs=ps.executeQuery();
            while (rs.next()) {                
                Mod_GetSetLoginCliente Consultarcliente=new Mod_GetSetLoginCliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
                Uncliente.add(Consultarcliente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Uncliente;
    }
    public ArrayList<Mod_GetSetDomicilio>ConsultarDomicilios(String cli){
        ArrayList<Mod_GetSetDomicilio> domisilioscli= new ArrayList<>();
        try {
            ps=cnn.prepareStatement ("Select dom_id,dom_total_general,dom_estado,dom_costo_domicilio,dom_fecha_inicio,dom_fecha_salida,dom_fecha_entrega,dom_cli_id,men_nombre from tb_domicilio inner join tb_mensajero on (men_id=dom_men_id) where dom_cli_id='"+cli+"'");
            rs=ps.executeQuery();
            //JOptionPane.showMessageDialog(null, "Datos Consultados");
            while(rs.next()){
                Mod_GetSetDomicilio ConsulDomi=new Mod_GetSetDomicilio(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                domisilioscli.add(ConsulDomi);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return domisilioscli;
    }
    
    public ArrayList<Mod_GetSetActualizarCliente>ConsultarDatosCliente(String cli_id){
        ArrayList<Mod_GetSetActualizarCliente> ListaCliente=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("Select Cli_id,Cli_documento,Cli_nombre,Cli_genero,Cli_telefono,Cli_email,Cli_direccion_1,Cli_barrio_1,Cli_descipcion_1,Cli_direccion_2,Cli_barrio_2,Cli_descipcion_2,usu_nombre,(aes_decrypt(usu_password,'AES')),usu_foto from tb_cliente inner join tb_usuario on (Usu_id=cli_usu_id) where cli_id='"+cli_id+"'");
            rs=ps.executeQuery();
            while(rs.next()){
                Mod_GetSetActualizarCliente ConsultaCli=new Mod_GetSetActualizarCliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15));
                ListaCliente.add(ConsultaCli);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ListaCliente;
    }
    
    public boolean insertarcliente (Mod_GetSetLoginCliente gscli){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("INSERT INTO tb_Cliente (cli_documento,cli_nombre, cli_fecha_naci,cli_genero,cli_telefono,cli_email,cli_direccion_1, cli_barrio_1,cli_descipcion_1,cli_direccion_2,cli_barrio_2,cli_descipcion_2,cli_usu_id) VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, gscli.getCli_documento());
            ps.setString(2, gscli.getCli_nombre());
            ps.setString(3, gscli.getCli_fecha_naci());
            ps.setString(4, gscli.getCli_genero());
            ps.setString(5, gscli.getCli_telefono());
            ps.setString(6, gscli.getCli_email());
            ps.setString(7, gscli.getCli_direccion_1());
            ps.setString(8, gscli.getCli_barrio_1());
            ps.setString(9, gscli.getCli_descripcion_1());
            ps.setString(10, gscli.getCli_direccion_2());
            ps.setString(11, gscli.getCli_barrio_2());
            ps.setString(12, gscli.getCli_descripcion_2());
            ps.setString(13, gscli.getCli_usu_id());
            dat=ps.executeUpdate();
            JOptionPane.showMessageDialog(null, gscli.getCli_usu_id());
            if(dat>0){
                reg=true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return reg;
    }
    
    public boolean ActualizarCliente (Mod_GetSetActualizarCliente actcli){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("Update tb_cliente inner join tb_usuario on (usu_id=cli_usu_id) set usu_nombre='"+actcli.getUsu_nombre()+"',"
                    + "usu_password=aes_encrypt('"+actcli.getUsu_password()+"','AES'), cli_telefono='"+actcli.getCli_telefono()+"',"
                    + "cli_email='"+actcli.getCli_email()+"'"
                    + ",cli_direccion_1='"+actcli.getCli_direccion_1()+"', cli_barrio_1='"+actcli.getCli_barrio_1()+"'"
                    + ",cli_descipcion_1='"+actcli.getCli_descripcion_1()+"',cli_direccion_2='"+actcli.getCli_direccion_2()+"'"
                    + ",cli_barrio_2='"+actcli.getCli_barrio_2()+"',cli_descipcion_2='"+actcli.getCli_descripcion_2()+"'"
                    + " where cli_id='"+actcli.getCli_id()+"'");
            dat=ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos actualizados Modelo");
            if(dat>0){
                reg=true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return reg;
    }
    public boolean ActualizarFotoCliente (Mod_GetSetActualizarCliente actfot){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("call ActualizarFotoCliente('"+actfot.getUsu_foto()+"','"+actfot.getCli_id()+"')");
            dat=ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos actualizados Modelo");
            if(dat>0){
                reg=true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return reg;
    }
}
