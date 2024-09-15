package DAO;

import models.Admin;

import java.util.ArrayList;

public interface DaoAdmin {
    boolean insert(Admin admin, DAOManager dao);
    boolean update(Admin admin, DAOManager dao);
    boolean deleteAll(DAOManager dao);
    Admin readById(int id, DAOManager dao);
    Admin readByEmail(String email, DAOManager dao);
    Admin readByEmailAndPass(String email, String pass, DAOManager dao);
    ArrayList<Admin> readAll(DAOManager dao);
}
