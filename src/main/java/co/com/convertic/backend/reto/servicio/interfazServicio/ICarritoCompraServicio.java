package co.com.convertic.backend.reto.servicio.interfazServicio;

import co.com.convertic.backend.reto.modelo.CarritoCompra;

import java.util.List;
import java.util.Optional;

public interface ICarritoCompraServicio {

    CarritoCompra registrarProducto(CarritoCompra carritoCompra) throws Exception;

    List<CarritoCompra> obtenerCarritoPorUsuarioId(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
