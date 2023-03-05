package co.com.convertic.backend.reto.controlador;

import co.com.convertic.backend.reto.modelo.Ciudad;
import co.com.convertic.backend.reto.servicio.implementacion.CiudadServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/ciudad")
public class CiudadControlador {
    private CiudadServicio ciudadServicio;

    public CiudadControlador(CiudadServicio ciudadServicio) {
        this.ciudadServicio = ciudadServicio;
    }

    @GetMapping
    public ResponseEntity<List<Ciudad>> obtenerCiudad() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ciudadServicio.obtenerCiudad());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
