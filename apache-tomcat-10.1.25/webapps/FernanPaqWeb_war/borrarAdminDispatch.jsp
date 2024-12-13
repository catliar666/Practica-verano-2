<%

    if (session.getAttribute("driverAdded") != null) {
        session.removeAttribute("driverAdded");
        response.sendRedirect("accountAdmin.jsp");
        return;
    }
    if (session.getAttribute("changePassYes") != null) {
        session.removeAttribute("changePassYes");
        response.sendRedirect("accountAdmin.jsp");
        return;
    }
    if (session.getAttribute(" shipmentFound") != null) {
        session.removeAttribute("shipmentFound");
        response.sendRedirect("accountAdmin.jsp");
        return;
    }
    if (session.getAttribute("emailNoRegisterDriver") != null) {
        session.removeAttribute("emailNoRegisterDriver");
        response.sendRedirect("accountAdmin.jsp");
        return;
    }
    if (session.getAttribute("emailNoRegisterAdmin") != null) {
        session.removeAttribute("emailNoRegisterAdmin");
        response.sendRedirect("accountAdmin.jsp");
        return;
    }




    session.setAttribute("errorBorrar", "No hay un elemento para borrar");
    response.sendRedirect("accountAdmin.jsp");
%>