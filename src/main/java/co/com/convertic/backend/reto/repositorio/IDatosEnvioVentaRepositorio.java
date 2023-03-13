package co.com.convertic.backend.reto.repositorio;

import co.com.convertic.backend.reto.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDatosEnvioVentaRepositorio extends JpaRepository<Venta,Integer> {
}
