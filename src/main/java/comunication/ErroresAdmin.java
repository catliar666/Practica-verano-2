package comunication;

import persistence.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErroresAdmin {

    /*Esta clase se va a usar para avisar al administrador de la página, osea yo, cuando ocurre un error de excepciones dentro de ella
    que tipo de excepcion ha sido a que hora se ha producido, el dia y el usuario junto con el navegador
     */

    public static String mensajePredeterminado(Exception e, String error, LocalDateTime fechaError){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        return "Buenas admin, su pagina web ha sufrido un error el día" + fechaError.format(formatter) + " de tipo " + error + ", con excepción "
                + e.getMessage() + " por favor, revise el error o actualice su página. Gracias";

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
