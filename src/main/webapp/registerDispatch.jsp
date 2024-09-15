<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 03/08/2024
  Time: 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.User" %>
<%@ page import="appcontroller.AppController" %>
<%@ page import="comunication.ValidarCorreo" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    AppController controller = new AppController();
    // Aquí empieza el registro del usuario
    String name = request.getParameter("name"),
            email = request.getParameter("email"),
            surname = request.getParameter("surname"),
            pass = request.getParameter("password"),
            address = request.getParameter("address"),
            province = request.getParameter("province"),
            city = request.getParameter("city"),
            pass2 = request.getParameter("password2");

    int fails = 0;
    /*Debo de mirar si la opcion check-yes esta marcada o si lo está check-no para poner la notificación o no*/
    String notificationNo = request.getParameter("notification");

    // Validación de campos
    if (name == null || name.trim().isEmpty()) {
        session.setAttribute("nameNull", "No hay nombre");
        fails++;
    }
    if (email == null || email.trim().isEmpty()) {
        session.setAttribute("emailNull", "No hay email");
        fails++;
    }
    if (surname == null || surname.trim().isEmpty()) {
        session.setAttribute("surnameNull", "No hay apellidos");
        fails++;
    }
    if (pass == null || pass.trim().isEmpty()) {
        session.setAttribute("passNull", "No hay contraseña");
        fails++;
    }
    if (pass2 == null ||  pass2.trim().isEmpty()) {
        session.setAttribute("pass2Null", "No hay segunda contraseña");
        fails++;
    }
    if (address == null || address.trim().isEmpty()) {
        session.setAttribute("addressNull", "No hay direccion");
        fails++;
    }
    if (province == null || province.trim().isEmpty()) {
        session.setAttribute("provinceNull", "No hay provincia");
        fails++;
    }
    if (city == null || city.trim().isEmpty()) {
        session.setAttribute("cityNull", "No hay ciudad");
        fails++;
    }
    if (fails >= 1) {
        response.sendRedirect("registerComplete.jsp");
        return;
    }

    if (!pass.equals(pass2)) {
        session.setAttribute("passNotEqual", "Contraseñas no iguales");
        response.sendRedirect("registerComplete.jsp");
        return;
    }



    try {
        int phone = Integer.parseInt(request.getParameter("phone"));
        int number = Integer.parseInt(request.getParameter("number"));
        int postal = Integer.parseInt(request.getParameter("postal"));

        if (phone <= 0 || number <= 0 || postal <= 0) {
            session.setAttribute("noValido", "Números introducidos no válidos");
            response.sendRedirect("registerComplete.jsp");
            return;
        }

        boolean userRegister = false;
        if (notificationNo.equals("no")) {
            userRegister = controller.addUser(name, surname, email, phone, pass, address, number, city,
                    province, postal, ValidarCorreo.enviarToken(email), false);
        } else {
            userRegister = controller.addUser(name, surname, email, phone, pass, address, number, city,
                    province, postal, ValidarCorreo.enviarToken(email), true);
        }

        // Intento de registro de usuario

        if (userRegister) {
            User user = controller.searchUserByEmail(email);
            controller.findShipmentCreateUser(user);
            try {
                ValidarCorreo.enviarToken(user.getEmail());
                response.sendRedirect("questionValidate.jsp");
            } catch (Exception e) {
                session.setAttribute("errorEmail", "No se ha podido enviar el email");
                response.sendRedirect("error.jsp");
                return;
            }
            session.setAttribute("usuarioLogueado", user);
            session.setAttribute("sucess", "Usuario registrado con éxito");

        } else {
            session.setAttribute("fail", "Ha ocurrido un error");
            response.sendRedirect("error.jsp");
            return;
        }

    } catch (NumberFormatException e) {
        session.setAttribute("errorNumber", "Error en el formato del número");
        response.sendRedirect("registerComplete.jsp");
    }
%>

</body>
</html>
