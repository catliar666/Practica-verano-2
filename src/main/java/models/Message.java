package models;

import java.time.LocalDateTime;

public class Message implements Comparable<Message>{
    private int id;
    private int idPackage;
    private int idReceiver;
    private int idSender;
    private String message;
    private LocalDateTime dateSend;
    private boolean view;
    private boolean edit;
    private boolean deleteSender;
    private boolean deleteReciever;


    /*Constructor para recuperar la informacion de los mensajes desde base de datos*/
    public Message(int id, int idReceiver, int idSender, int idPackage, String message,
                   LocalDateTime dateSend, boolean view, boolean edit,
                   boolean deleteSender, boolean deleteReciever) {
        this.id = id;
        this.idReceiver = idReceiver;
        this.idPackage = idPackage;
        this.idSender = idSender;
        this.message = message;
        this.dateSend = dateSend;
        this.view = view;
        this.edit = edit;
        this.deleteSender = deleteSender;
        this.deleteReciever = deleteReciever;
    }

    /*Constructor para la creacion de un mensaje desde el controller*/

    public Message(int id, int idReceiver, int idSender, int idPackage, String message) {
        this.id = id;
        this.idReceiver = idReceiver;
        this.idSender = idSender;
        this.idPackage = idPackage;
        this.message = message;
        dateSend = LocalDateTime.now();
        view = false;
        edit = false;
        deleteSender = false;
        deleteReciever = false;
    }


    public int getIdPackage() {
        return idPackage;
    }

    public void setIdPackage(int idPackage) {
        this.idPackage = idPackage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateSend() {
        return dateSend;
    }

    public void setDateSend(LocalDateTime dateSend) {
        this.dateSend = dateSend;
    }

    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public boolean isDeleteSender() {
        return deleteSender;
    }

    public void setDeleteSender(boolean deleteSender) {
        this.deleteSender = deleteSender;
    }

    public boolean isDeleteReciever() {
        return deleteReciever;
    }

    public void setDeleteReciever(boolean deleteReciever) {
        this.deleteReciever = deleteReciever;
    }

    //Comparo las fechas de los mensajes según del más antiguo al más nuevo
    @Override
    public int compareTo(Message other) {
        return other.getDateSend().compareTo(this.dateSend);
    }
}
