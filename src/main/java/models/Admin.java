package models;


import DAO.DaoAdmin;
import persistence.PersistenceData;

import java.io.Serializable;

public class Admin implements Serializable {

    //ATRIBUTOS
    private int id; //Codigo que crearemos nosotros
    private String name; //Nombre del administrador
    private String pass; //Contraseña del administrador
    private String email; //Correo electronico
    private boolean validate; //indica si la cuenta está validada o no mediante el codigo que se envia por correo

    //CONSTRUCTOR

    public Admin(int id, String name, String pass, String email) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.email = email;
        validate = false;
    }

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }


    //MÉTODOS

    //Metodo que comprueba si el email y la contraseña introducido por el usuario coincide con uno ya existente o no
    //Devuelve true si lo encuentra y false si no coincide con ninguno
    public boolean login(String email, String pass){
        return this.email.equals(email) && this.pass.equals(pass);
    }
    public boolean checkPass(String pass) {
        String passMD = PersistenceData.getMD5(pass);
        return this.pass.equals(passMD);
    }

    public String showProfile() {
        return "┌──. ■ .─────────────────────────────────────────────────────────┐\n" +
               "                    Informacion del perfil\n" +
               "└─────────────────────────────────────────────────────────. ■ .──┘\n" +
               "█  Número de referencia de admin: " + id + "\n" +
               "█  Nombre: " + name + "\n" +
               "█  Email: " + email + "\n" +
               "█  Contraseña: " + pass + "\n" +
               "──────────────────────────────────────────────────────────. ■ .──";
    }
}
