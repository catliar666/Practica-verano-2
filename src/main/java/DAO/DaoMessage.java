package DAO;

import models.Message;

import java.util.ArrayList;

public interface DaoMessage {
    boolean insert(Message message, DAOManager dao);
    boolean update(Message message, DAOManager dao);
    boolean deleteSender(Message message, DAOManager dao);
    boolean deleteReceiver(Message message, DAOManager dao);
    boolean messageView(Message message, DAOManager dao);
    Message readById(int id, DAOManager dao);
    Message searchMessageByEdit(int idSender, int idPackage, int idMessage, DAOManager dao);
    ArrayList<Message> readByIdPackage(int idSender, int idReceiver, int idPackage, DAOManager dao);
    ArrayList<Message> readNotView(int idUser, DAOManager dao);
    ArrayList<Message> searchMessageByIdUser(int idUser, DAOManager dao);
}
