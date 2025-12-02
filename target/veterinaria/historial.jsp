<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Historial Médico</title>
    <link rel="stylesheet" href="nicepage.css">
    
    <style>
        /* Estilo rápido para la tabla */
        table { width: 80%; margin: 20px auto; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #4CAF50; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
    </style>
</head>
<body>

    <h1 style="text-align: center;">Resultados de la Búsqueda</h1>
    
    <div style="text-align: center; margin-bottom: 20px;">
        <a href="index.html">Volver al Inicio</a>
    </div>

    <table>
        <thead>
            <tr>
                <th>Fecha</th>
                <th>Paciente</th>
                <th>Motivo de Consulta</th>
                <th>Teléfono Contacto</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listaDeConsultas}" var="c">
                <tr>
                    <td>${c.fecha}</td>
                    <td>${c.nombreMascota}</td>
                    <td>${c.motivo}</td>
                    <td>${c.telefono}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <c:if test="${empty listaDeConsultas}">
        <p style="text-align: center; color: red;">No se encontraron consultas para este ID.</p>
    </c:if>

</body>
</html>