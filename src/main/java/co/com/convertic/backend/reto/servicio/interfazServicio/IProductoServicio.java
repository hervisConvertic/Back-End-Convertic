package co.com.convertic.backend.reto.servicio.interfazServicio;

import co.com.convertic.backend.reto.modelo.Producto;


import java.util.List;
import java.util.Optional;

public interface IProductoServicio {
    List<Producto> buscarPorDescripcionMarcaColor(String termino, String genero);

    Optional<Producto> obtenerProductoPorId(Integer id) throws Exception;

    void actualizarBusqueda(Producto producto) throws Exception;

    List<Producto> obtenerProductosMasBuscados() throws Exception;
}
