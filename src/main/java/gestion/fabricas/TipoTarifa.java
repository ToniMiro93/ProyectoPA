package gestion.fabricas;

public enum TipoTarifa {

    TARDES("Tarifa de tardes"),
    DOMINGOS("Tarifa de domingos");

    private String descripción;

    TipoTarifa(String descripción) {
        this.descripción = descripción;
    }

    public static String opciones() {
        StringBuilder sb = new StringBuilder();
        sb.append("Elige una opcion: " + "\n");
        for (TipoTarifa tipo: values())
            sb.append(tipo.ordinal() + ") " + tipo.descripción + "\n");
        return sb.toString();
    }

    public static TipoTarifa IntergerToTipo(int posicion) {
        return values()[posicion];
    }


}

