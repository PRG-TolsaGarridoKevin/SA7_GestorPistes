package es.progcipfpbatoi.prog.sa7.pistes;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class GestorPistes {
    //Lista
    private static final ArrayList<Pista> listaPistes = new ArrayList<>();
    
    //Conjunto
    private static final HashSet<Pista> pistasArchivadas = new HashSet<>();
    
    //Diccionario
    private static final HashMap<String, ArrayList<Pista>> investigaciones = new HashMap<>();
    
    //Acciones de la clase -------------------------------------------------------
    
    public static void afegirPistesAInvestigacio(Pista pista, String nombreInvestigacion){
        investigaciones.put(nombreInvestigacion, listaPistes);
        if (investigaciones.containsKey(nombreInvestigacion)) {
            System.out.println("Pista "+pista.getId()+" agregada amb exit (asociada al cas " + nombreInvestigacion+")");
        }else{
            System.out.println("Pista "+pista.getId()+" agregada amb exit (asociada al nou cas " + nombreInvestigacion+")");
        }
    }
        
    public static void afegirPistes(Pista pista){
        
    if (listaPistes.contains(pista)) {
        System.out.println("La pista ja existeix");

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
        System.out.printf("\tEliminades per repetició: %d\n",contEliminacionPorRepeticion);
        System.out.printf("\tEliminades per baixa confiabilitat: %d\n",contEliminacionPorBajaFiabilidad);
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
    
    //**** Repasar documentacion para completar los metodos siguienntes ****
    
    //MostrarTotesLesPistes
    
    //MostrarPistesPerCategoria
    
    //SustituirFechaDePista
    
    //GestionarInvestigacions --> MostrarInvestigacionsObertes, MostrarPistesDeInvestigacio, TancarInvestigacio
    
}
