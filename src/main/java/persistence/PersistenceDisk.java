package persistence;

import DAO.*;
import appcontroller.AppController;
import models.Admin;
import models.Driver;
import models.Shipment;
import models.User;
import utils.Utils;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PersistenceDisk {



    public static void recordLogin(Object user, LocalDateTime date) {
        String tipo = "", nombre = "";
        if (user instanceof User) {
            tipo = "usuario";
            nombre = ((User) user).getName();
        }
        if (user instanceof Driver) {
            tipo = "conductor";
            nombre = ((Driver) user).getName();
        }
        if (user instanceof Admin) {
            tipo = "administrador";
            nombre = ((Admin) user).getName();
        }
        try {
            FileWriter fw = new FileWriter(Config.getPathRegisterLogin(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\"Inicio de sesión\";" + nombre
                     + ";" + tipo + ";" + Utils.fechaAString(date) + "\n");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void recordUpdateShipment(Shipment s, LocalDateTime date) {
        FileWriter fw;
        try {
            fw = new FileWriter(Config.getPathRegisterLogin(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\"Actualización del envío\";" + s.getId() + ";" + s.getStatus() + ";" + Utils.fechaAString(date) + "\n");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeRegister(String nombre, String tipo, LocalDateTime date) {
        try {
            FileWriter fw = new FileWriter(Config.getPathRegisterLogin(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\"Cierre de sesión\";"+ nombre + ";"
                     + tipo + ";" + Utils.fechaAString(date) + "\n");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public static boolean guardaBackup(String ruta, ArrayList<User> users, ArrayList<Admin> admins,
                                       ArrayList<Driver> drivers, ArrayList<Shipment> shipments) {
        try {
            File pathData = new File(System.getProperty("user.home") + ruta);
            if (!pathData.exists()) pathData.mkdirs();

            FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + ruta + "\\" + "backupUsers.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);

            fos = new FileOutputStream(System.getProperty("user.home") + ruta + "\\" + "backupAdmins.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(admins);

            fos = new FileOutputStream(System.getProperty("user.home") + ruta + "\\" + "backupDrivers.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(drivers);

            fos = new FileOutputStream(System.getProperty("user.home") + ruta + "\\" + "backupShipments.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(shipments);

            oos.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static void eliminarDatos(DAOManager dao) {
        DaoUserSQL daoUserSQL = new DaoUserSQL();
        DaoDriverSQL daoDriverSQL = new DaoDriverSQL();
        DaoShipmentSQL daoShipmentSQL = new DaoShipmentSQL();
        daoDriverSQL.deleteAll(dao);
        daoUserSQL.deleteAll(dao);
        daoShipmentSQL.deleteAll(dao);
    }


    public static ArrayList<User> restoreUsers(String route) {
        FileInputStream fis;
        ArrayList<User> users = new ArrayList<>();
        String rutaFinal = System.getProperty("user.home") + route + "\\" + "backupUsers.dat";
        File pathData = new File(rutaFinal);
        if (!pathData.exists()) return users;
        try {
            fis = new FileInputStream(rutaFinal);
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList<User>) ois.readObject();
            ois.close();
            return users;
        } catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }
    public static ArrayList<Driver> restoreDrivers(String route) {
        FileInputStream fis;
        ArrayList<Driver> drivers = new ArrayList<>();
        String rutaFinal = System.getProperty("user.home") + route + "\\" + "backupDrivers.dat";
        File pathData = new File(rutaFinal);
        if (!pathData.exists()) return drivers;
        try {
            fis = new FileInputStream(rutaFinal);
            ObjectInputStream ois = new ObjectInputStream(fis);
            drivers = (ArrayList<Driver>) ois.readObject();
            ois.close();
            return drivers;
        } catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }
    public static ArrayList<Admin> restoreAdmins(String route) {
        FileInputStream fis;
        ArrayList<Admin> admins = new ArrayList<>();
        String rutaFinal = System.getProperty("user.home") + route + "\\" + "backupAdmins.dat";
        File pathData = new File(rutaFinal);
        if (!pathData.exists()) return admins;
        try {
            fis = new FileInputStream(route);
            ObjectInputStream ois = new ObjectInputStream(fis);
            admins = (ArrayList<Admin>) ois.readObject();
            ois.close();
            return admins;
        } catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }
    public static ArrayList<Shipment> restoreShipments(String route) {
        FileInputStream fis;
        ArrayList<Shipment> shipments = new ArrayList<>();
        String rutaFinal = System.getProperty("user.home") + route + "\\" + "backupShipments.dat";
        File pathData = new File(rutaFinal);
        if (!pathData.exists()) return shipments;
        try {
            fis = new FileInputStream(rutaFinal);
            ObjectInputStream ois = new ObjectInputStream(fis);
            shipments = (ArrayList<Shipment>) ois.readObject();
            ois.close();
            return shipments;
        } catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }


}

