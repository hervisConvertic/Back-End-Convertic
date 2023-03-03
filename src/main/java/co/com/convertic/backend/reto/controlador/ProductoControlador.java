package co.com.convertic.backend.reto.controlador;

import co.com.convertic.backend.reto.modelo.Producto;
import co.com.convertic.backend.reto.servicio.implementacion.ProductoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/producto")
public class ProductoControlador {
    private ProductoServicio productoServicio;

    public ProductoControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping("/{genero}/{termino}")
    public ResponseEntity<?> busquedaProducto(@PathVariable String genero, @PathVariable String termino) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoServicio.buscarPorDescripcionMarcaColor(termino, genero));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. no se encuentran productos\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoServicio.obtenerProductoPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. no se encuentra producto\"}");
        }
    }

    @GetMapping
    public ResponseEntity<?> obtenerProductosMasBuscados() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoServicio.obtenerProductosMasBuscados());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. no se encuentran productos\"}");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> actualizarBusquedaPorId(@PathVariable Integer id) {
        try {
            Optional<Producto> productoExistente = productoServicio.obtenerProductoPorId(id);
            return productoExistente.map(producto -> {
                try {
                    productoServicio.actualizarBusqueda(producto);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return ResponseEntity.status(HttpStatus.OK).body(producto);
            }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. no se encuentra producto\"}");
        }
    }
}
