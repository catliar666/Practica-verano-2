package persistence;

import comunication.ErroresAdmin;
import utils.Utils;

import java.io.*;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;

public class Config {

    public static final String PATH =  rutaRelativa() + "\\config\\config.properties";

    public static String getPathRegisterLogin() {
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            return rutaRelativa() + p.getProperty("route_registerLogin", "\\data\\log\\log.data");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String rutaRelativa(){
        // Obtener la ruta completa de catalina.home
        String catalinaHome = System.getProperty("catalina.home");
        // Encontrar el índice de la última aparición de separador de directorios
        int lastIndex = catalinaHome.lastIndexOf(File.separator);
        // Verificar si encontramos el separador de directorios y construir la nueva ruta
        String parentDirectory = lastIndex != -1 ? catalinaHome.substring(0, lastIndex) : catalinaHome;
        return parentDirectory;

    }

    public static String getPathData() {
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            return p.getProperty("route_data", "data");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void updateLastLogin(String id, LocalDateTime date) {
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            p.setProperty(id, Utils.fechaAString(date));
            p.store(new FileWriter(PATH), "Update Login Access");
        } catch (IOException e) {
            try {
                ErroresAdmin.enviaMensajeTelegram("Error al actualizar el login del cierre de sesión");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static String getEmailAdmin() {
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            return p.getProperty("email_admin", "maariiaa1912@gmail.com");
        } catch (IOException e) {
            try {
                ErroresAdmin.enviaMensajeTelegram("Error al obtener el email del admin en la clase Config");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        }
    }

    public static String getLastLogin(String id) {
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            return p.getProperty(id);
        } catch (IOException e) {
            try {
                ErroresAdmin.enviaMensajeTelegram("Error en el Last Login de la clase Config");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        }
    }

    public static String getPathFile() {
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            return p.getProperty("route_files", rutaRelativa() + "/files");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean getUserInvited() {
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            if (p.getProperty("user_invited").equalsIgnoreCase("s")) return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*--------------------------------------------------------------------------------*/
    //INFORMACIÓN SOBRE LA BASE DE DATOS

    public static String getUserBasedData() {
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            return p.getProperty("user_BBDD", "root");
        } catch (IOException e) {
            String mensaje = ErroresAdmin.mensajePredeterminado(e, "User Based Data Not Found", LocalDateTime.now());
            try {
                ErroresAdmin.enviaMensajeTelegram(mensaje);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        }
    }

    public static String getPassBasedData() {
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            return p.getProperty("pass_BBDD", "root");
        } catch (IOException e) {
            String mensaje = ErroresAdmin.mensajePredeterminado(e, "Pass Based Data not found", LocalDateTime.now());
            try {
                ErroresAdmin.enviaMensajeTelegram(mensaje);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        }
    }
    public static String getUrlBasedData() {
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            return p.getProperty("url_BBDD", "jdbc:mysql://127.0.0.1:3306/PracticaT8");
        } catch (IOException e) {
            String mensaje = ErroresAdmin.mensajePredeterminado(e, "Url Based Data Not Found", LocalDateTime.now());
            try {
                ErroresAdmin.enviaMensajeTelegram(mensaje);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        }
    }

    /*-------------------------------------------------------------------------------*/
    //OBTENER INFORMACIÓN DEL ARCHIVO PROPERTIES SIN CONTAR LOS COMENTARIOS

    public static ArrayList<String> getInfo() {
        ArrayList<String> info = new ArrayList<>();
        FileReader fr;
        try {
            fr = new FileReader(PATH);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (line != null) {
                line = br.readLine();
                if (line != null && !line.contains("#")) info.add(line);
            }
        } catch (IOException e) {
            return null;
        }
        return info;
    }


    /*--------------------------------------------------------------------*/
    //CAMBIO DE PROPIEDAD MODO INVITADO SEGÚN RESPUESTA DEL ADMINISTRADOR

    public static boolean changeProperties(String respuesta) {
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            p.setProperty("user_invited", respuesta);
            p.store(new FileWriter(PATH), "Modo invitado actualizado");
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /*--------------------------------------------------------------------*/

    /*--------------------------------------------------------------------*/
    //OBTENER LOS ESTADOS DE LOS ENVIOS

    public static String getStatusOne(){
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            return p.getProperty("estado1", "En oficina de origen");
        } catch (IOException e) {
            String mensaje = ErroresAdmin.mensajePredeterminado(e, "Status Not found", LocalDateTime.now());
            try {
                ErroresAdmin.enviaMensajeTelegram(mensaje);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        }
    }
    public static String getStatusTwo(){
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            return p.getProperty("estado2", "En almacén");
        } catch (IOException e) {
            String mensaje = ErroresAdmin.mensajePredeterminado(e, "Status Not found", LocalDateTime.now());
            try {
                ErroresAdmin.enviaMensajeTelegram(mensaje);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        }
    }
    public static String getStatusThree(){
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            return p.getProperty("estado3", "En reparto");
        } catch (IOException e) {
            String mensaje = ErroresAdmin.mensajePredeterminado(e, "Status Not found", LocalDateTime.now());
            try {
                ErroresAdmin.enviaMensajeTelegram(mensaje);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        }
    }
    public static String getStatusFour(){
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            return p.getProperty("estado4", "Entregado");
        } catch (IOException e) {
            String mensaje = ErroresAdmin.mensajePredeterminado(e, "Status Not found", LocalDateTime.now());
            try {
                ErroresAdmin.enviaMensajeTelegram(mensaje);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        }
    }

    public static String getUrlValidation() {
        Properties p = new Properties();
        try {
            p.load(new FileReader(PATH));
            return p.getProperty("urlValidation", "http://" + InetAddress.getLocalHost() + ":8080/FernanPaqWeb_war_exploded/esperaValidacion.jsp");
        } catch (IOException e) {
            String mensaje = ErroresAdmin.mensajePredeterminado(e, "Url Validation Not Found", LocalDateTime.now());
            try {
                ErroresAdmin.enviaMensajeTelegram(mensaje);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        }
    }

    /*------------------------------------------------------------------*/
}
