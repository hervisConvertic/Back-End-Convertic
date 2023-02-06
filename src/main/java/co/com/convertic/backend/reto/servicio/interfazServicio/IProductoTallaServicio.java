package co.com.convertic.backend.reto.servicio.interfazServicio;

import co.com.convertic.backend.reto.modelo.ProductoTalla;

import java.util.List;

public interface IProductoTallaServicio {
    List<ProductoTalla> getByProductoGenero(String descripcion);
}
