public class Cesta {
    private ItemProducto itemproducto;
    public Cesta() { 
         itemproducto = new ItemProducto();
    }
    

  public void setNombre_producto(String nombre) {
    itemproducto.setNombre_producto(nombre);
  }

  public ItemProducto getNombre_producto() {
    return itemproducto;
  }

  public void setPrecio_producto(String nombre) {
      itemproducto.setPrecio_producto(nombre);
    }

    public ItemProducto getPrecio_producto() {
    return itemproducto;
  }

  public void setCantidad_producto(String nombre) {
    itemproducto.setCantidad_producto(nombre);
  }


   public ItemProducto getCantidad_producto() {
    return itemproducto;
  }


    
}
