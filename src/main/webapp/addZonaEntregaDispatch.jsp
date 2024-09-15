<%@ page import="models.Driver" %>
<%@ page import="appcontroller.AppController" %>
<%
    AppController controller = new AppController();
    Driver driver = (Driver) session.getAttribute("usuarioLogueado");

    if (driver != null) {

        String newPostal = request.getParameter("zonaEntregaNew");

        if (newPostal == null || newPostal.trim().isEmpty()) {
            session.setAttribute("postalNull", "No ha introducido un codigo postal nuevo");
            response.sendRedirect("accountDriver.jsp");
            return;
        }
        try {
            int postalNum = Integer.parseInt(newPostal);
            if (postalNum <= 0) {
                session.setAttribute("postalNull", "No ha introducido un codigo postal nuevo");
                response.sendRedirect("accountDriver.jsp");
                return;
            }
            if (driver.hasPostalCodeZone(postalNum)) {
                session.setAttribute("postalExiste", "Ha agregado un codigo postal existente en esta cuenta");
                response.sendRedirect("accountDriver.jsp");
                return;
            }
            if (controller.addZoneToDriver(driver.getId(), postalNum)) {
                session.setAttribute("addSuccess", "Añadido correctamente");
                response.sendRedirect("accountDriver.jsp");
                return;
            }
        }catch (Exception e) {
            session.setAttribute("error", "Error a la hora de parsear a integer");
            response.sendRedirect("error.jsp");
            return;
        }
    }
    response.sendRedirect("error.jsp");
%>