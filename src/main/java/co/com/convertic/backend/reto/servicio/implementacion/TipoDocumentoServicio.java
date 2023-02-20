package co.com.convertic.backend.reto.servicio.implementacion;

import co.com.convertic.backend.reto.modelo.TipoDocumento;
import co.com.convertic.backend.reto.repositorio.ITipoDocumentoRepositorio;
import co.com.convertic.backend.reto.servicio.interfazServicio.ITipoDocumentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoServicio implements ITipoDocumentoServicio {
    private ITipoDocumentoRepositorio tipoDocumentoRepositorio;

    @Autowired
    public TipoDocumentoServicio(ITipoDocumentoRepositorio tipoDocumentoRepositorio) {
        this.tipoDocumentoRepositorio = tipoDocumentoRepositorio;
    }

    @Override
    public List<TipoDocumento> obtenerTiposDocumento() throws Exception {
        try {
            return tipoDocumentoRepositorio.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
