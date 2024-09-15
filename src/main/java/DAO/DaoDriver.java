package DAO;

import models.Admin;
import models.Driver;

import java.util.ArrayList;

public interface DaoDriver {
    boolean insert(Driver driver, DAOManager dao);
    boolean update(Driver driver, DAOManager dao);
    boolean deleteAll(DAOManager dao);
    Driver readById(int id, DAOManager dao);
    ArrayList<Driver> readAll(DAOManager dao);
    Driver readByEmail(String email, DAOManager dao);
    Driver readByIdShipment(int id, DAOManager dao);
    Driver readByEmailAndPass(String email, String pass, DAOManager dao);

    Driver readByPostalCode(int postalCode, DAOManager dao);

    boolean insertZoneDelivery(Driver driverFind, int newPostalCode, DAOManager dao);
}
