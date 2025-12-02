<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    // Seguridad
    if (session.getAttribute("usuarioLogueado") == null) {
        response.sendRedirect(request.getContextPath() + "/login.html");
        return;
    }
%>

<!DOCTYPE html>
<html style="font-size: 16px;" lang="es">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <title>Panel Veterinario</title>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/nicepage.css" media="screen">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Consulta.css" media="screen">
    
    <style>
        /* 1. ARREGLO DEL FONDO VERDE: Forzamos que cubra toda la pantalla */
        .u-section-1 {
            background-image: url("${pageContext.request.contextPath}/images/ChatGPTImage25nov202509_03_46.png") !important;
            background-repeat: repeat; /* Para que el patrón se repita */
            background-size: auto;     /* Tamaño natural de las huellitas */
            min-height: 100vh;         /* Altura mínima del 100% de la ventana */
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            padding-top: 50px;
        }

        /* 2. CONTENEDOR DE LA TABLA: Diseño tarjeta flotante */
        .tabla-card {
            background-color: white;
            width: 90%;
            max-width: 1200px;
            margin: 0 auto; /* Centrado horizontal */
            border-radius: 20px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
            padding: 30px;
            position: relative;
            z-index: 2; /* Asegura que esté encima del fondo */
        }

        /* Títulos */
        .titulo-panel { font-family: 'Open Sans', sans-serif; color: #333; font-weight: 700; margin-bottom: 5px; }
        .subtitulo-panel { color: #666; font-size: 0.9rem; margin-bottom: 20px; display: block; }

        /* Estilos de Tabla */
        .admin-table { width: 100%; border-collapse: collapse; margin-top: 15px; font-family: sans-serif; }
        .admin-table thead tr { background-color: #2cccc4; color: white; text-align: left; }
        .admin-table th, .admin-table td { padding: 15px; border-bottom: 1px solid #eee; }
        .admin-table tr:hover { background-color: #f9f9f9; }

        /* Botones */
        .btn-accion { padding: 8px 12px; border-radius: 5px; text-decoration: none; font-weight: bold; margin-right: 5px; display: inline-block; }
        .btn-editar { background: #ffca28; color: #333; }
        .btn-borrar { background: #ef5350; color: white; }
        
        .btn-volver {
            display: inline-block; margin-top: 20px; padding: 10px 30px;
            background: #333; color: white; text-decoration: none; border-radius: 50px;
        }
    </style>
</head>

<body class="u-body u-xl-mode">
    
    <header class="u-clearfix u-header u-header" id="header" style="background: white;">
        <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
            <a href="${pageContext.request.contextPath}/index.html" class="u-image u-logo u-image-1">
                <img src="${pageContext.request.contextPath}/images/1.jpg" class="u-logo-image u-logo-image-1">
            </a>
            <nav class="u-menu u-menu-one-level u-offcanvas u-menu-1">
                <div class="u-custom-menu u-nav-container">
                    <ul class="u-nav u-spacing-2 u-unstyled u-nav-1">
                        <li class="u-nav-item">
                            <form action="${pageContext.request.contextPath}/logout" method="POST">
                                <button type="submit" style="background:none; border:none; cursor:pointer; color:red; font-weight:bold; font-size:1rem;">CERRAR SESIÓN</button>
                            </form>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </header>

    <section class="u-section-1">
        
        <div class="tabla-card">
            
            <div style="border-bottom: 2px solid #2cccc4; padding-bottom: 10px; margin-bottom: 20px; display:flex; justify-content:space-between; align-items:center;">
                <div>
                    <h2 class="titulo-panel">🐾 Citas Programadas</h2>
                    <span class="subtitulo-panel">Bienvenido, Dr. <%= session.getAttribute("usuarioLogueado") %></span>
                </div>
                <small style="color:#999;">Registros: ${misCitas != null ? misCitas.size() : '0'}</small>
            </div>

            <div style="overflow-x:auto;"> <table class="admin-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Fecha</th>
                            <th>Paciente</th>
                            <th>Motivo</th>
                            <th>Teléfono</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${misCitas}" var="c">
                            <tr>
                                <td><b>#${c.idConsulta}</b></td>
                                <td>${c.fecha}</td>
                                <td style="text-transform: capitalize;">${c.nombreMascota}</td>
                                <td>${c.motivo}</td>
                                <td>${c.telefono}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/cargarCita?id=${c.idConsulta}" class="btn-accion btn-editar">✏️</a>
                                    <a href="${pageContext.request.contextPath}/eliminarConsulta?id=${c.idConsulta}" class="btn-accion btn-borrar" onclick="return confirm('¿Borrar cita?');">🗑️</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <c:if test="${empty misCitas}">
                <div style="text-align: center; padding: 40px; background: #f9f9f9; border-radius: 10px; margin-top: 10px;">
                    <h3 style="color: #666;">📭 No hay citas para mostrar</h3>
                    <p>Si acabas de registrar una, verifica entrando nuevamente desde el Panel Principal.</p>
                </div>
            </c:if>

            <div style="text-align: center;">
                <a href="${pageContext.request.contextPath}/admin/dashboard.jsp" class="btn-volver">⬅ Volver al Panel</a>
            </div>
        </div>

    </section>

    <footer class="u-align-center u-clearfix u-footer u-grey-80" id="footer">
        <div class="u-clearfix u-sheet u-sheet-1">
            <p class="u-small-text u-text u-text-variant u-text-1"> Salud, amor y bienestar en cada patita. </p>
        </div>
    </footer>

</body>
</html>