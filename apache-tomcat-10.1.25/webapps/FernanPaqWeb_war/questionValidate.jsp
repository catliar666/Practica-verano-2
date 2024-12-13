<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 04/08/2024
  Time: 3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/styleQuestionValidate.css" rel="stylesheet">
    <link href="css/styleHeader.css" rel="stylesheet">
    <link href="css/styleFooterWhite.css" rel="stylesheet">
    <link href="css/styleResponsiveAll.css" rel="stylesheet">
    <link href="css/styleFails.css" rel="stylesheet">
    <title>Validate Account</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("usuarioLogueado");

    if (user != null && !user.isValidate()) {
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
<main>
<!--Si el usuario todavia no ha iniciado sesión por primera vez le damos la opción de preguntarle si quiere validar más tarde la cuenta
si elige que si, lo mandamos al indexUser, si elige que no, debemos comprobar si la url que le hemos mandado, ha sido clickada o no-->
<%
    if (!user.isFirst_login()) {
%>
<section class="container-question">
    <div class="question-box">
        <h3>¿Desea validar su cuenta ahora?</h3>
        <div class="option-container">
        <a href="esperaValidacion.jsp">
            Si</a>
        <a href="accountUser.jsp">
            No</a>
        </div>
    </div>
</section>
<%
    } else {
        response.sendRedirect("esperaValidacion.jsp");
        return;
    }
%>
</main>

<footer class="footer">
    <div class="container-footer">
        <p>&copy; 2024 FernanPaaq. Todos los derechos reservados.</p>
    </div>
</footer>
<!--Si una vez comprobado que está validado, lo redirigimos al cuentaValidada para avisarle de que ya ha sido validada
y no pueda entrar en esta página-->
<%
    } else {
        response.sendRedirect("cuentaValidada.jsp");
        return;
    }
%>
</body>
</html>
