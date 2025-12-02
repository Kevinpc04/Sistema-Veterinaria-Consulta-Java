package Servlets;

import DB.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guardarConsulta")
public class GuardarConsultaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idMascotaStr = request.getParameter("idMascota");
        String idDuenoStr = request.getParameter("idDueno");        
        String nombreMascota = request.getParameter("name");
        String edad = request.getParameter("edad"); 
        String genero = request.getParameter("genero"); 
        String telefono = request.getParameter("telefono");
        String motivo = request.getParameter("consulta");
        String fecha = request.getParameter("date");
        String raza = request.getParameter("raza");

        int edadInt = 0;
        try {
            if (edad != null && !edad.isEmpty()) {
                edadInt = Integer.parseInt(edad);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: La edad ingresada no es un número válido. Se usará 0.");
            edadInt = 0; 
        }

        int idMascota = 0;
        try {
            idMascota = Integer.parseInt(idMascotaStr);
        } catch (NumberFormatException e) {
            idMascota = 0;
        }
         
        int idDueno = 1; 

        try {
            if (idDuenoStr != null && !idDuenoStr.isEmpty()) {
            
                idDueno = Integer.parseInt(idDuenoStr);
            } else {
            
                idDueno = 1; 
            }
        } catch (NumberFormatException e) {
        
        idDueno = 1; 
        }   

        try {
            Connection con = DB.getConexion();

            String sqlCheck = "SELECT NombreMascota FROM consultamascota WHERE idMascota = ? LIMIT 1";
            PreparedStatement psCheck = con.prepareStatement(sqlCheck);
            psCheck.setInt(1, idMascota);
            ResultSet rsCheck = psCheck.executeQuery();

            if (rsCheck.next()) {

                String nombreExistente = rsCheck.getString("NombreMascota");
                
                if (!nombreExistente.equalsIgnoreCase(nombreMascota)) {
                    
                    con.close();
                    
                    // Mostramos alerta y devolvemos al usuario
                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().println("<script type=\"text/javascript\">");
                    response.getWriter().println("alert('ERROR: El ID " + idMascota + " ya pertenece a la mascota " + nombreExistente + ". Por favor verifique.');");
                    response.getWriter().println("history.back();");
                    response.getWriter().println("</script>");
                    return; 
                }
            }

            String sql = "INSERT INTO consultamascota "
                + "(idMascota, idDueño, NombreMascota, razaMascota, edadMascota, generoMascota, fechaConsulta, razonConsulta, telefono, diagnostico, tratamiento) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idMascota);        
            ps.setInt(2, idDueno);         
            ps.setString(3, nombreMascota);    
            ps.setString(4, raza);              
            ps.setString(5, String.valueOf(edadInt));         
            ps.setString(6, genero);       
            ps.setString(7, fecha);             
            ps.setString(8, motivo);            
            ps.setString(9, telefono);         
            ps.setString(10, "Pendiente de revisión");
            ps.setString(11, "Sin asignar"); 
            
            int filasAfectadas = ps.executeUpdate();
            
            con.close(); 
            
            if(filasAfectadas > 0){
                System.out.println("¡GUARDADO EXITOSO EN MYSQL!");
                response.sendRedirect("index.html");
            } else {
                response.getWriter().println("Error: No se guardó en la base de datos.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("ERROR SQL: " + e.getMessage());
        }
    }
}