package co.com.convertic.backend.reto.servicio.interfazServicio;

import co.com.convertic.backend.reto.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    Usuario save(Usuario usuario) throws Exception;

    Boolean login(String correoelectronico, String contrasena) throws Exception;

    List<Usuario> findAll() throws Exception;
    //para cristina
    List<Usuario> getByTipoDocumento(String descripcion);
}
