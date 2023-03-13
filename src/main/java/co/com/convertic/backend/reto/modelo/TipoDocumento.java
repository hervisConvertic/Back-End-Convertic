package co.com.convertic.backend.reto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "tipos_documento")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String descripcion;

    public TipoDocumento() {
    }

    public TipoDocumento(String tipodocumento) {
        this.descripcion = tipodocumento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String tipodocumento) {
        this.descripcion = tipodocumento;
    }
}
