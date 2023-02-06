package co.com.convertic.backend.reto.controlador;

import co.com.convertic.backend.reto.modelo.Usuario;
import co.com.convertic.backend.reto.servicio.implementacion.UsuarioServicio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
    private UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Usuario usuario, BindingResult bindingResult) {
        Usuario usuarioIngresado = null;
        Map<String, Object> response = new HashMap<>();
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(err -> " El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            System.out.println("ingreso aqui en la respuesta de envio");
            this.usuarioServicio.save(usuario);
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\":\"success\"}");
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"status\":\"Error:\"}"+e.getMessage());
        }
    }

    @PostMapping("/login-request")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        try {
            Boolean isLogin = usuarioServicio.login(usuario.getCorreo(), usuario.getContrasena());
            if (isLogin) {
                System.out.println("login success");
                return ResponseEntity.status(HttpStatus.OK).body("{\"status\":\"success\"}");
            } else {
                System.out.println("usuario no existe");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\":\"correo o contraseña incorrectos\"}");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error en la respuesta\"}" + e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. no se encuentra el usuario\"}");
        }
    }
    //para cristina
    @GetMapping("/documento/{descripcion}")
    public ResponseEntity<?> getDocumento(@PathVariable String descripcion) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.getByTipoDocumento(descripcion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. no se encuentran usuarios\"}");
        }
    }

}
