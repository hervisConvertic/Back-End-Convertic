package co.com.convertic.backend.reto.controlador;

import co.com.convertic.backend.reto.modelo.CarritoCompra;
import co.com.convertic.backend.reto.servicio.implementacion.CarritoCompraServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/carritoCompra")
public class CarritoCompraControlador {

    private CarritoCompraServicio carritoCompraServicio;

    public CarritoCompraControlador(CarritoCompraServicio carritoCompraServicio) {
        this.carritoCompraServicio = carritoCompraServicio;
    }

    @PostMapping
    public ResponseEntity<CarritoCompra> registrarProducto(@RequestBody CarritoCompra carritoCompra) {
        try {
            this.carritoCompraServicio.registrarProducto(carritoCompra);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<CarritoCompra>> obtenerCarritoUsuarioId(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(carritoCompraServicio.obtenerCarritoPorUsuarioId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CarritoCompra> eliminarCarritoPorId(@PathVariable Integer id){
        try {
            carritoCompraServicio.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
