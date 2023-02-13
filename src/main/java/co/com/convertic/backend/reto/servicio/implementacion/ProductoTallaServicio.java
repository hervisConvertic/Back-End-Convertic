package co.com.convertic.backend.reto.servicio.implementacion;

import co.com.convertic.backend.reto.modelo.ProductoTalla;
import co.com.convertic.backend.reto.repositorio.IProductoTallaRepositorio;
import co.com.convertic.backend.reto.servicio.interfazServicio.IProductoTallaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoTallaServicio implements IProductoTallaServicio {
    private IProductoTallaRepositorio productoTallaRepositorio;

    @Autowired
    public ProductoTallaServicio(IProductoTallaRepositorio productoTallaRepositorio) {
        this.productoTallaRepositorio = productoTallaRepositorio;
    }

    @Override
    public List<ProductoTalla> obtenerProductoPorGenero(String descripcion) throws Exception {
        try {
            return productoTallaRepositorio.getByProductoGenero(descripcion);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
