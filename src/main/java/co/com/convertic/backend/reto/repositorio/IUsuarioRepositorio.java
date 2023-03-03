package co.com.convertic.backend.reto.repositorio;

import co.com.convertic.backend.reto.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Usuario findByCorreoAndContrasena(String correoElectronico, String contrasena);

    Boolean existsByCorreo(String correoElectronico);

    @Query("SELECT u FROM Usuario u WHERE u.correo=:correo")
    Usuario findByCorreo(String correo);
}
