package model.entities;

import java.util.Objects;


public class Producto {
    private int codigo_producto;
    private String descripcion;
    private Double precio;
    private int numero_productos;

    public Producto() {}

    public Producto( int Codigo_Producto, String Descripcion, Double precio, int Numero_Productos) {
        this.codigo_producto = Codigo_Producto;
        this.descripcion = Descripcion;
        this.precio = precio;
        this.numero_productos = Numero_Productos;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getNumero_productos() {
        return numero_productos;
    }

    public void setNumero_productos(int numero_productos) {
        this.numero_productos = numero_productos;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo_producto=" + codigo_producto +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", numero_productos=" + numero_productos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto ) o;
        return Objects.equals(codigo_producto, producto.codigo_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_producto);
    }


}
