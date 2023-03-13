package co.com.convertic.backend.reto.repositorio;

import co.com.convertic.backend.reto.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  IProductoRepositorio extends JpaRepository<Producto, Integer> {
 /*   @Query("SELECT p FROM Producto p WHERE (LOWER(p.descripcion) LIKE LOWER(CONCAT('%',?1,'%'))  " +
            "OR LOWER(p.color) LIKE LOWER(CONCAT('%',?1,'%') ) OR LOWER(p.marca.descripcion) LIKE LOWER(CONCAT('%',?1,'%') ))" +
            " AND p.genero.descripcion = ?2  ")
    List<Producto> findProductoByDescripcionOrColorOrMarcaAndGenero(String termino, String genero);*/

    @Query("SELECT p FROM Producto p WHERE (LOWER(p.descripcion) LIKE LOWER(CONCAT('%',?1,'%'))  " +
            "OR LOWER(p.marca.descripcion) LIKE LOWER(CONCAT('%',?1,'%') ))" +
            " AND p.genero.descripcion = ?2  ")
    List<Producto> findProductoByDescripcionOrMarcaAndGenero(String termino, String genero);

    List<Producto> findTop4ByOrderByBusquedaDesc();

    @Query("SELECT p FROM Producto p WHERE p.genero.descripcion = ?1")
    List<Producto> findProductoByGeneroDescripcion(String genero);


}
