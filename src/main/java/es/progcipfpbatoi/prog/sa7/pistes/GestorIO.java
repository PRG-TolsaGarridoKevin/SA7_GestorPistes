package es.progcipfpbatoi.prog.sa7.pistes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class GestorIO {

    public static Scanner scanner = new Scanner(System.in);
    private static final String FORMATO_FECHA = "\\d{2}/\\d{2}/\\d{4}\""; 

    public static int llegirNumEnter(String missatge) {
        System.out.println(missatge);
        String numeroEntero;
        while (true) { 
            numeroEntero = scanner.nextLine();
            if (numeroEntero.matches("[1-9]\\d*")) {
                break;
            }
            System.out.println("Introdueix un nombre enter: ");
        }
        return Integer.parseInt(numeroEntero);
    }

    public static String llegirText(String missatge) {
        System.out.println(missatge);
        return scanner.nextLine();
    }

    public static boolean solicitarConfirmacio(String missatge) {
        boolean bucleActivo = true;
        while (bucleActivo) {
            System.out.println(missatge);
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                return true;
            } else if (respuesta.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Resposta no valida, introdueix (S/N)");
            }
        }
        return false;
    }

    public static void tancarScanner() {
        scanner.close();
    }
    
    //Añadir metodo para pedir y formatar fecha
    public static String demanarYFormatarData(String data, Pista pista){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        LocalDate dataDemanada = LocalDate.parse(data, formatter);
        Date fechaFinal = new Date(dataDemanada.getYear() - 1900, dataDemanada.getMonthValue() - 1, dataDemanada.getDayOfMonth());
        pista.setDataDescobriment(fechaFinal);
        return data;
    }
    
}
