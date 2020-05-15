package mvc.modelo;

import data.cliente.Cliente;
import mvc.modelo.tablas.InterrogaTablas;

import java.time.LocalDate;
import java.util.ArrayList;

public interface InterrogaModelo {
    ArrayList<Cliente> listarClientes();
    ArrayList<Cliente> clientesEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
    Cliente recuperarCliente(String nif);
    InterrogaTablas consultaTabla();
}
