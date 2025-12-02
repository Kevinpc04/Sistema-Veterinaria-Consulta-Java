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

@WebServlet("/eliminarConsulta")
public class EliminarConsultaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id");
        
        try {
            int id = Integer.parseInt(idStr);
            Connection con = DB.getConexion();
            

            String sql = "DELETE FROM consultamascota WHERE idConsulta = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            // Ejecutamos y guardamos el resultado
            int filas = ps.executeUpdate();


            if (filas > 0) {
                System.out.println("Éxito: Se eliminó la consulta con ID " + id);
            } else {
                System.out.println("Alerta: No se encontró ninguna consulta con ese ID para borrar.");
        }

con.close();
            con.close();

            request.getSession().setAttribute("mensaje", "¡Cita eliminada con éxito!");
            response.sendRedirect("listarCitasAdmin");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error al eliminar: " + e.getMessage());
        }
    }
}