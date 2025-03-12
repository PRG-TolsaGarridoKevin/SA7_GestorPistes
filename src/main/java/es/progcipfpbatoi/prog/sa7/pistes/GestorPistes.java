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
        for (int i = 0; i < GestorPistes.listaPistes.size(); i++) {
            Pista pistaActual = listaPistes.get(i);
            
            for (int j = i+1; j < listaPistes.size(); j++) {
                Pista pistaAComparar = listaPistes.get(j);
                
                if (pistaActual.equals(pistaAComparar)) {
                    if (pistaActual.getId() > pistaAComparar.getId()) {
                        listaPistes.remove(pistaActual);
                    }else{
                        listaPistes.remove(pistaAComparar);
                    }
                }      
            }
        }
    
    //2-Una vez terminado el proceso 1 , se eliminaran todas las pistas de la lista de fiabilidad inferior a 4,
    //estas si se archivaran
    //Al terminar se muestra un mensaje (ver ejemplo de ejecucion)
    
    }
    
    
    
    
    
    //**** Repasar documentacion para completar los metodos siguienntes ****
    
    //BuscarPistesPerParaulaClau
    
    //MostrarTotesLesPistes
    
    //MostrarPistesPerCategoria
    
    //SustituirFechaDePista
    
    //GestionarInvestigacions --> MostrarInvestigacionsObertes, MostrarPistesDeInvestigacio, TancarInvestigacio
    
}
