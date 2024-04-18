## Clase ProductoParaVender - Franco ## 

Testeando me di cuenta que se podian ingresar cantidades de productos negativas, por lo que cambie el metodo a:

``` java
public void setCantidad(Float cantidad){
        if (cantidad>=0){
        this.cantidad=cantidad;
        }
    }

```
``` java
Y los test funcionan para todos los casos:
    @ParameterizedTest
    @ValueSource(floats = {10f, -5f, -10f,84.2f})
	void setCantidadNegativaParametrizado(Float distintosValores){
        // valor inicial positivo
        Float valorOriginalPsotivo = 5f;
		productoParaVender.setCantidad(valorOriginalPsotivo);

        // pruebo cambiarlo a negativo
		productoParaVender.setCantidad(distintosValores);

        // pruebo con assert true y false
		// assertTrue(productoParaVender.getCantidad()>=0);
        assertFalse(productoParaVender.getCantidad()<=0);
	}
}

```
