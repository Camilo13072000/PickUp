
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mod_Login {
    Conexion con=new Conexion();
    Connection cnn=con.Conexionpickup();
    PreparedStatement ps=null;
    ResultSet rs=null;
    public ArrayList<Mod_GetSetUsuarios>Login(Mod_GetSetUsuarios gs){
        ArrayList<Mod_GetSetUsuarios> list=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("Select *from tb_usuario where usu_nombre='"+gs.getUsu_nombre()+"' and"
                    + " usu_password='"+gs.getUsu_password()+"'");
            rs=ps.executeQuery();
            while(rs.next()){
                Mod_GetSetUsuarios ges=new Mod_GetSetUsuarios(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(ges);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
}
