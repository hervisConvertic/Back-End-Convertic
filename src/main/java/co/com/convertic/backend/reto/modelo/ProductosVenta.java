package co.com.convertic.backend.reto.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="productos_venta")
public class ProductosVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int cantidad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_venta")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Venta venta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto_talla")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProductoTalla productoTalla;

    public ProductosVenta() {
    }

    public ProductosVenta(int cantidad, Venta venta, ProductoTalla productoTalla) {
        this.cantidad = cantidad;
        this.venta = venta;
        this.productoTalla = productoTalla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public ProductoTalla getProductoTalla() {
        return productoTalla;
    }

    public void setProductoTalla(ProductoTalla productoTalla) {
        this.productoTalla = productoTalla;
    }
}
