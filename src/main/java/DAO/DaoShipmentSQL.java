package DAO;

import models.Shipment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class DaoShipmentSQL implements DaoShipment{
    @Override
    public boolean insert(Shipment shipment, int idReciever, int idDriver, DAOManager dao) {
        String sentencia;
        String fecha = (shipment.getDeliveryDate() == null) ? null : "'" + shipment.getDeliveryDate() + "'";
        sentencia = "INSERT INTO shipment VALUES (" +
                    shipment.getId() +
                    ",'" + shipment.getCreateDate() +
                    "','" + shipment.getExpectDate() +
                    "'," + fecha +
                    "," + shipment.isNotifications() +
                    ",'" + shipment.getAlternativeAddress() +
                    "'," + shipment.getNumAlternative() +
                    "," + shipment.getAlternativePostalCode() +
                    ",'" + shipment.getAlternativeCity() +
                    "','" + shipment.getStatus() +
                    "'," + shipment.getCost() +
                    ",'" + shipment.getEmailUserNoRegister() +
                    "'," + shipment.getIdSender() +
                    ",'" + shipment.getNameUserNoRegister() +
                    "'," + ((idReciever == -1) ? null : idReciever) +
                    "," + ((idDriver == -1) ? null : idDriver) + ");";
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAll(DAOManager dao) {
        String sentencia;
        sentencia = "DELETE FROM shipment";
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean updateIdDriver(Shipment s, int idDriver, DAOManager dao) {
        String sentencia;
        sentencia = "UPDATE shipment SET " +
                    "idDriver = " + idDriver +
                    " WHERE id = " + s.getId();
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean updateStatusShipment(Shipment shipment, DAOManager dao) {
        String sentencia;
        sentencia = "UPDATE shipment SET deliveryDate = '" + shipment.getDeliveryDate() +
                    "', status = '" + shipment.getStatus() +
                    "' WHERE id = " + shipment.getId();
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean updateAddress(Shipment shipment, DAOManager dao) {
        String sentencia;
        sentencia = "UPDATE shipment SET alternativeAddress = '" + shipment.getAlternativeAddress() +
                    "', alternativePostalCode = " + shipment.getAlternativePostalCode() +
                    ", alternativeCity = '" + shipment.getAlternativeCity() + "' WHERE id = " + shipment.getId();
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public ArrayList<Shipment> readAll(DAOManager dao) {
        ArrayList<Shipment> shipments = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipments.add(new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipments;
    }


    @Override
    public Shipment readById(int id, DAOManager dao) {
        Shipment shipment = null;
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE id = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipment = new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister"));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipment;
    }

    @Override
    public int readIdDriverByIdShipment(int id, DAOManager dao) {
        int idDriver = -1;
        String sentencia;
        sentencia = "SELECT idDriver FROM shipment WHERE id = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    idDriver = rs.getInt("idDriver");
                }
            }
        } catch (SQLException e) {
            return -1;
        }
        return idDriver;
    }

    public ArrayList<Shipment> readAllShipmentPendings(DAOManager dao) {
        ArrayList<Shipment> shipments = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE status != '4'";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipments.add(new Shipment(rs.getInt("id"), createDate,
                           expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipments;
    }

    @Override
    public ArrayList<Shipment> readShipmentByIdSender(int idUser, DAOManager dao) {
        ArrayList<Shipment> shipments = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE idSender = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, idUser);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipments.add(new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipments;
    }

    public ArrayList<Shipment> readShipmentUnassigned(DAOManager dao) {
        ArrayList<Shipment> shipments = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE idDriver IS NULL";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipments.add(new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipments;
    }

    public ArrayList<Shipment> readShipmentByIdReciever(int idUser, DAOManager dao) {
        ArrayList<Shipment> shipments = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE idReciever = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, idUser);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipments.add(new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipments;
    }

    @Override
    public ArrayList<Shipment> readShipmentPendingsByUser(int idUser, DAOManager dao) {
        ArrayList<Shipment> shipments = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE idReciever = ? AND status != '4'";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, idUser);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipments.add(new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipments;
    }

    @Override
    public ArrayList<Shipment> readShipmentPendingsByDriver(int idDriver, DAOManager dao) {
        ArrayList<Shipment> shipments = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE idDriver = ? AND status != '4'";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, idDriver);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipments.add(new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipments;
    }

    @Override
    public ArrayList<Shipment> readShipmentDelivered(DAOManager dao) {
        ArrayList<Shipment> shipments = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE status = '4'";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipments.add(new Shipment(rs.getInt("id"), createDate,
                           expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipments;
    }

    @Override
    public ArrayList<Shipment> readShipmentDeliveredByDriver(int idDriver, DAOManager dao) {
        ArrayList<Shipment> shipments = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE idDriver = ? AND status = '4'";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, idDriver);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipments.add(new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return shipments;
    }

    @Override
    public ArrayList<Shipment> readAllShipmentUnassigned(DAOManager dao) {
        ArrayList<Shipment> shipmentsUnassigned = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE idDriver IS NULL";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipmentsUnassigned.add(new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipmentsUnassigned;
    }

    @Override
    public ArrayList<Shipment> readAllShipmentNoUser(DAOManager dao) {
        ArrayList<Shipment> shipmentsNoUser = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE idReciever IS NULL";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipmentsNoUser.add(new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipmentsNoUser;
    }

    @Override
    public ArrayList<Shipment> readShipmentByEmailUser(String email, DAOManager dao) {
        ArrayList<Shipment> shipmentsNoUser = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE emailUserNoRegister = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipmentsNoUser.add(new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipmentsNoUser;
    }

    @Override
    public void updateIdReciever(int id, int idShipment, DAOManager dao) {
        String sentencia;
        sentencia = "UPDATE shipment SET idReciever = " + id +
                    " WHERE id = " + idShipment;
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Shipment> readAllShipmentDriver(int id, DAOManager dao) {
        ArrayList<Shipment> shipmentsDriver = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE idDriver = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipmentsDriver.add(new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipmentsDriver;
    }

    @Override
    public ArrayList<Shipment> readAllShipmentUserById(int id, DAOManager dao) {
        ArrayList<Shipment> shipmentsUser = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE idReciever = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipmentsUser.add(new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"), rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return shipmentsUser;
    }

    @Override
    public ArrayList<Shipment> readShipmentDeliveredByUser(int id, DAOManager dao) {
        ArrayList<Shipment> shipments = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM shipment WHERE idReciever = ? AND status = '4'";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDate createDate = rs.getDate("createDate") != null ? rs.getDate("createDate").toLocalDate() : null;
                    LocalDate expectDate = rs.getDate("expectDate") != null ? rs.getDate("expectDate").toLocalDate() : null;
                    LocalDate deliveryDate = rs.getDate("deliveryDate") != null ? rs.getDate("deliveryDate").toLocalDate() : null;
                    shipments.add(new Shipment(rs.getInt("id"), createDate,
                            expectDate,
                            deliveryDate,
                            rs.getBoolean("notifications"), rs.getString("alternativeAddress"),
                            rs.getInt("numAlternative"),
                            rs.getInt("alternativePostalCode"),
                            rs.getString("alternativeCity"), rs.getString("status"),
                            rs.getDouble("cost"),
                            rs.getString("emailUserNoRegister"), rs.getInt("idSender"),
                            rs.getString("nameUserNoRegister")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return shipments;
    }
}
