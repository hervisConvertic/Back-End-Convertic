package co.com.convertic.backend.reto.repositorio;

import co.com.convertic.backend.reto.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Usuario findByCorreoelectronicoAndContrasena(String correoelectronico, String contrasena);

    Boolean existsByCorreoelectronico(String correoelectronico);

   //para cristina
    @Query("FROM Usuario WHERE tipodocumento.descripcion = :descripcion")
    List<Usuario> getByTipodocumento(String descripcion);
}
