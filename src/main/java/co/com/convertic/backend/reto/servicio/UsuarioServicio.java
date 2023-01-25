package co.com.convertic.backend.reto.servicio;

import co.com.convertic.backend.reto.modelo.Usuario;
import co.com.convertic.backend.reto.repositorio.IUsuarioRepositorio;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio implements IusuarioServicio {
    private IUsuarioRepositorio iUsuarioRepositorio;

    public UsuarioServicio(IUsuarioRepositorio iUsuarioRepositorio) {
        this.iUsuarioRepositorio = iUsuarioRepositorio;
    }

    @Override
    public Usuario save(Usuario usuario) throws Exception {
        try {
            usuario = iUsuarioRepositorio.save(usuario);
            return usuario;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean login(String correoelectronico, String contrasena) throws Exception {
        try {
            Usuario usuario=iUsuarioRepositorio.findByCorreoelectronicoAndContrasena(correoelectronico,contrasena);
            if(usuario!=null&&usuario.getCorreoelectronico().equals(correoelectronico)&&usuario.getContrasena().equals(contrasena))
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return false;
    }


}
