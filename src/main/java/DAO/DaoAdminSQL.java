package DAO;

import models.Admin;
import models.Shipment;
import persistence.PersistenceData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoAdminSQL implements DaoAdmin{

    @Override
    public boolean insert(Admin admin, DAOManager dao) {
        String sentencia;
        String passMD = PersistenceData.getMD5(admin.getPass());
        sentencia = "INSERT INTO admin VALUES (" + admin.getId() +
                    ",'" + admin.getName() + "','" + passMD + "','" + admin.getEmail() + ");";
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(Admin admin, DAOManager dao) {
        String sentencia;
        sentencia = "UPDATE admin SET name = '" + admin.getName() + "', pass = '" + admin.getPass() +
                    "', email = '" + admin.getEmail() + "' WHERE id = " + admin.getId();
        try (Statement stmt = dao.getConn().createStatement()) {
            stmt.executeUpdate(sentencia);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean deleteAll(DAOManager dao) {
            String sentencia;
            sentencia = "DELETE FROM admin";
            try (Statement stmt = dao.getConn().createStatement()) {
                stmt.executeUpdate(sentencia);
                return true;
            } catch (SQLException e) {
                return false;
            }
        }

    @Override
    public Admin readById(int id, DAOManager dao) {
        Admin admin = null;
        String sentencia;
        sentencia = "SELECT * FROM admin WHERE id = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    admin = new Admin(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("pass"),
                            rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return admin;
    }

    @Override
    public Admin readByEmail(String email, DAOManager dao) {
        Admin admin = null;
        String sentencia;
        sentencia = "SELECT * FROM admin WHERE email = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    admin = new Admin(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("pass"),
                            rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return admin;
    }

    @Override
    public Admin readByEmailAndPass(String email, String pass, DAOManager dao) {
        Admin admin = null;
        String sentencia;
        String passMD = PersistenceData.getMD5(pass);
        sentencia = "SELECT * FROM admin WHERE email = ? AND pass = ?";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            ps.setString(1, email);
            ps.setString(2, passMD);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    admin = new Admin(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("pass"),
                            rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return admin;
    }

    @Override
    public ArrayList<Admin> readAll(DAOManager dao) {
        ArrayList<Admin> admins = new ArrayList<>();
        String sentencia;
        sentencia = "SELECT * FROM admin";
        try (PreparedStatement ps = dao.getConn().prepareStatement(sentencia)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    admins.add(new Admin(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("pass"),
                            rs.getString("email")));
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return admins;
    }
}
