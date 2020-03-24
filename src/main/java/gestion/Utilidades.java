package gestion;

import data.Fecha;
import gestion.excepciones.ElementosNoEncontradosException;

import java.time.LocalDate;
import java.util.HashSet;

public class Utilidades {

    static <T extends Fecha> HashSet<T> filtrarElementosEntreFechas(HashSet<T> conjunto, LocalDate fechaInicial, LocalDate fechaFinal)
            throws ElementosNoEncontradosException {
        HashSet<T> nuevoConjunto = new HashSet<T>();
        for (T objeto: conjunto) {
            if (objeto.getFecha().compareTo(fechaInicial)>=0 && objeto.getFecha().compareTo(fechaFinal)<=0)
                nuevoConjunto.add(objeto);
        }
        if (nuevoConjunto.isEmpty()) throw new ElementosNoEncontradosException();
        return nuevoConjunto;
    }

    <T> String convertHashToString(HashSet<T> conjunto){
        String resultado = null;
        for (T elemento : conjunto)
            resultado = resultado + elemento.toString() + "\n";
        return resultado;
    }

}
