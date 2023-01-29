package co.com.convertic.backend.reto.controlador;

import co.com.convertic.backend.reto.servicio.implementacion.TipoDocumentoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/tipoDocumento")
public class TipoDocumentoControlador {
    private TipoDocumentoServicio tipoDocumentoServicio;

    public TipoDocumentoControlador(TipoDocumentoServicio tipoDocumentoServicio) {
        this.tipoDocumentoServicio = tipoDocumentoServicio;
    }
    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(tipoDocumentoServicio.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"tipod de documento no encontrados.\"}");
        }
    }

}
