package co.com.convertic.backend.reto.controlador;

import co.com.convertic.backend.reto.servicio.implementacion.ProductoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/producto")
public class ProductoControlador {
   private ProductoServicio productoServicio;

    public ProductoControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping("/{descrip}/{term}")
    public ResponseEntity<?> busquedaProducto(@PathVariable String descrip ,@PathVariable String term) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoServicio.buscarPorLetra(term,descrip));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. no se encuentran productos\"}");
        }
    }

}
