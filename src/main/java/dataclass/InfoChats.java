package dataclass;

import models.Message;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class InfoChats implements Comparable<InfoChats>{
    int idChat;
    int idPaquete;
    int idSender;
    int idReciever;
    ArrayList<Message> mensajesSender;
    ArrayList<Message> mensajesReciever;
    private LocalDateTime dateLastMessage;

    public InfoChats(int idChat, int idPaquete, int idSender,
                     int idReciever, ArrayList<Message> mensajesSender, ArrayList<Message> mensajesReciever, LocalDateTime dateLastMessage) {
        this.idChat = idChat;
        this.idPaquete = idPaquete;
        this.idSender = idSender;
        this.idReciever = idReciever;
        this.mensajesSender = mensajesSender;
        this.mensajesReciever = mensajesReciever;
        this.dateLastMessage = dateLastMessage;
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public int getIdReciever() {
        return idReciever;
    }

    public void setIdReciever(int idReciever) {
        this.idReciever = idReciever;
    }

    public ArrayList<Message> getMensajesSender() {
        return mensajesSender;
    }

    public void setMensajesSender(ArrayList<Message> mensajesSender) {
        this.mensajesSender = mensajesSender;
    }

    public ArrayList<Message> getMensajesReciever() {
        return mensajesReciever;
    }

    public void setMensajesReciever(ArrayList<Message> mensajesReciever) {
        this.mensajesReciever = mensajesReciever;
    }

    public LocalDateTime getDateLastMessage() {
        return dateLastMessage;
    }

    public void setDateLastMessage(LocalDateTime dateLastMessage) {
        this.dateLastMessage = dateLastMessage;
    }

    private static Message lastMessage(ArrayList<Message> mensajesReciever, ArrayList<Message> mensajesSender) {
        Message lastMessage;
        Message lastMessageSender = null;
        Message lastMessageReciever = null;

        // Buscar el último mensaje en la lista de mensajes recibidos
        for (Message mensaje : mensajesReciever) {
            if (lastMessageReciever == null || mensaje.getDateSend().isAfter(lastMessageReciever.getDateSend())) {
                lastMessageReciever = mensaje;
            }
        }

        // Buscar el último mensaje en la lista de mensajes enviados
        for (Message mensaje : mensajesSender) {
            if (lastMessageSender == null || mensaje.getDateSend().isAfter(lastMessageSender.getDateSend())) {
                lastMessageSender = mensaje;
            }
        }

        if (lastMessageReciever == null) {
            lastMessage = lastMessageSender;
        } else if (lastMessageSender == null) {
            lastMessage = lastMessageReciever;
        } else {
            lastMessage = lastMessageReciever.getDateSend().isAfter(lastMessageSender.getDateSend())
                    ? lastMessageReciever
                    : lastMessageSender;
        }

        return lastMessage;
    }

    private static String timeLastMessage(Message mensajeFinal){
        if (mensajeFinal == null) {
            return "No message provided";
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime messageTime = mensajeFinal.getDateSend();

        Duration duration = Duration.between(messageTime, now);
        long minutes = duration.toMinutes();
        long hours = duration.toHours();
        long days = duration.toDays();

        if (days >= 1) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return "Envíado: " + messageTime.format(formatter);
        } else if (hours >= 1) {
            return hours + " hora aprox";
        } else {
            return minutes + " minuto(s) aprox";
        }
    }

    @Override
    public int compareTo(InfoChats o) {
        return o.getDateLastMessage().compareTo(this.dateLastMessage);
    }

    /*
    * <div class="card">
  <div class="img"></div>
  <div class="textBox">
    <div class="textContent">
      <p class="h1">Clans of Clash</p>
      <span class="span">12 min ago</span>
    </div>
    <p class="p">Xhattmahs is not attacking your base!</p>
  <div>
</div></div></div>*/

    public StringBuilder showUserView() {
        StringBuilder result = new StringBuilder();
        Message mensajeFinal = lastMessage(mensajesReciever, mensajesSender);
        result.append("<a href='foundChatDispatch.jsp?idChat=" + idPaquete + "'>")
                .append("<div class='img'></div>")
                .append("<div class='textBox'>")
                .append("<div class='textContent'>")
                .append("<p class='h1'>").append("Paquete: " + idPaquete).append("</p>")
                .append("<span class='span'>").append(timeLastMessage(mensajeFinal)).append("</span>")
                .append("</div>")
                .append("<p class='p'>").append(mensajeFinal.getMessage()).append("</p>")
                .append("<div></div></a>");
        return result;
    }

    /*
     */

    public StringBuilder showMessageView(int idUser) {
        String imagenDelete = "<span class='material-icons'>delete</span>";
        // Combina los mensajes recibidos y enviados en una sola lista
        ArrayList<Message> allMessages = groupAllMessages(mensajesReciever, mensajesSender);
        Collections.sort(allMessages);

        // Crear un StringBuilder para almacenar el HTML
        StringBuilder result = new StringBuilder();

        result.append("<div class='card-container'>")
                .append("<div class='card-header'>")
                .append("<div class='img-avatar'></div>")
                .append("<div class='text-chat'>").append("Chat: " + idChat).append("</div>")
                .append("</div>")
                .append("<div class='card-body' id='card-body'>")
                .append("<div class='messages-container'>");

        // Itera sobre todos los mensajes
        for (Message m : allMessages) {
            // Verifica si el mensaje pertenece al usuario que está visualizando
            if (idUser == m.getIdSender()) {
                result.append("<div class='message-box right'>")
                        .append("<p>").append("<a href='borrarMensajeDispatch.jsp?idMensaje=" + m.getId() + "&" + "sender=true'>" + imagenDelete + "</a>" + m.getMessage()).append("</p>")
                        .append("</div>");

                // Asegúrate de que solo se marque como "Leído" cuando se haya visualizado correctamente
                result.append("<span class='state-right'>" + (m.isView() ? "Leído" : "Entregado") + "</span>");
            } else {
                // Si el usuario no es el remitente, el mensaje es recibido
                result.append("<div class='message-box left'>")
                        .append("<p>").append(m.getMessage()).append("</p>")
                        .append("</div>");

                // Aquí no es necesario mostrar "Leído" ni "Entregado" para el receptor, puedes ajustarlo si es necesario
            }
        }

        result.append("</div>"); // Cierra la card-body y messages-container

        return result; // Retorna el HTML generado
    }



    private ArrayList<Message> groupAllMessages(ArrayList<Message> mensajesReciever, ArrayList<Message> mensajesSender) {
        ArrayList<Message> allMessages = new ArrayList<>();
        allMessages.addAll(mensajesReciever);
        allMessages.addAll(mensajesSender);
        Collections.sort(allMessages);
        return allMessages;
    }
}
