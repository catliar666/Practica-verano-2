<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 06/09/2024
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // Primera condición: Verifica si "packageNoLogin" no es null
    if (session.getAttribute("packageNoLogin") != null) {
        session.removeAttribute("packageNoLogin");
        response.sendRedirect("seguimientoEnvio.jsp");
        return; // Termina la ejecución después de la redirección
    }

    // Segunda condición: Verifica el parámetro "page"
    String pageParam = request.getParameter("page");
    if ("makeShipment".equals(pageParam)) {
        session.removeAttribute("packageSuccess");
        response.sendRedirect("accountUser.jsp");
        return; // Termina la ejecución después de la redirección
    }

    if (session.getAttribute("changePassYes") != null) {
        session.removeAttribute("changePassYes");
        response.sendRedirect("accountUser.jsp");
        return; // Termina la ejecución después de la redirección
    }


    // Si ninguna condición anterior se cumple, establece un error y redirige
    session.setAttribute("errorBorrar", "No hay elemento para borrar");
    response.sendRedirect("seguimientoEnvio.jsp");
%>

</body>
</html>
