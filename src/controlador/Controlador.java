package controlador;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.event.ChangeEvent;
import modelo.Informacion;
import modelo.Producto;
import modelo.ProductoAVender;
import modelo.Usuario;
import vista.RegistroPago;
import vista.Vista;

public class Controlador {
    //clase de la vista
    private Vista v;
    //clase que contiene los metodos para trabajar con al base de datos
    private Informacion inf;
    private String nombre;
    //cantidad de producto
    private int cantidad;
    private float precio;
    //lista de productos almacenados en el jList
    private DefaultListModel lista_productos;
    //todos los productos
    private Vector<Producto> allProducts;
    private RegistroPago vistaRegistro;
    private Vector<ProductoAVender> productoAVender;
    
    public Controlador() throws SQLException {
        v = new Vista();
        inf = new Informacion();
        lista_productos = new DefaultListModel();
        vistaRegistro = new RegistroPago();
        productoAVender = new Vector();
        cargarInformacion();
        eventos();
        v.setVisible(true);
    }
    
    public void cargarInformacion() throws SQLException{
        //carga de categorias en combobox
        v.getCbxCategoria().setModel(inf.recuperarCategorias());
        int selectedCategoria = v.getCbxCategoria().getSelectedIndex();        
        //carga los productos en el combo box de acuerdo a la categoria
        v.getCbxProducto().setModel(inf.recuperarProductosCategoria(selectedCategoria + 1));
    }
    
    public void eventos() {
        //evento del combo box de categoria
        v.getCbxCategoria().addActionListener ((ActionEvent e) -> {
            try {
                //recupera el indiced de la categoria seleccionada en el combobox
                int selectedCategoria = v.getCbxCategoria().getSelectedIndex();
                
                //carga los productos en el combo box de acuerdo a la categoria
                v.getCbxProducto().setModel(inf.recuperarProductosCategoria(selectedCategoria + 1));
            } catch (SQLException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //evento del spinner
        v.getSpnCantidad().addChangeListener((ChangeEvent ce) -> {
            //recupera el valor actual del spinner
            cantidad = Integer.parseInt(v.getSpnCantidad().getValue().toString());
            
            //valida que no sea menor que cero el spinner
            if(cantidad < 1)
                v.getSpnCantidad().setValue(1);
        });
        
        //evento del boton agregar producto
        v.getBtnAgregar().addActionListener((ActionEvent e) -> {
            int id = 0;
            
            try {
                allProducts = inf.recuperarTodosProductos();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            nombre = (String) v.getCbxProducto().getModel().getSelectedItem();
            cantidad = (int) v.getSpnCantidad().getValue();
            
            for (int i = 0; i < allProducts.size(); i++) {
                if (allProducts.get(i).getNombre().equals(nombre)) {
                    precio = allProducts.get(i).getPrecio() * cantidad;
                    id = allProducts.get(i).getId();
                    break;
                }
            }
            
            lista_productos.addElement(nombre + ", " + cantidad + ", $" + precio);
            productoAVender.add(new ProductoAVender(cantidad, precio, id));
            
            v.getjLstContenido().setModel(lista_productos);
        });
        
        //evento del boton eliminar producto
        v.getBtnEliminar().addActionListener((ActionEvent e) -> {
            int index = v.getjLstContenido().getSelectedIndex();
            
            if (index >= 0) {
                lista_productos.removeElementAt(index);
                v.getjLstContenido().setModel(lista_productos);
                productoAVender.remove(index);
            }
        });
        
        v.getBtnPagar().addActionListener((ActionEvent e) -> {
            vistaRegistro.getTfxNombre().setText("");
            vistaRegistro.getTfxApellido().setText("");
            vistaRegistro.getTfxDireccion().setText("");
            vistaRegistro.getTfxTelefono().setText("");
            vistaRegistro.setVisible(true);
        });
        
        vistaRegistro.getBtnRegistrarPago().addActionListener((ActionEvent e) -> {                       
            try {
                inf.registrarUsuario(
                    new Usuario(
                        vistaRegistro.getTfxNombre().getText(),
                        vistaRegistro.getTfxApellido().getText(),
                        vistaRegistro.getTfxDireccion().getText(),
                        vistaRegistro.getTfxTelefono().getText()
                    )
                );
                
                float suma = 0;
                
                for (int i = 0; i < productoAVender.size(); i++) {
                    suma += productoAVender.get(i).getCantidad()*productoAVender.get(i).getPrecio();
                }
                
                inf.registrarNota(suma);
                inf.registrarNotaDetalle(productoAVender);
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            vistaRegistro.setVisible(false);
            productoAVender = new Vector();
        });
    }
}