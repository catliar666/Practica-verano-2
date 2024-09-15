package comunication;

import persistence.Config;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static jakarta.mail.Transport.send;

public class Mensajes {
    private static final String host = "smtp.gmail.com";
    private static final String user = "fernanpaaqsl@gmail.com";
    private static final String pass = "keld dhmw rgyi wkbx";




    public static boolean enviarMensaje(String destino, String asunto, String mensaje, String archivoAdjunto){
        // Creamos nuestra variable de propiedades con los datos de nuestro servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


// Obtenemos la sesión en nuestro servidor de correo
        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
        try{
            //Creamos un mensaje de correo por defecto
            Message message = new MimeMessage(session);

            //En el mensaje, establecemos el receptor
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destino));

            //Establecemos el asunto
            message.setSubject(asunto);

            message.setFrom(new InternetAddress(user));

            //Añadimos el contenido del mensaje
            /*message.setText(mensaje);*/ //Para enviar texto plano
            MimeBodyPart textoPart = new MimeBodyPart();
            textoPart.setContent(mensaje, "text/html; charset=utf-8");

            // Combinamos las partes del mensaje
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textoPart);

            // Si se proporciona una ruta de archivo, adjuntamos el archivo al mensaje
            if (archivoAdjunto != null && !archivoAdjunto.isEmpty()) {
                MimeBodyPart adjuntoPart = new MimeBodyPart();
                adjuntoPart.attachFile(new File(Config.rutaRelativa() + "/" + Config.getPathFile() + "/" + archivoAdjunto));
                multipart.addBodyPart(adjuntoPart);
            }

            // Establecemos el contenido del mensaje como la combinación de texto y archivo (si se proporciona)
            message.setContent(multipart);

            // Enviamos el mensaje
            Transport.send(message);


        } catch (Exception e){ //Si entra aquí hemos tenido fallo
            throw new RuntimeException(e);
        }

        return true;
    }

    private static void adjuntarArchivo(Message message, String archivoAdjunto) {
        MimeBodyPart adjunto = new MimeBodyPart();
        try {
            adjunto.attachFile(new File(Config.getPathFile() + "/" + archivoAdjunto));
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(adjunto);
            message.setContent(multipart);
        } catch (IOException | MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
