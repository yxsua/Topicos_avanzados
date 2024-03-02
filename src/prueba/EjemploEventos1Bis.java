package prueba;

import java.applet.*;
import java.awt.*;

@SuppressWarnings("serial")
public class EjemploEventos1Bis extends Applet {

	// Crear variables de los componentes del Applet
	Button bIzdo, bCentral, bDcho;
	TextField display, entrada;
	Panel pNorte, pSur, pMenu, pTexto;
	List menu;
	String[] colores;
	
	public void init() {
		System.out.println("Inicializando ejemplo con manejo de eventos en clase externa...");
		setLayout(new BorderLayout());  // Tipo de layout de la aplicación
		
		// Crear objetos y asignarlos a las variables
		bIzdo = new Button("Mostrar");
		bCentral = new Button("Color");
		bDcho = new Button("Borrar");
		menu = new List();
		colores = new String[]{
				"Rojo", 
				"Azul",
				"Morado", 
				"Amarillo", 
				"Verde", 
				"Naranja", 
				"Negro"};
		
		// Añadir los objetos (colores) al menú
		for(String color : colores) {
			menu.add(color);
		}
		
		display = new TextField(20);
		entrada = new TextField("Hola!", 10);
		
		// Implementar clase respondedora para los botones
		Respuesta manejador = new Respuesta(display, entrada, bIzdo, bCentral, bDcho, menu);
		bIzdo.addActionListener(manejador);
		bCentral.addActionListener(manejador);
		bDcho.addActionListener(manejador);
		
		// Deshabilitar el textfield "display" para evitar que se escriba en el por parte del usuario
		display.setEditable(false);
		
		// Crear un subpanel para colocar el textfield & el botón para mostrar el texto
		pTexto = new Panel(new BorderLayout());
		pTexto.add(bIzdo, BorderLayout.NORTH);
		pTexto.add(entrada, BorderLayout.SOUTH);
		
		// Crear un subpanel para colocar el menu & el botón de aplicar en vertical
		pMenu = new Panel(new BorderLayout());
		pMenu.add(menu, BorderLayout.NORTH);
		pMenu.add(bCentral, BorderLayout.SOUTH);
		
		// Crear paneles y añadir objetos con un FlowLayout
		pNorte = new Panel(new FlowLayout());
		pNorte.add(display);
				
		pSur = new Panel(new FlowLayout());
		pSur.add(pTexto);
		pSur.add(pMenu);
		pSur.add(bDcho);
		
		// Crear el Layout del Applet
		this.add(pNorte, BorderLayout.NORTH);
		this.add(pSur, BorderLayout.SOUTH);
		
		// Cambiar el tamaño por defecto del Applet
		this.setSize(new Dimension(500, 150));
		
		return;
	}

}
