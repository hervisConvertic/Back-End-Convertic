package co.com.convertic.backend.reto.repositorio;

import co.com.convertic.backend.reto.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Usuario findByCorreoAndContrasena(String correoElectronico, String contrasena);

    Boolean existsByCorreo(String correoElectronico);

   //para cristina
    @Query("FROM Usuario WHERE tipoDocumento.descripcion= :descripcion")
    List<Usuario> getByTipodocumento(String descripcion);
}
