
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Mod_Domicilio {
    Conexion con=new Conexion();
    Connection cnn=con.Conexionpickup();
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public boolean GenerarDomicilio(Mod_GetSetDomicilio DGs){
        boolean reg=false;
        int dat, dom_id;
        try {
            ps=cnn.prepareStatement("call InsertarDomicilio(?,?,?,?,?)");
            ps.setInt(1, DGs.getDom_total_general());
            ps.setString(2, DGs.getDom_estado());
            ps.setInt(3, DGs.getDom_costo_domicilio());
            ps.setString(4, DGs.getDom_cli_id());
            ps.setString(5, DGs.getDom_fecha_inicio());
            dat=ps.executeUpdate();
            
            if(dat>0){
                reg=true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+" Modelo Domicilio");
        }
        return reg;
    }
    public ArrayList<Mod_GetSetDomicilio>DomId(){
        ArrayList<Mod_GetSetDomicilio>DatoId=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("Select @@identity dom_id");
            rs=ps.executeQuery();
            while (rs.next()) {
                Mod_GetSetDomicilio domi=new Mod_GetSetDomicilio(rs.getInt(1));
                DatoId.add(domi);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+" Modelo Domicilio identity");
        }
        return DatoId;
    }
    
    public ArrayList<Mod_GetSetDomicilioMensajero>DomiciliosActivos(int men_id,String Estado){
        ArrayList<Mod_GetSetDomicilioMensajero>ListaDomicilio=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("Call DomicilioMensajero('"+men_id+"','"+Estado+"')");
            rs=ps.executeQuery();
            while(rs.next()){
                Mod_GetSetDomicilioMensajero Domicilio=new Mod_GetSetDomicilioMensajero(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                ListaDomicilio.add(Domicilio);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ListaDomicilio;
    }
    
    public boolean ActualizarEstado(Mod_GetSetDomicilio gsdom){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("Call EstadoDomicilio('"+gsdom.getDom_id()+"','"+gsdom.getDom_estado()+"')");
            dat=ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Estado Actualizado");
            if(dat>0){
                reg = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"Actualizar");
        }
        
        if(gsdom.getDom_estado().equals("Enviando")){
            
            try {
                ps=cnn.prepareStatement("Call DomicilioFechaSalida('"+gsdom.getDom_id()+"','"+gsdom.getDom_fecha_salida()+"')");
                dat=ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Exito");
                if(dat>0){
                    reg = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if(gsdom.getDom_estado().equals("Entregado")){
            
            try {
                ps=cnn.prepareStatement("Call DomicilioFechaEntrega('"+gsdom.getDom_id()+"','"+gsdom.getDom_fecha_salida()+"')");
                dat=ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Exito");
                if(dat>0){
                    reg = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
        return reg;
    }
}
