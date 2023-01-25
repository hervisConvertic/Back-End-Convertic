package co.com.convertic.backend.reto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "tipos_documento")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipodocumento;
}
