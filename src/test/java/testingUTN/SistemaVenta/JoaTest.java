package testingUTN.SistemaVenta;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/*
Test sobre la clase: Producto
    metodo: sinExistencia()
    test que comprueba que el producto no tiene existencia

    Resultado esperado: false
*/

@SuppressWarnings("unused")
@SpringBootTest
public class JoaTest {

    /*Se crea un objeto de la clase Producto con un nombre, descripción y existencia inicial de cero. */

    Producto producto;

    @BeforeEach
    public void setUp() {
        // Crear un nuevo producto antes de cada prueba
        producto = new Producto("Joa", "123", 50.0f, 10f);
    }
    @Test
    public void testConExistencia() {
        imprimirExistencia();
        assertTrue(producto.sinExistencia());
    }

    @Test
    public void testSinExistencia() {
        imprimirExistencia();
        assertFalse(producto.sinExistencia());
    }

    @Test
    public void testAumentarExistencia() {
        imprimirExistencia();
        producto.setExistencia(10f);
        imprimirExistencia();
        assertFalse(producto.sinExistencia());
    }

    @Test
    public void testDisminuirExistencia() {
        imprimirExistencia();
        producto.setExistencia(5.0f);
        imprimirExistencia();
        assertTrue(producto.sinExistencia());
    }

    // Método para imprimir la existencia del producto
    private void imprimirExistencia() {
        System.out.println("Existencia actual: " + producto.getExistencia());
    }
}