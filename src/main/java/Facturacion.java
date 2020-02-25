import java.util.HashMap;
import java.util.HashSet;

public class Facturacion {
    private HashMap<String, HashSet<Llamada>> llamadas;
    private HashMap<String, HashSet<Factura>> facturas;

    Facturacion(){
        llamadas=new HashMap<>();
        facturas=new HashMap<>();
    }


}
