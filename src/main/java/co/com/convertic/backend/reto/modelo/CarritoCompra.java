package co.com.convertic.backend.reto.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "carrito_compra")
public class CarritoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_productoTalla")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProductoTalla productoTalla;
    private int cantidad;

    public CarritoCompra() {
    }

    public CarritoCompra(Usuario usuario, ProductoTalla productoTalla, int cantidad) {
        this.usuario = usuario;
        this.productoTalla = productoTalla;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ProductoTalla getProductoTalla() {
        return productoTalla;
    }

    public void setProductoTalla(ProductoTalla productoTalla) {
        this.productoTalla = productoTalla;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
