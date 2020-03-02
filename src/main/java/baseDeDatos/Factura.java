package baseDeDatos;

import java.time.LocalDate;

public class Factura {
    static private int codigoDisponible;
    private Tarifa tarifaAplicada;
    final private int codigo;
    private LocalDate emision;  //Fecha de emision
    private LocalDate inicioPeriodo;    //Inicio del periodo de baseDeDatos.gestionClientes
    private LocalDate finalPeriodo;     //Final del periodo de baseDeDatos.gestionClientes
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

    public LocalDate getInicioPeriodo() {
        return inicioPeriodo;
    }

    public LocalDate getFinalPeriodo() {
        return finalPeriodo;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getImporte() {
        return importe;
    }

    @Override
    public String toString() {
        return "baseDeDatos.Factura{" + '\n' +
                "tarifaAplicada=" + tarifaAplicada + '\n' +
                ", codigo=" + codigo + '\n' +
                ", emision=" + emision + '\n' +
                ", inicioPeriodo=" + inicioPeriodo + '\n' +
                ", finalPeriodo=" + finalPeriodo + '\n' +
                ", importe=" + importe + '\n' +
                '}';
    }
}
