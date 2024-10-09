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
        String imagenDelete = "<img class='imagenDelete' src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAptJREFUSEuVV1GWwyAIhJM1OVmSk6U9mSuKOgim23xs+xoFZhhGl0keJqJU/uj38mvwPVijS+MPJqakoXUvhLZ77Ps4/2Myi2Nd0PwGE9fvGxO9UkDCQ/4PMb2FwNUjoVfPkVtwftscFQS1n7lhl08gLfDPlnEeRCSfjuqx3PbbEwV7a6tNsJoYxUV0S1IN9NaK5dPlfGSrFl6Lr8EgV/0JH0Eq9MiLM2u80BTozUm+qNdX0uNJXCa6+vBYsG0vv5nSXhf9PkLTWGI9CnTqMROluop3oqT0rrpn4Y1VIT/NIDrDSLX09dbyItEJbUL7FU0JE22J6BWruDvTnvteAGEC6AcLeNv7MVrRiIiIRJTywPuOvgXTd5ZqFMKMeCOmG2rB5JhUEndUvfLhm30fJOAjoyyKtkyo39bRuCdzEIfCgkZSq8mBmOlqxLfCnhC3ejamdBuhj0o80jaIOmtlRH9OPBLMtDt6gzmYejyJS01DmAZx2TBMSdRbhDTRrp4cjFOEGJZ5VbsYvBGlpl5QfVkYqL3r41nVA7H1Vc0QqVdeIfqRfCWuZsMOcbXJSvXY3OlVze/5nG4Hx0bEN6yvyS1bBbEC6/7/VdW5iiMruZ3NezvkIfbCQHrtz+JqJ5MVV2/lkT38Uzw81M9kmQFiNJeFZRZZP10+hrC8AOedyIbma5ZZNxsDGfG+lOCGtiu5FVcuFrMjGsRujqvQ/osdYvcD5oBJMeMGifnIcy63jiLAmEEHzyarhYqtSpvKvU13yASIpY5zA8cJqsM1s1HAoTN0gK2ZrkH93mbWLEZinFHLuzE6BP7HYHCdmYJ+vZ35wltmuWXY59cel92fetNYFeRvmehW/xsnA/BZhx6x+uBqcoOJcUtXsluIhf4AzpcvNQl1zfMAAAAASUVORK5CYII=\"/>";
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
                .append("<div class='card-body'>")
                .append("<div class='messages-container'>");

        // Itera sobre todos los mensajes
        for (Message m : allMessages) {
                       if (idUser == m.getIdSender()) {
                result.append("<div class='message-box right'>")
                        .append("<p>").append(m.getMessage()).append("</p>")
                        .append("<a href='borrarMensajeDispatch.jsp?idMensaje=" + m.getId() + "&" + "sender=true'>" + imagenDelete + "</a>")
                        .append("</div>")
                        .append("<span class='state-right'>" + (m.isView() ? "Leído" : "Entregado") + "</span>");
                } else {
                    // Si el usuario no es el remitente, entonces el mensaje es recibido y va a la izquierda
                    result.append("<div class='message-box left'>")
                            .append("<p>").append(m.getMessage()).append("</p>")
                            .append("</div>");
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
