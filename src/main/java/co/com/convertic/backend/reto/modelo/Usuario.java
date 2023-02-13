package co.com.convertic.backend.reto.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    private String nombre;

    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z\s]+",message = "apellido solo se permiten letras y espacios")
    private String apellido;

    @Column(nullable = false)
    @Email(message = "por favor ingrese un correo electronico valido")
    private String correo;
    @Column(nullable = false)
    @Pattern(regexp = "(?=^.{5,}$)((?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))^.*", message = "contraseña debe ser de longitud mínima 5, y debe contener letras mayúsculas,\n" +
            "letras minúsculas y números.\n")
    private String contrasena;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_tipodocumento")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private TipoDocumento tipoDocumento;


    public Usuario() {
    }

    public Usuario(String documento, String nombre, String apellido, String correo, String contrasena, TipoDocumento tipoDocumento) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
