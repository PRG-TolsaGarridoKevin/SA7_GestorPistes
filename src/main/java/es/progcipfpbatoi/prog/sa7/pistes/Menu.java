package es.progcipfpbatoi.prog.sa7.pistes;
public class Menu {
    public void iniciar(){
    boolean continuar = true;

    while (continuar) {
        System.out.println("MENU DE L'INVESTIGADOR");
        System.out.println("1. Afegir pistes");
        System.out.println("2. Eliminar pistes sospitoses");
        System.out.println("3. Buscar pistes per paraules clau");
        System.out.println("4. Mostrar totes les pistes");
        System.out.println("5. Mostrar pistes per categoria");
        System.out.println("6. Substituir data de pista");
        System.out.println("7. Gestionar investigacions");
        System.out.println("8. Eixir");

        int opcionSeleccionada = GestorIO.llegirNumEnter("\nSelecciona una opció: ");
        
        switch (opcionSeleccionada) {
            case 1 -> afegirPistes();
            case 2 -> GestorPistes.eliminarPistesSospitoses();
            case 3 -> buscarPistesPerParaulaClau();
            case 4 -> GestorPistes.mostrarTotesLesPistes();
            
            case 5 -> {
            }
            
            case 6 -> {
            }
            
            case 7 -> {
            }
            
            case 8 -> {
                continuar = false;
                System.out.println("\n[--- Eixint del programa ---]");
            }
            }  
        }
        GestorIO.tancarScanner();
    }
    
    
    private static void afegirPistes(){
        String descripcionPista = GestorIO.llegirText("Ingressa la descripció de la pista: ");
        String seleccionCategoria = GestorIO.llegirText("Categoria (Govern/Tecnologia/Misteri/Corruppció): ");
        Categoria categoria = Categoria.fromString(seleccionCategoria);
        int nivelFiavilidad = GestorIO.llegirNumEnter("Nivell de confiabilitat (1-10): ");
        boolean asociarPista = GestorIO.solicitarConfirmacio("Vols asociar aquesta pista a una investigacio? (S/N): ");
               
        Pista novaPista = new Pista(descripcionPista,categoria,nivelFiavilidad);
                
        if (asociarPista) {
            String nombreInvestigacion = GestorIO.llegirText("Ingresa el nom de la investigació: ");
            GestorPistes.afegirPistesAInvestigacio(novaPista,nombreInvestigacion);
        }else{
            GestorPistes.afegirPistes(novaPista);
        }
    }
    
    private static void buscarPistesPerParaulaClau(){
        String paraulesClauObtenides = GestorIO.llegirText("\nIngresa les paraules clau (Separades per espai en blanc): ");
        GestorPistes.buscarPistesPerParaulaClau(paraulesClauObtenides);
    }
    
    
    
}
