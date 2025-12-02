package Servlets;

import DB.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/actualizarCita")
public class ActualizarCitaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Recibir datos del formulario (incluyendo el ID oculto)
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("name");
        String fecha = request.getParameter("date");
        String motivo = request.getParameter("motivo");
        String tel = request.getParameter("telefono");
        String nuevoDiagnostico = request.getParameter("diagnostico");
        String nuevoTratamiento = request.getParameter("tratamiento");
        
        try {
            Connection con = DB.getConexion();
            // 2. UPDATE SQL
            String sql = "UPDATE consultamascota SET NombreMascota=?, fechaConsulta=?, razonConsulta=?, telefono=?, diagnostico=?, tratamiento=? WHERE idConsulta=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, fecha);
            ps.setString(3, motivo);
            ps.setString(4, tel);
            ps.setString(5, nuevoDiagnostico);
            ps.setString(6, nuevoTratamiento);
            ps.setInt(7, id);
            
            ps.executeUpdate();
            con.close();
            
            response.sendRedirect("listarCitasAdmin");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error actualizando: " + e.getMessage());
        }
    }
}