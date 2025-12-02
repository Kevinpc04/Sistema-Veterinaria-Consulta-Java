package Servlets;

import DB.DB;
import modelo.Mascota;
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
import javax.servlet.http.HttpSession;

@WebServlet("/listarPacientes")
public class ListarPacientesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Seguridad
        HttpSession session = request.getSession();
        if (session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect("login.html");
            return;
        }

        List<Mascota> listaPacientes = new ArrayList<>();

        try {
            Connection con = DB.getConexion();
            // 2. TRUCO SQL: Agrupamos por nombre para no repetir pacientes
            String sql = "SELECT NombreMascota, razaMascota, telefono FROM consultamascota GROUP BY NombreMascota";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Mascota m = new Mascota();
                m.setNombre(rs.getString("NombreMascota"));
                m.setRaza(rs.getString("razaMascota"));
                m.setTelefonoDueno(rs.getString("telefono"));
                listaPacientes.add(m);
            }
            con.close();

            // 3. Enviar al JSP
            request.setAttribute("misPacientes", listaPacientes);
            request.getRequestDispatcher("admin/pacientes.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
