package DAO;

import models.Driver;
import models.Shipment;
import persistence.PersistenceData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoDriverSQL implements DaoDriver {
    public boolean deleteAll(DAOManager dao) {
        String sentencia;
        sentencia = "DELETE FROM driver";
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            deleteAllZone(dao);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public boolean deleteAllZone(DAOManager dao) {
        String sentencia;
        sentencia = "DELETE FROM deliveryZones";
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean insert(Driver driver, DAOManager dao) {
        String sentencia;
        String passMD = PersistenceData.getMD5(driver.getPass());
        sentencia = "INSERT INTO driver VALUES (" + driver.getId() +
                    ", '" + driver.getName() +
                    "','" + passMD +
                    "','" + driver.getEmail() +
                    "'," + driver.isValidate() + ");";
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(Driver driver, DAOManager dao) {
        String sentencia;
        sentencia = "UPDATE driver SET name = '" + driver.getName() +
                    "', pass = '" + driver.getPass() +
                    "', email = '" + driver.getEmail() +
                    "' WHERE id = " + driver.getId();
        try (Statement stmt = dao.getConn().prepareStatement(sentencia)) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Driver readById(int id, DAOManager dao) {
        Driver driver = null;
        String sentencia;
        sentencia = "SELECT * FROM driver WHERE id = ?";
        try(PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
                    ArrayList<Integer> deliveryZones = readDeliveryZones(rs.getInt("id"), dao);
                    ArrayList<Shipment> shipments = daoShipmentSQL.readAllShipmentDriver(rs.getInt("id"), dao);
                    driver = new Driver(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("pass"),
                            rs.getString("email"),
                            rs.getBoolean("validate"), deliveryZones, shipments);
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return driver;
    }

    @Override
    public ArrayList<Driver> readAll(DAOManager dao) {
        ArrayList<Driver> drivers = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM driver";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
                    ArrayList<Integer> deliveryZones = readDeliveryZones(rs.getInt("id"), dao);
                    ArrayList<Shipment> shipments = daoShipmentSQL.readAllShipmentDriver(rs.getInt("id"), dao);
                    drivers.add(new Driver(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("pass"),
                            rs.getString("email"),
                            rs.getBoolean("validate"), deliveryZones, shipments));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return drivers;
    }

    private ArrayList<Integer> readDeliveryZones(int id, DAOManager dao) {
        ArrayList<Integer> deliveryZones = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM deliveryZones WHERE idDriver = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    deliveryZones.add(rs.getInt("postalCode"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return deliveryZones;
    }

    @Override
    public Driver readByEmail(String email, DAOManager dao) {
        Driver driver = null;
        String sentencia;
        sentencia = "SELECT * FROM driver WHERE email = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
                ArrayList<Integer> deliveryZones = readDeliveryZones(rs.getInt("id"), dao);
                ArrayList<Shipment> shipments = daoShipmentSQL.readAllShipmentDriver(rs.getInt("id"), dao);
                driver = new Driver(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("pass"),
                        rs.getString("email"),
                        rs.getBoolean("validate"), deliveryZones, shipments);
            }
        } catch (SQLException e) {
            return null;
        }
        return driver;
    }

    @Override
    public Driver readByIdShipment(int id, DAOManager dao) {
        return null;
    }

    public Driver readByEmailAndPass(String email, String pass, DAOManager dao) {
        Driver driver = null;
        String sentencia;
        String passMD = PersistenceData.getMD5(pass);
        sentencia = "SELECT * FROM driver WHERE email = ? AND pass = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setString(1, email);
            ps.setString(2, passMD);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
                    ArrayList<Integer> deliveryZones = readDeliveryZones(rs.getInt("id"), dao);
                    ArrayList<Shipment> shipments = daoShipmentSQL.readAllShipmentDriver(rs.getInt("id"), dao);
                    driver = new Driver(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("pass"),
                            rs.getString("email"),
                            rs.getBoolean("validate"), deliveryZones, shipments);
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return driver;
    }

    @Override
    public Driver readByPostalCode(int postalCode, DAOManager dao) {
        Driver driver = null;
        String sentencia;
        sentencia = "SELECT * FROM driver d inner join deliveryZones dz on d.id = dz.idDriver WHERE dz.postalCode = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, postalCode);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
                    ArrayList<Integer> deliveryZones = readDeliveryZones(rs.getInt("id"), dao);
                    ArrayList<Shipment> shipments = daoShipmentSQL.readAllShipmentDriver(rs.getInt("id"), dao);
                    driver = new Driver(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("pass"),
                            rs.getString("email"),
                            rs.getBoolean("validate"), deliveryZones, shipments);
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return driver;
    }

    @Override
    public boolean insertZoneDelivery(Driver driverFind, int newPostalCode, DAOManager dao) {
        Driver driver = readByPostalCode(newPostalCode, dao);
        if (driver == null || driver.getId() != driverFind.getId()) {
            String sentencia;
            sentencia = "INSERT INTO deliveryZones VALUES (" + newPostalCode + "," + driverFind.getId() + ");";
            try (Statement stmt = dao.getConn().prepareStatement(sentencia)) {
                stmt.executeUpdate(sentencia);
                return true;
            } catch (SQLException e) {
                return false;
            }
        }
        return false;
    }
}
