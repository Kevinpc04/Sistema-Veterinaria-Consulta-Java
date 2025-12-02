package Servlets;

import DB.DB;
import modelo.Consulta;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buscarHistorial")
public class BuscarHistorialServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idRecibido = request.getParameter("idBusqueda");
        
        List<Consulta> listaResultados = new ArrayList<>();

        try {
            Connection con = DB.getConexion();
            
            String sql = "SELECT fechaConsulta, NombreMascota, razonConsulta, telefono FROM consultamascota WHERE idMascota = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idRecibido));
            
            ResultSet rs = ps.executeQuery(); 
            
            while (rs.next()) {
                Consulta c = new Consulta();
                c.setFecha(rs.getString("fechaConsulta"));
                c.setNombreMascota(rs.getString("NombreMascota"));
                c.setMotivo(rs.getString("razonConsulta"));
                c.setTelefono(rs.getString("telefono"));
                
                listaResultados.add(c);
            }
            
            con.close();
            
            request.setAttribute("listaDeConsultas", listaResultados);
            request.getRequestDispatcher("historial.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error al buscar: " + e.getMessage());
        }
    }
}