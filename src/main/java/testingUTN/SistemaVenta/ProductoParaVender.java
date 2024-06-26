package testingUTN.SistemaVenta;

public class ProductoParaVender extends Producto {
    private Float cantidad;
    private Float precio;

    public ProductoParaVender(String nombre, String codigo, Float precio, Float existencia, Integer id, Float cantidad) {
        super(nombre, codigo, precio, existencia, id);
        this.cantidad = cantidad;
    }

    public ProductoParaVender(String nombre, String codigo, Float precio, Float existencia, Float cantidad) {
        super(nombre, codigo, precio, existencia);
        this.cantidad = cantidad;
    }

    public ProductoParaVender(){
        
    }

    public void aumentarCantidad() {
        this.cantidad++;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public Float getTotal() {
        return this.getPrecio() * this.cantidad;
    }

    // con testing, agregue la validacion
    public void setCantidad(Float cantidad){
        if (cantidad>=0){
            this.cantidad = cantidad;
        }
    }

    public void setPrecio(Float precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }

    public Float precioEncuotas(int cuotas){
        return getPrecio()/cuotas;
    }
}
