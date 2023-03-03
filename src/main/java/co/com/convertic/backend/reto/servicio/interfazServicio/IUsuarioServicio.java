package co.com.convertic.backend.reto.servicio.interfazServicio;

import co.com.convertic.backend.reto.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    Usuario registrarUsuario(Usuario usuario) throws Exception;

    Boolean loguearUsuario(String correoelectronico, String contrasena) throws Exception;

    List<Usuario> obtenerUsuario() throws Exception;

    Usuario obternerUsuarioPorCorreo(String correo) throws Exception;
}
