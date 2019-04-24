
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class EscribeTXT implements DAOCompra{

    public EscribeTXT (){
    try{
      FileWriter fileWriter = new FileWriter("datos/tienda.txt");
        }
    catch(IOException ex){
      ex.printStackTrace();
        }

    }
    
    public void grabar(Compra c){
        String nombre = c.getPer().getName();
        String variable_nombre_producto = c.getCesta_producto().getNombre_producto().getNombre_producto();
        String[] lista_nombre_productos = variable_nombre_producto.split(":");
        String variable_cantidad_producto = c.getCesta_cantidad_producto().getCantidad_producto().getCantidad_producto();
        String[] lista_cantidad_productos = variable_cantidad_producto.split(":");
        String variable_precio_producto = c.getPrecio_producto().getPrecio_producto().getPrecio_producto();
        String[] lista_precio_productos = variable_precio_producto.split(":");
        //System.out.println(lista_cantidad_productos[1]);
           for (int x=1; x < lista_nombre_productos.length; x++){
            String p1 = lista_precio_productos[x];
            String p2 = lista_cantidad_productos[x];
            //System.out.println(p1);
            //System.out.println(p2);
            int p3 = Integer.parseInt(p1)*Integer.parseInt(p2);
            //System.out.println("despues de p3");
           try {
           FileWriter fileWriter = new FileWriter("datos/tienda.txt",true);
           fileWriter.write(nombre + " ha comprado: " + lista_nombre_productos[x] + " en una cantidad igual a " + lista_cantidad_productos[x] + " precio_total: " + p3 + '\n' );
           fileWriter.close();
           }
           catch(IOException ex){
            ex.printStackTrace();
            }
           }
        
      }

    }
    