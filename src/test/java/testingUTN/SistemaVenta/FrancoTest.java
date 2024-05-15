package testingUTN.SistemaVenta;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*  
    Test sobre clase: ProductoParaVender
    metodo: getTotal()        mmmm nose
*/

@SpringBootApplication
public class FrancoTest {
	ProductoParaVender productoParaVender;

	@BeforeEach
	void setUp() {
		// Configurar el estado inicial antes de cada prueba
		productoParaVender = new ProductoParaVender("Producto", "123", 10f, 20f, 5f);
	}

	// testea que incremente bien el valor
	@Test
	void aumentarCantidad() {
		productoParaVender.aumentarCantidad();
		assertEquals(productoParaVender.getCantidad(), 6f);
	}

	// no puede ingresar valores negativos, si puede 0
	@Test
	void setCantidadNegativa() {
		// pruebo cambiarlo a negativo
		productoParaVender.setCantidad(-1f);

		// pruebo con assert true y false
		assertTrue(productoParaVender.getCantidad() >= 0);
		// assertFalse(productoParaVender.getCantidad()<=0);
	}

	// igual que el test de arriba, pero con parametros
	// prueba muchos casos de una
	@ParameterizedTest
	@ValueSource(floats = { 10f, -5f, -10f, 84.2f })
	void setCantidadNegativaParametrizado(Float distintosValores) {
		// pruebo cambiarlo a negativo
		productoParaVender.setCantidad(distintosValores);

		// pruebo con assert true y false
		// assertTrue(productoParaVender.getCantidad()>=0);
		assertFalse(productoParaVender.getCantidad() <= 0);
	}

	// tienen que pasar todos los test
	@Test
	void groupedAssertions() {
		productoParaVender.setCantidad(-2f);
		productoParaVender.setPrecio(-200f);
		assertAll("positivo",
				() -> assertTrue(productoParaVender.getCantidad()>=0),
				() -> assertTrue(productoParaVender.getPrecio()>=0)
				);
	}

	// pruea
	// @Test
	// void excepcionNegativa(){

	// Exception exception = assertThrows(IllegalArgumentException.class, () -> {
	// productoParaVender.setCantidad(4f);
	// });

	// String actualMessage = exception.getMessage();
	// System.out.println(actualMessage);
	// assertThrows(IllegalArgumentException.class, () -> {
	// productoParaVender.setCantidad(4f);
	// });

	// assertDoesNotThrow(() -> {
	// // Intentamos establecer una cantidad positiva
	// productoParaVender.setCantidad(10f);
	// });
	// }
}
