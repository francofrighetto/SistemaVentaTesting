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

    @Test // Testeamos flujo alternativo: cantidad cero
    public void testGetTotal_CantidadCero() {
        Venta venta = new Venta();
        Float cantidad = 0.0f;                              // Cantidad Cero
        Float precio = 10.0f;
        ProductoVendido producto = new ProductoVendido(cantidad, precio, "ProductoTest", "123", venta);
        Float totalEsperado = 0.0f;                         // resultado: 0
        Float totalReal = producto.getTotal();              // deberia ser 0 tambien
        assertEquals(totalEsperado, totalReal);
    }

    @Test // Testeamos flujo alternativo: precio cero
    public void testGetTotal_PrecioCero() {
        Venta venta = new Venta();
        Float cantidad = 5.0f;                              
        Float precio = 0.0f;                                // Precio Cero
        ProductoVendido producto = new ProductoVendido(cantidad, precio, "ProductoTest", "123", venta);
        Float totalEsperado = 0.0f;                         // resultado: 0
        Float totalReal = producto.getTotal();              // deberia ser 0 tambien
        assertEquals(totalEsperado, totalReal);
    }

    @Test // Testeamos flujo alternativo: cantidad negativa
    public void testGetTotal_CantidadNegativa() {
        Venta venta = new Venta();
        Float cantidad = -5.0f;                              // Cantidad Negativa
        Float precio = 10.0f;                                
        ProductoVendido producto = new ProductoVendido(cantidad, precio, "ProductoTest", "123", venta);
        Float totalEsperado = 0.0f;                         // resultado: 0  (para una cantidad negativa, el total deberia ser cero)
        Float totalReal = producto.getTotal();              // deberia ser 0 tambien
        assertEquals(totalEsperado, totalReal);
    }
}