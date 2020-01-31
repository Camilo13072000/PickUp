
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mod_LoginUsuario {
    
    Conexion con=new Conexion();
    Connection cnn=con.Conexionpickup();
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public boolean insertarusuario (Mod_GetSetUsuarios gsusu){
    
        boolean reg=false;
        int dat;
        try {
            ps=cnn.prepareStatement("INSERT INTO tb_Usuario (usu_nombre,usu_password,usu_rol,usu_estado,usu_foto) VALUES (?,?,?,?,?)");
            ps.setString(1, gsusu.getUsu_nombre());
            ps.setString(2, gsusu.getUsu_password());
            ps.setString(3, gsusu.getUsu_rol());
            ps.setString(4, gsusu.getUsu_estado());
            ps.setString(5, gsusu.getUsu_foto());
            dat=ps.executeUpdate();
            if(dat>0){
                reg=true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return reg;
    }
    public ArrayList<Mod_GetSetUsuarios> consultarUnUsuario (String nom_usuario){
    ArrayList<Mod_GetSetUsuarios> lista = new ArrayList<>();
    try {
        ps = cnn.prepareStatement("select usu_id from tb_usuario where usu_nombre = '"+nom_usuario+"'");
        rs = ps.executeQuery();
        while(rs.next())
        {
            Mod_GetSetUsuarios consuta_un_usuario = new Mod_GetSetUsuarios(rs.getInt(1));
            lista.add(consuta_un_usuario);
        }
    } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null, "error al consultar un mensajero "+ e);
    }
    
    return lista;
    }
}
