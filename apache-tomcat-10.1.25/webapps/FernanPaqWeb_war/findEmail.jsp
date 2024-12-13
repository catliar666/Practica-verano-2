<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 03/08/2024
  Time: 0:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.User" %>
<%@ page import="models.Driver" %>
<%@ page import="models.Admin" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/styleRegisterEmail.css" rel="stylesheet">
    <link href="css/styleHeader.css" rel="stylesheet">
    <link href="css/styleFooterWhite.css" rel="stylesheet">
    <link href="css/styleResponsiveAll.css" rel="stylesheet">
    <link href="css/styleFails.css" rel="stylesheet">
    <title>Register FernanPaaq</title>
    <!-- BOXICONS -->
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
</head>
<body class="no-grid-layout">

<%
    Object userLog = session.getAttribute("usuarioLogueado");
    if (userLog != null){
        if (userLog instanceof User) {
            response.sendRedirect("indexUsuario.jsp");
        } else if (userLog instanceof Driver) {
            response.sendRedirect("indexConductor.jsp");
        } else if (userLog instanceof Admin) {
            response.sendRedirect("indexAdmin.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
%>
<!-- Comienzo de la barra de navegación -->
<header class="header">
    <nav class="nav">
        <a href="index.jsp" class="nav_logo"><img src="img/Logo fernanpaaq.png" alt="logo" style="width: 75%;"></a> <!--<img src="img/FernanPaaq.png" value="Logotipo FernanPaaq">-->
        <ul class="nav_items">
            <li class="nav_item">
                <a href="index.jsp" class="nav_link">Inicio</a>
                <a href="#" class="nav_link">Sobre nosotros</a>
                <a href="#" class="nav_link">Contacto</a>
            </li>

        </ul>

    </nav>
</header>
<!--Fin de la barra de navegación-->

<!--REGISTER CONTAINER-->
<!--CONTENEDOR DEL FORMULARIO REGISTRO DE CUENTA-->

<div class="form-container">
    <div class="col col-1">
        <div class="image-layer">
            <img src="img/dibujoPaqueteria.png" class="form-image-main" alt="image 1">
        </div>
        <p class="featured-word">Solo te tomará unos minutos registrarte en <span>FernanPaaq</span></p>
    </div>
    <div class="col col-2">
        <div class="btn-box">
            <a href="login.jsp"><button class="btn btn-1" id="login">Inicia Sesión</button></a>
            <a href="findEmail.jsp"><button class="btn btn-2" id="register">Registrate</button></a>
        </div>
        <form action="findEmailDispatch.jsp" method="post">
            <div class="register-form">
                <div class="form-title">
                    <span>Registra tu cuenta</span>
                </div>
                <%
                   String emailUse = (String) session.getAttribute("emailUse");
                    if (emailUse != null) {
                        session.removeAttribute("emailUse");
                %>
                <p class="text-red text-sm">El email ya existe, inicie sesión o escoja otro email</p>
                <%
                    }
                %>
                <%
                    String emailNull = (String) session.getAttribute("emailNull");
                    if (emailNull != null) {
                        session.removeAttribute("emailNull");
                %>
                <p class="text-red text-sm">Debe introducir un email correcto</p>
                <%
                    }
                %>
                <div class="form-inputs">
                    <div class="input-box">
                        <input type="text" name="registerEmail" class="input-field" placeholder="Introduce tu email" required>
                        <i class="bx bx-envelope icon"></i>
                    </div>
                    <div class="forgot-pass">
                        <a href="login.jsp">¿Tienes una cuenta? Inicia sesión</a>
                    </div>
                    <div class="input-box">
                        <button class="input-submit">
                            <span>Registrarse</span>
                            <i class="bx bx-right-arrow-alt"></i>
                        </button>
                    </div>

                </div>
                <div class="social-login">
                    <i class=" bx bxl-google"></i>
                    <a href="https://www.facebook.com/burguerestacion/"><i class=" bx bxl-facebook"></i></a>
                    <a href="https://x.com/cat_liar666?t=Nne5xW51qeevcJGApVTvUw&s=08"><i class=" bx bxl-twitter"></i></a>
                    <a href="https://github.com/catliar666"><i class=" bx bxl-github"></i></a>
                </div>
            </div>
        </form>
    </div>
</div>


<!--Comienzo del footer-->

<footer class="footer">
    <div class="container-footer">
        <p>&copy; 2024 FernanPaaq. Todos los derechos reservados.</p>
    </div>
</footer>

<!--Fin del footer-->

</body>
</html>
