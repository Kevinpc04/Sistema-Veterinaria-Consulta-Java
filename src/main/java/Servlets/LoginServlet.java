package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String u = request.getParameter("usuario");
        String p = request.getParameter("clave");
        
        // VALIDACIÓN SIMPLE (Hardcoded)
        // En el futuro, esto debería consultar la tabla de 'usuarios' en la base de datos
        if ("admin".equals(u) && "1234".equals(p)) {
            
            // 1. Crear la sesión de seguridad
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", "Doctor Principal");
            session.setAttribute("rol", "admin"); // Guardamos el rol por si acaso
            
            // 2. Redirigir a la CARPETA PROTEGIDA
            // Fíjate en la ruta: entramos a la carpeta 'admin'
            response.sendRedirect("admin/dashboard.jsp");
            
        } else {
            // Si falla, lo devolvemos al login con un mensaje (podrías manejar el error mejor en el HTML)
            response.sendRedirect("login.html?error=true");
        }
    }
}