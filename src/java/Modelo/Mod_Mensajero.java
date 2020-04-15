
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mod_Mensajero {
    
    Conexion con=new Conexion();
    Connection cnn=con.Conexionpickup();
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public ArrayList<Mod_GetSetMensajero>DatosMensajero(int usuario){
        ArrayList<Mod_GetSetMensajero>ListaMensajero=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("Call MensajeroId('"+usuario+"')");
            rs=ps.executeQuery();
            while(rs.next()){
                Mod_GetSetMensajero Datos=new Mod_GetSetMensajero(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                ListaMensajero.add(Datos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ListaMensajero;
    }
    
    public ArrayList<Mod_GetSetActualizarMensajero>DatosUsuarioMensajero(int men_id){
        ArrayList<Mod_GetSetActualizarMensajero>ListaMensajero=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("call usuariomensajero('"+men_id+"')");
            rs=ps.executeQuery();
            while(rs.next()){
                Mod_GetSetActualizarMensajero Mensajero=new Mod_GetSetActualizarMensajero(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                ListaMensajero.add(Mensajero);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ListaMensajero;
    }
    public boolean ActualizarMensajero(Mod_GetSetActualizarMensajero actmen){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("Call ActualizarMensajero('"+actmen.getUsu_nombre()+"',aes_encrypt('"+actmen.getUsu_password()+"','AES'),"
                    + "'"+actmen.getMen_direccion_1()+"','"+actmen.getMen_barrio_1()+"','"+actmen.getMen_descripcion_1()+"',"
                    + "'"+actmen.getMen_telefono()+"','"+actmen.getMen_email()+"','"+actmen.getMen_id()+"')");
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
    public boolean ActualizarFotoMensajero(Mod_GetSetActualizarMensajero actfot){
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("call ActualizarFotoMensajero('"+actfot.getUsu_foto()+"','"+actfot.getMen_id()+"')");
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
