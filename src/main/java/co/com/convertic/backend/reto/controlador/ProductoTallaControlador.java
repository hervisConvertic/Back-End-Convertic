package co.com.convertic.backend.reto.controlador;

import co.com.convertic.backend.reto.servicio.implementacion.ProductoTallaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productoTalla")
public class ProductoTallaControlador {
    private ProductoTallaServicio productoTallaServicio;

    public ProductoTallaControlador(ProductoTallaServicio productoTallaServicio) {
        this.productoTallaServicio = productoTallaServicio;
    }
    @GetMapping("/{descripcion}")

    public ResponseEntity<?> productosPorGenero(@PathVariable String descripcion) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoTallaServicio.getByProductoGenero(descripcion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. no se encuentran productos\"}");
        }
    }
}
