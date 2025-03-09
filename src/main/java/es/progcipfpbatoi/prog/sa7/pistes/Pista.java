package es.progcipfpbatoi.prog.sa7.pistes;
import java.util.Date;
import java.util.Objects;

public class Pista {
    private int id;
    private String descripcio;
    private Categoria categoria;
    private int confiabilitat;
    private Date dataDescobriment;

    //cuando hacemos new pista sumamos 1 a la pista
    public Pista(int id, String descripcio, Categoria categoria, int confiabilitat, Date dataDescobriment) {
        this.id = id;
        this.descripcio = descripcio;
        this.categoria = categoria;
        this.confiabilitat = confiabilitat;
        this.dataDescobriment = dataDescobriment;
    }

    @Override
    public String toString() {
        return "[" + categoria + "]" + descripcio + " | Confiabilitat:" + confiabilitat + " | Descoberta el " + dataDescobriment;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    
    
    /*
        Es considera que una pista és igual a un altra si la seua categoria 
        coincideix i, a més, el 80% de les paraules de la descripció també
        coincideixen (es considera com a separador entre paraules, l’espai 
        en blanc (un o mes seguits), la coma i/o el punt).
    */
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pista other = (Pista) obj;
        if (!Objects.equals(this.descripcio, other.descripcio)) {
            return false;
        }
        return this.categoria == other.categoria;
    }
    
}
