package appcontroller;

import DAO.*;
import comunication.AsignacionCorreo;
import comunication.MensajeTelegram;
import comunication.Mensajes;
import models.*;
import persistence.Config;
import dataclass.InfoShipmentDataClass;
import persistence.PersistenceData;
import persistence.PersistenceDisk;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

public class AppController implements Serializable {

    private final DAOManager DAO;


    //CONSTRUCTOR

    public AppController() {
        DAO = DAOManager.getSinglentonInstance();
    }


    //METODOS


    /* Método que busca al usuario según el id que le pasen por teclado, si lo encuentra, devuelve al usuario
       Method that searches for the user according to the id that is passed to them on the keyboard, if it is found, it returns the user
     */
    public User searchUserById(int id) {
        try {
            DAO.open();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            User u = daoUserSQL.readById(id, DAO);
            return u;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /* Método que busca al usuario según el id que le pasen por teclado, si lo encuentra, devuelve al usuario
       Method that searches for the user according to the email that is passed to them on the keyboard, if it is found, it returns the user
     */
    public User searchUserByEmail(String email) {
        try {
            DAO.open();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            User u = daoUserSQL.readByEmail(email, DAO);
            return u;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*Método que busca un usuario y lo retorna si contiene el envio que le pasan por teclado*/
    /*Method that searches for a user and returns it if it contains the message that is passed through the keyboard*/
    public User searchUserByIdShipment(int idShipment) {
        try {
            DAO.open();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            User u = daoUserSQL.readByIdShipment(idShipment, DAO);
            DAO.close();
            return u;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*Añade un nuevo usuario a la lista del controlador, si la accion se ha realizado correctamente retorna true*/
    /*Adds a new user to the controller list, if the action has been performed correctly it returns true*/
    public boolean addUser(String name, String surname, String email, int phone, String pass, String street, int num, String city,
                           String state, int postalCode, int token, boolean notificate) {
        try {
            DAO.open();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            ArrayList<Shipment> shipments = daoShipmentSQL.readShipmentByEmailUser(email, DAO);
            boolean insert = daoUserSQL.insert(new User(false, uniqueUserId(), name, surname, email, pass, phone, street, num, city, state,
                    postalCode, token, notificate, false, shipments), DAO);
            DAO.close();
            return insert;
        } catch (Exception e) {
            return false;
        }
    }


    /*Método que sirve para asignar a un nuevo usuario un ID UNICO, si el número random
    asignado es igual a uno ya existente vuelve a crearlo hasta que este sea distinto de los que hay creados*/

    /*Method that is used to assign a UNIQUE ID to a new user, if the random number assigned
    is equal to an existing one, create it again until it is different from the ones that have been created*/

    private int uniqueUserId() {
        int idUnique;
        do {
            idUnique = (int) (Math.random() * 10000);
        } while (searchUserById(idUnique) != null);
        return idUnique;
    }

    /*Método que sirve para buscar en una lista de conductores un conductor usando su ID, si el ID es encontrado el
    método devuelve el conductor, en cambio, si no se encuentra el método devuelve null*/

    /*Method used to search a list of drivers for a driver using its ID, if the ID is found
    the method returns the driver, if not found the method returns null*/

    public Driver searchDriverById(int id) {
        try {
            DAO.open();
            DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
            Driver d = daoDriverSQL.readById(id, DAO);
            return d;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /*Método que sirve para buscar en una lista de conductores un conductor usando su EMAIL, si el EMAIL es encontrado el
    método devuelve el conductor, en cambio, si no se encuentra el método devuelve null*/

    /*Method used to search a list of drivers for a driver using its EMAIL, if the EMAIL is found
    the method returns the driver, if not found the method returns null*/
    public Driver searchDriverByEmail(String email) {
        try {
            DAO.open();
            DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
            Driver d = daoDriverSQL.readByEmail(email, DAO);
            return d;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /*Método que genera un ID único para cada conductor usando los números aleatorios, si el ID generado ya está siendo utilizado
    se vuelve a generar otro hasta que no coincida con ninguno anterior*/

    /*Method that generates a unique ID for each driver using the random numbers, if the generated ID is already in use,
    a new one is generated until it does not match any previous one*/
    private int uniqueDriverId() {
        int idUnique;
        do {
            idUnique = (int) (Math.random() * 10000);
        } while (searchDriverById(idUnique) != null);
        return idUnique;
    }

    /*Método que crea un nuevo objeto DRIVER con un ID único, nombre, email y contraseña, además lo agrega a
    la coleccion que administra los conductores del sistema*/

    /*Method that creates a new DRIVER object with a unique ID, name, email and password,
    and adds it to the collection that manages the system drivers*/
    public boolean addDriver(String name, String email, String pass) {
        try {
            DAO.open();
            DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
            boolean insert = daoDriverSQL.insert(new Driver(uniqueDriverId(), name, pass, email, false, null, null), DAO);
            DAO.close();
            return insert;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addAdmin(String name, String email, String pass) {
        try {
            DAO.open();
            DaoAdminSQL daoAdminSQL = new DaoAdminSQL();
            boolean insert = daoAdminSQL.insert(new Admin(uniqueIdAdmin(), name, pass, email), DAO);
            DAO.close();
            return insert;
        } catch (Exception e) {
            return false;
        }
    }

    private int uniqueIdAdmin() {
        int idUnique;
        int cont = 0;
        do {
            idUnique = cont;
            cont++;
        } while (searchAdminId(idUnique) != null);
        return idUnique;
    }

    private Admin searchAdminId(int idUnique) {
        try {
            DAO.open();
            DaoAdminSQL daoAdminSQL = new DaoAdminSQL();
            Admin a = daoAdminSQL.readById(idUnique, DAO);
            DAO.close();
            return a;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*Método que busca un envío en la colección por su ID, si lo encuentra lo retorna*/
    /*Method that searches for a consignment in the collection by its ID, if found it returns it*/

    public Shipment searchShipmentById(int id) {
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            Shipment s = daoShipmentSQL.readById(id, DAO);
            DAO.close();
            return s;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /*Método que tiene igual funcionamiento a searchShipmentByID pero con la condición que busca los envíos para usuarios
    que no han iniciado sesión*/

    /*Method that searches for a consignment in the collection by its ID, if found it returns it*/
    public InfoShipmentDataClass searchShipmentByIdNoLogin(int id) {
        InfoShipmentDataClass shipmentNoLogin = null;
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            Shipment s = daoShipmentSQL.readById(id, DAO);
            User userSender = daoUserSQL.readById(s.getIdSender(), DAO);
            shipmentNoLogin = new InfoShipmentDataClass(s.getId(), s.getCreateDate(), s.getExpectDate(), s.getDeliveryDate(), s.getAlternativePostalCode(), s.getStatus(),
                    userSender.getName(), s.getNameUserNoRegister(), s.getAlternativeAddress(), s.getAlternativeCity());
            DAO.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return shipmentNoLogin;
    }

    /*Método que genera un número aleatorio para el identificar un envío, lo crea utilizando los números aleatorios
    cada número generado pasa por una comprobación para ver que no está siendo utilizado ni por los métodos de
    searchShipmentById ni por el searchShipmentByIdNoLogin*/

    /*Method that generates a random number to identify a shipment, creates it using the random numbers
    Each number generated goes through a check to see that it is not being used by either the
    searchShipmentById or searchShipmentByIdNoLogin*/

    public int uniqueShipmentId() {
        int idUnique;
        do {
            idUnique = (int) (Math.random() * 10000);
        } while (searchShipmentById(idUnique) != null && searchShipmentByIdNoLogin(idUnique) != null);
        return idUnique;
    }


    /*Método para iniciar sesión, si el email y la contraseña introducidos encuentra una cuenta con esas credenciales devuelve el objeto
     * correspondiente, si no lo encuentra en ninguno de los arrays alojados en el controller devuelve null*/

    /* Method to log in, if the email and password entered finds an account with those credentials, it returns the object
  corresponding, if it is not found in any of the arrays hosted in the controller it returns null*/

    public Object login(String email, String pass) {
        try {
            DAO.open();
            DaoAdminSQL daoAdminSQL = new DaoAdminSQL();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
            Admin a = daoAdminSQL.readByEmailAndPass(email, pass, DAO);
            if (a != null) {
                PersistenceDisk.recordLogin(a, LocalDateTime.now());
                return a;
            }
            User u = daoUserSQL.readByEmailAndPass(email, pass, DAO);
            if (u != null) {
                PersistenceDisk.recordLogin(u, LocalDateTime.now());
                return u;
            }
            Driver d = daoDriverSQL.readByEmailAndPass(email, pass, DAO);
            if (d != null) {
                PersistenceDisk.recordLogin(d, LocalDateTime.now());
                return d;
            }
            DAO.close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /*Método que buca un usuario mediante su teléfono movil, si lo encuentra devuelve el usuario que lo contiene, sino devuelve null*/

    /*Method that searches for a user using their mobile phone, if it finds it, it returns the user that contains it, otherwise it returns null*/

    public User searchUserByPhone(int phone) {
        try {
            DAO.open();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            User u = daoUserSQL.readByPhone(phone, DAO);
            DAO.close();
            return u;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*Método que busca el mejor conductor de la zona especificada mediante el código postal*/
    /*Method that searches for the best driver in the area specified by  postal code*/

    public Driver searchBestDriverByPostalCode(int postalCode) {
        try {
            DAO.open();
            DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
            Driver d = daoDriverSQL.readByPostalCode(postalCode, DAO);
            return d;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*Método que devuelve un ArrayList del dataclass con información de los paquetes que faltan por asignar
     * este método lo utiliza solo el admin del programa para poder asignar paquetes a conductores*/
    /*Method that returns an ArrayList of the dataclass with information about the packages that remain to be assigned
     * this method is used only by the program admin to be able to assign packages to drivers*/

    public ArrayList<InfoShipmentDataClass> getShipmentsUnassigned() {
        DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
        DaoUserSQL daoUserSQL = new DaoUserSQL();
        ArrayList<InfoShipmentDataClass> resultsData = new ArrayList<>();
        try {
            DAO.open();
            ArrayList<Shipment> results = daoShipmentSQL.readShipmentUnassigned(DAO);
            for (Shipment s :
                    results) {
                User u = daoUserSQL.readById(s.getIdSender(), DAO);
                resultsData.add(new InfoShipmentDataClass(s.getId(),
                        s.getCreateDate(), s.getExpectDate(), s.getDeliveryDate(),
                        s.getAlternativePostalCode(), s.getStatus(),
                        u.getName(), s.getNameUserNoRegister(),
                        s.getAlternativeAddress(), s.getAlternativeCity()));
            }
            DAO.close();
            Collections.sort(resultsData);
            Collections.reverse(resultsData);
            return resultsData;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


    public ArrayList<InfoShipmentDataClass> getShipmentSendByUser(int idUser) {
        ArrayList<InfoShipmentDataClass> resultsData = new ArrayList<>();
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            ArrayList<Shipment> results = daoShipmentSQL.readShipmentByIdSender(idUser, DAO);
            for (Shipment s :
                    results) {
                User u = daoUserSQL.readById(s.getIdSender(), DAO);
                resultsData.add(new InfoShipmentDataClass(s.getId(),
                        s.getCreateDate(), s.getExpectDate(), s.getDeliveryDate(),
                        s.getAlternativePostalCode(), s.getStatus(),
                        u.getName(), s.getNameUserNoRegister(),
                        s.getAlternativeAddress(), s.getAlternativeCity()));
            }
            DAO.close();
            Collections.sort(resultsData);
            return resultsData;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


    /*Método que busca los envíos pendientes de un usuario específico, obtiene la información de cada envío pendiente, crea
    objetos InfoShipmentDataClass para representar los envíos con su información y devuelve una lista de estos objetos*/

    /*Method that searches for pending shipments for a specific user, obtains the information of each pending shipment,
    creates InfoShipmentDataClass objects to represent the shipments with their information and returns a list of these objects*/
    public ArrayList<InfoShipmentDataClass> getShipmentPendingsToUser(int idUser) {
        DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
        DaoUserSQL daoUserSQL = new DaoUserSQL();
        ArrayList<InfoShipmentDataClass> resultsData = new ArrayList<>();
        try {
            DAO.open();
            ArrayList<Shipment> results = daoShipmentSQL.readShipmentPendingsByUser(idUser, DAO);
            for (Shipment s :
                    results) {
                User u = daoUserSQL.readById(s.getIdSender(), DAO);
                resultsData.add(new InfoShipmentDataClass(s.getId(),
                        s.getCreateDate(), s.getExpectDate(), s.getDeliveryDate(),
                        s.getAlternativePostalCode(), s.getStatus(),
                        u.getName(), s.getNameUserNoRegister(),
                        s.getAlternativeAddress(), s.getAlternativeCity()));
            }
            DAO.close();
            Collections.sort(resultsData);
            return resultsData;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /*Método que busca los envíos pendientes de un conductor específico, obtiene la información de cada envío pendiente, crea
    objetos InfoShipmentDataClass para representar los envíos con su información y devuelve una lista de estos objetos*/

    /*Method that searches for pending shipments for a specific driver, obtains the information of each pending shipment,
    creates InfoShipmentDataClass objects to represent the shipments with their information and returns a list of these objects*/
    public ArrayList<InfoShipmentDataClass> getShipmentsPendingsDriver(int idDriver) {
        DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
        DaoUserSQL daoUserSQL = new DaoUserSQL();
        ArrayList<InfoShipmentDataClass> resultsData = new ArrayList<>();
        try {
            DAO.open();
            ArrayList<Shipment> results = daoShipmentSQL.readShipmentPendingsByDriver(idDriver, DAO);
            for (Shipment s :
                    results) {
                User u = daoUserSQL.readById(s.getIdSender(), DAO);
                resultsData.add(new InfoShipmentDataClass(s.getId(),
                        s.getCreateDate(), s.getExpectDate(), s.getDeliveryDate(),
                        s.getAlternativePostalCode(), s.getStatus(),
                        u.getName(), s.getNameUserNoRegister(),
                        s.getAlternativeAddress(), s.getAlternativeCity()));
            }
            DAO.close();
            Collections.sort(resultsData);
            return resultsData;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /*Método que indica la media de días que tardan los conductores en entregar los paquetes*/
    /*Method that indicates the average number of days it takes drivers to deliver packages*/

    public double numDaysToDeliver() {
        int contDelivery = 0;
        double results = 0, contDays = 0;
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            ArrayList<Shipment> shipments = daoShipmentSQL.readShipmentDelivered(DAO);
            for (Shipment s :
                    shipments) {
                contDelivery = shipments.size();
                contDays += s.getCreateDate().until(s.getDeliveryDate(), ChronoUnit.DAYS);
            }
            DAO.close();
            if (shipments.isEmpty()) return 2;
            if (contDelivery > 0) results = contDays / contDelivery;
            return results;
        } catch (Exception e) {
            return -1;
        }
    }


    /*Añade un envío si este no está asociado a ningun usuario, se añade a la lista de envios sin usuario del controlador, retorna el envio*/
    /*Adds a shipment if it is not associated with any user, it is added to the list of shipments without a controller user, returns the shipment*/
    public Shipment addShipmentToNoRegisterUser(String status, int idUser, String email, int postalCode, String name, int num, boolean notifications, String address, String city) {
        Shipment shipmentCreate = null;
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            Driver bestDriver = searchBestDriverByPostalCode(postalCode);
            int idShipment = uniqueShipmentId();
            shipmentCreate = new Shipment(idShipment, LocalDate.now(), LocalDate.now().plusDays(2), null, notifications, address, num, postalCode,
                    city, status, calculatedCost(postalCode), email, idUser, name);
            if (daoShipmentSQL.insert(shipmentCreate, -1, ((bestDriver != null) ? bestDriver.getId() : -1), DAO)) {
                shipmentCreate = daoShipmentSQL.readById(idShipment, DAO);
            }
            if (bestDriver != null) {
                MensajeTelegram.enviaMensajeTelegram(MensajeTelegram.mensajePredeterminado(shipmentCreate.getId(),
                        shipmentCreate.getStatus(), bestDriver.getName(), shipmentCreate.getExpectDate()));
            }
            DAO.close();
            return shipmentCreate;
        } catch (Exception e) {
            return null;
        }
    }

    /*Calcula el coste a pagar por el remitente sobre el paquete que quiere enviar, si el codigo postal está registrado en algun conductor
    el precio es más barato que si no hay ningun conductor que pueda enviarlo
     */
    /*Calculates the cost to be paid by the sender for the package he wants to send, if the postal code is registered in a driver
     the price is cheaper than if there is no driver who can send it
      */
    private double calculatedCost(int postalCode) {
        Driver bestDriver = searchBestDriverByPostalCode(postalCode);
        if (bestDriver != null) return 3.53;
        return 10.25;
    }

    /*Cambia la informacion de un envio seleccionado, cambia toda la direccion*/
    /*Change the information of a selected shipment, change the entire address*/
    public boolean changeDeliveryData(int idShipment, String address, int postalCode, String city) {
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            Shipment shipment = daoShipmentSQL.readById(idShipment, DAO);
            shipment.setAlternativeAddress(address);
            shipment.setAlternativePostalCode(postalCode);
            shipment.setAlternativeCity(city);
            PersistenceDisk.recordUpdateShipment(shipment, LocalDateTime.now());
            boolean change = daoShipmentSQL.updateAddress(shipment, DAO);
            DAO.close();
            return change;
        } catch (Exception e) {
            return false;
        }
    }

    private Driver searchDriverByIdShipment(int idShipment) {
        try {
            DAO.open();
            DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
            Driver driver = daoDriverSQL.readByIdShipment(idShipment, DAO);
            DAO.close();
            return driver;
        } catch (Exception e) {
            return null;
        }
    }

    /*Obtiene todos los envios que ha entregado el conductor que se indica por teclado*/
    /*Obtains all the shipments that the driver indicated on the keyboard has delivered*/
    public ArrayList<InfoShipmentDataClass> getShipmentsFinishedDriver(int idDriver) {
        ArrayList<InfoShipmentDataClass> resultsData = new ArrayList<>();
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            ArrayList<Shipment> results = daoShipmentSQL.readShipmentDeliveredByDriver(idDriver, DAO);
            for (Shipment s :
                    results) {
                User u = daoUserSQL.readById(s.getIdSender(), DAO);
                resultsData.add(new InfoShipmentDataClass(s.getId(),
                        s.getCreateDate(), s.getExpectDate(), s.getDeliveryDate(),
                        s.getAlternativePostalCode(), s.getStatus(),
                        u.getName(), s.getNameUserNoRegister(),
                        s.getAlternativeAddress(), s.getAlternativeCity()));
            }
            DAO.close();
            Collections.sort(resultsData);
            return resultsData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*Cambia el estado del envio al indicado por teclado y al envio seleccionado*/
    /*Change the status of the shipment to the one indicated by keyboard and to the selected shipment*/
    public void changeDeliveryStatus(String newStatus, int id) {
        Shipment shipmentSelect = searchShipmentById(id);
        if (shipmentSelect != null) {
            shipmentSelect.setStatus(newStatus);
            shipmentSelect.setDeliveryDate(LocalDate.now());
            try {
                DAO.open();
                DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
                daoShipmentSQL.updateStatusShipment(shipmentSelect, DAO);
                DAO.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    /*Añade un envio y comprueba si el usuario remitente y el
    destinatario existen en la plataforma, para guardarlo dentro de la informacion de cada uno*/
    /*Add a shipment and check if the sender and recipient users exist on the platform, to save it within each one's information*/

    public Shipment addShipment(int idSender, int idReciever, boolean notifications) {
        User reciever = searchUserById(idReciever);
        Driver d = searchBestDriverByPostalCode(reciever.getPostalCode());
        try {
            DAO.open();
            Shipment shipmentCreate = new Shipment(uniqueShipmentId(), LocalDate.now(), LocalDate.now().plusDays(2), null, notifications,
                    reciever.getStreet(), reciever.getNum(), reciever.getPostalCode(), reciever.getCity(),
                    "1", calculatedCost(reciever.getPostalCode()), reciever.getEmail(), idSender, reciever.getName());
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            daoShipmentSQL.insert(shipmentCreate, idReciever, ((d == null) ? -1 : d.getId()), DAO);
            DAO.close();
            return shipmentCreate;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /*Añade una zona de entrega al conductor que se elija por teclado*/
    /*Adds a delivery area to the driver chosen by keyboard*/
    public boolean addZoneToDriver(int idDriver, int newPostalCode) {
        Driver driverFind = searchDriverById(idDriver);
        boolean insert = false;
        if (driverFind != null) {
            try {
                DAO.open();
                DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
                insert = daoDriverSQL.insertZoneDelivery(driverFind, newPostalCode, DAO);
                DAO.close();
            } catch (Exception e) {
                return false;
            }

        }
        return insert;
    }



    /*Obtiene el número de envios que ha creado un usuario, si el id del usuario está registrado en los envios
     * devuelve la informacion completa del envio en un arraylist, si ocurre algún problema devuelve -1 indicando
     * que ha ocurrido una excepcion*/
    public int getNumShipmentsMadeByUser(int idUser) {
        ArrayList<Shipment> shipmentsCreate;
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            shipmentsCreate = daoShipmentSQL.readShipmentByIdSender(idUser, DAO);
            DAO.close();
            return shipmentsCreate.size();
        } catch (Exception e) {
            return -1;
        }


    }

    //METODOS AÑADIDOS POR MI

    public void findShipmentCreateUser(User u) {
        ArrayList<Shipment> shipmentsFind;
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            shipmentsFind = daoShipmentSQL.readShipmentByEmailUser(u.getEmail(), DAO);
            if (!shipmentsFind.isEmpty()) {
                for (Shipment s :
                        shipmentsFind) {
                    if (s != null) daoShipmentSQL.updateIdReciever(u.getId(), s.getId(), DAO);
                }
            }
            DAO.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*Método que nos muestra cuantos usuarios están registrados o almacenados en el sistema*/

    /*Method that shows how many users are registered or stored in the system.*/
    public int numUsers() {
        try {
            DAO.open();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            ArrayList<User> usersAll = daoUserSQL.readAll(DAO);
            DAO.close();
            return usersAll.size();
        } catch (Exception e) {
            return -1;
        }

    }

    /*Método que nos muestra cuantos conductores están registrados o almacenados en el sistema*/

    /*Method that shows how many drivers are registered or stored in the system.*/
    public int numDrivers() {
        try {
            DAO.open();
            DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
            ArrayList<Driver> driversAll = daoDriverSQL.readAll(DAO);
            DAO.close();
            return driversAll.size();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*Método que nos muestra el numero de envios pendientes
    Method that shows us the number of pending shipments*/
    public int numShipmentsPendings() {
        ArrayList<Shipment> shipmentsPendings = new ArrayList<>();
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            shipmentsPendings = daoShipmentSQL.readAllShipmentPendings(DAO);
            DAO.close();
        } catch (Exception e) {
            return -1;
        }
        return shipmentsPendings.size();

    }


    /*Método que nos muestra el numero de envios por asignar
    Method showing the number of consignments to be assigned*/
    public int numShipmentsToAssing() {
        ArrayList<Shipment> shipmentsToAssing;
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            shipmentsToAssing = daoShipmentSQL.readAllShipmentUnassigned(DAO);
            DAO.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return shipmentsToAssing.size();

    }


    /*Método que nos muestra cuantos envios están actualmente asociados a usuarios no registrados
    Method that shows us how many shipments are currently associated with unregistered users*/
    public int numShipmentsToNoUserRegister() {
        ArrayList<Shipment> shipmentsToNoUser;
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            shipmentsToNoUser = daoShipmentSQL.readAllShipmentNoUser(DAO);
            DAO.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return shipmentsToNoUser.size();
    }

    public boolean addShipmentDriver(int idShipment, int idDriver) {
        Driver d = searchDriverById(idDriver);
        Shipment s = searchShipmentById(idShipment);
        if (d != null && s != null) {
            updateShipmentDriver(s, idDriver);
            try {
                MensajeTelegram.enviaMensajeTelegram(MensajeTelegram.mensajePredeterminado(s.getId(), s.getStatus(), d.getName(), s.getExpectDate()));
            } catch (IOException e) {
                return false;
            }
            return true;
        }
        return false;
    }

    private void updateShipmentDriver(Shipment s, int idDriver) {
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            daoShipmentSQL.updateIdDriver(s, idDriver, DAO);
            DAO.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void closeLogin(Object user) {
        if (user instanceof User) {
            PersistenceDisk.closeRegister(((User) user).getName(), "usuario", LocalDateTime.now());
            Config.updateLastLogin(String.valueOf(((User) user).getId()), LocalDateTime.now());
        }
        if (user instanceof Driver) {
            PersistenceDisk.closeRegister(((Driver) user).getName(), "conductor", LocalDateTime.now());
            Config.updateLastLogin(String.valueOf(((Driver) user).getId()), LocalDateTime.now());
        }
        if (user instanceof Admin) {
            PersistenceDisk.closeRegister(((Admin) user).getName(), "admin", LocalDateTime.now());
            Config.updateLastLogin(String.valueOf(((Admin) user).getId()), LocalDateTime.now());
        }
    }

    /*Busca a un admin según el email de este, si lo encuentra, retorna el objeto de la clase Admin encontrado*/
    public Admin searchAdminByEmail(String emailAdmin) {
        try {
            DAO.open();
            DaoAdminSQL daoAdminSQL = new DaoAdminSQL();
            return daoAdminSQL.readByEmail(emailAdmin, DAO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void recordLogin(User userUse, LocalDateTime fecha) {
        PersistenceDisk.recordLogin(userUse, fecha);
    }

    /*Aqui le pasamos un objeto, miramos dentro qué tipo de objeto es y dependiendo de cual sea guardamos su id en una variable
    para luego pasarla a un metodo de la clase Config y modificar el fichero properties para guardar la información
    del ultimo inicio de sesión de los usuarios
     */
    public String getLastLogin(Object user) {
        String id = "";
        if (user instanceof User) id = String.valueOf(((User) user).getId());
        if (user instanceof Driver) id = String.valueOf(((Driver) user).getId());
        if (user instanceof Admin) id = String.valueOf(((Admin) user).getId());
        return Config.getLastLogin(id);
    }

    /* Método que retorna true si el fichero pdf ha sido creado con exito
    de no ser así retorna false*/
    public String createPdf(Shipment shipment, User user) {
        return PersistenceData.recordPdf(shipment, user);
    }


    /*Este método busca en todas las listas de envios, todos los envíos, obviando los repetidos (ya que a la hora de recuperar informacion
    con los ficheros, la referencia no se ejecuta) una vez que termina retorna un Arraylist con todos los envíos*/
    private ArrayList<Shipment> allShipments() {
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            ArrayList<Shipment> allShipments = daoShipmentSQL.readAll(DAO);
            DAO.close();
            return allShipments;
        } catch (Exception e) {
            return null;
        }

    }

    /*En este método se crea un arraylist y en él se meten todos los envios que no están repetidos
     * y que se han creado nuevos, revisando todas las listas que contengan pedidos para luego pasar la información a un
     * metodo dentro de persistencia, este grabará el archivo excel y retornará true si el archivo se ha creado con exito y false si
     * no ha sido así
     * Una vez retorne true, se procederá a enviar un correo al administrador principal del programa, pasandole el nombre del archivo
     * el email del administrador un asunto y un mensaje*/
    public boolean sendExcel(Admin admin) {
        ArrayList<Shipment> s = allShipments();
        if (PersistenceData.recordExcel(s)) {
            Mensajes.enviarMensaje(admin.getEmail(), "listado de envios",
                    "Este es el listado de los paquetes", "listadoEnvios.xls");
            return true;
        }
        return false;
    }

    public ArrayList<String> getInfoProperties() {
        ArrayList<String> info = Config.getInfo();
        ArrayList<String> modificado;
        if (info == null) return null;
        else {
            modificado = reemplazarCaracter(info);
            return modificado;
        }
    }

    private ArrayList<String> reemplazarCaracter(ArrayList<String> info) {
        ArrayList<String> sinIgual = new ArrayList<>();
        String result;
        for (String s :
                info) {
            if (s.contains("=")) {
                result = s.replace("=", ": ");
                sinIgual.add(result);
            }
        }
        return sinIgual;
    }

    public boolean changeInvitedMode(String respuesta) {
        if (respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("n")) {
            return Config.changeProperties(respuesta);
        } else return false;
    }

    public void sendEmail(Shipment shipment, User user, String nombreArchivo, boolean notification) {
        if (notification)
            Mensajes.enviarMensaje(shipment.getEmailUserNoRegister(), "Asignación de envío", AsignacionCorreo.plantillaAsignacion(shipment.getNameUserNoRegister(), shipment.getExpectDate(),
                    shipment.getStatus(), shipment.getAlternativeAddress(), shipment.getAlternativeCity(), user.getName(), shipment.getNameUserNoRegister()), null);
        Mensajes.enviarMensaje(user.getEmail(), "Creación de envío y factura", AsignacionCorreo.plantillaAsignacion(shipment.getNameUserNoRegister(), shipment.getExpectDate(),
                shipment.getStatus(), shipment.getAlternativeAddress(), shipment.getAlternativeCity(), user.getName(), shipment.getNameUserNoRegister()), nombreArchivo);
    }


    public ArrayList<User> getUsers() {
        ArrayList<User> users;
        try {
            DAO.open();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            users = daoUserSQL.readAll(DAO);
            DAO.close();
            return users;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Driver> getDrivers() {
        ArrayList<Driver> drivers;
        try {
            DAO.open();
            DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
            drivers = daoDriverSQL.readAll(DAO);
            DAO.close();
            return drivers;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean updateUser(Object user) {
        DaoUserSQL daoUserSQL = new DaoUserSQL();
        DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
        DaoAdminSQL daoAdminSQL = new DaoAdminSQL();
        try {
            DAO.open();
            if (user instanceof User) return daoUserSQL.update((User) user, DAO);
            if (user instanceof Driver) return daoDriverSQL.update((Driver) user, DAO);
            if (user instanceof Admin) return daoAdminSQL.update((Admin) user, DAO);
            DAO.close();
        } catch (Exception e) {
            return false;
        }
        return false;
    }


    public ArrayList<Shipment> searchShipmentByEmail(String email) {
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            ArrayList<Shipment> shipmentsFind = daoShipmentSQL.readShipmentByEmailUser(email, DAO);
            DAO.close();
            return shipmentsFind;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User validateAccountToken(int token){
        User user;
        try {
            DAO.open();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            user = daoUserSQL.readByToken(token, DAO);
            if (user != null) {
                user.setValidate(true);
                if (updateUser(user)) return user;
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        return null;

    }

    public User createAccountShippingInfo(String email, String pass, int phone, int token, String state) {
        ArrayList<Shipment> shipmentsFind = searchShipmentByEmail(email);
        Shipment shipmentInfo;
        if (!shipmentsFind.isEmpty()) {
            shipmentInfo = shipmentsFind.get(0);
            addUser(shipmentInfo.getNameUserNoRegister(), "", shipmentInfo.getEmailUserNoRegister(), phone, pass,
                    shipmentInfo.getAlternativeAddress(), shipmentInfo.getNumAlternative(), shipmentInfo.getAlternativeCity(), state, shipmentInfo.getAlternativePostalCode(),
                    token, shipmentInfo.isNotifications());
            User userFind = searchUserByEmail(email);
            userFind.setShipments(shipmentsFind);
            findShipmentCreateUser(userFind);
            return userFind;
        }
        return null;
    }

    public ArrayList<InfoShipmentDataClass> getShipmentsFinishedUser(int id) {
        ArrayList<InfoShipmentDataClass> resultsData = new ArrayList<>();
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            ArrayList<Shipment> results = daoShipmentSQL.readShipmentDeliveredByUser(id, DAO);
            for (Shipment s :
                    results) {
                User u = daoUserSQL.readById(s.getIdSender(), DAO);
                resultsData.add(new InfoShipmentDataClass(s.getId(),
                        s.getCreateDate(), s.getExpectDate(), s.getDeliveryDate(),
                        s.getAlternativePostalCode(), s.getStatus(),
                        u.getName(), s.getNameUserNoRegister(),
                        s.getAlternativeAddress(), s.getAlternativeCity()));
            }
            DAO.close();
            Collections.sort(resultsData);
            return resultsData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveBackup(String ruta) {
        try {
            DAO.open();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
            DaoAdminSQL daoAdminSQL = new DaoAdminSQL();
            ArrayList<User> users = daoUserSQL.readAll(DAO);
            ArrayList<Shipment> shipments = daoShipmentSQL.readAll(DAO);
            ArrayList<Driver> drivers = daoDriverSQL.readAll(DAO);
            ArrayList<Admin> admins = daoAdminSQL.readAll(DAO);
            DAO.close();
            return PersistenceDisk.guardaBackup(ruta, users, admins, drivers, shipments);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean restoreBackup(String ruta) {
        deleteDataBase();
        File pathData = new File(System.getProperty("user.home") + ruta);
        if (!pathData.exists()) return false;
        ArrayList<User> usersTemp = PersistenceDisk.restoreUsers(ruta);
        ArrayList<Driver> driversTemp = PersistenceDisk.restoreDrivers(ruta);
        ArrayList<Shipment> shipmentsTemp = PersistenceDisk.restoreShipments(ruta);
        try {
            DAO.open();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            restoreUsers(usersTemp);
            restoreDrivers(driversTemp, shipmentsTemp);
            ArrayList<Shipment> newShipments = new ArrayList<>();
            for (Shipment s : shipmentsTemp) {
                if (daoShipmentSQL.readById(s.getId(), DAO) == null) {
                    newShipments.add(s);
                }
            }
            if (!newShipments.isEmpty()) {
                for (Shipment s :
                        newShipments) {
                    daoShipmentSQL.insert(s, -1, -1, DAO);
                }
            }
            DAO.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private void restoreUsers(ArrayList<User> usersTemp) {
        try {
            DAO.open();
            DaoUserSQL daoUserSQL = new DaoUserSQL();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            if (!usersTemp.isEmpty()) {
                for (User u :
                        usersTemp) {
                    daoUserSQL.insert(u, DAO);
                    for (Shipment s :
                            u.getShipments()) {
                        if (s.getEmailUserNoRegister().equals(u.getEmail())) {
                            daoShipmentSQL.insert(s, u.getId(), -1, DAO);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private void restoreDrivers(ArrayList<Driver> driversTemp, ArrayList<Shipment> shipments) {
        try {
            DAO.open();
            DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
            DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
            if (!driversTemp.isEmpty()) {
                for (Driver d :
                        driversTemp) {
                    daoDriverSQL.insert(d, DAO);
                    for (Shipment w :
                            d.getShipments()) {
                        if (daoShipmentSQL.readById(w.getId(), DAO) == null) {
                            daoShipmentSQL.insert(w, -1, d.getId(), DAO);
                        } else daoShipmentSQL.updateIdDriver(w, d.getId(), DAO);
                    }
                    for (Integer i :
                            d.getDeliveryZones()) {
                        if (i != null) daoDriverSQL.insertZoneDelivery(d, i, DAO);
                    }
                }
            }
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private void deleteDataBase() {
        try {
            DAO.open();
            PersistenceDisk.eliminarDatos(DAO);
            DAO.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean updatePass(Object user) {
        DaoUserSQL daoUserSQL = new DaoUserSQL();
        DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
        DaoAdminSQL daoAdminSQL = new DaoAdminSQL();
        try {
            DAO.open();
            if (user instanceof User) {
                String passMD = PersistenceData.getMD5(((User) user).getPass());
                ((User) user).setPass(passMD);
                return daoUserSQL.update((User) user, DAO);
            }
            if (user instanceof Driver) {
                String passMD = PersistenceData.getMD5(((Driver) user).getPass());
                ((Driver) user).setPass(passMD);
                return daoDriverSQL.update((Driver) user, DAO);
            }
            if (user instanceof Admin) {
                String passMD = PersistenceData.getMD5(((Admin) user).getPass());
                ((Admin) user).setPass(passMD);
                return daoAdminSQL.update((Admin) user, DAO);
            }
            DAO.close();
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /*MÉTODOS PARA AÑADIR MENSAJERIA ENTRE USUARIO Y CONDUCTOR*/

    public boolean newMessage(String text, int idSender, int idReceiver, int idPackage){
        boolean send = false;
        try {
            DAO.open();
            DaoMessageSQL daoMessageSQL = new DaoMessageSQL();
            send = daoMessageSQL.insert(new Message(generateIdMessage(), idReceiver, idSender, idPackage, text), DAO);
            DAO.close();
        } catch (Exception e) {
            return false;
        }

        return send;
    }

    public ArrayList<Message> messagesForPackage(int idSender, int idReceiver, int idPackage){
        ArrayList<Message> messages;
        try {
            DAO.open();
            DaoMessageSQL daoMessageSQL = new DaoMessageSQL();
            messages = daoMessageSQL.readByIdPackage(idSender, idReceiver, idPackage, DAO);
            DAO.close();
        } catch (Exception e) {
            return null;
        }
        return messages;
    }

    public boolean deleteMessageSender(int idMessage) {
        boolean delete = false;
        Message message = searchMessageById(idMessage);
        if (message != null) {
        try {
            DAO.open();
            DaoMessageSQL daoMessageSQL = new DaoMessageSQL();
            delete = daoMessageSQL.deleteSender(message, DAO);
            DAO.close();
        }catch (Exception e) {
            return false;
        }
    }
        return delete;
    }

    public boolean deleteMessageReciever(int idMessage) {
        boolean delete = false;
        Message message = searchMessageById(idMessage);
        if (message != null) {
            try {
                DAO.open();
                DaoMessageSQL daoMessageSQL = new DaoMessageSQL();
                delete = daoMessageSQL.deleteReceiver(message, DAO);
                DAO.close();
            }catch (Exception e) {
                return false;
            }
        }
        return delete;
    }

    public boolean editMessageSend(int idSender, int idMessage, int idPackage, String text){
        boolean edit = false;
        try {
            DAO.open();
            DaoMessageSQL daoMessageSQL = new DaoMessageSQL();
            Message message = daoMessageSQL.searchMessageByEdit(idMessage, idSender, idPackage, DAO);
            if (message != null) {
                message.setEdit(true);
                message.setMessage(text);
                edit = daoMessageSQL.update(message, DAO);
            }
            DAO.close();
        } catch (Exception e) {
            return false;
        }
        return edit;
    }

    public int generateIdMessage(){
        int idUnique;
        do {
            idUnique = (int) (Math.random() * 10000);
        } while (searchMessageById(idUnique) != null);
        return idUnique;
    }

    private Message searchMessageById(int idUnique) {
        Message message;
        try {
            DAO.open();
            DaoMessageSQL daoMessageSQL = new DaoMessageSQL();
            message = daoMessageSQL.readById(idUnique, DAO);
            DAO.close();
        } catch (Exception e) {
            return null;
        }

        return message;
    }

    public ArrayList<Message> messageForPackageUser(int idUser) {
        ArrayList<Message> messages;
        try {
            DAO.open();
            DaoMessageSQL daoMessageSQL = new DaoMessageSQL();
            messages = daoMessageSQL.searchMessageByIdUser(idUser, DAO);
            DAO.close();
        } catch (Exception e) {
            return null;
        }
        return messages;

    }


    /*public ArrayList<Message> messageForPackageDriver(int id) {
        ArrayList<Message> messages;
        try {
            DAO.open();
            DaoMessageSQL daoMessageSQL = new DaoMessageSQL();
            messages = daoMessageSQL.searchMessageByIdDriver(id, DAO);
            DAO.close();
        } catch (Exception e) {
            return null;
        }
        return messages;
    }*/
}
