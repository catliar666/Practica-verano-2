package models;

import persistence.Config;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Shipment implements Serializable {

    //ATRIBUTOS
    private int id; //Código que identifica al paquete
    private LocalDate createDate; //Fecha en la que se ha creado el paquete
    private LocalDate expectDate; //Fecha estimada de entrega
    private LocalDate deliveryDate; //Fecha en la que se envió el paquete
    private boolean notifications;
    private String alternativeAddress; //Direccion alternativa por si el usuario no está registrado
    private int numAlternative; //Direccion alternativa por si el usuario no está registrado
    private int alternativePostalCode; //Codigo postal para los usuarios no registrados
    private String alternativeCity; //Ciudad para los usuarios no registrados
    private String status; //Estado del paquete, si está entregado o no
    private double cost; //Coste del envio
    private String emailUserNoRegister; //Email del usuario no registrado
    private int idSender; //Código de la persona que envia el paquete
    private String nameUserNoRegister; //Nombre del usuario no registrado

    //CONSTRUCTOR

    public Shipment(int id, LocalDate createDate, LocalDate expectDate, LocalDate deliveryDate, boolean notifications, String alternativeAddress, int numAlternative,
                    int alternativePostalCode, String alternativeCity, String status, double cost, String emailUserNoRegister, int idSender, String nameUserNoRegister) {
        this.id = id;
        this.createDate = createDate;
        this.expectDate = expectDate;
        this.deliveryDate = deliveryDate;
        this.notifications = notifications;
        this.alternativeAddress = alternativeAddress;
        this.numAlternative = numAlternative;
        this.alternativePostalCode = alternativePostalCode;
        this.alternativeCity = alternativeCity;
        this.status = status;
        this.cost = cost;
        this.emailUserNoRegister = emailUserNoRegister;
        this.idSender = idSender;
        this.nameUserNoRegister = nameUserNoRegister;
    }


    //GETTERS AND SETTERS



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(LocalDate expectDate) {
        this.expectDate = expectDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public boolean isNotifications() {
        return notifications;
    }

    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }

    public String getAlternativeAddress() {
        return alternativeAddress;
    }

    public void setAlternativeAddress(String alternativeAddress) {
        this.alternativeAddress = alternativeAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getEmailUserNoRegister() {
        return emailUserNoRegister;
    }

    public void setEmailUserNoRegister(String emailUserNoRegister) {
        this.emailUserNoRegister = emailUserNoRegister;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public String getNameUserNoRegister() {
        return nameUserNoRegister;
    }

    public void setNameUserNoRegister(String nameUserNoRegister) {
        this.nameUserNoRegister = nameUserNoRegister;
    }

    public int getAlternativePostalCode() {
        return alternativePostalCode;
    }

    public void setAlternativePostalCode(int alternativePostalCode) {
        this.alternativePostalCode = alternativePostalCode;
    }

    public int getNumAlternative() {
        return numAlternative;
    }

    public void setNumAlternative(int numAlternative) {
        this.numAlternative = numAlternative;
    }

    public String getAlternativeCity() {
        return alternativeCity;
    }

    public void setAlternativeCity(String alternativeCity) {
        this.alternativeCity = alternativeCity;
    }

    //MÉTODOS


    @Override
    public String toString() {
        return "Shipment{" +
               "id=" + id +
               ", createDate=" + createDate +
               ", expectDate=" + expectDate +
               ", deliveryDate=" + deliveryDate +
               ", notifications=" + notifications +
               ", alternativeAddress='" + alternativeAddress + '\'' +
               ", status='" + status + '\'' +
               ", cost=" + cost +
               ", emailUserNoRegister='" + emailUserNoRegister + '\'' +
               ", idSender='" + idSender + '\'' +
               ", nameUserNoRegister='" + nameUserNoRegister + '\'' +
               '}';
    }

    public StringBuilder resumeWeb(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateExpect = expectDate.format(formatter);
        String statusString = (status.equals("1") ? Config.getStatusOne() : (status.equals("2") ? Config.getStatusTwo() :
                (status.equals("3") ? Config.getStatusThree() : (status.equals("4") ? Config.getStatusFour() : "No hay registros"))));
        StringBuilder resultado = new StringBuilder();
        resultado.append("<li class='package-item'>")
                .append("<div class='package-info'>")

                // Fila de títulos
                .append("<div class='package-titulos'>")
                .append("<span class='package-label'>Identificador</span>")
                .append("<span class='package-label'>Estado</span>")
                .append("<span class='package-label'>Fecha estimada</span>")
                .append("<span class='package-label'>Dirección</span>")
                .append("<span class='package-label'>Destinatario</span>")
                .append("<span class='package-label'>Costo</span>")
                .append("</div>")

                // Fila de detalles
                .append("<div class='package-detalles'>")
                .append("<span class='package-detail'>").append(id).append("</span>")
                .append("<span class='package-detail'>").append(statusString).append("</span>")
                .append("<span class='package-detail'>").append(dateExpect).append("</span>")
                .append("<span class='package-detail'>").append(alternativeAddress).append(", ").append(numAlternative)
                .append(" " + alternativeCity).append("(" + alternativePostalCode + ")").append("</span>")
                .append("<span class='package-detail'>").append(nameUserNoRegister).append("</span>")
                .append("<span class='package-detail'>").append(cost).append("</span>")
                .append("</div>")

                .append("</div>") // Cierre de package-info
                .append("</li>"); // Cierre de package-item
        resultado.append("</ul>");
        /*resultado += "──. ■ .───────────────────────────────────────────\n" +
        "█ Número de id del paquete: " + id + "\n"
        + "█ Estado: " + statusString + "\n" +
        "█ Fecha estimada de entrega: " + dateExpect + "\n" +
        "█ Será entregado en: " + alternativeAddress + " " + alternativeCity + "(" + alternativePostalCode + ")" + "\n" +
        "█ Destinatario: " + nameUserNoRegister + "\n" +
        "█ Cantidad pagada: " + cost + "\n" +
        "───────────────────────────────────────────. ■ .──";*/
        return resultado;
    }

    public String resume(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateExpect = expectDate.format(formatter);
        String statusString = (status.equals("1") ? Config.getStatusOne() : (status.equals("2") ? Config.getStatusTwo() :
                (status.equals("3") ? Config.getStatusThree() : (status.equals("4") ? Config.getStatusFour() : "No hay registros"))));
        String resultado = "";
        resultado += "──. ■ .───────────────────────────────────────────\n" +
        "█ Número de id del paquete: " + id + "\n"
        + "█ Estado: " + statusString + "\n" +
        "█ Fecha estimada de entrega: " + dateExpect + "\n" +
        "█ Será entregado en: " + alternativeAddress + " " + alternativeCity + "(" + alternativePostalCode + ")" + "\n" +
        "█ Destinatario: " + nameUserNoRegister + "\n" +
        "█ Cantidad pagada: " + cost + "\n" +
        "───────────────────────────────────────────. ■ .──";
        return resultado;
    }
    public StringBuilder resumeToNoLogin(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateExpect = expectDate.format(formatter);
        String statusString = (status.equals("1") ? Config.getStatusOne() : (status.equals("2") ? Config.getStatusTwo() :
                (status.equals("3") ? Config.getStatusThree() : (status.equals("4") ? Config.getStatusFour() : "No hay registros"))));
        StringBuilder resultado = new StringBuilder();
        String deliveryDateTittle = (deliveryDate != null ? "<span class='package-label'>Fecha de entrega</span>" : "<span class='package-label'>Fecha de entrega estimada</span>");
        String deliveryDateLabel = (deliveryDate != null ? deliveryDate.format(formatter) : dateExpect);
        resultado.append("<li class='package-item'>")
                .append("<div class='package-info'>")

                // Fila de títulos
                .append("<div class='package-titulos'>")
                .append("<span class='package-label'>Identificador</span>")
                .append("<span class='package-label'>Estado del envío</span>")
                .append(deliveryDateTittle)
                .append("<span class='package-label'>Dirección de entrega</span>")
                .append("</div>")

                // Fila de detalles
                .append("<div class='package-detalles'>")
                .append("<span class='package-detail'>").append(id).append("</span>")
                .append("<span class='package-detail'>").append(statusString).append("</span>")
                .append("<span class='package-detail'>").append(deliveryDateLabel).append("</span>")
                .append("<span class='package-detail'>").append(alternativeAddress).append(", ").append(numAlternative)
                .append(" " + alternativeCity).append("(" + alternativePostalCode + ")").append("</span>")
                .append("</span>")
                .append("</div>")

                .append("</div>") // Cierre de package-info
                .append("</li>"); // Cierre de package-item
            resultado.append("</ul>");
        /*resultado += "──. ■ .───────────────────────────────────────────\n" +
                     "█ Estado: " + statusString + "\n" +
                     "█ Fecha estimada de entrega: " + dateExpect + "\n" +
                     "█ Será entregado en: " + alternativeAddress + " " + alternativeCity + "(" + alternativePostalCode + ")" + "\n" +
                     "───────────────────────────────────────────. ■ .──";*/
        return resultado;
    }
    public StringBuilder resumeForDriver(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateExpect = expectDate.format(formatter);
        String statusString = (status.equals("1") ? Config.getStatusOne() : (status.equals("2") ? Config.getStatusTwo() :
                (status.equals("3") ? Config.getStatusThree() : (status.equals("4") ? Config.getStatusFour() : "No hay registros"))));
        StringBuilder resultado = new StringBuilder();
        resultado.append("<li class='package-item'>")
                .append("<div class='package-info'>")

                // Fila de títulos
                .append("<div class='package-titulos'>")
                .append("<span class='package-label'>Número identificativo</span>")
                .append("<span class='package-label'>Estado del envío</span>")
                .append("<span class='package-label'>Fecha de creación</span>")
                .append("<span class='package-label'>Fecha estimada de entrega</span>")
                .append("<span class='package-label'>Dirección de entrega</span>")
                .append("<span class='package-label'>Destinatario</span>")
                .append("</div>")

                // Fila de detalles
                .append("<div class='package-detalles'>")
                .append("<span class='package-detail'>").append(id).append("</span>")
                .append("<span class='package-detail'>").append(statusString).append("</span>")
                .append("<span class='package-detail'>").append(createDate.format(formatter)).append("</span>")
                .append("<span class='package-detail'>").append(dateExpect).append("</span>")
                .append("<span class='package-detail'>").append(alternativeAddress).append(", ").append(numAlternative)
                .append(" " + alternativeCity).append("(" + alternativePostalCode + ")").append("</span>")
                .append("<span class='package-detail'>").append(nameUserNoRegister).append("</span>")
                .append("</div>")

                .append("</div>") // Cierre de package-info
                .append("</li>"); // Cierre de package-item
        resultado.append("</ul>");
        /*resultado += "──. ■ .───────────────────────────────────────────\n" + "█ Número de id del paquete: " + id + "\n"
                     + "█ Estado: " + statusString + "\n" +
                     "█ Fecha de creación: " + createDate.format(formatter) + "\n" + "█ Fecha estimada de entrega: " + dateExpect + "\n" +
                     "█ Será entregado en: " + alternativeAddress + " " + alternativeCity + "(" + alternativePostalCode + ")" + "\n" +
                     "█ Destinatario: " + nameUserNoRegister + "\n" +
                     "───────────────────────────────────────────. ■ .──";*/
        return resultado;
    }

}
