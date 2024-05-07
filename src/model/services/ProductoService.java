package model.services;

import model.entities.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> getList();
    Producto getById(String codigo_producto);
    Producto save(Producto Producto);
    void update(Producto Producto);
    void delete(Producto Producto);
}
