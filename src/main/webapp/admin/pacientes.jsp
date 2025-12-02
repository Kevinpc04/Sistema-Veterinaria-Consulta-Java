<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    if (session.getAttribute("usuarioLogueado") == null) {
        response.sendRedirect(request.getContextPath() + "/login.html");
        return;
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <title>Pacientes</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/nicepage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Consulta.css">
    
    <style>
        .u-section-1 {
            background-image: url("${pageContext.request.contextPath}/images/ChatGPTImage25nov202509_03_46.png") !important;
            background-size: auto;
            min-height: 100vh;
            padding-top: 50px;
        }
        .tabla-card {
            background-color: white; width: 90%; max-width: 1000px; margin: 0 auto;
            border-radius: 20px; padding: 30px; box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        }
        .admin-table { width: 100%; border-collapse: collapse; margin-top: 15px; }
        .admin-table th { background-color: #673ab7; color: white; padding: 12px; text-align: left; } /* Morado para diferenciar */
        .admin-table td { border-bottom: 1px solid #ddd; padding: 10px; }
    </style>
</head>
<body class="u-body u-xl-mode">
    
    <header class="u-clearfix u-header u-header">
        <div class="u-clearfix u-sheet u-sheet-1">
             <a href="${pageContext.request.contextPath}/index.html" class="u-image u-logo u-image-1">
                <img src="${pageContext.request.contextPath}/images/1.jpg" class="u-logo-image u-logo-image-1">
            </a>
        </div>
    </header>

    <section class="u-section-1">
        <div class="tabla-card">
            <h2>🐶 Listado de Pacientes Únicos</h2>
            <p>Clientes registrados en el historial.</p>
            
            <table class="admin-table">
                <thead>
                    <tr>
                        <th>Nombre Paciente</th>
                        <th>Raza</th>
                        <th>Teléfono Dueño</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${misPacientes}" var="p">
                        <tr>
                            <td><strong>${p.nombre}</strong></td>
                            <td>${p.raza}</td>
                            <td>${p.telefonoDueno}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            
            <br>
            <div style="text-align: center;">
                <a href="${pageContext.request.contextPath}/admin/dashboard.jsp" 
                   style="background: #333; color: white; padding: 10px 20px; border-radius: 50px; text-decoration: none;">
                   ⬅ Volver al Panel
                </a>
            </div>
        </div>
    </section>
</body>
</html>S