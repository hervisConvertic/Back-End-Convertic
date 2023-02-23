package co.com.convertic.backend.reto.servicio.implementacion;

import co.com.convertic.backend.reto.modelo.Talla;
import co.com.convertic.backend.reto.repositorio.ITallaRepositorio;
import co.com.convertic.backend.reto.servicio.interfazServicio.ITallaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TallaServicio implements ITallaServicio {
    private ITallaRepositorio tallaRepositorio;

    @Autowired
    public TallaServicio(ITallaRepositorio tallaRepositorio) {
        this.tallaRepositorio = tallaRepositorio;
    }

    @Override
    public List<Talla> obtenerTalla() throws Exception {
        try {
            return tallaRepositorio.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
