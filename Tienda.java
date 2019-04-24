import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.File;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label; 
import javafx.scene.control.TextField; // https://stackoverflow.com/questions/50469703/java-awt-textfield-cannot-be-converted-to-javafx-scene-node/50469774#50469774
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane ;
import java.awt.*;
import javax.swing.*;
import static javafx.application.Application.launch; 
import javafx.geometry.Pos; 
import javafx.scene.control.PasswordField; 
import javafx.scene.text.Text;
import javafx.scene.control.*;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.util.Duration;


import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Collections;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Tienda extends Application {

    public static File fichero;
    public static String ruta_fichero="catalogos/catalogo_frutas.txt";
    public String producto = "";
    public String dinero;
    public String cantidad;
    public String nombre_p="";
    public String second_p="";
    public String dni_p="";
    public String phone_p="";
    public String address_p="";
    public String locality_p="";
    public String zip_p="";
    public List<Compra> lista_compras = new ArrayList<Compra>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        Label label_inicio = new Label("Tienda Paco&Deivid");
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(10), label_inicio);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.play();
        Button boton_compras = new Button("Ir a compras");
        Button boton_productos = new Button("Cargar Productos");
        Button boton_ver_lista = new Button("Ver registro compras");
        Button boton_ver_clientes = new Button("Ver registro clientes");
        Button boton_salir = new Button("Salir"); 
        root.getChildren().add(boton_compras);
        root.getChildren().add(boton_productos);
        root.getChildren().add(boton_ver_lista); 
        root.getChildren().add(boton_ver_clientes);  
        root.getChildren().add(boton_salir); 
        root.getChildren().add(label_inicio); 
        Scene scene = new Scene(root, 500,500); 
        primaryStage.setScene(scene); 
        primaryStage.setTitle("Menu Inicio");
        primaryStage.show();
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;" +
                "-fx-background-color: #d4f1fa;");
        boton_compras.setStyle("-fx--color:red;");
        boton_compras.setTranslateX(-160);
        boton_compras.setTranslateY(-120);
        boton_productos.setTranslateX(0);
        boton_productos.setTranslateY(-120);
        boton_salir.setTranslateX(150);
        boton_salir.setTranslateY(-120);
        boton_ver_lista.setTranslateX(100);
        boton_ver_lista.setTranslateY(200);
        boton_ver_clientes.setTranslateX(100);
        boton_ver_clientes.setTranslateY(160);
        label_inicio.setTranslateX(0);
        label_inicio.setTranslateY(-200);
        label_inicio.setStyle( "-fx-font-size: 26;");

        boton_ver_lista.setOnAction(ver_lista->{
        	primaryStage.close();
        	StackPane root4 = new StackPane(); 
            //root2.getChildren().add(button2);
            Scene fourthScene = new Scene(root4, 500,500);
            Stage fourthStage = new Stage();
            fourthStage.setScene(fourthScene); 
            fourthStage.setTitle("Comprobar información base de datos");
            fourthStage.show();
            primaryStage.close();
            root4.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;" +
                "-fx-background-color: #d4f1fa;");
            GridPane grid4 = new GridPane();
	        grid4.setPadding(new Insets(10, 10, 10, 10));
	        grid4.setVgap(5);
	        grid4.setHgap(5);
	        final TextField name4 = new TextField();
	        name4.setPromptText("Introduce tu nombre");
	        name4.setPrefColumnCount(10);
	        GridPane.setConstraints(name4, 0, 0);
	        grid4.getChildren().add(name4);
	        //Defining the Submit button
	        Button enviar4 = new Button("Comprobar");
	        Button ver_todo = new Button("Ver todos");
	        Button atras2 = new Button("Volver atrás");
	        GridPane.setConstraints(enviar4, 1, 0);
	        GridPane.setConstraints(ver_todo, 2, 0);
	        GridPane.setConstraints(atras2, 3, 0);
	        grid4.getChildren().add(enviar4);
	        grid4.getChildren().add(ver_todo);
	        grid4.getChildren().add(atras2);
	        final Label label2 = new Label();
	        root4.getChildren().addAll(grid4,label2);

	        enviar4.setOnAction(buscar_bd->{
	        	if (name4.getText() != null && !name4.getText().isEmpty()){
	        		LeerBD leerBaseDatos = new LeerBD(); 
	        		leerBaseDatos.listaProductos(name4.getText());
	        		leerBaseDatos.cierraConexion();
	        }
	        else {
	            label2.setText("Por favor, escribe el nombre");
	          }

	        });

			ver_todo.setOnAction(all_bd->{
	        	LeerBD leerBaseDatosAll = new LeerBD(); 
	        	leerBaseDatosAll.listaProductosAll();
	        	leerBaseDatosAll.cierraConexion();
	        	
	        });

	        atras2.setOnAction(evento->{
	            primaryStage.show();
	            fourthStage.close();
	        });

		});

        boton_ver_clientes.setOnAction(ver_cliente->{
            primaryStage.close();
            StackPane root5 = new StackPane(); 
            //root2.getChildren().add(button2);
            Scene fifthScene = new Scene(root5, 500,500);
            Stage fifthStage = new Stage();
            fifthStage.setScene(fifthScene); 
            fifthStage.setTitle("Comprobar información base de datos");
            fifthStage.show();
            primaryStage.close();
            root5.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;" +
                "-fx-background-color: #d4f1fa;");
            GridPane grid5 = new GridPane();
            grid5.setPadding(new Insets(10, 10, 10, 10));
            grid5.setVgap(5);
            grid5.setHgap(5);
            final TextField name5 = new TextField();
            name5.setPromptText("Introduce tu nombre");
            name5.setPrefColumnCount(10);
            GridPane.setConstraints(name5, 0, 0);
            grid5.getChildren().add(name5);
            //Defining the Submit button
            Button enviar5 = new Button("Comprobar");
            Button ver_todo_cli = new Button("Ver todos");
            Button atras4 = new Button("Volver atrás");
            GridPane.setConstraints(enviar5, 1, 0);
            GridPane.setConstraints(ver_todo_cli, 2, 0);
            GridPane.setConstraints(atras4, 3, 0);
            grid5.getChildren().add(enviar5);
            grid5.getChildren().add(ver_todo_cli);
            grid5.getChildren().add(atras4);
            final Label label3 = new Label();
            root5.getChildren().addAll(grid5,label3);

            enviar5.setOnAction(buscar_cliente_bd->{
                if (name5.getText() != null && !name5.getText().isEmpty()){
                    LeerBD leerCliente = new LeerBD(); 
                    leerCliente.listaClientes(name5.getText());
                    leerCliente.cierraConexion();
            }
            else {
                label3.setText("Por favor, escribe el nombre");
              }

            });

            ver_todo_cli.setOnAction(all_cliente_bd->{
                LeerBD leerClientesAll = new LeerBD(); 
                leerClientesAll.listaClientesAll();
                leerClientesAll.cierraConexion();
                
            });

            atras4.setOnAction(evento->{
                primaryStage.show();
                fifthStage.close();
            });

        });
        
        boton_compras.setOnAction(comprar->{
            producto=""; //resetear variables para cada cliente
            dinero=""; // o se suman las de todos
            cantidad="";
            StackPane root2 = new StackPane(); 
            //root2.getChildren().add(button2);
            Scene secondScene = new Scene(root2, 500,500);
            Stage secondStage = new Stage();
            secondStage.setScene(secondScene); 
            secondStage.setTitle("Apartado Persona");
            secondStage.show();
            primaryStage.close();
            root2.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;" +
                "-fx-background-color: #d4f1fa;");
            
        //Creating a GridPane container
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        //Defining the Name text field
        final TextField name = new TextField();
        name.setPromptText("Introduce tu nombre");
        name.setPrefColumnCount(10);
        GridPane.setConstraints(name, 0, 0);
        grid.getChildren().add(name);
        //Defining the Last Name text field
        final TextField lastName = new TextField();
        lastName.setPromptText("Introduce tu apellido.");
        GridPane.setConstraints(lastName, 0, 1);
        grid.getChildren().add(lastName);
        
        //Defining the DNI text field
        final TextField dni = new TextField();
        dni.setPrefColumnCount(15);
        dni.setPromptText("Introduce DNI.");
        GridPane.setConstraints(dni, 0, 2);
        grid.getChildren().add(dni);
        //Defining the Phone text field
        final TextField phone = new TextField();
        phone.setPrefColumnCount(15);
        phone.setPromptText("Introduce teléfono.");
        GridPane.setConstraints(phone, 0, 3);
        grid.getChildren().add(phone);
        //Defining the Address text field
        final TextField address = new TextField();
        address.setPrefColumnCount(15);
        address.setPromptText("Introduce dirección.");
        GridPane.setConstraints(address, 0, 4);
        grid.getChildren().add(address);
        //Defining the Locality text field
        final TextField locality = new TextField();
        locality.setPrefColumnCount(15);
        locality.setPromptText("Introduce localidad.");
        GridPane.setConstraints(locality, 0, 5);
        grid.getChildren().add(locality);
        //Defining the ZIP text field
        final TextField zip = new TextField();
        zip.setPrefColumnCount(15);
        zip.setPromptText("Introduce código postal.");
        GridPane.setConstraints(zip, 0, 6);
        grid.getChildren().add(zip);
        //Defining the Submit button
        Button enviar = new Button("Siguiente");
        GridPane.setConstraints(enviar, 1, 0);
        grid.getChildren().add(enviar);
        //Defining the Clear button
        Button clear = new Button("Resetear");
        GridPane.setConstraints(clear, 1, 1);
        grid.getChildren().add(clear);
        final Label label = new Label();
        Button atras3 = new Button("Volver atrás");
        GridPane.setConstraints(atras3, 1, 2);
        grid.getChildren().add(atras3);

        root2.getChildren().addAll(grid,label);

        atras3.setOnAction(evento->{
	            primaryStage.show();
	            secondStage.close();
	    });


            enviar.setOnAction(event->{

            	if (name.getText() != null && !name.getText().isEmpty()) {
		            nombre_p=name.getText();
                    second_p=lastName.getText();
                    dni_p=dni.getText();
                    phone_p=phone.getText();
                    address_p=address.getText();
                    locality_p=locality.getText();
                    zip_p=zip.getText();
                    //System.out.println(zip_p);
		            StackPane root3 = new StackPane(); 
		            //root2.getChildren().add(button2);
		            Scene thirdScene = new Scene(root3, 700,500);
		            Stage thirdStage = new Stage();
		            thirdStage.setScene(thirdScene); 
		            thirdStage.setTitle("Apartado Compra");
		            thirdStage.show();
		            secondStage.close();
		            root3.setStyle("-fx-padding: 10;" +
		                "-fx-border-style: solid inside;" +
		                "-fx-border-width: 2;" +
		                "-fx-border-insets: 5;" +
		                "-fx-border-radius: 5;" +
		                "-fx-border-color: blue;" +
		                "-fx-background-color: #d4f1fa;");

        			Button finalizar = new Button("Finalizar compra");

                    Button cancelar = new Button("Cancelar compra");

			        GridPane grid2 = new GridPane();
			        grid2.setPadding(new Insets(10, 10, 10, 10));
			        
			        Button confirmar = new Button ("Confirmar compra");
			        Label notification = new Label ();

			        String[] styleClasses = new String[] { Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL
			        };
			        Spinner<Integer> spinner = new Spinner<Integer>(1, 20, 2);
			        spinner.getStyleClass().addAll(styleClasses);

			         //grid2.getChildren().add(button2);
			        final ComboBox emailComboBox = new ComboBox(); // https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
			        String[] lista_productos = leerMapa();
			        //System.out.println(Arrays.toString(lista_productos));
			        for (String s: lista_productos) { // recorre el string para introducirlo en el BOX
			            emailComboBox.getItems().add(s); 
			        }
			        //grid2.add(emailComboBox, 0, 4);
    
                    cancelar.setOnAction(eventc -> {
                        thirdStage.close();
                        primaryStage.show();

                    });

        			confirmar.setOnAction(evenx->{
               			if (emailComboBox.getValue() != null && !emailComboBox.getValue().toString().isEmpty()) {
		                    notification.setText("Has comprado:" + ' ' + emailComboBox.getValue()   );
		                    Object selectedItem = emailComboBox.getValue(); // https://stackoverflow.com/questions/5845846/obtaining-value-from-combo-box-in-netbeans-gui
		                    String selectedItemStr = selectedItem.toString();
		                    dinero = dinero + ":" + selectedItemStr.replaceAll("[^\\d.]", "");

		                    int cantidad_numero = spinner.getValue();
		                    String cantidad_st = Integer.toString(cantidad_numero);
		                    cantidad = cantidad +  ":" + cantidad_st;


		                    String[] parts = selectedItemStr.split(" ");
		                    //System.out.println(parts[0]);
		                    String part1 = parts[0];
		                    producto = producto + ":" + part1;
		                    emailComboBox.setValue(null);
		                }
                		else {
                    		notification.setText("No has seleccionado nada.."); 
               		 	}
                		//System.out.println("eeeee");
        			});



			        grid2.setVgap(4);
			        grid2.setHgap(10);
			        grid2.setPadding(new Insets(5, 5, 5, 5));
			        grid2.add(new Label("Catalogo de compras: "), 0, 0);
			        grid2.add(emailComboBox, 1, 0);
			        grid2.add(new Label("Elige Cantidad: "), 0, 1);
			        grid2.add(spinner,1,1);
			        grid2.add(cancelar, 2, 2);
			        grid2.add(confirmar, 3, 2);
                    grid2.add(finalizar, 4, 2);
                    
			        
			        grid2.add (notification, 1, 3, 3, 1);


			        root3.getChildren().addAll(grid2);

			         finalizar.setOnAction(evento->{
			         	DAOCompra escribeBD = new EscribeBD();
                        DAOCliente escribeClienteBD = new EscribeClienteBD();
                        DAOCompra escribeTXT = new EscribeTXT();
			         	Compra compra1 = addCompra(nombre_p, dinero, producto, cantidad);
                        Person cli = addCliente(nombre_p, second_p, dni_p, phone_p, address_p, locality_p, zip_p);
			    		lista_compras.add(compra1);
			    		escribeBD.grabar(compra1);
                        escribeClienteBD.grabar(cli);
                        escribeTXT.grabar(compra1);
			            primaryStage.show();
			            secondStage.close();
			            thirdStage.close();
			            //System.out.println("productos recopilado " + producto);
			            //System.out.println("Cantidad producto " + cantidad);
			            //System.out.println("dinero recopilado " + dinero);

			            }); 

         	} //else del if que comprueba si el campo 'nombre' esta vacio, si lo esta salta una advertencia que no te deja continuar
     		else {
            	label.setText("Por favor, rellena los datos, como mínimo tu nombre");
         	}

            }); 
            clear.setOnAction(eventoo->{
                name.clear();
                lastName.clear();
                dni.clear();
            }); 

                

            
        });

        boton_productos.setOnAction(producto->{

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            this.fichero = fileChooser.showOpenDialog(primaryStage);
            //System.out.println(this.fichero);
        });

        boton_salir.setOnAction(salir->{
            System.exit(1);
        });

    }

    public static void main(String[] args) {
        launch();

    }

    public static String[] leerMapa()
    {
        ArrayList<String> lista_pro = new ArrayList<String>();
        String st;
        int contador = 0;
        File ruta = fichero;
        if (ruta == null){ // selecciona ruta al fichero de productos ¿no? pilla ruta por defecto
            String ruta2 = ruta_fichero;
        
        try { 
            BufferedReader br = new BufferedReader(new FileReader(ruta2) );
            while ( (st = br.readLine() ) != null) {
                lista_pro.add(st);
                contador = contador + 1;
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    else{ // selecciona ruta al fichero de productos, pues selecciona dicha ruta
        
        try { 
            BufferedReader br = new BufferedReader(new FileReader(ruta) );
            while ( (st = br.readLine() ) != null) {
                lista_pro.add(st);
                contador = contador + 1;
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

        String[] introduce_productos = new String[contador];
        int i = 0;
        while (i < contador){
            introduce_productos[i] = lista_pro.get(i);
            i = i + 1;
        }

        return introduce_productos;
    }

    public static Compra addCompra(String name, String precio, String producto_elegido, String cantidad_productos) {
		Compra compras = new Compra();
		compras.setPer(name);
		compras.setPrecio_producto(precio + ":");
		compras.setCesta_producto(producto_elegido + ":");
		compras.setCesta_cantidad_producto(cantidad_productos + ":");
		return compras;
	}

    public static Person addCliente(String name, String second, String dni, String phone, String address, String locality, String zip) {
        Person cliente = new Person(name, second, dni, phone, address, locality, zip);
        return cliente;
    }
 
		
}



// hbox
// https://stackoverflow.com/questions/32317126/cant-click-on-buttons-in-hbox
