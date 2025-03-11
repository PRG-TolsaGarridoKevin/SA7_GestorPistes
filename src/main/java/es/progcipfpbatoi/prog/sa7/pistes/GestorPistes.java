package es.progcipfpbatoi.prog.sa7.pistes;

import java.util.ArrayList;

public class GestorPistes {
    //una lista de pistas ordenadas por ingreso y SI pueden haber pistas repetidas
    private static ArrayList<Pista> listaPistes = new ArrayList<>();
    
    //un conjunto de pistas arxivadas , NO pueden haber pistas repetidas
    
    //un diccionario que permita asociar las pistas a una investigacion concreta 
    //la llave sera el nombre de la investigacion
    //el valor sera una lista de pistas relacionadas
    
    //Acciones de la clase -------------------------------------------------------
    
    //AfegirPistes --> AfegirPistesAInvestigacio
    public static void afegirPistes(Pista pista, boolean asociarPista){
        //Preguntar por asociar en el Menu
        if (asociarPista) {
            
        }
        //Si dice que si añadir la pista a una investigacion concreta (el nombre se la pasa el usuario) 
        //Si no existe se crea una nueva investigacion , si la pista no se asocia ,solo se añadira a la lista de pistas  
        
        if (listaPistes.contains(pista)) {
            //Si la pista esta repetida, antes de añadirla se sustitullen las fechas de las pistas repetidas 
            //a la fecha de la nueva pista añadida, ademas de avisar al usuario con un mensage(ejemplo de ejecucion)
            //La pista ja existeix.
            //Actualització de les dates de les pistes repetides a la data 03/02/2025
            //la fecha de la nueva pista sera la fecha del sistema y la fiabilidad no variara de la original
        }else{
            listaPistes.add(pista);
            
        }
        //Mensage de que la pista se ha agregado con exito (Pista 1 agregada amb èxit.) el numero varia
        
    }
    //**** Repasar documentacion para completar los metodos siguienntes ****
    
    
    //EliminarPistesSospitoses
    
    //BuscarPistesPerParaulaClau
    
    //MostrarTotesLesPistes
    
    //MostrarPistesPerCategoria
    
    //SustituirFechaDePista
    
    //GestionarInvestigacions --> MostrarInvestigacionsObertes, MostrarPistesDeInvestigacio, TancarInvestigacio
    
}
