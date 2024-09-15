<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 24/07/2024
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.User" %>
<%@ page import="models.Driver" %>
<%@ page import="models.Admin" %>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/styleRegisterComplete.css" rel="stylesheet">
    <title>Registro</title>
</head>

<body>

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


<section class="container">
    <h3>Regístrate en FernanPaaq</h3>
    <hr>
    <br>

    <form action="registerDispatch.jsp" method="post" id="registroForm">

        <div class="column">
            <div class="input-box">
                <%
                    if (session.getAttribute("nameNull") != null) {
                        session.removeAttribute("nameNull");
                %>
                <p class="text-red">Debes introducir un nombre</p>
                <%
                    }
                %>
                <label>Nombre</label>
                <input type="text" name="name" id="name" placeholder="Introduce tu nombre" pattern="^[^<>]*$">
            </div>

            <div class="input-box">
                <%
                    if (session.getAttribute("surnameNull") != null) {
                        session.removeAttribute("surnameNull");
                %>
                <p class="text-red">Debes introducir un apellido</p>
                <%
                    }
                %>
                <label>Apellidos</label>
                <input type="text" name="surname" id="surname" placeholder="Introduce tus apellidos" pattern="^[^<>]*$">
            </div>

        </div>

        <div class="input-box">
            <%
                if (session.getAttribute("emailNull") != null) {
                    session.removeAttribute("emailNull");
            %>
            <p class="text-red">Debes introducir un email</p>
            <%
                }
            %>

            <label>Email</label>
            <%
                String registerEmail = (String) session.getAttribute("emailNoRegister");
                String emailFound = (String) session.getAttribute("emailRegister");
                if (registerEmail == null && emailFound == null) {
            %>
            <input type="email" name="email" id="email" placeholder="Ingresa tu email" required pattern="^[^<>]*$">
            <%
                }
                if (registerEmail != null) {
            %>
            <input type="email" name="email" id="email" placeholder="Ingresa tu email" value="<%= registerEmail %>" required pattern="^[^<>]*$">
            <%
                } if (emailFound != null) {

            %>
            <input type="email" name="email" id="email" placeholder="Ingresa tu email" value="<%= emailFound %>" required pattern="^[^<>]*$">
            <%}%>
        </div>

        <div class="input-box">
            <%
                if (session.getAttribute("errorNumber") != null) {
                    session.removeAttribute("errorNumber");
            %>
            <p class="text-red">Debes introducir un número</p>
            <%
                }
            %>
            <%
                if (session.getAttribute("noValido") != null) {
                    session.removeAttribute("noValido");
            %>
            <p class="text-red">Debes introducir un número de teléfono válido</p>
            <%
                }
            %>
            <label>Número de telefono</label>

            <input type="number" name="phone" id="phone" placeholder="Ingresa tu número de telefono" pattern="^[^<>]*$">
        </div>

        <div class="input-box">
            <%
                if (session.getAttribute("addressNull") != null) {
                    session.removeAttribute("addressNull");
            %>
            <p class="text-red">Debes introducir una dirección</p>
            <%
                }
            %>
            <label>Dirección</label>

            <input type="text" name="address" id="address" placeholder="Ingresa tu dirección de domicilio" pattern="^[^<>]*$">
        </div>


        <div class="column">
            <div class="input-box">
                <%
                    if (session.getAttribute("errorNumber") != null) {
                        session.removeAttribute("errorNumber");
                %>
                <p class="text-red">Debes introducir un número</p>
                <%
                    }
                %>
                <%
                    if (session.getAttribute("noValido") != null) {
                        session.removeAttribute("noValido");
                %>
                <p class="text-red">Debes introducir un número de portal válido</p>
                <%
                    }
                %>
                <label>Número de portal</label>

                <input type="number" name="number" id="number" placeholder="Ingresa tu número de portal" pattern="^[^<>]*$">
            </div>

            <div class="input-box">
                <%
                    if (session.getAttribute("errorNumber") != null) {
                        session.removeAttribute("errorNumber");
                %>
                <p class="text-red">Debes introducir un número</p>
                <%
                    }
                %>
                <%
                    if (session.getAttribute("noValido") != null) {
                        session.removeAttribute("noValido");
                %>
                <p class="text-red">Debes introducir un código postal válido</p>
                <%
                    }
                %>
                <label>Código postal</label>

                <input type="number" name="postal" id="postal" placeholder="Ingresa tu código postal" pattern="^[^<>]*$">
            </div>
        </div>

        <div class="column">
            <div class="input-box">
                <%
                    if (session.getAttribute("provinceNull") != null) {
                        session.removeAttribute("provinceNull");
                %>
                <p class="text-red">Debes introducir una provincia</p>
                <%
                    }
                %>
                <label>Provincia</label>

                <input type="text" name="province" id="province" placeholder="Ingresa tu provincia" pattern="^[^<>]*$">
            </div>
            <div class="input-box">
                <%
                    if (session.getAttribute("cityNull") != null) {
                        session.removeAttribute("cityNull");
                %>
                <p class="text-red">Debes introducir una ciudad</p>
                <%
                    }
                %>
                <label>Ciudad</label>

                <input type="text" name="city" id="city" placeholder="Ingresa tu ciudad" pattern="^[^<>]*$">
            </div>
        </div>
        <div class="input-box">
            <%
                if (session.getAttribute("passNotEqual") != null) {
                    session.removeAttribute("passNotEqual");
            %>
            <p class="text-red">Las contraseñas deben ser iguales</p>
            <%
                }
            %>
            <%
                if (session.getAttribute("passNull") != null) {
                    session.removeAttribute("passNull");
            %>
            <p class="text-red">Debes introducir una contraseña</p>
            <%
                }
            %>
            <label>Contraseña</label>

            <input type="password" name="password" id="password" placeholder="Ingresa tu contraseña" required pattern="^[^<>]*$">
        </div>
        <div class="input-box">
            <%
                if (session.getAttribute("pass2Null") != null) {
                    session.removeAttribute("pass2Null");
            %>
            <p class="text-red">Debes introducir una contraseña</p>
            <%
                }
            %>
            <label>Introduce nuevamente tu contraseña</label>

            <input type="password" name="password2" id="password2" placeholder="Ingresa nuevamente tu contraseña" required pattern="^[^<>]*$">
        </div>
        <div class="column">
            <div class="notification-box">
                <h3>¿Desea recibir notificaciones?</h3>
                <label for="check-yes">
                    <input type="radio" id="check-yes" name="notification" value="yes" checked>
                    Si</label>
                <label for="check-no">
                    <input type="radio" id="check-no" name="notification" value="no">
                    No</label>
            </div>
        </div>
        <div class="button-form">
            <button>Enviar</button>
        </div>
        <div class="login_signup">¿Tienes una cuenta? <a href="login.jsp" id="login">Iniciar sesión</a></div>
    </form>
</section>

<script src="jscript/comprobacionFormulario.js"></script>

<footer class="footer">
    <div class="container-footer">
        <p>&copy; 2024 FernanPaaq. Todos los derechos reservados.</p>
    </div>
</footer>

</body>
</html>
