package co.com.convertic.backend.reto.controlador;

import co.com.convertic.backend.reto.modelo.Email;
import co.com.convertic.backend.reto.servicio.implementacion.EmailServicio;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailControlador {
    private EmailServicio emailServicio;

    public EmailControlador(EmailServicio emailServicio) {
        this.emailServicio = emailServicio;
    }

    @PostMapping
    public String enviarEmail(@RequestBody Email email) {
        try {
            String estado = emailServicio.enviarEmail(email);
            return estado;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
