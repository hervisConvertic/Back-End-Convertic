package co.com.convertic.backend.reto.servicio;

import co.com.convertic.backend.reto.modelo.Usuario;
import co.com.convertic.backend.reto.repositorio.IUsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio implements IUsuarioServicio {
    private IUsuarioRepositorio iUsuarioRepositorio;

    public UsuarioServicio(IUsuarioRepositorio iUsuarioRepositorio) {
        this.iUsuarioRepositorio = iUsuarioRepositorio;
    }

    @Override
    public Usuario save(Usuario usuario) throws Exception {
        try {
            if (iUsuarioRepositorio.existsByCorreoelectronico(usuario.getCorreoelectronico())) {
                throw new IllegalArgumentException("correo ya se encuentra registrado");
            }
            if (iUsuarioRepositorio.existsByContrasena(usuario.getContrasena())) {
                throw new IllegalArgumentException("contrasena ya se encuentra registrada");
            }
            usuario = iUsuarioRepositorio.save(usuario);
            return usuario;
        } catch (
                Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean login(String correoelectronico, String contrasena) throws Exception {
        try {
            Usuario usuario = iUsuarioRepositorio.findByCorreoelectronicoAndContrasena(correoelectronico, contrasena);
            if (usuario != null && usuario.getCorreoelectronico().equals(correoelectronico) && usuario.getContrasena().equals(contrasena))
                return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        try {
            List<Usuario> usuarios=iUsuarioRepositorio.findAll();
            return usuarios;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
