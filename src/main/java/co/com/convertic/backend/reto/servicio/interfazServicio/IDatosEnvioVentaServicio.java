package co.com.convertic.backend.reto.servicio.interfazServicio;

import co.com.convertic.backend.reto.modelo.DatosEnvioVenta;


public interface IDatosEnvioVentaServicio {
    DatosEnvioVenta registrarDatosVenta(DatosEnvioVenta datosEnvioVenta) throws Exception;
}
