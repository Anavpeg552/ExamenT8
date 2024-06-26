package model.services;

import model.dao.ProductoDao;
import model.dao.DAOFactory;
import model.entities.Producto;

import java.util.List;

public class ProductoServiceImpl implements ProductoService{


    private ProductoDao dao;

    @Override
    public List<Producto> getList() {
        return dao.findAll();
    }

    @Override
    public Producto getById(String Codigo_producto) {
        return dao.findById(Codigo_producto);
    }

    @Override
    public Producto save(Producto producto) {
       return dao.save(producto);
    }

    @Override
    public void update(Producto producto) {
        dao.update(producto);
    }

    @Override
    public void delete(Producto producto) {
        dao.delete(producto);
    }
}
