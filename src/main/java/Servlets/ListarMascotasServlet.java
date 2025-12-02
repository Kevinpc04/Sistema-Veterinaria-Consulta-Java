package Servlets;

import modelo.MascotaDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verHistorial") 
public class ListarMascotasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        List<MascotaDTO> lista = new ArrayList<>();
        MascotaDTO m1 = new MascotaDTO();
        m1.setNombre("Firulais"); m1.setRaza("Labrador"); m1.setFechaIngreso("2023-10-25"); m1.setEstado("En tratamiento");
        lista.add(m1);

        request.setAttribute("misMascotas", lista); 

        request.getRequestDispatcher("historial.jsp").forward(request, response);
    }
}