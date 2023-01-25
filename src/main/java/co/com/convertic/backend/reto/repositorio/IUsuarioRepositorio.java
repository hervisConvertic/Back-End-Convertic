package co.com.convertic.backend.reto.repositorio;

import co.com.convertic.backend.reto.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer> {
    Usuario findByCorreoelectronicoAndContrasena(String correoelectronico, String contrasena);
}
