package co.com.convertic.backend.reto.servicio.interfazServicio;

import co.com.convertic.backend.reto.modelo.Producto;


import java.util.List;

public interface IProductoServicio {
     List<Producto> buscarPorLetra(String term,String descrip);
}
