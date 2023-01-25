package co.com.convertic.backend.reto.servicio;

import co.com.convertic.backend.reto.modelo.Usuario;

public interface IusuarioServicio {
    public Usuario save(Usuario usuario) throws Exception;
    public Boolean login(String correoelectronico,String contrasena) throws Exception;
}
