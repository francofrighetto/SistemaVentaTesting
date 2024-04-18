package testingUTN.SistemaVenta;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

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

    Producto producto = new Producto("Joa", "Joa", 0.0f, 0.0f);

    @Test
    public void testConExistencia() {
        assertTrue(producto.sinExistencia());


    }

    @Test
    public void testSinExistencia() {
        assertFalse(producto.sinExistencia());
    }

    /*pruebo aumentando la existencia */
    
    @Test
    public void testAumentarExistencia(){
        producto.setExistencia(10f);
        assertFalse(producto.sinExistencia());
    }

    @ParameterizedTest
    @ValueSource(floats = {10f, -5f, -10f,84.2f})
    public void testAumentarExistenciaParametrizado(Float distintosValores){
        producto.setExistencia(10f);
        assertFalse(producto.sinExistencia());
    }
}