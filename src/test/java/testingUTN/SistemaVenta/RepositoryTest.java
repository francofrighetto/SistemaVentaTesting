package testingUTN.SistemaVenta;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
@SpringBootTest
public class RepositoryTest {

    @Autowired
    ProductosRepository productosRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Producto producto = new Producto();
        producto.setCodigo("1");
        producto.setExistencia(2f);
        producto.setNombre("nombre");
        producto.setPrecio(100f);
        
        testEntityManager.persist(producto);
    }


    @Test
    public void findLocalByNameIgnoreCaseFound(){
        Producto producto = productosRepository.findByNombre("nombre");
        assertEquals(producto.getNombre(),"nombre");
    }

    // @Test
    // public void findLocalByNameIgnoreCaseNotFound(){
    //     Optional<Local> local = localRepository.findByNameIgnoreCase("Cinema");
    //     assertEquals(local,Optional.empty());
    // }
    
}
