package unidad2;

import java.applet.*;
import java.awt.*;

@SuppressWarnings("serial")
public class EjemploBotones extends Applet {
	
	Button b1, b2, b3;
	
	public void init() {
		
		// Inicializar botón (es)
		b1 = new Button("Botón 1");
		
		// Cambiar las propiedades, color de letra y color de fondo
		b1.setForeground(Color.red);
		b1.setBackground(Color.cyan);
		
		b2 = new Button("Botón 2");
		
		b2.setForeground(Color.orange);
		b2.setBackground(Color.blue);
		
		b3 = new Button();
		// Como usamos el constructor por defecto, hay que manualmente modificar
		// el Label del botón
		b3.setLabel("Botón 3");
		
		b3.setForeground(Color.white);
		b3.setBackground(Color.black);
		
		// Por defecto es el FlowLayout
		// Los elementos se colocan uno delante de otro hasta que no haya espacio,
		// entonces van a la siguiente línea.
		System.out.println("Administrador de diseño aplicado: " + this.getLayout());
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
	}

}
