package testingUTN.SistemaVenta;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrancoTest {
    ProductoParaVender productoParaVender = new ProductoParaVender();

	@Test
	void aumentarCantidad(){
		Float valor = 0.0f;
		productoParaVender.setCantidad(valor);
		productoParaVender.aumentarCantidad();
		assertTrue(productoParaVender.getCantidad()>valor);
	}

    @Test
	void setCantidadNegativa(){
        // valor inicial positivo
        Float valorOriginalPsotivo = 5f;
		productoParaVender.setCantidad(valorOriginalPsotivo);

        // pruebo cambiarlo a negativo
		productoParaVender.setCantidad(-1f);

        // pruebo con assert true y false
		// assertTrue(productoParaVender.getCantidad()>=0);
        assertFalse(productoParaVender.getCantidad()<=0);
	}

    // igual que el test de arriba, pero con parametros
    // prueba muchos casos de una
    @ParameterizedTest
    @ValueSource(floats = {10f, -5f, -10f,84.2f})
	void setCantidadNegativaParametrizado(Float distintosValores){
        // valor inicial positivo
        Float valorOriginalPsotivo = 5f;
		productoParaVender.setCantidad(valorOriginalPsotivo);

        // pruebo cambiarlo a negativo
		productoParaVender.setCantidad(distintosValores);

        // pruebo con assert true y false
		// assertTrue(productoParaVender.getCantidad()>=0);
        assertFalse(productoParaVender.getCantidad()<=0);
	}
}
