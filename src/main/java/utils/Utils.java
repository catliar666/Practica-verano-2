package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static void clickToContinue(){
        var s = new Scanner(System.in);
        System.out.print("Pulsa cualquier tecla para continuar: ");
        s.nextLine();
    }

    public static void checkEmail(){
        System.out.print("Comprobando correo electrónico");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(". ");
        }
    }
    public static void login(){
        System.out.print("Iniciando sesión");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(". ");
        }
        System.out.println();
    }

    public static void closeSesion(){
        System.out.print("Cerrando sesión");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(". ");
        }
        System.out.println();
    }
    public static void exitOption(){
        System.out.print("Saliendo");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(". ");
        }
        System.out.println();
    }
    public static String fechaAString(LocalDateTime fecha){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fecha.format(f);
    }

    public static String fechaAString(LocalDate fecha){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (fecha != null) return fecha.format(f);
        return "No hay datos disponibles";
    }



    public static boolean VerEtiquetas(String mensaje) {
        if (mensaje == null) return false;

        // Regex para buscar etiquetas HTML
        String regex = "<[^>]*>|&[a-zA-Z0-9#]+;";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mensaje);

        // Comprobar si hay al menos una coincidencia
        return matcher.find();
    }


}
