package models;

import persistence.PersistenceData;
import persistence.PersistenceDisk;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    //ATRIBUTOS
    public boolean first_login;
    private int id; //codigo que generaremos
    private String name; //nombre
    private String surname; //Apellidos
    private String email; //Correo electronico
    private String pass; //contraseña
    private int phone; //telefono
    private String street; //calle
    private int num; //numero de la casa
    private String city; //ciudad o pueblo
    private String state; //provincia
    private int postalCode; //codigo postal
    private int token;
    private boolean notification; //Atributo que sirve para saber si el usuario quiere o no notificaciones en el email
    private boolean validate; //indica si la cuenta está validada o no mediante el codigo que se envia por correo
    private ArrayList<Shipment> shipments; //envios que tiene este usuario

    //CONSTRUCTOR


    public User(boolean first_login, int id, String name, String surname, String email, String pass,
                int phone, String street, int num, String city, String state, int postalCode, int token,
                boolean notification, boolean validate, ArrayList<Shipment> shipments) {
        this.first_login = first_login;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.street = street;
        this.num = num;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.token = token;
        this.notification = notification;
        this.validate = validate;
        this.shipments = shipments;
    }

    //GETTERS AND SETTERS


    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public boolean isFirst_login() {
        return first_login;
    }

    public void setFirst_login(boolean first_login) {
        this.first_login = first_login;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
    }


    //MÉTODOS


    /*Este método cuenta los pedidos que quedan pendientes por ser entregados, devuelve un contador con la cantidad de los envios*/
    /*This method counts the orders that are pending to be delivered, returns a counter with the quantity of shipments*/
    public int numDeliveriesPendingToDeliver() {
        int shipmentDeliverPending = 0;
        for (Shipment s:
             shipments) {

            if (s != null && s.getIdSender() != this.id && !s.getStatus().equals("4")) shipmentDeliverPending++;
        }
        return shipmentDeliverPending;
    }

    /*Este método busca los envios según el id que nos pasen por teclado, al final, si lo encuentra, devuelve el objeto Shipment*/
    /*This method searches for the shipments according to the id that is passed to us on the keyboard,
    at the end, if it finds it, it returns the Shipment object*/
    public Shipment searchDeliveryById(int id){
        if (shipments.isEmpty()) return null;
        else {
            for (Shipment s:
                 shipments) {
                if (s != null && s.getId() == id) return s;
            }
        }
        return null;
    }

    /*Este método junta los atributos, street, num, postalcode, city y state para crear un solo string con toda esa informacion*/
    /*This method brings together the attributes, street, num, postalcode, city and state to create a single string with all that information*/
    public String getAddress(){
        String results = "";
        results += street + ", " + num + ", " + postalCode + " " + city + "(" + state + ")";
        return results;
    }
    public boolean validarToken(int tokenIngresado) {
        // Verificar si el token ingresado coincide
        if (tokenIngresado == this.token) return true;
        return false;
    }

    @Override
    public String toString() {
        return "┌──. ■ .─────────────────────────────────────────────────────────┐\n" +
               "                    Informacion del usuario\n" +
               "└─────────────────────────────────────────────────────────. ■ .──┘\n" +
               "█  Número de referencia del usuario: " + id + "\n" +
               "█  Nombre: " + name + "\n" +
               "█  Apellidos: " + (surname.isEmpty() ? "No hay datos para mostrar" : surname) + "\n" +
               "█  Email: " + email + "\n" +
               "█  Número de teléfono: " + phone + "\n" +
               "█  Dirección: " + street + " " + num + ", " + city + ", " + state + "(" + postalCode + ")" + "\n" +
               "──────────────────────────────────────────────────────────. ■ .──";
    }

    public boolean checkPass(String pass) {
        String passMD = PersistenceData.getMD5(pass);
        return this.pass.equals(passMD);
    }

    public StringBuilder resumeForAdmin() {
        StringBuilder results = new StringBuilder();
        results.append("<div class='card-image'>")
                // Información restante que se muestra al hacer hover
                .append("<p class='text-title-hover'>Identificador: ").append("<p class='text-body'>").append(id).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Apellidos: ").append("<p class='text-body'>").append(surname).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Teléfono: ").append("<p class='text-body'>").append(phone).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Dirección: ").append("<p class='text-body'>").append(street).append(", ").append(city).append(" (").append(postalCode).append(")</p>").append("</p>")
                .append("<p class='text-title-hover'>¿Notificaciones? ").append("<p class='text-body'>").append(((notification) ? "Sí" : "No")).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>Envios pendientes: ").append("<p class='text-body'>").append(numDeliveriesPendingToDeliver()).append("</p>").append("</p>")
                .append("<p class='text-title-hover'>¿Cuenta validada? ").append("<p class='text-body'>")
                .append(((validate) ? "Realizada" : "No realizada")).append("</p>").append("</p>")
                .append("</div>")
                .append("<div class='card-description'>")
                // Solo la expedición del paquete y el título con el ID
                .append("<span class='text-title'>Nombre: ").append(name).append("</span>")
                .append("<p class='text-body'>Email: ").append(email).append("</p>")
                // Botón de "Más información"
                .append("<button class='info-button'>Más información</button>")
                .append("</div>");

        /*return "──────. ■ .──────────────────────────────────────────────────────\n" +
               "█  Número de referencia del usuario: " + id + "\n" +
               "█  Nombre y apellidos: " + name + " " + surname + "\n" +
               "█  Email: " + email + "\n" +
               "█  Validación de cuenta: " + ((validate) ? "Realizada" : "No realizada") + "\n" +
               "█  Recibe notificaciones: " + ((notification) ? "Sí" : "No") + "\n" +
               "█  Número de teléfono: " + phone + "\n" +
               "█  Dirección: " + street + " " + num + ", " + city + ", " + state + "(" + postalCode + ")" + "\n" +
               "█  Envíos pendientes de entrega: " + numDeliveriesPendingToDeliver() + "\n" +
               "──────────────────────────────────────────────────────────. ■ .──";*/
    return results;
    }

}
