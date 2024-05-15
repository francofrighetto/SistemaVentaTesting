package testingUTN.SistemaVenta;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Entity
@ToString
@Getter
@Setter
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fechaYHora;
    private String nombreempleado;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private Set<ProductoVendido> productos;

    public Venta() {
        this.fechaYHora = Utiles.obtenerFechaYHoraActual();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTotal() {
        Float total = 0f;
        for (ProductoVendido productoVendido : this.productos) {
            total += productoVendido.getTotal();
        }
        return total;
    }

    public String getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(String fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Set<ProductoVendido> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductoVendido> productos) {
        this.productos = productos;
    }

    public void setNombreempleado(String nombreempleado){
        this.nombreempleado=nombreempleado;
    }

    public String getNombreempleado(){
        return this.nombreempleado;
    }
 
}
