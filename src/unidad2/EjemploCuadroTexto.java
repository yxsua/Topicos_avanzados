package unidad2;

import java.applet.*;
import java.awt.*;

@SuppressWarnings("serial")
public class EjemploCuadroTexto extends Applet {

	// Declaramos variables
	TextField tf1, tf2, tf3, tf4;
	Font miFuente;
	
	public void init() {
		// "Creamos" nuestra fuente y la añadimos al Layout
		miFuente = new Font("Serif", Font.BOLD, 15);
		this.setFont(miFuente);
		
		// Creamos los TextFields (cuadros de texto)
		tf1 = new TextField();
		tf1.setColumns(20);
		tf1.setText("Cuadro text 1");
		
		tf2 = new TextField("Cuadro texto 2");
		tf2.setEchoChar('*');
		
		tf3 = new TextField(13);
		tf3.setText("Hola");
		
		tf4 = new TextField("Cuadro texto 4", 25);
		tf4.setEditable(false);
		
		// Añadimos los textFields al Layout
		this.add(tf1);
		this.add(tf2);
		this.add(tf3);
		this.add(tf4);
	}
}
