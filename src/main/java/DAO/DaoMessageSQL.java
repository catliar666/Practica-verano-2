package DAO;

import models.Message;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DaoMessageSQL implements DaoMessage {
    @Override
    public boolean insert(Message message, DAOManager dao) {
        String sentencia;
        sentencia = "INSERT INTO message VALUES (" + message.getId() +
                    ", " + message.getIdPackage() +
                    "," + message.getIdReceiver() +
                    "," + message.getIdSender() +
                    ",'" + message.getMessage() +
                    "','" + message.getDateSend() +
                    "'," + message.isView() +
                    "," + message.isEdit() +
                    "," + message.isDeleteSender() +
                    "," + message.isDeleteReciever() +");";
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(Message message, DAOManager dao) {
        String sentencia;
        sentencia = "UPDATE message SET idPackage = " + message.getIdPackage() +
                    ", idReciever = " + message.getIdReceiver() +
                    ", idSender = " + message.getIdSender() +
                    ", message = '" + message.getMessage() +
                    "', dateSend = '" + message.getDateSend() +
                    "', view = " + message.isView() +
                    ", edit = " + message.isEdit() +
                    ", deleteSender = " + message.isDeleteSender() +
                    ", deleteReciever = " + message.isDeleteReciever() +
                    " WHERE id = " + message.getId();  // Espacio añadido aquí

        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean deleteSender(Message message, DAOManager dao) {
        String sentencia;
        sentencia = "UPDATE message SET deleteSender = TRUE WHERE id = " + message.getId() +
                    "AND idSender = " + message.getIdSender();
        try (Statement stmt = dao.getConn().createStatement()){
            stmt.execute(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean deleteReceiver(Message message, DAOManager dao) {
        String sentencia;
        sentencia = "UPDATE message SET deleteSender = TRUE WHERE id = " + message.getId() +
                    "AND idReciever = " + message.getIdReceiver();
        try (Statement stmt = dao.getConn().createStatement()){
            stmt.execute(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean messageView(Message message, DAOManager dao) {
        String sentencia;
        sentencia = "UPDATE message SET view = TRUE WHERE id = " + message.getId() +
                    "AND idReciever = " + message.getIdReceiver();
        try (Statement stmt = dao.getConn().createStatement()){
            stmt.execute(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


    @Override
    public Message readById(int id, DAOManager dao) {
        Message message = null;
        String sentencia;
        sentencia = "SELECT * FROM message WHERE id = ?";
        try(PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDateTime fecha = null;
                    Timestamp timestamp = rs.getTimestamp("dateSend");

                    if (timestamp != null) {
                        fecha = timestamp.toLocalDateTime();
                    }
                    message = new Message(rs.getInt("id"),
                            rs.getInt("idReciever"),
                            rs.getInt("idSender"),
                            rs.getInt("idPackage"),
                            rs.getString("message"),
                            fecha,
                            rs.getBoolean("view"),
                            rs.getBoolean("edit"),
                            rs.getBoolean("deleteSender"),
                            rs.getBoolean("deleteReciever"));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return message;
    }

    @Override
    public Message searchMessageByEdit(int idSender, int idPackage, int idMessage, DAOManager dao) {
        Message message = null;
        String sentencie;
        sentencie = "SELECT * FROM message WHERE idSender = ? AND idPackage = ? AND idMessage = ?";
        try(PreparedStatement ps = dao.getConn().prepareStatement(sentencie)) {
            ps.setInt(1, idSender);
            ps.setInt(2, idSender);
            ps.setInt(3, idSender);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDateTime fecha = null;
                    Timestamp timestamp = rs.getTimestamp("dateSend");

                    if (timestamp != null) {
                        fecha = timestamp.toLocalDateTime();
                    }
                    message = new Message(rs.getInt("id"),
                            rs.getInt("idReciever"),
                            rs.getInt("idSender"),
                            rs.getInt("idPackage"),
                            rs.getString("message"),
                            fecha,
                            rs.getBoolean("view"),
                            rs.getBoolean("edit"),
                            rs.getBoolean("deleteSender"),
                            rs.getBoolean("deleteReciever"));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return message;

    }

    @Override
    public ArrayList<Message> readByIdPackage(int idSender, int idReceiver, int idPackage, DAOManager dao) {
        ArrayList<Message> messages = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM message WHERE idSender = ?";
        try(PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, idSender);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDateTime fecha = null;
                    Timestamp timestamp = rs.getTimestamp("dateSend");

                    if (timestamp != null) {
                        fecha = timestamp.toLocalDateTime();
                    }
                    messages.add(new Message(rs.getInt("id"),
                            rs.getInt("idReciever"),
                            rs.getInt("idSender"),
                            rs.getInt("idPackage"),
                            rs.getString("message"),
                            fecha,
                            rs.getBoolean("view"),
                            rs.getBoolean("edit"),
                            rs.getBoolean("deleteSender"),
                            rs.getBoolean("deleteReciever")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return messages;
    }

    @Override
    public ArrayList<Message> readNotView(int idUser, DAOManager dao) {
        ArrayList<Message> messages = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM message WHERE view IS NOT TRUE AND idReciever = ?";
        try(PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, idUser);
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDateTime fecha = null;
                    Timestamp timestamp = rs.getTimestamp("dateSend");

                    if (timestamp != null) {
                        fecha = timestamp.toLocalDateTime();
                    }
                    messages.add(new Message(rs.getInt("id"),
                            rs.getInt("idReciever"),
                            rs.getInt("idSender"),
                            rs.getInt("idPackage"),
                            rs.getString("message"),
                            fecha,
                            rs.getBoolean("view"),
                            rs.getBoolean("edit"),
                            rs.getBoolean("deleteSender"),
                            rs.getBoolean("deleteReciever")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return messages;
    }

    @Override
    public ArrayList<Message> searchMessageByIdUser(int idUser, DAOManager dao) {
        ArrayList<Message> messages = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM message WHERE idReciever = ? OR idSender = ?";
        try(PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, idUser);
            ps.setInt(2, idUser);
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDateTime fecha = null;
                    Timestamp timestamp = rs.getTimestamp("dateSend");

                    if (timestamp != null) {
                        fecha = timestamp.toLocalDateTime();
                    }
                    messages.add(new Message(rs.getInt("id"),
                            rs.getInt("idReciever"),
                            rs.getInt("idSender"),
                            rs.getInt("idPackage"),
                            rs.getString("message"),
                            fecha,
                            rs.getBoolean("view"),
                            rs.getBoolean("edit"),
                            rs.getBoolean("deleteSender"),
                            rs.getBoolean("deleteReciever")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return messages;
    }


}
