package co.com.convertic.backend.reto.servicio.interfazServicio;

import co.com.convertic.backend.reto.modelo.Venta;


public interface IDatosEnvioVentaServicio {
    Venta registrarDatosVenta(Venta datosEnvioVenta) throws Exception;
}
