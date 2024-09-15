<%@ page import="appcontroller.AppController" %>
<%@ page import="models.User" %>
<%@ page import="models.Admin" %>
<%@ page import="models.Driver" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 03/08/2024
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/styleRegisterInfo.css" rel="stylesheet">
    <link href="css/styleHeader.css" rel="stylesheet">
    <link href="css/styleFooterWhite.css" rel="stylesheet">
    <link href="css/styleResponsiveAll.css" rel="stylesheet">
    <title>Información encontrada</title>
</head>
<body>

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


<%
    Object userLog = session.getAttribute("usuarioLogueado");
    if (userLog != null){
        if (userLog instanceof User) {
            response.sendRedirect("indexUsuario.jsp");
        } else if (userLog instanceof Driver) {
            response.sendRedirect("indexConductor.jsp");
        } else if (userLog instanceof Admin) {
            response.sendRedirect("indexAdmin.jsp");
        }
    }
%>
<main>
    <%
        if (session.getAttribute("confirm") == null) {
    %>
    <section class="container-question">
        <div class="question-box">
            <h3>¿Desea utilizar la información encontrada?</h3>
            <p class="info-extra">Se ha detectado información asociada a esta dirección de correo electrónico.
                Si desea proceder con la creación de una cuenta utilizando la información disponible, por favor responda "Sí".
                En caso contrario, será redirigido a un formulario donde deberá completar toda la información desde el principio.</p>
            <div class="option-container">
                <a href="registerByInfoShipmentDispatch.jsp">
                    Si</a>
                <a href="registerComplete.jsp">
                    No</a>
            </div>
        </div>
    </section>

    <%
        } else {
            String email = (String) session.getAttribute("emailRegister");
    %>
    <section class="container-register">
        <form method="post" action="registerByInfoShipmentDispatch.jsp">
            <h2>Introduce la información que falta</h2>
            <p class="info-extra">Utilizaremos la información encontrada pero deberá rellenar más campos de los que no disponemos informacón</p>
            <div class="info-container">
                <h3>Email:</h3>
                <%
                    if (session.getAttribute("emailNull") != null) {
                        session.removeAttribute("emailNull");
                %>
                <p class="text-red">Debes introducir un email</p>
                <%
                    }
                %>
                <input type="text" name="emailText" placeholder="Introduzca un email" value="<%=email%>" required>
            </div>
            <div class="info-container">
                <h3>Télefono:</h3>
                <%
                    if (session.getAttribute("phoneNull") != null) {
                        session.removeAttribute("phoneNull");
                %>
                <p class="text-red">Debes introducir un número de teléfono</p>
                <%
                    }
                %>
                <input type="number" name="phoneText" placeholder="Introduzca un teléfono" required>
            </div>
            <div class="info-container">
                <h3>Provincia:</h3>
                <%
                    if (session.getAttribute("stateNull") != null) {
                        session.removeAttribute("stateNull");
                %>
                <p class="text-red">Debes introducir una provincia</p>
                <%
                    }
                %>
                <input type="text" name="stateText" placeholder="Introduzca una provincia" required>
            </div>
            <div class="info-container">
                <h3>Contraseña:</h3>
                <%
                    if (session.getAttribute("passNull") != null) {
                        session.removeAttribute("passNull");
                %>
                <p class="text-red">Debes introducir una contraseña</p>
                <%
                    }
                %>
                <input type="password" name="pass1" placeholder="Introduzca una contraseña" required>
            </div>
            <div class="info-container">
                <h3>Repite la contraseña:</h3>
                <%
                    if (session.getAttribute("pass2Null") != null) {
                        session.removeAttribute("pass2Null");
                %>
                <p class="text-red">Debes introducir una contraseña</p>
                <%
                    }
                %>
                <input type="password" name="pass2" placeholder="Introduzca una contraseña" required>
            </div>
            <div class="button-form">
                <button type="submit">Crear</button>
            </div>
        </form>
    </section>
    <%
        }
    %>
</main>

<footer class="footer">
    <div class="container-footer">
        <p>&copy; 2024 FernanPaaq. Todos los derechos reservados.</p>
    </div>
</footer>
<!--Aqui tengo que hacer una pagina web que me pida numero de telefono, contraseña, numero de portal y provincia-->

<!--Está pagina debe de tener dos opciones la 1- Si acepta crear la cuenta con la informacion de los paquetes
debemos mostrar la informacion encontrada y pedirle la extra-->

<!--Si elige no crear la cuenta a traves de la informacion de los paquetes, lo saltamos a la pagina registerComplete.jsp
para que le pida toda la información posible-->

<!--El token debo llamarlo desde la clase validar correo o algo así y crearlo en el dispatch de esta página-->
</body>
</html>
