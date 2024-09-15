package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
}
