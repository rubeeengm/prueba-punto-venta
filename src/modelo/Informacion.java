package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

public class Informacion {
    public DefaultComboBoxModel recuperarCategorias() throws SQLException {
        Conexion c = new Conexion();
        
        Connection conn = c.conexionMysql();
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery ("select nombre from categorias");
        
        DefaultComboBoxModel categorias = new DefaultComboBoxModel();
        
        while (rs.next()) { 
            categorias.addElement(rs.getString(1));
        }
        
        conn.close();
        
        return categorias;
    }
    
    public DefaultComboBoxModel recuperarProductosCategoria(int id_categoria) throws SQLException {
        Conexion c = new Conexion();
        
        Connection conn = c.conexionMysql();
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery ("SELECT nombre FROM productos WHERE categorias_idcategorias = "+id_categoria+";");
        
        DefaultComboBoxModel productos = new DefaultComboBoxModel();
        
        while (rs.next()) { 
            productos.addElement(rs.getString(1));
        }
        
        conn.close();
        
        return productos;
    }
    
    public Vector recuperarTodosProductos() throws SQLException {
        Conexion c = new Conexion();
        
        Connection conn = c.conexionMysql();
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery ("SELECT * FROM productos;");
        
        Vector<Producto> productos = new Vector();
        
        while (rs.next()) {
            productos.addElement(new Producto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4)));
        }
        
        conn.close();
        
        return productos;
    }
    
    public void registrarUsuario(Usuario usuario) throws SQLException {
        Conexion c = new Conexion();
        
        Connection conn = c.conexionMysql();
        
        Statement st = conn.createStatement();
        st.executeUpdate("INSERT INTO usuarios (nombre, apellidos, direccion, telefono) "
                + "VALUES ('"+usuario.getNombre()+"','"+usuario.getApellido()+"','"+usuario.getDireccion()
                +"','"+usuario.getTelefono()+"');");
        
        conn.close();
    }
    
    public void registrarNota(float total) throws SQLException {
        Conexion c = new Conexion();
        
        Connection conn = c.conexionMysql();
        
        Statement st = conn.createStatement();
        
        st.executeUpdate("INSERT INTO nota_cabecera (total, usuarios_idusuarios) "
                + "VALUES ("+total+","+totalUsuarios()+");");
        
        conn.close();
    }
    
    public void registrarNotaDetalle(Vector<ProductoAVender> productos) throws SQLException {
        Conexion c = new Conexion();
        
        Connection conn = c.conexionMysql();
        
        Statement st = conn.createStatement();
        
        for (int i = 0; i < productos.size(); i++) {
            st.executeUpdate("INSERT INTO nota_detalle (cantidad, precio, nota_cabecera_idnota_cabecera, productos_idproductos) "
                + "VALUES ("+productos.get(i).getCantidad()+","+productos.get(i).getPrecio()+","+totalNotas()+","+productos.get(i).getId_producto()+");");
        }
        
        conn.close();
    }
    
    public int totalUsuarios() throws SQLException {
        Conexion c = new Conexion();
        
        Connection conn = c.conexionMysql();
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery ("SELECT * FROM usuarios;");
        
        int id = 0;
        
        while (rs.next()) {
           id = rs.getInt(1);
        }
        
        conn.close();
        
        return id;
    }
    
    public int totalNotas() throws SQLException {
        Conexion c = new Conexion();
        
        Connection conn = c.conexionMysql();
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery ("SELECT * FROM nota_cabecera;");
        
        int id = 0;
        
        while (rs.next()) {
           id = rs.getInt(1);
        }
        
        conn.close();
        
        return id;
    }
}
