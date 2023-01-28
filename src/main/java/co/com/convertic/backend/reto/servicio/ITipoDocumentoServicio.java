package co.com.convertic.backend.reto.servicio;

import co.com.convertic.backend.reto.modelo.TipoDocumento;

import java.util.List;

public interface ITipoDocumentoServicio {
    public List<TipoDocumento> findAll() throws Exception;
}
