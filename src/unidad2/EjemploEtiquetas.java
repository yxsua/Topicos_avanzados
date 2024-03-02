package unidad2;

import java.applet.*;
import java.awt.*;

@SuppressWarnings("serial")
public class EjemploEtiquetas extends Applet {
	
	// Declaración de varialbes
	Label lb1, lb2, lb3;
	Font miFuente;
	
	public void init() {
		// Creamos y establecemos una nueva fuente
		miFuente = new Font("Serif", Font.BOLD, 15);
		this.setFont(miFuente);
		
		// Creamos los labels
		lb1 = new Label();
		lb1.setText("Etiqueta 1");
		lb1.setForeground(Color.white);
		lb1.setBackground(Color.black);
		lb1.setAlignment(Label.RIGHT);
		
		lb2 = new Label("Etiqueta 2");
		
		lb3 = new Label("Etiqueta 3", Label.CENTER);
		lb3.setBackground(Color.cyan);
		
		// Añadimos los labels al Layout
		this.add(lb1);
		this.add(lb2);
		this.add(lb3);
	}
	

}
