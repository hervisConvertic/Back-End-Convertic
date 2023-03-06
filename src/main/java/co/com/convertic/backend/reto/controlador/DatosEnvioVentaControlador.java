package co.com.convertic.backend.reto.controlador;

import co.com.convertic.backend.reto.modelo.DatosEnvioVenta;
import co.com.convertic.backend.reto.servicio.implementacion.DatosEnvioVentaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/datosEnvioVenta")
public class DatosEnvioVentaControlador {
    private DatosEnvioVentaServicio datosEnvioVentaServicio;

    public DatosEnvioVentaControlador(DatosEnvioVentaServicio datosEnvioVentaServicio) {
        this.datosEnvioVentaServicio = datosEnvioVentaServicio;
    }

    @PostMapping
    ResponseEntity<DatosEnvioVenta> registrarDatosEnvio(@RequestBody DatosEnvioVenta datosEnvioVenta) {
        try {
            this.datosEnvioVentaServicio.registrarDatosVenta(datosEnvioVenta);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
