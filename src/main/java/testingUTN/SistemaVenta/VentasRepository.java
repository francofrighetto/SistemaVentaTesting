package testingUTN.SistemaVenta;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VentasRepository extends JpaRepository<Venta, Integer> {
    Optional<Venta> findByNombreempleado(String nombreempleado);
}
