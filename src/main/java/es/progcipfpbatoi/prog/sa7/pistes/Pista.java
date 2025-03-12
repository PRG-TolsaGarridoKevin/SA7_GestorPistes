package es.progcipfpbatoi.prog.sa7.pistes;

import java.util.Date;
import java.util.Objects;

public class Pista {

    private static int contadorId = 1;

    private int id;
    private String descripcio;
    private Categoria categoria;
    private int confiabilitat;
    private Date dataDescobriment;

    public Pista(String descripcio, Categoria categoria, int confiabilitat) {
        this.id = contadorId++;
        this.descripcio = descripcio;
        this.categoria = categoria;
        this.confiabilitat = confiabilitat;
        this.dataDescobriment = new Date();
    }

    @Override
    public String toString() {
        return "[" + categoria + "]" + descripcio + " | Confiabilitat:" + confiabilitat + " | Descoberta el " + dataDescobriment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoria, descripcio);
    }

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
        if (this.categoria != other.categoria) {
            return false;
        }

        String[] descripcion1 = dividirEnPalabras(this.descripcio);
        String[] descripcion2 = dividirEnPalabras(other.descripcio);

        int palabrasIguales = 0;
        for (String palabraDescripcion1 : descripcion1) {
            for (String palabraDescripcion2 : descripcion2) {
                if (palabraDescripcion1.equalsIgnoreCase(palabraDescripcion2)) {
                    palabrasIguales++;
                    break;
                }
            }
        }
        double porcentajeCoincidencias = (double) palabrasIguales / Math.max(descripcion1.length, descripcion2.length);
        return porcentajeCoincidencias >= 0.80;
    }

    private String[] dividirEnPalabras(String descripcion) {
        if (descripcion == null || descripcion.isEmpty()) {
            return new String[0];
        }
        String descripcionLimpiada = descripcion.replaceAll("[\\.,]", "");
        return descripcionLimpiada.trim().split("\\s+");
    }

    public int getId() {
        return id;
    }

    public Date getDataDescobriment() {
        return dataDescobriment;
    }

    public void setDataDescobriment(Date dataDescobriment) {
        this.dataDescobriment = dataDescobriment;
    }

    public int getConfiabilitat() {
        return confiabilitat;
    }

    public void setConfiabilitat(int confiabilitat) {
        this.confiabilitat = confiabilitat;
    }
}
