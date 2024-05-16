package testingUTN.SistemaVenta;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class VentaRepositoryTest {

    @Mock
    private VentasRepository ventasRepository;
    Venta venta = new Venta();

    public VentaRepositoryTest(){
        venta.setId(1);
        venta.setNombreempleado("franco");

        Set<ProductoVendido> productos = new HashSet<>();
        ProductoVendido producto1 = new ProductoVendido();
        producto1.setPrecio(10.0f);
        ProductoVendido producto2 = new ProductoVendido();
        producto2.setPrecio(20.0f);
        productos.add(producto1);
        productos.add(producto2);
        venta.setProductos(productos);
    }

    @Test
    public void testFindId() {

        when(ventasRepository.findById(1)).thenReturn(Optional.of(venta));

        Optional<Venta> result = ventasRepository.findById(1);

        assertNotNull(result);
        System.out.println(result.orElse(null));
    }

    @Test
    public void testFindEmpleado() {

        when(ventasRepository.findByNombreempleado("franco")).thenReturn(Optional.of(venta));

        Optional<Venta> result = ventasRepository.findByNombreempleado("franco");

        assertNotNull(result);
        System.out.println(result.orElse(null));
    }

    @Test
    public void testFindEmpleadoNotFound() {
        when(ventasRepository.findByNombreempleado("maria")).thenReturn(Optional.of(venta));

        Optional<Venta> result = ventasRepository.findByNombreempleado("maria");

        assertTrue(!result.get().getNombreempleado().equals("maria"));
        System.out.println("Venta con nombre de empleado 'maria' no existe: " + result.orElse(null));
    }

    @Test
    public void testIdNotFound() {
        when(ventasRepository.findById(2)).thenReturn(Optional.of(venta));

        Optional<Venta> result = ventasRepository.findById(2);

        assertTrue(result.get().getId()!=2);
        System.out.println("Venta con ID 2 no existe: " + result.orElse(null));
    }

}
