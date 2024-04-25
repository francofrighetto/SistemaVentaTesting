package testingUTN.SistemaVenta;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Test sobre la clase: Producto
    metodo: sinExistencia()
    test que comprueba que el producto no tiene existencia

    Resultado esperado: false
*/

/*Utilizamos @SpringBootApplication, que se utiliza para iniciar una aplicación Spring Boot. */
@SpringBootApplication
public class JoaTest {

    /*Este método de prueba crea un objeto Producto con una determinada cantidad de stock (20.0f) y comprueba que el método sinExistencia().  */
    /*Este método prueba un flujo normal donde el producto tiene stock. */
    @Test
    public void testSinExistencia_FlujoNormal() {
        Producto producto = new Producto("Joa", "123", 10.0f, 20.0f, 5);
        assertFalse(producto.sinExistencia());
    }

    /*Este método de prueba crea un objeto Producto sin stock (0.0f) y verifica que el método sinExistencia() de la clase Producto devuelva verdadero. */
    @Test
    public void testSinExistencia_FlujoAlternativo() {
        Producto producto = new Producto("Joa", "123", 10.0f, 0.0f, 5);
        assertTrue(producto.sinExistencia());
    }
    /* Este método de prueba crea un objeto Producto con una determinada cantidad de stock (20.0f) 
    y comprueba que el método getExistencia() de la clase Producto devuelva el valor esperado (20.0f). 
    Este método prueba un flujo normal donde el producto tiene stock. */
    @Test
    public void testExistencia_FlujoNormal() {
        Producto producto = new Producto("Joa", "123", 10.0f, 20.0f, 5);
        assertEquals(20.0f, producto.getExistencia());
    }

}