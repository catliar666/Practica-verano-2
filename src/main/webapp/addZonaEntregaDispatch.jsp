<%@ page import="models.Driver" %>
<%@ page import="appcontroller.AppController" %>
<%@ page import="utils.Utils" %>
<%
    AppController controller = new AppController();
    Object driver = session.getAttribute("usuarioLogueado");

    if (driver instanceof Driver) {

        String newPostal = request.getParameter("zonaEntregaNew");

        if (newPostal == null || newPostal.trim().isEmpty() || Utils.VerEtiquetas(newPostal)) {
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
            if (((Driver) driver).hasPostalCodeZone(postalNum)) {
                session.setAttribute("postalExiste", "Ha agregado un codigo postal existente en esta cuenta");
                response.sendRedirect("accountDriver.jsp");
                return;
            }
            if (controller.addZoneToDriver(((Driver) driver).getId(), postalNum)) {
                Driver driverActual = controller.searchDriverById(((Driver) driver).getId());
                session.removeAttribute("usuarioLogueado");
                session.setAttribute("usuarioLogueado", driverActual);
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