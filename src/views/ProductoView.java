package views;

import model.entities.Producto;
import model.services.ProductoService;
import model.services.ProductoServiceImpl;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class ProductoView extends JPanel {

    ProductoService service;
    JTable listadoTable;
    private JPanel formPanel;
    JTextField _Codigo_producto;
    JTextField _precio;
    JTextField _Descripcion;
    JTextField _Numero_productos;
    JButton addButton;
    JButton updateButton;
    JButton deleteButton;
    JButton clearButton;

    public ProductoView () {

        service = new ProductoServiceImpl();

        this.setLayout(new GridLayout(2,1));

        listadoTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(listadoTable);
        this.add(scrollPane, BorderLayout.CENTER);

        crearFormulario();

        this.add(formPanel, BorderLayout.SOUTH);
        formPanel.setVisible(true);

        listadoTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = listadoTable.getSelectedRow();
                if (selectedRow >= 0) {
                    showProductForm(selectedRow);
                }
            }
        });

        showProducts();
        this.setVisible(true);
    }

    private void crearFormulario() {
        // Crear formulario
        formPanel = new JPanel(new GridLayout(5, 2));

        formPanel.setBorder(BorderFactory.createTitledBorder("Detalles del Producto"));
        formPanel.add(new JLabel("Codigo_producto:"));
        _Codigo_producto = new JTextField();
        formPanel.add(_Codigo_producto);

        formPanel.add(new JLabel("Descripcion:"));
        _Descripcion = new JTextField();
        formPanel.add(_Descripcion);

        formPanel.add(new JLabel("Numero_productos:"));
        _Numero_productos = new JTextField();
        formPanel.add(_Numero_productos);


        formPanel.add(new JLabel("Precio:"));
        _precio = new JTextField();
        formPanel.add(_precio);



        addButton = new JButton("Nuevo");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProducto();
            }
        });
        formPanel.add(addButton);

        updateButton = new JButton("Actualizar");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProducto();
            }
        });
        formPanel.add(updateButton);

        deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProducto();
            }
        });
        formPanel.add(deleteButton);

        clearButton = new JButton("Limpiar");

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
        formPanel.add(clearButton);
    }


    private void showProducts() {

        // Configurar modelo de datos
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Descripcion");
        model.addColumn("Numero_productos");
        model.addColumn("Precio");


        List<Producto> productos = service.getList();

        for (Producto coche : productos) {
            model.addRow(new Object[]{
                    coche.getCodigo_producto(),
                    coche.getDescripcion(),
                    coche.getNumero_productos(),
                    coche.getPrecio()
            });
        }

        listadoTable.setModel(model);
        formPanel.setVisible(true);
    }

    private void showProductForm(int rowIndex) {
        DefaultTableModel model = (DefaultTableModel) listadoTable.getModel();
        String Codigo_producto = (String) model.getValueAt(rowIndex, 0);

        Producto producto = service.getById(Codigo_producto);

        _Codigo_producto.setText(producto.getCodigo_producto());
        _Numero_productos.setText(producto.getNumero_productos());
        _Descripcion.setText(producto.getDescripcion());
        _precio.setText(String.valueOf(producto.getPrecio()));

    }



    private void deleteProducto() {
        String Codigo_producto = _Codigo_producto.getText();
        Producto producto = new Producto();
        producto.setCodigo_producto(Codigo_producto);
        service.delete(producto);
        showProducts();
    }

    private void clearForm() {
        _Codigo_producto.setText("");
        _Numero_productos.setText("");
        _Descripcion.setText("");
        _precio.setText("");

    }

}
