package co.com.convertic.backend.reto.servicio.implementacion;

import co.com.convertic.backend.reto.modelo.Producto;
import co.com.convertic.backend.reto.modelo.ProductoTalla;
import co.com.convertic.backend.reto.repositorio.IProductoRepositorio;
import co.com.convertic.backend.reto.servicio.interfazServicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServicio implements IProductoServicio {
    private IProductoRepositorio productoRepositorio;

    public ProductoServicio(IProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    public List<Producto> buscarPorLetra(String term,String descrip) {
        return productoRepositorio.findProductoByDescripcionEqualsIgnoreCaseOrColorEqualsIgnoreCaseOrMarcaEqualsIgnoreCaseAndGenero(term,descrip);
    }
}
