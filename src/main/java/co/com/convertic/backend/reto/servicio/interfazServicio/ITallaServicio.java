package co.com.convertic.backend.reto.servicio.interfazServicio;

import co.com.convertic.backend.reto.modelo.Talla;

import java.util.List;

public interface ITallaServicio {

    List<Talla> obtenerTalla() throws Exception;
}
