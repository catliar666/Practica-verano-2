package DAO;

import models.Admin;
import models.User;

import java.util.ArrayList;

public interface DaoUser {
    boolean insert(User user, DAOManager dao);
    boolean update(User user, DAOManager dao);
    boolean deleteAll (DAOManager dao);
    User readById(int id, DAOManager dao);
    User readByEmail(String email, DAOManager dao);
    User readByEmailAndPass(String email, String pass, DAOManager dao);

    User readByIdShipment(int idShipment, DAOManager dao);

    User readByPhone(int phone, DAOManager dao);
    User readByToken(int token, DAOManager dao);

    ArrayList<User> readAll(DAOManager dao);
}
