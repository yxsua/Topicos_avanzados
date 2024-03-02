package unidad2;

import java.awt.*;
import java.awt.event.*;

public class EjemploVentanas {

	public static void main(String[] args)
	{
		// Creamos el frame
		Frame frame = new Frame();
		
		// Elegimos administrador de diseño
		frame.setLayout(new FlowLayout());
		
		// Situar, dimensionar y cambiar el color de fondo
		frame.setTitle("Mi primera Ventanita");
		frame.setBounds(100, 40, 250, 250);
		frame.setBackground(Color.cyan);
		
		// Crear componentes
		Button b1 = new Button("Aceptar");
		b1.setForeground(Color.red);
		
		Button b2 = new Button("Cancelar");
		b2.setForeground(Color.green);
		
		TextField tf = new TextField("Esto es un cuadro de texto");
		tf.setForeground(Color.white);
		tf.setBackground(Color.blue);
		
		// Asignamos un ícono a la barra del título
		frame.setIconImage(frame.getToolkit().getImage("src/unidad2/pinguino.jpg"));
		
		// Agregamos componentes a la ventana
		frame.add(b1);
		frame.add(b2);
		frame.add(tf);
		
		// Dejamos que se ajuste al tamaño de los componentes
		frame.pack();
		
		frame.addWindowListener(new WindowAdapter( ) {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		// Mostramos el frame
		frame.setVisible(true);
	}
}
