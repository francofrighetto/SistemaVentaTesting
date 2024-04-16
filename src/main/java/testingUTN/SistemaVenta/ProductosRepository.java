package testingUTN.SistemaVenta;

import org.springframework.data.repository.CrudRepository;

public interface ProductosRepository extends CrudRepository<Producto, Integer> {

    Producto findFirstByCodigo(String codigo);
}
