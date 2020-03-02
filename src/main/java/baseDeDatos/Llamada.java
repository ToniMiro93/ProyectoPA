package baseDeDatos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada {
    private long numDest;
    private LocalDate fecha;
    private LocalTime hora;
    private int duracion;

    public Llamada(long numDest, int duracion) {
        this.numDest = numDest;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        this.duracion = duracion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public long getNumDest() {
        return numDest;
    }

    public LocalTime getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Llamada{" + "numDest=" + numDest + ", fecha=" + fecha + ", hora=" + hora + ", duracion=" + duracion + '}';
    }
}
