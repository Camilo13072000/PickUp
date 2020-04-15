
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Mod_Categorias {
    Conexion con=new Conexion();
    Connection cnn=con.Conexionpickup();
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public ArrayList<Mod_GetSetCategorias>ConsultarCategorias(){
        ArrayList<Mod_GetSetCategorias> catecli=new ArrayList<>();
        try {
            ps=cnn.prepareStatement("Select cate_codigo,cate_nombre,cate_foto from tb_categoria");
            rs=ps.executeQuery();
            while (rs.next()) {
                Mod_GetSetCategorias ConsulCate=new Mod_GetSetCategorias(rs.getString(1), rs.getString(2), rs.getString(3));
                catecli.add(ConsulCate);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return catecli;
    }
}
