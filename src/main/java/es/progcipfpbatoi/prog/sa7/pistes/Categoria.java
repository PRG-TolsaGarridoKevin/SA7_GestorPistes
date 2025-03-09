package es.progcipfpbatoi.prog.sa7.pistes;

public enum Categoria {
    GOVERN, TECNOLOGIA, MISTERI, CORRUPCIO;

    public static Categoria fromString(String string) {
        switch (string.toUpperCase()) {
            case "GOVERN":
                return GOVERN;
            case "TECNOLOGIA":
                return TECNOLOGIA;
            case "MISTERI":
                return MISTERI;
            case "CORRUPCIO":
                return CORRUPCIO;
            default:
                return null;
        }
    };

    @Override
    public String toString() {
        return "Categoria = " + name();
    }
}
