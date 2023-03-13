package co.com.convertic.backend.reto.servicio.implementacion;

import co.com.convertic.backend.reto.modelo.CarritoCompra;
import co.com.convertic.backend.reto.modelo.ProductoTalla;
import co.com.convertic.backend.reto.repositorio.ICarritoCompraRepositorio;
import co.com.convertic.backend.reto.repositorio.IProductoTallaRepositorio;
import co.com.convertic.backend.reto.servicio.interfazServicio.ICarritoCompraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoCompraServicio implements ICarritoCompraServicio {

    private ICarritoCompraRepositorio carritoCompraRepositorio;
    private IProductoTallaRepositorio productoTallaRepositorio;

    @Autowired
    public CarritoCompraServicio(ICarritoCompraRepositorio carritoCompraRepositorio, IProductoTallaRepositorio productoTallaRepositorio) {
        this.carritoCompraRepositorio = carritoCompraRepositorio;
        this.productoTallaRepositorio = productoTallaRepositorio;
    }

    @Override
    public CarritoCompra registrarProducto(CarritoCompra carritoCompra) throws Exception {
        try {
            return carritoCompraRepositorio.save(carritoCompra);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<CarritoCompra> obtenerCarritoPorUsuarioId(Integer id) throws Exception {
        try {
            return carritoCompraRepositorio.getByUsuario(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            carritoCompraRepositorio.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void actualizarInventario(Integer id) throws Exception {
        try {
            List<CarritoCompra> carritoCompraList = carritoCompraRepositorio.findCarritoCompraByUsuarioId(id);
            for (CarritoCompra carritoCompra : carritoCompraList) {
                Integer idProductoTalla = carritoCompra.getProductoTalla().getId();
                Integer cantidad = carritoCompra.getCantidad();
                ProductoTalla productoTalla = productoTallaRepositorio.findById(idProductoTalla).orElseThrow();

                Integer nuevoInventario = productoTalla.getInventario() - cantidad;
                productoTalla.setInventario(nuevoInventario);
                productoTallaRepositorio.save(productoTalla);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
