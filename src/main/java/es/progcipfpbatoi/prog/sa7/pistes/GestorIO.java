package es.progcipfpbatoi.prog.sa7.pistes;

import java.util.Scanner;

public class GestorIO {
    public static Scanner scanner = new Scanner(System.in);
    
    public static int llegirNumEnter(String missatge){
        System.out.println(missatge);
        while(!scanner.hasNextInt()){
            System.out.println("Introduex un nombre enter: ");
            scanner.hasNextInt();
        }
        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }
    
    public static String llegirText(String missatge){
        System.out.println(missatge);
        return scanner.nextLine();
    }
    
    public static void tancarScanner(){
        scanner.close();
    }
}
