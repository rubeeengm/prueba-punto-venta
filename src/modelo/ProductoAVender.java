package modelo;

public class ProductoAVender {
    private int cantidad;
    private float precio;
    private int id_producto;

    public ProductoAVender() {
    }

    public ProductoAVender(int cantidad, float precio, int id_producto) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_producto = id_producto;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
}
