package co.com.convertic.backend.reto.repositorio;

import co.com.convertic.backend.reto.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductoRepositorio extends JpaRepository<Producto, Integer> {
    @Query("SELECT p FROM Producto p WHERE (p.descripcion LIKE %?1% OR p.color LIKE %?1% OR p.marca.descripcion LIKE %?1%) AND p.genero.descripcion=?2")
    List<Producto> findProductoByDescripcionEqualsIgnoreCaseOrColorEqualsIgnoreCaseOrMarcaEqualsIgnoreCaseAndGenero(String term, String descrip);



}
