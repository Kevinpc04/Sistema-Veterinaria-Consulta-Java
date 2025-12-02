<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%
    // Si no hay usuario en la sesión, lo pateamos fuera
    if (session.getAttribute("usuarioLogueado") == null) {
        response.sendRedirect("../login.html");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Panel Médico</title>
    <link rel="stylesheet" href="../css/nicepage.css"> 
</head>
<body style="padding: 20px;">

    <h1>Bienvenido, <%= session.getAttribute("usuarioLogueado") %></h1>
    <hr>
    
    <h2>Gestión de Citas</h2>
    
    <ul>
        <li><a href="../listarCitasAdmin">📅 Ver Citas Pendientes</a></li>
        <li><a href="${pageContext.request.contextPath}/listarPacientes">🐶 Listado de Pacientes</a></li>
    </ul>

    <br><br>
    <form action="../logout" method="POST"> <button type="submit" style="background: red; color: white;">Cerrar Sesión</button>
    </form>

</body>
</html>