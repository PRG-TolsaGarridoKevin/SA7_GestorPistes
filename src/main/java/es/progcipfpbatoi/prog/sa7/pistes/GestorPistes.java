package es.progcipfpbatoi.prog.sa7.pistes;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class GestorPistes {
    private static final ArrayList<Pista> listaPistes = new ArrayList<>();
    
    //un conjunto de pistas arxivadas , NO pueden haber pistas repetidas
    //
    
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
    
    
    
    //**** Repasar documentacion para completar los metodos siguienntes ****
    
    
    //EliminarPistesSospitoses
    
    //BuscarPistesPerParaulaClau
    
    //MostrarTotesLesPistes
    
    //MostrarPistesPerCategoria
    
    //SustituirFechaDePista
    
    //GestionarInvestigacions --> MostrarInvestigacionsObertes, MostrarPistesDeInvestigacio, TancarInvestigacio
    
}
