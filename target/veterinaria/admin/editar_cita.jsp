<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Cita</title>
    <link rel="stylesheet" href="../css/nicepage.css">
</head>
<body style="padding: 20px;">

    <h1>Editar Cita #${citaEditar.idConsulta}</h1>

    <form action="${pageContext.request.contextPath}/actualizarCita" method="POST">
        
        <input type="hidden" name="id" value="${citaEditar.idConsulta}">

        <label>Nombre Mascota:</label><br>
        <input type="text" name="name" value="${citaEditar.nombreMascota}" required><br><br>

        <label>Fecha:</label><br>
        <input type="text" name="date" value="${citaEditar.fecha}" required><br><br>
        
        <label>Motivo:</label><br>
        <input type="text" name="motivo" value="${citaEditar.motivo}" required><br><br>

        <label>Teléfono:</label><br>
        <input type="text" name="telefono" value="${citaEditar.telefono}" required><br><br>

        <hr style="margin: 20px 0; border: 0; border-top: 2px solid #2cccc4;">
        <h3 style="color: #333;">Zona Médica (Exclusivo Veterinario)</h3>

        <div style="margin-bottom: 15px;">
            <label style="font-weight: bold;">Diagnóstico:</label><br>
            <textarea name="diagnostico" rows="3" style="width: 100%; padding: 10px;">${citaEditar.diagnostico}</textarea>
        </div>

        <div style="margin-bottom: 15px;">
            <label style="font-weight: bold;">Tratamiento / Receta:</label><br>
            <textarea name="tratamiento" rows="3" style="width: 100%; padding: 10px;">${citaEditar.tratamiento}</textarea>
        </div>

        <button type="submit" style="background: blue; color: white; padding: 10px;">GUARDAR CAMBIOS</button>
        <button type="submit" style="background: blue; color: white; padding: 10px;">CANCELAR</button>
    </form>

</body>
</html>