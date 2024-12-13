package dataclass;

import persistence.Config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InfoShipmentDataClass implements Comparable<InfoShipmentDataClass> {
    private int id; //Codigo que crearemos nosotros
    private LocalDate createDate; //Fecha de creacion
    private LocalDate expectDate; //Fecha estimada de entrega
    private LocalDate deliveryDate; //Fecha de envio
    private int postalCode; //Codigo postal de la ciudad a la que va a ser enviado
    private String status; //Estado del paquete, si esta en reparto, entregado, en almacen, en oficina
    private String sender; //Remitente
    private String receiver; //Persona que recibe el paquete
    private String address; //Direccion de envio
    private String city; //Ciudad a la que va dirigido el paquete
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    //CONSTRUCTOR

    public InfoShipmentDataClass(int id, LocalDate createDate, LocalDate expectDate, LocalDate deliveryDate,
                                 int postalCode, String status, String sender, String receiver, String address, String city) {
        this.id = id;
        this.createDate = createDate;
        this.expectDate = expectDate;
        this.deliveryDate = deliveryDate;
        this.postalCode = postalCode;
        this.status = status;
        this.sender = sender;
        this.receiver = receiver;
        this.address = address;
        this.city = city;
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

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    //MÉTODOS


    @Override
    public String toString() {
        return "InfoShipmentDataClass{" +
               "id=" + id +
               ", createDate=" + createDate +
               ", expectDate=" + expectDate +
               ", deliveryDate=" + deliveryDate +
               ", postalCode=" + postalCode +
               ", status='" + status + '\'' +
               ", sender='" + sender + '\'' +
               ", receiver='" + receiver + '\'' +
               ", address='" + address + '\'' +
               ", city='" + city + '\'' +
               '}';
    }


    public StringBuilder forTracking() {
        String statusString = (status.equals("1") ? Config.getStatusOne() : (status.equals("2") ? Config.getStatusTwo() :
                (status.equals("3") ? Config.getStatusThree() : (status.equals("4") ? Config.getStatusFour() : "No hay registros"))));
        StringBuilder result = new StringBuilder();
        String dateExpect = expectDate.format(formatter);
        String dateFinished = (deliveryDate != null) ? deliveryDate.format(formatter) : "No hay fecha estimada todavía";
        String fechaEstado = (status.equals("4") ? "<p class='text-title-hover'>Entregado el: " : "<p class='text-title-hover'>Entrega estimada: ");

        StringBuilder results = new StringBuilder();
        results.append("<a href=findPackageDispatch.jsp?idPackage=" + id + "><div class='card-image'>")
                // Información restante que se muestra al hacer hover
                .append(fechaEstado).append("<p class='text-body'>").append((status.equals("4") ? dateFinished : dateExpect)).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Dirección: ").append("<p class='text-body'>").append(address).append(", ").append(city).append(" (").append(postalCode).append(")</p>").append("</p>")
                .append("<p class='text-title-hover'>Destinatario: ").append("<p class='text-body'>").append(receiver).append("</p>").append("</p>")
                .append("</div>")
                .append("<div class='card-description'>")
                // Solo la expedición del paquete y el título con el ID
                .append("<span class='text-title'>ID: ").append(id).append("</span>")
                .append("<p class='text-body'>Estado: ").append(statusString).append("</p>")
                // Botón de "Más información"
                .append("<button class='info-button'>Más información</button>")
                .append("</div></a>");
        /*return String.format(
                "┌──. ■ .──────────────────────────┐\n" +
                "          Envío nº %d\n" +
                "└──────────────────────────. ■ .──┘\n" +
                "█  Fecha aproximada de entrega: %s\n" +
                "█  Dirección de envío: %s, %s, %d\n" +
                "█  Estado actual del envío: %s\n" +
                "█  Destinatario: %s\n" +
                "──────────────────────────────────────────. ■ .──", id, dateExpect,
                address, city, postalCode, status, receiver);*/
        return results;
    }
    public StringBuilder forAdminUnassigned(){
        StringBuilder results = new StringBuilder();
        String fechaEstado = (status.equals("4") ? "<p class='text-title-hover'>Entregado el: " : "<p class='text-title-hover'>Entrega estimada: ");
        String dateCreate = createDate.format(formatter);
        String dateExpect = expectDate.format(formatter);
        String dateDelivery = (deliveryDate != null) ? deliveryDate.format(formatter) : "No hay fecha estimada todavía";
        String statusString = (status.equals("1") ? Config.getStatusOne() : (status.equals("2") ? Config.getStatusTwo() :
                (status.equals("3") ? Config.getStatusThree() : (status.equals("4") ? Config.getStatusFour() : "No hay registros"))));

        results.append("<div class='card-image'>")
                // Información restante que se muestra al hacer hover
                .append(fechaEstado).append("<p class='text-body'>").append((status.equals("4") ? dateDelivery : dateExpect)).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Expedición: ").append("<p class='text-body'>").append(dateCreate).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Dirección: ").append("<p class='text-body'>").append(address).append(", ").append(city).append(" (").append(postalCode).append(")</p>").append("</p>")
                .append("<p class='text-title-hover'>Estado: ").append("<p class='text-body'>").append(statusString).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Remitente: ").append("<p class='text-body'>").append(sender).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Destinatario: ").append("<p class='text-body'>").append(receiver).append("</p>").append("</p>")
                .append("</div>")
                .append("<div class='card-description'>")
                // Solo la expedición del paquete y el título con el ID
                .append("<span class='text-title'>Envío: ").append(id).append("</span>")
                .append("<p class='text-body'>Estado: ").append(statusString).append("</p>")
                // Botón de "Más información"
                .append("<button class='info-button'>Más información</button>")
                .append("</div>");
        /*return String.format(
                            "┌──. ■ .──────────────────────────┐\n" +
                            "    Envío nº referencia %d\n" +
                            "└──────────────────────────. ■ .──┘\n" +
                            "█    Fecha de expedición: %s\n" +
                            "█    Fecha aproximada de entrega: %s\n" +
                            "█    Fecha real de entrega: %s\n" +
                            "█    Dirección de envío: %s, %s, %d\n" +
                            "█    Estado actual del envío: %s\n" +
                            "█    Remitente: %s\n" +
                            "█    Destinatario: %s\n" +
                            "─────────────────────────────────────────────────. ■ .──", id, dateCreate,
                dateExpect, (deliveryDate != null) ? dateDelivery : "Todavia no se ha entregado",
                address, city, postalCode, status, sender, receiver);*/
        return results;
    }

    public StringBuilder forReciever(){
        String dateCreate = createDate.format(formatter);
        String dateExpect = expectDate.format(formatter);
        String dateFinished = (deliveryDate != null) ? deliveryDate.format(formatter) : "No hay fecha estimada todavía";
        String fechaEstado = (status.equals("4") ? "<p class='text-title-hover'>Entregado el: " : "<p class='text-title-hover'>Entrega estimada: ");
        String statusString = (status.equals("1") ? Config.getStatusOne() : (status.equals("2") ? Config.getStatusTwo() :
                (status.equals("3") ? Config.getStatusThree() : (status.equals("4") ? Config.getStatusFour() : "No hay registros"))));
        StringBuilder results = new StringBuilder();
        results.append("<div class='card-image'>")
                // Información restante que se muestra al hacer hover
                .append(fechaEstado).append("<p class='text-body'>").append((status.equals("4") ? dateFinished : dateExpect)).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Expedición: ").append("<p class='text-body'>").append(dateCreate).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Dirección: ").append("<p class='text-body'>").append(address).append(", ").append(city).append(" (").append(postalCode).append(")</p>").append("</p>")
                .append("<p class='text-title-hover'>Remitente: ").append("<p class='text-body'>").append(sender).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Destinatario: ").append("<p class='text-body'>").append(receiver).append("</p>").append("</p>")
                .append("</div>")
                .append("<div class='card-description'>")
                // Solo la expedición del paquete y el título con el ID
                .append("<span class='text-title'>Envío: ").append(id).append("</span>")
                .append("<p class='text-body'>Estado: ").append(statusString).append("</p>")
                // Botón de "Más información"
                .append("<button class='info-button'>Más información</button>")
                .append("</div>");
        /*return String.format(
                "┌──. ■ .──────────────────────────┐\n" +
                "          Envío nº %d\n" +
                "└──────────────────────────. ■ .──┘\n" +
                "█    Fecha de expedición: %s\n" +
                "█    Fecha aproximada de entrega: %s\n" +
                "█    Estado actual del envío: %s\n" +
                "█    Dirección de envío: %s, %s, %d\n" +
                "█    Remitente: %s\n" +
                "█    Destinatario: %s\n" +
                "─────────────────────────────────────────────. ■ .──", id, dateCreate,
                dateExpect, status, address, city, postalCode, sender, receiver);*/
        return results;

    }

    public StringBuilder forSender() {
        String dateCreate = createDate.format(formatter);
        String dateExpect = expectDate.format(formatter);
        String statusString = (status.equals("1") ? Config.getStatusOne() : (status.equals("2") ? Config.getStatusTwo() :
                (status.equals("3") ? Config.getStatusThree() : (status.equals("4") ? Config.getStatusFour() : "No hay registros"))));
        StringBuilder results = new StringBuilder();
        results.append("<div class='card-image'>")
                // Información restante que se muestra al hacer hover
                .append("<p class='text-title-hover'>Entrega estimada: ").append("<p class='text-body'>").append(dateExpect).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Estado: ").append("<p class='text-body'>").append(statusString).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Dirección: ").append("<p class='text-body'>").append(address).append(", ").append(city).append(" (").append(postalCode).append(")</p>").append("</p>")
                .append("<p class='text-title-hover'>Remitente: ").append("<p class='text-body'>").append(sender).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Destinatario: ").append("<p class='text-body'>").append(receiver).append("</p>").append("</p>")
                .append("</div>")
                .append("<div class='card-description'>")
                // Solo la expedición del paquete y el título con el ID
                .append("<span class='text-title'>Envío: ").append(id).append("</span>")
                .append("<p class='text-body'>Expedición: ").append(dateCreate).append("</p>")
                // Botón de "Más información"
                .append("<button class='info-button'>Más información</button>")
                .append("</div>");
        /*return String.format(
                "┌──. ■ .──────────────────────────┐\n" +
                "          Envío nº %d\n" +
                "└──────────────────────────. ■ .──┘\n" +
                "█    Fecha de expedición: %s\n" +
                "█    Fecha aproximada de entrega: %s\n" +
                "█    Estado actual del envío: %s\n" +
                "█    Dirección de envío: %s, %s, %d\n" +
                "█    Remitente: %s\n" +
                "█    Destinatario: %s\n" +
                "─────────────────────────────────────────────. ■ .──", id, dateCreate, dateExpect,
                status, address, city, postalCode, sender, receiver);*/
        return results;

    }

    public StringBuilder forDriverFinished() {
        String dateDelivery = (deliveryDate != null) ? deliveryDate.format(formatter) : "No hay fecha estimada todavía";

        String dateCreate = createDate.format(formatter);
        String statusString = (status.equals("1") ? Config.getStatusOne() : (status.equals("2") ? Config.getStatusTwo() :
                (status.equals("3") ? Config.getStatusThree() : (status.equals("4") ? Config.getStatusFour() : "No hay registros"))));
        StringBuilder results = new StringBuilder();
        results.append("<div class='card-image'>")
                // Información restante que se muestra al hacer hover
                .append("<p class='text-title-hover'>Fecha expedición: ").append("<p class='text-body'>").append(dateCreate).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Dirección: ").append("<p class='text-body'>").append(address).append(", ").append(city).append(" (").append(postalCode).append(")</p>").append("</p>")
                .append("<p class='text-title-hover'>Destinatario: ").append("<p class='text-body'>").append(receiver).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Remitente: ").append("<p class='text-body'>").append(sender).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Estado: ").append("<p class='text-body'>").append(statusString).append("</p>").append("</p>")
                .append("</div>")
                .append("<div class='card-description'>")
                // Información en el titulo
                .append("<span class='text-title'>ID: ").append(id).append("</span>")
                .append("<p class='text-body'>Fecha entrega: ").append(dateDelivery).append("</p>")
                // Botón de "Más información"
                .append("<button class='info-button'>Más información</button>")
                .append("</div>");

        /*return String.format(
                "┌──. ■ .──────────────────────────┐\n" +
                "          Envío nº %d \n" +
                "└──────────────────────────. ■ .──┘\n" +
                "█    Remitente: %s\n" +
                "█    Destinatario: %s\n" +
                "█    Fecha de expedición: %s\n" +
                "█    Fecha de entrega: %s\n" +
                "█    Dirección de envío: %s, %s, %d\n" +
                "█    Estado actual del envío: %s\n" +
                "─────────────────────────────────────────────. ■ .──", id, sender, receiver, dateCreate, dateDelivery, address, city, postalCode, status);*/
    return results;
    }

    public StringBuilder forDriverPending() {
        String dateCreate = createDate.format(formatter);
        String dateExpect = expectDate.format(formatter);
        String statusString = (status.equals("1") ? Config.getStatusOne() : (status.equals("2") ? Config.getStatusTwo() :
                (status.equals("3") ? Config.getStatusThree() : (status.equals("4") ? Config.getStatusFour() : "No hay registros"))));
        StringBuilder results = new StringBuilder();
        results.append("<div class='card-image'>")
                // Información restante que se muestra al hacer hover
                .append("<p class='text-title-hover'>Fecha expedición: ").append("<p class='text-body'>").append(dateCreate).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Dirección: ").append("<p class='text-body'>").append(address).append(", ").append(city).append(" (").append(postalCode).append(")</p>").append("</p>")
                .append("<p class='text-title-hover'>Destinatario: ").append("<p class='text-body'>").append(receiver).append("</p>").append("</p>")
                .append("</div>")
                .append("<div class='card-description'>")
                // Solo la expedición del paquete y el título con el ID
                .append("<span class='text-title'>ID: ").append(id).append("</span>")
                .append("<p class='text-body'>Entrega límite: ").append(dateExpect).append("</p>")
                // Botón de "Más información"
                .append("<button class='info-button'>Más información</button>")
                .append("</div>");

        /*return String.format(
                "┌──. ■ .──────────────────────────┐\n" +
                "          Envío nº %d\n" +
                "└──────────────────────────. ■ .──┘\n" +
                "█    Fecha de expedición: %s\n" +
                "█    Fecha de entrega límite: %s\n" +
                "█    Dirección de envío: %s, %s, %d\n" +
                "█    Destinatario: %s\n" +
                "─────────────────────────────────────────────. ■ .──", id, dateCreate,
                dateExpect, address, city, postalCode, receiver);*/
        return results;
    }


    @Override
    public int compareTo(InfoShipmentDataClass o) {
        if (this.createDate.isBefore(o.getCreateDate())) {
            return 1;
        }
        if (this.createDate.isAfter(o.getCreateDate())) {
            return -1;
        }
        return 0;
    }
}
