package data.llamada;

import data.Fecha;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada implements Serializable, Fecha {
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

    //Constructor provisional para los tests para controlar
    //las horas a las que se hacen las llamadas
    public Llamada(int duracion, LocalDate fecha, LocalTime hora){
        this.numDest = 111111111;
        this.duracion = duracion;
        this.fecha = fecha;
        this.hora = hora;
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
