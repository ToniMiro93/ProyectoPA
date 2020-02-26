import java.time.LocalDate;

public class Factura {
    private Tarifa tarifaAplicada;
    private int codigo;
    private LocalDate emision;
    private LocalDate inicioPeriodo;    //Inicio del periodo de Facturacion
    private LocalDate finalPeriodo;     //Final del periodo de Facturacion
    private double importe;

    public Factura(Tarifa tarifaAplicada, int codigo, LocalDate emision, LocalDate inicioPeriodo, LocalDate finalPeriodo, double importe) {
        this.tarifaAplicada = tarifaAplicada;
        this.codigo = codigo;
        this.emision = emision;
        this.inicioPeriodo = inicioPeriodo;
        this.finalPeriodo = finalPeriodo;
        this.importe = importe;
    }

    public LocalDate getEmision() {
        return emision;
    } //Fecha de emision
}
