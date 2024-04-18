package testingUTN.SistemaVenta;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
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
}
