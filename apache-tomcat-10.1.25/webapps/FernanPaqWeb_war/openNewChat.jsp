<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 09/10/2024
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Object user = session.getAttribute("usuarioLogueado");

    if (user == null) {
        session.setAttribute("userNull", "no hay usuario registrado");
        response.sendRedirect("error.jsp");
        return;
    }

    if (user instanceof User){
        if (((User) user).isFirst_login() && !((User) user).isValidate()) {
            response.sendRedirect("questionValidate.jsp");
            return;
        } else {

%>
<!-- Comienzo de la barra de navegación -->
<header class="header">
    <div class="nav">
        <a href="index.jsp" class="nav_logo"><img src="img/Logo fernanpaaq.png" alt="logo" style="width: 75%;"></a>
        <ul class="nav_items">
            <li class="nav_item">
                <a href="index.jsp" class="nav_link">Inicio</a>
                <a href="sobreNosotros.html" class="nav_link">Sobre nosotros</a>
                <a href="sobreNosotros.html" class="nav_link">Contacto</a>
            </li>

        </ul>
        <a class="nav_welcome">Bienvenido <%= ((User) user).getName()%>
        </a>
    </div>
</header>
<!--Fin de la barra de navegación-->

<footer class="footer">
    <div class="container-footer">
        <p>&copy; 2024 FernanPaaq. Todos los derechos reservados.</p>
    </div>
</footer>
<%
        }
    }
%>
</body>
</html>
