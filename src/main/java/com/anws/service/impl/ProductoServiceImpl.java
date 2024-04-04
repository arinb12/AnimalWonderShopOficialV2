package com.anws.service.impl;

import com.anws.dao.ProductoDao;
import com.anws.domain.Producto;
import com.anws.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activos) {
        var lista=productoDao.findAll(); //Se va a guardar en esta lista
        if (activos) {
           lista.removeIf(e -> !e.isActivo()); //Va a remover de la lista lo que sea diferente de activos 
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional //Metodo de tipo transaccional porque le voy a preguntar a la bd sobre la info si existe me la devuelve
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

}