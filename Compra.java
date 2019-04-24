public class Compra {
  private Person per;
  private Cesta cesta_p;
  public Compra() {
    // constructor por defecto
    per = new Person();
    cesta_p = new Cesta();
  }
  public void setPer(String name) {
    per.setName(name);
  }

  public void setCesta_producto(String nombre) {
    cesta_p.setNombre_producto(nombre);
  }

   public Cesta getCesta_producto() {
    return cesta_p;
  }

//
  public void setPrecio_producto(String nombre) {
    cesta_p.setPrecio_producto(nombre);
  }

   public Cesta getPrecio_producto() {
    return cesta_p;
  }
//
  
  public void setCesta_cantidad_producto(String cantidad) {
    cesta_p.setCantidad_producto(cantidad);
  }

   public Cesta getCesta_cantidad_producto() {
    return cesta_p;
  }

  public Person getPer() {
    return per;
  }

}
