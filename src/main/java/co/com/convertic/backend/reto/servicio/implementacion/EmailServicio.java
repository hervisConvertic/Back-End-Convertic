package co.com.convertic.backend.reto.servicio.implementacion;

import co.com.convertic.backend.reto.modelo.Email;
import co.com.convertic.backend.reto.servicio.interfazServicio.IEmailServicio;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServicio implements IEmailServicio {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailServicio(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String enviarEmail(Email email) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(email.getPara());
            simpleMailMessage.setText(email.getMensaje());
            simpleMailMessage.setSubject(email.getAsunto());

            javaMailSender.send(simpleMailMessage);
            return "Email fue enviado Exitosamente...";

        } catch (Exception e) {
            return "error enviando el correo " + e.getLocalizedMessage();
        }


    }
}
