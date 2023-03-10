package co.com.convertic.backend.reto.repositorio;

import co.com.convertic.backend.reto.modelo.ProductoTalla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductoTallaRepositorio extends JpaRepository<ProductoTalla, Integer> {
    @Query("FROM ProductoTalla WHERE producto.genero.descripcion=:descripcion")
    List<ProductoTalla> getByProductoGenero(String descripcion);

    @Query("FROM ProductoTalla WHERE producto.id=:id")
    ProductoTalla getByProductoId(Integer id);

    @Query("FROM ProductoTalla WHERE (producto.id=:idProducto AND talla.id=:idTalla)")
    ProductoTalla getByProductoIdAndTallaId(Integer idProducto, Integer idTalla);
}
