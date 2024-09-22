<%@ page import="appcontroller.AppController" %>
<%@ page import="models.User" %>
<%@ page import="utils.Utils" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 10/09/2024
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    AppController controller = new AppController();
    User user = (User) session.getAttribute("usuarioLogueado");

    String email = request.getParameter("emailNew"),
            street = request.getParameter("streetNew"),
            name = request.getParameter("nameNew"),
            surname = request.getParameter("surnameNew"),
            num = request.getParameter("numNew"),
            postalCode = request.getParameter("postalNew"),
            city = request.getParameter("cityNew"),
            phone = request.getParameter("phoneNew"),
            state = request.getParameter("stateNew");

    String notificationNo = request.getParameter("notificationNoName"),
            notificationYes = request.getParameter("notificationYesName");
    int fails = 0;

    if (name == null || name.trim().isEmpty() || Utils.VerEtiquetas(name)) {
        session.setAttribute("nameNull", "No hay nombre");
        fails++;
    }
    if (email == null || email.trim().isEmpty() || Utils.VerEtiquetas(email)) {
        session.setAttribute("emailNull", "No hay email");
        fails++;
    }
    if (surname == null || surname.trim().isEmpty() || Utils.VerEtiquetas(surname)) {
        session.setAttribute("surnameNull", "No hay apellidos");
        fails++;
    }
    if (street == null || street.trim().isEmpty() || Utils.VerEtiquetas(street)) {
        session.setAttribute("streetNull", "No hay direccion");
        fails++;
    }
    if (state == null || state.trim().isEmpty() || Utils.VerEtiquetas(state)) {
        session.setAttribute("stateNull", "No hay provincia");
        fails++;
    }
    if (city == null || city.trim().isEmpty() || Utils.VerEtiquetas(city)) {
        session.setAttribute("cityNull", "No hay ciudad");
        fails++;
    }
    if (num == null || num.trim().isEmpty() || Utils.VerEtiquetas(num)) {
        session.setAttribute("numNull", "No hay número de portal");
        fails++;
    }
    if (phone == null || phone.trim().isEmpty() || Utils.VerEtiquetas(phone)) {
        session.setAttribute("phoneNull", "No hay telefono");
        fails++;
    }
    if (postalCode == null || postalCode.trim().isEmpty() || Utils.VerEtiquetas(postalCode)) {
        session.setAttribute("postalCodeNull", "No hay código postal");
        fails++;
    }
    if (fails > 0) {
        response.sendRedirect("accountUser.jsp");
        return;
    }

    if (user != null) {
        try {
            int postal = Integer.parseInt(postalCode), numStreet = Integer.parseInt(num), phoneNum = Integer.parseInt(phone);
            user.setCity(city);
            user.setStreet(street);
            user.setPostalCode(postal);
            user.setState(state);
            user.setPhone(phoneNum);
            user.setNum(numStreet);
            user.setName(name);
            user.setSurname(surname);
            user.setEmail(email);
            if (notificationNo != null) {
                user.setNotification(false);
            }
            if (notificationYes != null) {
                user.setNotification(true);
            }
            if (controller.updateUser(user)){
                session.setAttribute("usuarioLogueado", user);
                session.setAttribute("modifySuccess", "Modificado con exito");
                response.sendRedirect("accountUser.jsp");
                return;
            };
            session.setAttribute("modifyError", "No se ha podido modificar");
            response.sendRedirect("accountUser.jsp");
        }catch (NumberFormatException e) {
            response.sendRedirect("error.jsp");
        }
    }
    response.sendRedirect("error.jsp");

%>
</body>
</html>