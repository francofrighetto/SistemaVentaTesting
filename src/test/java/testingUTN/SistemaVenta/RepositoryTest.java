package testingUTN.SistemaVenta;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

// // @DataJpaTest
// // @SpringBootTest
// @SpringBootApplication
// @ExtendWith(MockitoExtension.class)

// public class RepositoryTest {

//     @Mock
//     private VentasRepository ventasRepository;

//     @Test
//     public void testTotalVenta() {
//         // Create a mock Venta object
//         Venta venta = new Venta();
//         Set<ProductoVendido> productos = new HashSet<>();
//         ProductoVendido producto1 = new ProductoVendido();
//         producto1.setPrecio(10.0f);
//         ProductoVendido producto2 = new ProductoVendido();
//         producto2.setPrecio(20.0f);
//         productos.add(producto1);
//         productos.add(producto2);
//         venta.setProductos(productos);

//         when(ventasRepository.findById(1)).thenReturn(java.util.Optional.of(venta));

//         System.out.println(venta);
//     }
    
// }

@ExtendWith(MockitoExtension.class)
public class RepositoryTest {

    @Mock
    private VentasRepository ventasRepository;


    @Test
    public void testTotalVenta() {
        // Create a mock Venta object
        Venta venta = new Venta();
        venta.setId(1);
        Set<ProductoVendido> productos = new HashSet<>();
        ProductoVendido producto1 = new ProductoVendido();
        producto1.setPrecio(10.0f);
        ProductoVendido producto2 = new ProductoVendido();
        producto2.setPrecio(20.0f);
        productos.add(producto1);
        productos.add(producto2);
        venta.setProductos(productos);

        // Configure the mock behavior
        when(ventasRepository.findById(1)).thenReturn(Optional.of(venta));

        // Call the method under test
        Optional<Venta> result = ventasRepository.findById(1);


        // Validate the result
        assertNotNull(result);
        System.out.println(result.orElse(null));
    }

    @Test
    public void testEmpleado() {
        // Create a mock Venta object
        Venta venta = new Venta();
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

        // Configure the mock behavior
        when(ventasRepository.findByNombreempleado("franco")).thenReturn(Optional.of(venta));

        // Call the method under test
        Optional<Venta> result = ventasRepository.findByNombreempleado("franco");


        // Validate the result
        assertNotNull(result);
        System.out.println(result.orElse(null));
    }
}
