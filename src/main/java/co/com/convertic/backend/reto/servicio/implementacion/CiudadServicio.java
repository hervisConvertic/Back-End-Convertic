package co.com.convertic.backend.reto.servicio.implementacion;

import co.com.convertic.backend.reto.modelo.Ciudad;
import co.com.convertic.backend.reto.repositorio.ICiudadRepositorio;
import co.com.convertic.backend.reto.servicio.interfazServicio.ICiudadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServicio implements ICiudadServicio {

    private ICiudadRepositorio ciudadRepositorio;

    @Autowired
    public CiudadServicio(ICiudadRepositorio ciudadRepositorio) {
        this.ciudadRepositorio = ciudadRepositorio;
    }

    @Override
    public List<Ciudad> obtenerCiudad() throws Exception {
        try {
            return ciudadRepositorio.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
