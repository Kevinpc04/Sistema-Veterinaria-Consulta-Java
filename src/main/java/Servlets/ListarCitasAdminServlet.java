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
import javax.servlet.http.HttpSession;

@WebServlet("/listarCitasAdmin")
public class ListarCitasAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        if (session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect("login.html");
            return;
        }

        List<Consulta> lista = new ArrayList<>();

        try {
            Connection con = DB.getConexion();
            
            String sql = "SELECT idConsulta, fechaConsulta, NombreMascota, razonConsulta, telefono FROM consultamascota";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Consulta c = new Consulta();
                c.setIdConsulta(rs.getInt("idConsulta"));
                c.setFecha(rs.getString("fechaConsulta"));
                c.setNombreMascota(rs.getString("NombreMascota"));
                c.setMotivo(rs.getString("razonConsulta"));
                c.setTelefono(rs.getString("telefono"));
                lista.add(c);
            }
            con.close();

            request.setAttribute("misCitas", lista);
            request.getRequestDispatcher("admin/ver_citas_pendientes.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}