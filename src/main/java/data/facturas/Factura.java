package data.facturas;

import data.Fecha;
import data.tarifas.Tarifa;

import java.io.Serializable;
import java.time.LocalDate;

public class Factura implements Serializable, Fecha {
    private static int codigoDisponible;
    private Tarifa tarifaAplicada;
    private final int codigo;
    private LocalDate fechaEmision;     //Fecha de fechaEmision
    private LocalDate inicioPeriodo;    //Inicio del periodo de gestion.GestionClientes
    private LocalDate finalPeriodo;     //Final del periodo de gestion.GestionClientes
    private double importe;

    public Factura(Tarifa tarifaAplicada, LocalDate fechaEmision, LocalDate inicioPeriodo, LocalDate finalPeriodo, double importe) {
        this.tarifaAplicada = tarifaAplicada;
        this.codigo = codigoDisponible++;
        this.fechaEmision = fechaEmision;
        this.inicioPeriodo = inicioPeriodo;
        this.finalPeriodo = finalPeriodo;
        this.importe = importe;
    }




    public LocalDate getFecha() {
        return fechaEmision;
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
        return "data.facturas.Factura{" + '\n' +
                "tarifaAplicada=" + tarifaAplicada + '\n' +
                ", codigo=" + codigo + '\n' +
                ", fechaEmision=" + fechaEmision + '\n' +
                ", inicioPeriodo=" + inicioPeriodo + '\n' +
                ", finalPeriodo=" + finalPeriodo + '\n' +
                ", importe=" + importe + '\n' +
                '}';
    }

    public Tarifa getTarifaAplicada() {
        return tarifaAplicada;
    }
}
