package testingUTN.SistemaVenta;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ApplicationTests {
	ProductoParaVender productoParaVender = new ProductoParaVender();

	@Test
	void contextLoads() {
	}

	@Test
	void prueba(){
		Float valor = 0.0f;
		productoParaVender.setCantidad(valor);
		productoParaVender.aumentarCantidad();
		assertTrue(productoParaVender.getCantidad()>valor);

	}

}
