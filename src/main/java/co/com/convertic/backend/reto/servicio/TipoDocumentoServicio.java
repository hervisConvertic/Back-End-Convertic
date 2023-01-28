package co.com.convertic.backend.reto.servicio;

import co.com.convertic.backend.reto.modelo.TipoDocumento;
import co.com.convertic.backend.reto.repositorio.ITipoDocumentoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoDocumentoServicio implements ITipoDocumentoServicio{
    private ITipoDocumentoRepositorio tipoDocumentoRepositorio;

    public TipoDocumentoServicio(ITipoDocumentoRepositorio tipoDocumentoRepositorio) {
        this.tipoDocumentoRepositorio = tipoDocumentoRepositorio;
    }

    @Override
    public List<TipoDocumento> findAll() throws Exception {
        try {
            List<TipoDocumento> tipoDocumentos=tipoDocumentoRepositorio.findAll();
            return tipoDocumentos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
