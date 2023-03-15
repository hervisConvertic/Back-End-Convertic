package co.com.convertic.backend.reto.repositorio;

import co.com.convertic.backend.reto.modelo.CarritoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface ICarritoCompraRepositorio extends JpaRepository<CarritoCompra, Integer> {

    @Query("FROM CarritoCompra WHERE usuario.id=:id")
    List<CarritoCompra> getByUsuario(Integer id);

    List<CarritoCompra> findCarritoCompraByUsuarioId(Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM CarritoCompra c  WHERE c.usuario.id = :id")
    void eliminarPorUsuario(int id);


}
