package prueba;

import java.awt.*;
import java.awt.event.*;

public class Respuesta implements ActionListener {

	Button bIzdo, bCentral, bDcho;
	TextField display, entrada;
	List menu;
	
	public Respuesta(TextField display, TextField entrada, Button bIzdo, Button bCentral, Button bDcho, List menu) {
		this.display = display;
		this.entrada = entrada;
		this.bIzdo = bIzdo;
		this.bCentral = bCentral;
		this.bDcho = bDcho;
		this.menu = menu;
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
