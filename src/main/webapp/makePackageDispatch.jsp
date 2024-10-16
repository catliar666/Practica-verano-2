<%@ page import="models.User" %>
<%@ page import="appcontroller.AppController" %>
<%@ page import="persistence.Config" %>
<%@ page import="models.Shipment" %>
<%@ page import="jdk.jshell.execution.Util" %>
<%@ page import="utils.Utils" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 27/08/2024
  Time: 20:07
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
    Object user = session.getAttribute("usuarioLogueado");
    try {
        if (user == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        if (user instanceof User) {

            String email = request.getParameter("email"),
                    num = request.getParameter("num"),
                    street = request.getParameter("street"),
                    city = request.getParameter("city"),
                    postalCode = request.getParameter("postalCode"),
                    nameReciever = request.getParameter("nameReciever"), nombreArchivo;

            int fails = 0;

            if (email == null || email.trim().isEmpty() || Utils.VerEtiquetas(email) || Utils.VerInyeccionSql(email)) {
                fails++;
                session.setAttribute("emailNull", "Email null");
            }
            if (street == null || street.trim().isEmpty() || Utils.VerEtiquetas(street) || Utils.VerInyeccionSql(street)) {
                fails++;
                session.setAttribute("streetNull", "Street null");
            }
            if (city == null || city.trim().isEmpty() || Utils.VerEtiquetas(city) || Utils.VerInyeccionSql(city)) {
                fails++;
                session.setAttribute("cityNull", "City null");
            }
            if (num == null || num.trim().isEmpty() || Utils.VerEtiquetas(num) || Utils.VerInyeccionSql(num)) {
                fails++;
                session.setAttribute("numNull", "num null");
            }
            if (postalCode == null || postalCode.trim().isEmpty() || Utils.VerEtiquetas(postalCode) || Utils.VerInyeccionSql(postalCode)) {
                fails++;
                session.setAttribute("postalNull", "postal null");
            }
            if (nameReciever == null || nameReciever.trim().isEmpty() || Utils.VerEtiquetas(nameReciever) || Utils.VerInyeccionSql(nameReciever)) {
                fails++;
                session.setAttribute("nameNull", "Name null");
            }

            if (fails > 0) {
                response.sendRedirect("accountUser.jsp");
                return;
            }

            int postalCodeNum = Integer.parseInt(postalCode), number = Integer.parseInt(num);

            if (postalCodeNum <= 0 || number <= 0) {
                session.setAttribute("postalCodeNull", "Postal code null");
                response.sendRedirect("accountUser.jsp");
                return;
            }


            Shipment shipment = controller.addShipmentToNoRegisterUser("1", ((User) user).getId(), email, postalCodeNum, nameReciever, number, true, street, city);

            if (shipment != null) {
                nombreArchivo = controller.createPdf(shipment, (User) user);
                controller.sendEmail(shipment, (User) user, nombreArchivo, true);
                session.setAttribute("packageSuccess", shipment);
                response.sendRedirect("accountUser.jsp");
                return;
            } else {
                session.setAttribute("errorPackageMake", "Error al crear el paquete");
                response.sendRedirect("accountUser.jsp");
            }
        }
        } catch(Exception e){
            response.sendRedirect("error.jsp");
        }
%>
</body>
</html>
