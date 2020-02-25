import java.time.LocalDate;

public class Factura {
    private Tarifa tarifaAplicada;
    private int codigo;
    private LocalDate emision;
    private LocalDate inicioPeriodo;    //Inicio del periodo de Facturacion
    private LocalDate finalPeriodo;     //Final del periodo de Facturacion
    private double importe;

    public LocalDate getEmision() {
        return emision;
    } //Fecha de emision
}
