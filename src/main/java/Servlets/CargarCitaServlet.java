package Servlets;

import DB.DB;
import modelo.Consulta;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cargarCita")
public class CargarCitaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id");
        
        try {
            Connection con = DB.getConexion();
            // Traemos TODOS los datos de esa cita específica
            String sql = "SELECT * FROM consultamascota WHERE idConsulta = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idStr));
            ResultSet rs = ps.executeQuery();
            
            Consulta c = new Consulta();
            if (rs.next()) {
                c.setIdConsulta(rs.getInt("idConsulta"));
                c.setFecha(rs.getString("fechaConsulta"));
                c.setNombreMascota(rs.getString("NombreMascota"));
                c.setMotivo(rs.getString("razonConsulta"));
                c.setTelefono(rs.getString("telefono"));
                c.setDiagnostico(rs.getString("diagnostico"));
                c.setTratamiento(rs.getString("tratamiento"));
            }
            con.close();
            
            // Enviamos el objeto 'c' al formulario de edición
            request.setAttribute("citaEditar", c);
            request.getRequestDispatcher("admin/editar_cita.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}