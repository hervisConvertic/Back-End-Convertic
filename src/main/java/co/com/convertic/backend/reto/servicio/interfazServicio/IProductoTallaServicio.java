package co.com.convertic.backend.reto.servicio.interfazServicio;

import co.com.convertic.backend.reto.modelo.ProductoTalla;

import java.util.List;

public interface IProductoTallaServicio {
    List<ProductoTalla> obtenerProductoPorGenero(String descripcion) throws Exception;

    ProductoTalla obtenerProductoPorId(Integer id) throws Exception;

    ProductoTalla obtenerCantidad(Integer idProducto,Integer idTalla) throws Exception;
}
