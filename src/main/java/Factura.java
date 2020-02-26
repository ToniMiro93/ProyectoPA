import java.time.LocalDate;

public class Factura {
    static private int codigoDisponible;
    private Tarifa tarifaAplicada;
    final private int codigo;
    private LocalDate emision;  //Fecha de emision
    private LocalDate inicioPeriodo;    //Inicio del periodo de gestionClientes
    private LocalDate finalPeriodo;     //Final del periodo de gestionClientes
    private double importe;

    public Factura(Tarifa tarifaAplicada, LocalDate emision, LocalDate inicioPeriodo, LocalDate finalPeriodo) {
        this.tarifaAplicada = tarifaAplicada;
        this.codigo = codigoDisponible++;
        this.emision = emision;
        this.inicioPeriodo = inicioPeriodo;
        this.finalPeriodo = finalPeriodo;
    }

    public LocalDate getEmision() {
        return emision;
    }

    public void calcularImporte(){
        double sumaImporte;
    }
}
