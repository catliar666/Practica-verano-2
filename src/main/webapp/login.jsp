<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 09/07/2024
  Time: 18:17
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
    <link href="css/styleLogin.css" rel="stylesheet">
    <link href="css/styleFails.css" rel="stylesheet">
    <title>Login FernanPaaq</title>
    <!-- BOXICONS -->
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
</head>
<body class="no-grid-layout">

<%
        Object userLog = session.getAttribute("usuarioLogueado");
        if (userLog != null){
            if (userLog instanceof User) {
                response.sendRedirect("indexUsuario.jsp");
                return;
            } else if (userLog instanceof Driver) {
                response.sendRedirect("indexConductor.jsp");
                return;
            } else if (userLog instanceof Admin) {
                response.sendRedirect("indexAdmin.jsp");
                return;
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

<!--Login-->
    <div class="form-container">
        <div class="col col-1">
            <div class="image-layer">
                <img src="img/dibujoPaqueteria.png" class="form-image-main" alt="image 1">
            </div>
            <p class="featured-word">Solo te tomará unos minutos iniciar sesión en <span>FernanPaaq</span></p>
        </div>
        <div class="col col-2">
            <div class="btn-box">
                <a href="login.jsp"><button class="btn btn-1" id="login">Inicia Sesión</button></a>
                <a href="findEmail.jsp"><button class="btn btn-2" id="register">Registrate</button></a>
            </div>
            <!--CONTENEDOR DEL FORMULARIO INICIO SESIÓN-->
            <form action="loginDispatch.jsp" method="post">
            <div class="login-form">
                <div class="form-title">
                    <span>Inicia sesión</span>
                </div>
                <%
                    if (session.getAttribute("datosIncorrectos") != null) {
                        session.removeAttribute("datosIncorrectos");
                %>
                <p class="text-red">Los datos introducidos son incorrectos</p>
                <%}%>
                <div class="form-inputs">
                    <div class="input-box">
                        <%
                            if (session.getAttribute("emailNull") != null) {
                                session.removeAttribute("emailNull");
                        %>
                        <p class="text-red">Debes introducir un email</p>
                        <%}%>
                    <input type="text" name="emailText" class="input-field" placeholder="Introduce tu email" required>
                    <i class="bx bx-envelope icon"></i>
                    </div>
                    <div class="input-box">
                        <%
                            if (session.getAttribute("passNull") != null) {
                                session.removeAttribute("passNull");
                        %>
                        <p class="text-red">Debes introducir tu contraseña</p>
                        <%}%>
                        <input type="password" name="passText" class="input-field" placeholder="Introduce tu contraseña" required>
                        <i class="bx bx-lock-alt icon"></i>
                    </div>
                    <div class="forgot-pass">
                        <a href="cambiarContraseña.jsp">¿Has olvidado tu contraseña?</a>
                    </div>
                    <div class="input-box">
                        <button class="input-submit">
                            <span>Iniciar Sesión</span>
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

    <script src="jscript/app.js"></script>

<!--Comienzo del footer-->

<footer class="footer login-footer">
    <div class="container-footer">
        <p>&copy; 2024 FernanPaaq. Todos los derechos reservados.</p>
    </div>
</footer>

<!--Fin del footer-->
</body>
</html>
