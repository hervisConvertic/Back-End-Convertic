package co.com.convertic.backend.reto.servicio.interfazServicio;

import co.com.convertic.backend.reto.modelo.TipoDocumento;

import java.util.List;

public interface ITipoDocumentoServicio {
    List<TipoDocumento> findAll() throws Exception;
}
