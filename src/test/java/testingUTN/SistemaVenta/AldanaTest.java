package testingUTN.SistemaVenta;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*  
    Test sobre clase: producto vendido
               metodo: getTotal() 
*/

public class AldanaTest {
    @Test // Testeamos un flujo normal
    public void testGetTotal() {
        // Creamos un objeto tipo Venta para el constructor de ProductoVendido
        Venta venta = new Venta();
        
        // Creamos un objeto ProductoVendido con una cantidad y precio específicos
        Float cantidad = 5.0f;
        Float precio = 10.0f;
        ProductoVendido producto = new ProductoVendido(cantidad, precio, "ProductoTest", "123", venta);
        
        // Calculamos el total esperado 
        Float totalEsperado = cantidad * precio;            // resultado: 50
        
        // Obtenemos el total real utilizando el método getTotal() y lo mostramos
        Float totalReal = producto.getTotal();              // deberia ser 50 tambien

        // Comprobar si el total esperado y el total real son iguales
        assertEquals(totalEsperado, totalReal);
    }





}