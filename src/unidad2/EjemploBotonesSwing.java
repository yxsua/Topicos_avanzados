package unidad2;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class EjemploBotonesSwing extends JApplet {

	// Declaración de variables
	JButton b1, b2, b3;
	
	@SuppressWarnings("deprecation")
	public void init() {
		// Inicializar botón (es)
		b1 = new JButton("Botón 1");
		
		// Cambiar las propiedades, color de letra y color de fondo
		b1.setForeground(Color.red);
		b1.setBackground(Color.cyan);
		
		b2 = new JButton("Botón 2");
		
		b2.setForeground(Color.orange);
		b2.setBackground(Color.blue);
		
		b3 = new JButton();
		// Como usamos el constructor por defecto, hay que manualmente modificar
		// el Label del botón (método deprecado en swing)
		b3.setLabel("Botón 3");
		
		b3.setForeground(Color.white);
		b3.setBackground(Color.black);
		
		// Por defecto es el BorderLayout
		// Los elementos se colocan en 5 zonas geográficas
		// norte, sur, este, oeste & centro
		System.out.println("Administrador de diseño aplicado: " + this.getLayout());
		
		Container contentPane = this.getContentPane();
		
		// Cambiar el layout del container
		contentPane.setLayout(new FlowLayout());
		
		// Añadir los componentes al contentPane
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);

	}
}
