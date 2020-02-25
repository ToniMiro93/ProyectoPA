import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada {
    private int numDest;
    private LocalDate fecha;
    private LocalTime hora;
    private int duracion;

    public Llamada(int numDest, LocalDate fecha, LocalTime hora, int duracion) {
        this.numDest = numDest;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
