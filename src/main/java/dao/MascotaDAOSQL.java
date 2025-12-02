/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import DB.DB;
import modelo.MascotaDTO;


/**
 *
 * @author Usuario
 */
public class MascotaDAOSQL {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = null;
    DB conexion = null;
    
    public void agregarMascota(MascotaDTO mascota){
        try{
            con = DB.getConexion();
            String sql = "INSERT INTO mascotas (nombre, identificacion, raza, edad, tipo, peso, estado, fechaIngreso, lugarOrigen, genero, documentoPropietario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, mascota.getNombre());
            ps.setString(2, mascota.getIdentificacion());
            ps.setString(3, mascota.getRaza());
            ps.setInt(4, mascota.getEdad());
            ps.setString(5, mascota.getTipo());
            ps.setFloat(6, mascota.getPeso());
            ps.setString(7, mascota.getEstado());
            ps.setString(8, mascota.getFechaIngreso());
            ps.setString(9, mascota.getLugarOrigen());
            ps.setString(10, String.valueOf(mascota.getGenero()));
            ps.setString(11, mascota.getDocumentoPropietario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try { 
            if (rs != null) rs.close(); 
                } catch (Exception e) {}

            try { 
            if (ps != null) ps.close(); 
                } catch (Exception e) {}

            try { 
            if (con != null) con.close(); 
                } catch (Exception e) {}
            }

    }
}
