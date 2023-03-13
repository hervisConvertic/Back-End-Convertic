package co.com.convertic.backend.reto.servicio.implementacion;

import co.com.convertic.backend.reto.modelo.Venta;
import co.com.convertic.backend.reto.repositorio.IDatosEnvioVentaRepositorio;
import co.com.convertic.backend.reto.servicio.interfazServicio.IDatosEnvioVentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosEnvioVentaServicio implements IDatosEnvioVentaServicio {
    private IDatosEnvioVentaRepositorio datosEnvioVentaRepositorio;

    @Autowired
    public DatosEnvioVentaServicio(IDatosEnvioVentaRepositorio datosEnvioVentaRepositorio) {
        this.datosEnvioVentaRepositorio = datosEnvioVentaRepositorio;
    }

    @Override
    public Venta registrarDatosVenta(Venta datosEnvioVenta) throws Exception {
        try {
            return datosEnvioVentaRepositorio.save(datosEnvioVenta);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
