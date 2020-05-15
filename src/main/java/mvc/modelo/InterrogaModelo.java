package mvc.modelo;

import data.cliente.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;

public interface InterrogaModelo {
    ArrayList<Cliente> listarClientes();
    ArrayList<Cliente> clientesEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
