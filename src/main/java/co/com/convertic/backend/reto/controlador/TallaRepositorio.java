package co.com.convertic.backend.reto.controlador;

import co.com.convertic.backend.reto.modelo.ProductoTalla;
import co.com.convertic.backend.reto.servicio.implementacion.TallaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/talla")
public class TallaRepositorio {

    private TallaServicio tallaServicio;

    public TallaRepositorio(TallaServicio tallaServicio) {
        this.tallaServicio = tallaServicio;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTalla() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(tallaServicio.obtenerTalla());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. no se encuentran las tallas\"}");
        }
    }
}
