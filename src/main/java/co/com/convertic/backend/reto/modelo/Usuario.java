package co.com.convertic.backend.reto.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Pattern(regexp = "^[0-9]*$", message = "documento solo puede tener numeros")
    private String documento;
    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z\s]+",message = "nombre solo se permiten letras y espacios")
    private String nombre1;
    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z\s]+",message = "nombre solo se permiten letras y espacios")
    private String nombre2;
    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z\s]+",message = "apellido solo se permiten letras y espacios")
    private String apellido1;
    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z\s]+",message = "apellido solo se permiten letras y espacios")
    private String apellido2;
    @Column(nullable = false)
    @Email(message = "por favor ingrese un correo electronico valido")
    private String correoelectronico;
    @Column(nullable = false)
    @Pattern(regexp = "(?=^.{5,}$)((?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))^.*", message = "contraseña debe ser de longitud mínima 5, y debe contener letras mayúsculas,\n" +
            "letras minúsculas y números.\n")
    private String contrasena;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_tipodocumento")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private TipoDocumento tipodocumento;


    public Usuario() {
    }

    public Usuario(TipoDocumento tipodocumento, String documento, String nombre1, String nombre2, String apellido1, String apellido2, String correoelectronico, String contrasena) {
        this.tipodocumento = tipodocumento;
        this.documento = documento;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correoelectronico = correoelectronico;
        this.contrasena = contrasena;
    }

    public Integer getId() {
        return id;
    }

    public TipoDocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(TipoDocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
