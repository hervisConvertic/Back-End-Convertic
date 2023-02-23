package co.com.convertic.backend.reto.servicio.implementacion;

import co.com.convertic.backend.reto.modelo.Producto;
import co.com.convertic.backend.reto.repositorio.IProductoRepositorio;
import co.com.convertic.backend.reto.servicio.interfazServicio.IProductoServicio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio implements IProductoServicio {
    private IProductoRepositorio productoRepositorio;

    public ProductoServicio(IProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    public List<Producto> buscarPorDescripcionMarcaColor(String termino, String genero) {
        return productoRepositorio.findProductoByDescripcionOrColorOrMarcaAndGenero(termino,genero);
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Integer id) throws Exception {
        try {
        return productoRepositorio.findById(id);
        }catch (Exception e){

            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void actualizarBusqueda(Producto producto) throws Exception {
        try {
            producto.setBusqueda(producto.getBusqueda()+1);
            productoRepositorio.save(producto);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Producto> obtenerProductosMasBuscados() throws Exception {
        try {
            return productoRepositorio.findTop4ByOrderByBusquedaDesc();
        }catch (Exception e){
        throw new Exception(e.getMessage());
    }
    }


}
