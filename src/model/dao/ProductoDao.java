package model.dao;
import model.entities.Producto;

import java.util.List;

public interface ProductoDao {
    List<Producto> findAll();
    Producto findById(String codigo_producto);
    Producto save(Producto Producto);
    void update(Producto Producto);
    void delete(Producto Producto);
}
