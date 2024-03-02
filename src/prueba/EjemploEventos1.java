package prueba;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings({ "serial" })
public class EjemploEventos1 extends Applet implements ActionListener {

	// Crear variables de los componentes del Applet
	Button bIzdo, bCentral, bDcho;
	TextField display, entrada;
	Panel pNorte, pSur, pMenu, pTexto;
	List menu;
	String[] colores;
	
	public void init() {
		System.out.println("Inicializando ejemplo...");
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
		
		// Indicar que la clase que debe escuchar por los eventos es esta misma
		bIzdo.addActionListener(this);
		bCentral.addActionListener(this);
		bDcho.addActionListener(this);
		
		display = new TextField(20);
		entrada = new TextField("Hola!", 10);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Registro en consola de los eventos ejecutados
		System.out.println("Código evento: " + e.getID());
		System.out.println("Información evento: " + e.paramString());
		
		// Obtener la fuente del evento generado
		Object origen = e.getSource();
		
		// Ejecutar el código correspondiente a cada fuente
		if(origen==bIzdo) {
			display.setText(entrada.getText());
		} else if(origen==bCentral) {
			switch(menu.getItem(menu.getSelectedIndex())) {
			case "Rojo":
				display.setForeground(Color.red);
				break;
			case "Azul":
				display.setForeground(Color.blue);
				break;
			case "Amarillo":
				display.setForeground(Color.yellow);
				break;
			case "Naranja":
				display.setForeground(Color.orange);
				break;
			case "Verde":
				display.setForeground(Color.green);
				break;
			case "Morado":
				display.setForeground(Color.magenta);
				break;
			case "Negro":
				display.setForeground(Color.black);
				break;
			}
		} else if(origen==bDcho) {
			display.setText("");
			display.setForeground(Color.black);
		}
		
	}
	
}

