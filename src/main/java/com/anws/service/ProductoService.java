package com.anws.service;

import com.anws.domain.Producto;
import java.util.List;

public interface ProductoService {

    // Se obtiene un listado de productos en un List
    public List<Producto> getProductos(boolean activos);
    
    // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto);

    // Se inserta un nuevo producto si el id del producto esta vacÃƒÂ­o
    // Se actualiza un producto si el id del producto NO esta vacÃƒÂ­o
    public void save(Producto producto);

    // Se elimina el producto que tiene el id pasado por parÃƒÂ¡metro
    public void delete(Producto producto);
        
}
