package comunication;

import persistence.Config;

public class ValidarCorreo {
    private static String correo;
    private static int token;

    // Método para generar un token aleatorio
    private static int generarToken() {
        return (int) (Math.random() * 10000) + 1000;
    }

    // Método para enviar el token al correo y almacenarlo
    public static int enviarToken(String correoTeclado) {
        correo = correoTeclado;
        token = generarToken();
        String urlEmail = Config.getUrlValidation() + "?token="+ token;
        Mensajes.enviarMensaje(correo, "Verifica tu cuenta de FernanPaaq", PlantillaToken.generaPlantillaToken(urlEmail), null);
        return token;
    }


}
