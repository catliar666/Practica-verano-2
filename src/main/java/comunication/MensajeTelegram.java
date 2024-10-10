package comunication;

import persistence.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MensajeTelegram {
    public static String mensajePredeterminado(int numSeguimiento, String estado, String nombreConductor, LocalDate fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String statusString = (estado.equals("1") ? Config.getStatusOne() : (estado.equals("2") ? Config.getStatusTwo() :
                (estado.equals("3") ? Config.getStatusThree() : (estado.equals("4") ? Config.getStatusFour() : "No hay registros"))));
        return "Buenas " + nombreConductor + " te han asignado el paquete " + numSeguimiento + ", actualmente está '" + statusString
                + "' la fecha límite de su entrega es " + fecha.format(formatter) + ". Que tenga un buen día.";

    }
    public static boolean enviaMensajeTelegram(String mensaje) throws IOException {
        String direccion; //URL de la API de mi bot en mi conversacion
        String fijo="https://api.telegram.org/bot6721739071:AAELX63MJLwYvzAMRDuFFK0MRyOfSpFUg4Y/sendMessage?chat_id=888386182=&text=";
        direccion=fijo+mensaje;
        URL url;
        boolean dev;
        dev=false;
        try {
            url = new URL(direccion);
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            dev=true;

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dev;
    }
}
