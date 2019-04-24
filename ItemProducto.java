public class ItemProducto {
    private String nombre_producto;
    private String cantidad_producto;
    private String precio_producto;
    public ItemProducto() { 
         nombre_producto = "";
         cantidad_producto = "";
         precio_producto="";
    }

    public void setNombre_producto(String t) {
      this.nombre_producto = this.nombre_producto + t;
    }

    public void setPrecio_producto(String p) {
      this.precio_producto = this.precio_producto + p;
    }

    public String getPrecio_producto() {
      return precio_producto;
    }

    public void setCantidad_producto(String q) {
      this.cantidad_producto = this.cantidad_producto + q;
    }
    public String getNombre_producto() {
      return nombre_producto;
    }
    public String getCantidad_producto() {
      return cantidad_producto;
    }



}
