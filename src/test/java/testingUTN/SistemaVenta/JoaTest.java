package testingUTN.SistemaVenta;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
/*  Testeamos un flujo normal*/
@SuppressWarnings("unused")
@SpringBootTest
public class JoaTest {

    /* Testeamos un flujo normal */
    @Test
    public void testSinExistencia_FlujoNormal() {
        Producto producto = new Producto("Joa", "123", 10.0f, 20.0f, 5);
        assertFalse(producto.sinExistencia());
    }

    /* Testeamos un flujo alternativo */
    @Test
    public void testSinExistencia_FlujoAlternativo() {
        Producto producto = new Producto("Joa", "123", 10.0f, 0.0f, 5);
        assertTrue(producto.sinExistencia());
    }
    /* testeamos un flujo normal para existencia */
    @Test
    public void testExistencia_FlujoNormal() {
        Producto producto = new Producto("Joa", "123", 10.0f, 20.0f, 5);
        assertEquals(20.0f, producto.getExistencia());
    }

}