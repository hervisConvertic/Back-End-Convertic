package co.com.convertic.backend.reto.servicio.implementacion;

import co.com.convertic.backend.reto.modelo.Usuario;
import co.com.convertic.backend.reto.repositorio.IUsuarioRepositorio;
import co.com.convertic.backend.reto.servicio.interfazServicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio implements IUsuarioServicio {
    private IUsuarioRepositorio iUsuarioRepositorio;

    @Autowired
    public UsuarioServicio(IUsuarioRepositorio iUsuarioRepositorio) {
        this.iUsuarioRepositorio = iUsuarioRepositorio;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception {
        try {
            if (iUsuarioRepositorio.existsByCorreo(usuario.getCorreo())) {
                throw new IllegalArgumentException("correo ya se encuentra registrado");
            }
            return iUsuarioRepositorio.save(usuario);
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                throw e;
            }
            throw new Exception("Error inesperado tratando de guardar el usuario");
        }
    }

    @Override
    public Boolean loguearUsuario(String correoelectronico, String contrasena) throws Exception {
        try {
            Usuario usuario = iUsuarioRepositorio.findByCorreoAndContrasena(correoelectronico, contrasena);
            return usuario != null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Usuario> obtenerUsuario() throws Exception {
        try {
            return iUsuarioRepositorio.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Usuario obternerUsuarioPorCorreo(String correo) throws Exception {
        try {
            return iUsuarioRepositorio.findByCorreo(correo);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
