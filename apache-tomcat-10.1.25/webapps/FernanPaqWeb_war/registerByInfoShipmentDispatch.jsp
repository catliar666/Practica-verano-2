<%@ page import="appcontroller.AppController" %>
<%@ page import="models.User" %>
<%@ page import="comunication.ValidarCorreo" %>
<%@ page import="utils.Utils" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 04/08/2024
  Time: 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (session.getAttribute("confirm") == null) {
        session.setAttribute("confirm", "true");
        response.sendRedirect("registerByInfoShipment.jsp");
        return;
    }
    AppController controller = new AppController();
    String email = request.getParameter("emailText"),
            phone = request.getParameter("phoneText"),
            state = request.getParameter("stateText"),
            pass1 = request.getParameter("pass1"),
            pass2 = request.getParameter("pass2");

    int fails = 0;

    if (pass1 == null || pass1.trim().isEmpty() || Utils.VerEtiquetas(pass1) || Utils.VerInyeccionSql(pass1)) {
        session.setAttribute("passNull", "No hay contraseña");
        fails++;
    }
    if (pass2 == null ||  pass2.trim().isEmpty() || Utils.VerEtiquetas(pass2) || Utils.VerInyeccionSql(pass2)) {
        session.setAttribute("pass2Null", "No hay segunda contraseña");
        fails++;
    }
    if (state == null || state.trim().isEmpty() || Utils.VerEtiquetas(state) || Utils.VerInyeccionSql(state)) {
        session.setAttribute("stateNull", "No hay provincia");
        fails++;
    }
    if (email == null || email.trim().isEmpty() || Utils.VerEtiquetas(email) || Utils.VerInyeccionSql(email)) {
        session.setAttribute("emailNull", "No hay email");
        fails++;
    }
    if (phone == null || phone.trim().isEmpty() || Utils.VerEtiquetas(phone) || Utils.VerInyeccionSql(phone)) {
        session.setAttribute("phoneNull", "No hay email");
        fails++;
    }

    if (fails >= 1) {
        response.sendRedirect("registerComplete.jsp");
        return;
    }

    if (!pass1.equals(pass2)) {
        session.setAttribute("passNotEqual", "Contraseñas no iguales");
        response.sendRedirect("registerComplete.jsp");
        return;
    }

    try {
        int phoneNum = Integer.parseInt(phone);

        if (phoneNum <= 0) {
            session.setAttribute("noValido", "Números introducidos no válidos");
            response.sendRedirect("registerComplete.jsp");
            return;
        }
        int token = ValidarCorreo.enviarToken(email);

        User userUse = controller.createAccountShippingInfo(email, pass1, phoneNum, token, state);
        if (userUse != null) {
            session.removeAttribute("confirm");
            session.setAttribute("usuarioLogueado", userUse);
            response.sendRedirect("questionValidate.jsp");
            return;
        }
        session.setAttribute("fail", "Ha ocurrido un error");
        response.sendRedirect("error.jsp");


    } catch (Exception e) {
        session.setAttribute("error", "Error o en el formato del numero o a la hora de enviar el token");
        response.sendRedirect("error.jsp");
    }
    /*Aquí comprobamos la información recogida, sobre si quiere crear la cuenta o no, no sé si hacer dos paginas
    es decir, una página que diga, hemos encontrado infrmacion sobre su cuenta, quiere crear su cuenta en razón a esta información?
    y que de a elegir entre si y no, si dice que si, se le salta a una página que le pregunte la informacion que falta
    y para comprobarla lo llevamos aquí
    y si dice que no pues salta al registerComplete.jsp, también en el registerComplete debo comprobar si ese email tiene paquetes
    y añadirselo automaticamente
     */
%>
</body>
</html>
