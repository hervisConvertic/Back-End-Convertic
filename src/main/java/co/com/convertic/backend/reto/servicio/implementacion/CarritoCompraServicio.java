package co.com.convertic.backend.reto.servicio.implementacion;

import co.com.convertic.backend.reto.modelo.CarritoCompra;
import co.com.convertic.backend.reto.repositorio.ICarritoCompraRepositorio;
import co.com.convertic.backend.reto.servicio.interfazServicio.ICarritoCompraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoCompraServicio implements ICarritoCompraServicio {

    private ICarritoCompraRepositorio carritoCompraRepositorio;

    @Autowired
    public CarritoCompraServicio(ICarritoCompraRepositorio carritoCompraRepositorio) {
        this.carritoCompraRepositorio = carritoCompraRepositorio;
    }

    @Override
    public CarritoCompra registrarProducto(CarritoCompra carritoCompra) throws Exception {
        try {
         return carritoCompraRepositorio.save(carritoCompra);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<CarritoCompra> obtenerCarritoPorUsuarioId(Integer id) throws Exception {
        try {
            return carritoCompraRepositorio.getByUsuario(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
