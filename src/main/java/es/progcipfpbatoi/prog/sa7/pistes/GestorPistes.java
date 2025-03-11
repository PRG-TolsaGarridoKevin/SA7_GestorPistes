package es.progcipfpbatoi.prog.sa7.pistes;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorPistes {
    private static ArrayList<Pista> listaPistes = new ArrayList<>();
    
    //un conjunto de pistas arxivadas , NO pueden haber pistas repetidas
    //
    
    private static HashMap<String, ArrayList<Pista>> investigaciones = new HashMap<>();
    
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
        //Si la pista esta repetida, antes de añadirla se sustitullen las fechas de las pistas repetidas 
        //a la fecha de la nueva pista añadida, ademas de avisar al usuario con un mensage(ejemplo de ejecucion)
        //La pista ja existeix.
        //Actualització de les dates de les pistes repetides a la data 03/02/2025
        //la fecha de la nueva pista sera la fecha del sistema y la fiabilidad no variara de la original
    }else{
        listaPistes.add(pista);    
    }
        //Mensage de que la pista se ha agregado con exito (Pista pista.getID() agregada amb èxit.) el numero varia
        
    }
    
    
    
    //**** Repasar documentacion para completar los metodos siguienntes ****
    
    
    //EliminarPistesSospitoses
    
    //BuscarPistesPerParaulaClau
    
    //MostrarTotesLesPistes
    
    //MostrarPistesPerCategoria
    
    //SustituirFechaDePista
    
    //GestionarInvestigacions --> MostrarInvestigacionsObertes, MostrarPistesDeInvestigacio, TancarInvestigacio
    
}
