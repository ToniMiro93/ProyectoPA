package baseDeDatos.facturas;

import baseDeDatos.clientes.datos.Tarifa;

import java.time.LocalDate;

public class Factura {
    private static int codigoDisponible;
    private Tarifa tarifaAplicada;
    private final int codigo;
    private LocalDate emision;          //Fecha de emision
    private LocalDate inicioPeriodo;    //Inicio del periodo de gestion.GestionClientes
    private LocalDate finalPeriodo;     //Final del periodo de gestion.GestionClientes
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
        return "baseDeDatos.facturas.Factura{" + '\n' +
                "tarifaAplicada=" + tarifaAplicada + '\n' +
                ", codigo=" + codigo + '\n' +
                ", emision=" + emision + '\n' +
                ", inicioPeriodo=" + inicioPeriodo + '\n' +
                ", finalPeriodo=" + finalPeriodo + '\n' +
                ", importe=" + importe + '\n' +
                '}';
    }
}
