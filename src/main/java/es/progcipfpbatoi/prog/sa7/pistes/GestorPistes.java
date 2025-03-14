package es.progcipfpbatoi.prog.sa7.pistes;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GestorPistes {
    //Lista
    private static final ArrayList<Pista> listaPistes = new ArrayList<>();
    
    //Conjunto
    private static final HashSet<Pista> pistasArchivadas = new HashSet<>();
    
    //Diccionario
    private static final HashMap<String, ArrayList<Pista>> investigaciones = new HashMap<>();
    
    //Acciones de la clase -------------------------------------------------------
    
    public static void afegirPistesAInvestigacio(Pista pista, String nombreInvestigacion){
        listaPistes.add(pista);
        investigaciones.put(nombreInvestigacion, listaPistes);
        
        if (investigaciones.containsKey(nombreInvestigacion)) {
            System.out.println("\nPista "+pista.getId()+" agregada amb exit (asociada al cas " + nombreInvestigacion+")");
        }else{
            System.out.println("\nPista "+pista.getId()+" agregada amb exit (asociada al nou cas " + nombreInvestigacion+")");
        }
    }
        
    public static void afegirPistes(Pista pista){
        
    if (listaPistes.contains(pista)) {
        System.out.println("\nLa pista ja existeix\n");

        for (Pista pistaExistente : listaPistes) {
            if (pistaExistente.equals(pista)) {
                Date novaData = new Date();
                pista.setDataDescobriment(novaData);
                pistaExistente.setDataDescobriment(novaData);
                pista.setConfiabilitat(pistaExistente.getConfiabilitat()); 
                System.out.println("Actualització de les dates de les pistes repetides a la data "+ pista.getDataDescobriment());
                break;
            }
        }
    }else{
        listaPistes.add(pista);    
    }
        System.out.printf("Pista %d agregada amb exit",pista.getId());
    }
    

    //EliminarPistesSospitoses (repetidas y poco fiables)
    public static void eliminarPistesSospitoses(){
        int contEliminacionPorRepeticion = 0;
        int contEliminacionPorBajaFiabilidad = 0;
        
        for (int i = 0; i < GestorPistes.listaPistes.size(); i++) {
            Pista pistaActual = listaPistes.get(i);
            
            for (int j = i+1; j < listaPistes.size(); j++) {
                Pista pistaAComparar = listaPistes.get(j);
                
                if (pistaActual.equals(pistaAComparar)) {
                    if (pistaActual.getId() > pistaAComparar.getId()) {
                        listaPistes.remove(i);
                        contEliminacionPorRepeticion++;
                        i--;
                        break;
                    }else{
                        listaPistes.remove(j);
                        contEliminacionPorRepeticion++;
                        j--;
                    }
                }      
            }
        }

        for (int i = 0; i < GestorPistes.listaPistes.size(); i++) {
            Pista pistaActual = listaPistes.get(i);
            
            if (pistaActual.getConfiabilitat() < 4) {
                pistasArchivadas.add(pistaActual);
                listaPistes.remove(i);
                contEliminacionPorBajaFiabilidad++;
                i--;
            }
        }
        
        System.out.println("\nProcés d'eliminació de pistes completat =>");
        System.out.printf("\tArxivades per baixa confiabilitat: %d\n",contEliminacionPorBajaFiabilidad);
        System.out.printf("\tEliminades per repetició: %d\n",contEliminacionPorRepeticion);
        System.out.println(".....\n");
    }
    
    
    //BuscarPistesPerParaulaClau
    public static void buscarPistesPerParaulaClau(String paraulesClau){
        ArrayList<Pista> pistasConPalabraClave = new ArrayList<>();
        String[] palabrasClave = paraulesClau.split("\\s+"); 
        
        //Buscar pistas almacenadas en lista con las palabras clave
        for (Pista pistaEnLista : GestorPistes.listaPistes) {
           if (contieneAlgunaParaulaClau(pistaEnLista, palabrasClave)) {
                pistasConPalabraClave.add(pistaEnLista);
            }
        }
        
        //Buscar pistas archivadas en conjunto con las palabras clave
        for (Pista pistaEnArchivo : GestorPistes.pistasArchivadas) {
            if (contieneAlgunaParaulaClau(pistaEnArchivo, palabrasClave)) {
                pistasConPalabraClave.add(pistaEnArchivo);
            }
        }
        
        if (pistasConPalabraClave.isEmpty()) {
            System.out.print("\nNo hay pistas con esas palabras clave\n");
        }else{
            System.out.print("\nPista trobada amb èxit\n");
            
            for (Pista pista : pistasConPalabraClave) {
                System.out.println(pista.toString());
            }
        }
    }
    
    private static boolean contieneAlgunaParaulaClau(Pista pista, String[] paraulesClau) {
    String[] palabrasDescripcion = pista.getDescripcio().split("\\s+");
    for (String paraulaClau : paraulesClau) {
        for (String palabraDescripcion : palabrasDescripcion) {
            if (palabraDescripcion.equalsIgnoreCase(paraulaClau)) {
                return true;
            }
        }
    }
    return false;
}
    
    //MostrarTotesLesPistes
    public static void mostrarTotesLesPistes(){
        //Mostrar totes les pistes
        if (GestorPistes.listaPistes.isEmpty()) {
            System.out.printf("\nNo hi ha cap pista en la llista de pistes\n");
        }else{
            System.out.println("Pistes de la llista");
            for (Pista pista : listaPistes) {
                System.out.println("\n"+pista.getId()+". "+pista.toString());
            }
        }
        
        //Mostrar pistas archivadas
        if (GestorPistes.pistasArchivadas.isEmpty()) {
            System.out.printf("\nNo hi ha cap pista arxivada\n");
        }else{
            System.out.println("\nPistes arxivades");
            for (Pista pistaArchivada : pistasArchivadas) {
                System.out.println("\n"+pistaArchivada.getId()+". "+pistaArchivada.toString());
            }
        }
    }

    //MostrarPistesPerCategoria
    public static void mostrarPistesPerCategoria(String categoria){
        int cont = 1;
        ArrayList<Pista> listaCategorias = new ArrayList<>();
        for (Pista pista : listaPistes) {
            if (pista.getCategoria().equals(Categoria.fromString(categoria))){
                System.out.println("\n"+cont+". "+pista.toString());
                listaCategorias.add(pista);
                cont++;
            }
        }
        
        if (listaCategorias.isEmpty()) {
            System.out.println("\nLa categoria descrita no existeix\n");
        }
    } 
        
    //SustituirFechaDePista
    public static void substituirDataDeUnaPista(int idPista){
        Pista pistaEncontrada = null;
        for (Pista pista : listaPistes) {
            if (pista.getId() == idPista) {
                pistaEncontrada = pista;
                System.out.printf("La pista %d si existeix\n",idPista);
                Menu.pedirNuevaFecha(pistaEncontrada);
            }else{
                System.out.printf("La pista %d no existeix\n",idPista);
                break;
            }
        }
    }
    
    //GestionarInvestigacions --> MostrarInvestigacionsObertes, MostrarPistesDeInvestigacio, TancarInvestigacio
    public static void gestionarInvestigacions(){
        System.out.println("\nGestionar investigacions");
        System.out.println("1. Mostrar totes les investigacions");
        System.out.println("2. Mostrar pistes per investigació");
        System.out.println("3. Tancar una investigació");
        
        int opcionSeleccionada = GestorIO.llegirNumEnter("Selecciona una opció: ");
        
        switch(opcionSeleccionada){
            case 1 -> {
                System.out.println("\nInvestigacions Obertes\n");
                int contador = 1;
                for (Map.Entry<String,ArrayList<Pista>> investigacion : investigaciones.entrySet()) {
                    System.out.println(contador+". "+investigacion.getKey()+" (Pistes asociades: "+investigacion.getValue().size()+")\n");
                    contador++;
                }
            }
            case 2 -> {}
            case 3 -> {}
                  
        
        }
    
    }
    
    public static void afegirPistesTest(){
        Pista novaPista1 = new Pista("Pista uno de test, per a vorer si funciona correctament",Categoria.CORRUPCIO,6);
        Pista novaPista2 = new Pista("Pista uno de test per vorer si funciona correctament",Categoria.CORRUPCIO,3);
        Pista novaPista3 = new Pista("Pista tres de test",Categoria.MISTERI,8);
        Pista novaPista4 = new Pista("Pista cuatre de test, jsfvskjfvskufvskfuyvskfu",Categoria.TECNOLOGIA,2);
    
        listaPistes.add(novaPista1);
        listaPistes.add(novaPista2);
        listaPistes.add(novaPista3);
        listaPistes.add(novaPista4);
    }
}
