package DAO;

import models.Shipment;

import java.util.ArrayList;

public interface DaoShipment {

    boolean insert(Shipment shipment, int idReciever, int idDriver, DAOManager dao);
    boolean deleteAll(DAOManager dao);
    boolean updateIdDriver(Shipment s, int idDriver, DAOManager dao);
    boolean updateStatusShipment(Shipment shipment, DAOManager dao);
    boolean updateAddress(Shipment shipment, DAOManager dao);
    ArrayList<Shipment> readAll(DAOManager dao);
    Shipment readById(int id, DAOManager dao);

    ArrayList<Shipment> readShipmentByIdSender(int idUser, DAOManager dao);
    ArrayList<Shipment> readShipmentByIdReciever(int idUser, DAOManager dao);

    ArrayList<Shipment> readShipmentPendingsByUser(int idUser, DAOManager dao);

    ArrayList<Shipment> readShipmentPendingsByDriver(int idDriver, DAOManager dao);

    ArrayList<Shipment> readShipmentDelivered(DAOManager dao);

    ArrayList<Shipment> readShipmentDeliveredByDriver(int idDriver, DAOManager dao);

    ArrayList<Shipment> readAllShipmentUnassigned(DAOManager dao);

    ArrayList<Shipment> readAllShipmentNoUser(DAOManager dao);

    ArrayList<Shipment> readShipmentByEmailUser(String email, DAOManager dao);

    void updateIdReciever(int id, int idShipment, DAOManager dao);


    ArrayList<Shipment> readAllShipmentDriver(int id, DAOManager dao);

    ArrayList<Shipment> readAllShipmentUserById(int id, DAOManager dao);


    ArrayList<Shipment> readShipmentDeliveredByUser(int id, DAOManager dao);

}
