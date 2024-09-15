package DAO;

import models.Admin;
import models.Shipment;
import models.User;
import persistence.PersistenceData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoUserSQL implements DaoUser{
    @Override
    public boolean insert(User user, DAOManager dao) {
        String sentencia;
        String passMD = PersistenceData.getMD5(user.getPass());
        sentencia = "INSERT INTO user VALUES (" +
                    user.isFirst_login() +
                    "," + user.getId() +
                    ",'" + user.getName() +
                    "','" + user.getSurname()
                    + "','" + user.getEmail() +
                    "','" + passMD +
                    "'," + user.getPhone() +
                    ",'" + user.getStreet() +
                    "'," + user.getNum() +
                    ",'" + user.getCity() +
                    "','" + user.getState() +
                    "'," + user.getPostalCode() +
                    "," + user.getToken() +
                    "," + user.isNotification() +
                    "," + user.isValidate() + ");";
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(User user, DAOManager dao) {
        String sentencia;
        sentencia = "UPDATE user SET name = '" + user.getName() +
                    "', pass = '" + user.getPass() +
                    "', email = '" + user.getEmail() +
                    "', phone = " + user.getPhone() +
                    ", street = '" + user.getStreet() +
                    "', num = " + user.getNum() +
                    ", city = '" + user.getCity() +
                    "', state = '" + user.getState() +
                    "', postalCode = " + user.getPostalCode() +
                    ", validate = " + user.isValidate() +
                    ", first_login = " + user.isFirst_login() +
                    ", notification = " + user.isNotification() +
                    " WHERE id = " + user.getId();
        try (Statement stmt = dao.getConn().prepareStatement(sentencia)) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean deleteAll(DAOManager dao) {
        String sentencia;
        sentencia = "DELETE FROM user";
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public User readById(int id, DAOManager dao) {
        User user = null;
        String sentencia;
        sentencia = "SELECT * FROM user WHERE id = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
                    ArrayList<Shipment> shipments = daoShipmentSQL.readAllShipmentUserById(rs.getInt("id"), dao);
                    user = new User(rs.getBoolean("first_login"),
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("email"),
                            rs.getString("pass"),
                            rs.getInt("phone"),
                            rs.getString("street"),
                            rs.getInt("num"),
                            rs.getString("city"),
                            rs.getString("state"),
                            rs.getInt("postalCode"),
                            rs.getInt("token"),
                            rs.getBoolean("notification"),
                            rs.getBoolean("validate"), shipments);
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return user;
    }

    @Override
    public User readByEmailAndPass(String email, String pass, DAOManager dao) {
        User user = null;
        String sentencia;
        String passMD = PersistenceData.getMD5(pass);
        sentencia = "SELECT * FROM user WHERE email = ? AND pass = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setString(1, email);
            ps.setString(2, passMD);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
                    ArrayList<Shipment> shipments = daoShipmentSQL.readAllShipmentUserById(rs.getInt("id"), dao);
                    user = new User(rs.getBoolean("first_login"),
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("email"),
                            rs.getString("pass"),
                            rs.getInt("phone"),
                            rs.getString("street"),
                            rs.getInt("num"),
                            rs.getString("city"),
                            rs.getString("state"),
                            rs.getInt("postalCode"),
                            rs.getInt("token"),
                            rs.getBoolean("notification"),
                            rs.getBoolean("validate"), shipments);
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return user;
    }

    @Override
    public User readByIdShipment(int idShipment, DAOManager dao) {
        User user = null;
        DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
        String sentencia;
        sentencia = "SELECT * FROM user u inner join shipment s on u.id = s.idReciever WHERE s.id = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, idShipment);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ArrayList<Shipment> shipments = daoShipmentSQL.readAllShipmentUserById(rs.getInt("id"), dao);
                    user = new User(rs.getBoolean("first_login"),
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("email"),
                            rs.getString("pass"),
                            rs.getInt("phone"),
                            rs.getString("street"),
                            rs.getInt("num"),
                            rs.getString("city"),
                            rs.getString("state"),
                            rs.getInt("postalCode"),
                            rs.getInt("token"),
                            rs.getBoolean("notification"),
                            rs.getBoolean("validate"), shipments);
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return user;
    }

    @Override
    public User readByPhone(int phone, DAOManager dao) {
        User user = null;
        DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
        String sentencia;
        sentencia = "SELECT * FROM user WHERE phone = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, phone);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ArrayList<Shipment> shipments = daoShipmentSQL.readAllShipmentUserById(rs.getInt("id"), dao);
                    user = new User(rs.getBoolean("first_login"),
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("email"),
                            rs.getString("pass"),
                            rs.getInt("phone"),
                            rs.getString("street"),
                            rs.getInt("num"),
                            rs.getString("city"),
                            rs.getString("state"),
                            rs.getInt("postalCode"),
                            rs.getInt("token"),
                            rs.getBoolean("notification"),
                            rs.getBoolean("validate"), shipments);
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return user;
    }

    @Override
    public User readByToken(int token, DAOManager dao) {
        User user = null;
        DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
        String sentencia;
        sentencia = "SELECT * FROM user WHERE token = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, token);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ArrayList<Shipment> shipments = daoShipmentSQL.readAllShipmentUserById(rs.getInt("id"), dao);
                    user = new User(rs.getBoolean("first_login"),
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("email"),
                            rs.getString("pass"),
                            rs.getInt("phone"),
                            rs.getString("street"),
                            rs.getInt("num"),
                            rs.getString("city"),
                            rs.getString("state"),
                            rs.getInt("postalCode"),
                            rs.getInt("token"),
                            rs.getBoolean("notification"),
                            rs.getBoolean("validate"), shipments);
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return user;
    }

    @Override
    public ArrayList<User> readAll(DAOManager dao) {
        ArrayList<User> users = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM user";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
                    ArrayList<Shipment> shipments = daoShipmentSQL.readAllShipmentUserById(rs.getInt("id"), dao);
                    users.add(new User(rs.getBoolean("first_login"),
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("email"),
                            rs.getString("pass"),
                            rs.getInt("phone"),
                            rs.getString("street"),
                            rs.getInt("num"),
                            rs.getString("city"),
                            rs.getString("state"),
                            rs.getInt("postalCode"),
                            rs.getInt("token"),
                            rs.getBoolean("notification"),
                            rs.getBoolean("validate"), shipments));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User readByEmail(String email, DAOManager dao) {
        User user = null;
        String sentencia;
        sentencia = "SELECT * FROM user WHERE email = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
                    ArrayList<Shipment> shipments = daoShipmentSQL.readAllShipmentUserById(rs.getInt("id"), dao);
                    user = new User(rs.getBoolean("first_login"),
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("email"),
                            rs.getString("pass"),
                            rs.getInt("phone"),
                            rs.getString("street"),
                            rs.getInt("num"),
                            rs.getString("city"),
                            rs.getString("state"),
                            rs.getInt("postalCode"),
                            rs.getInt("token"),
                            rs.getBoolean("notification"),
                            rs.getBoolean("validate"), shipments);
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return user;
    }
}
