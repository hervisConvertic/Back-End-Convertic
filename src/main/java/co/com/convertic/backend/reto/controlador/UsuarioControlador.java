package co.com.convertic.backend.reto.controlador;

import co.com.convertic.backend.reto.modelo.Usuario;
import co.com.convertic.backend.reto.servicio.implementacion.UsuarioServicio;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody Usuario usuario, BindingResult bindingResult) {
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
            this.usuarioServicio.registrarUsuario(usuario);

            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } catch (IllegalArgumentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            // return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( e.getMessage());
        }
    }

    @PostMapping("/login-request")
    public ResponseEntity<?> logearUsuario(@RequestBody Usuario usuario) throws Exception {
        try {
            Boolean isLogin = usuarioServicio.loguearUsuario(usuario.getCorreo(), usuario.getContrasena());
            if (isLogin) {
                System.out.println("login success");
                return ResponseEntity.status(HttpStatus.OK).body(usuario);
            } else {
                System.out.println("usuario no existe");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"mensaje\":\"correo electrónico o contraseña incorrectos\"}");
            }
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error en la respuesta\"}" + e.getMessage());

        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuario() {
        try {
            List<Usuario> usuario = usuarioServicio.obtenerUsuario();
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } catch (Exception e) {
            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("mensaje", "No se encuentra el usuario");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<Usuario>());
        }
    }

    @GetMapping("/{correo}")
    public ResponseEntity<Usuario> obternerUsuarioPorCorreo(@PathVariable String correo, Usuario usuario) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.obternerUsuarioPorCorreo(correo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
