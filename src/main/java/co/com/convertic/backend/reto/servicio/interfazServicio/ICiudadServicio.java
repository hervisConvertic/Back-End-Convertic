package co.com.convertic.backend.reto.servicio.interfazServicio;

import co.com.convertic.backend.reto.modelo.Ciudad;
import co.com.convertic.backend.reto.modelo.TipoDocumento;

import java.util.List;

public interface ICiudadServicio {
    List<Ciudad> obtenerCiudad() throws Exception;
}
