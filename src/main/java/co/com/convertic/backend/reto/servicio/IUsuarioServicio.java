package co.com.convertic.backend.reto.servicio;

import co.com.convertic.backend.reto.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    public Usuario save(Usuario usuario) throws Exception;
    public Boolean login(String correoelectronico,String contrasena) throws Exception;
    public List<Usuario> findAll() throws Exception;
}
