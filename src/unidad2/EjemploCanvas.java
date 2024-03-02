package unidad2;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class EjemploCanvas extends Frame {
	
	// Declaración de variables
	Button b1, b2;
	TextField tf;
	
	MiCanvas mc;
	
	public EjemploCanvas(String titulo)
	{
		super(titulo);
		this.setLayout(new FlowLayout());
		
		// Cambiar color de fondo
		this.setBackground(Color.cyan);
		
		// Creamos los objetos
		b1 = new Button("Aceptar");
		b1.setForeground(Color.red);
		
		b2 = new Button("Cancelar");
		b2.setForeground(Color.green);
		
		// Crear cuadro de texto
		tf = new TextField("Esto es un cuadro de texto");
		tf.setForeground(Color.white);
		tf.setBackground(Color.blue);
		
		// Obtener imagen para ícono de la barra de título y para el canvas
		Image imagen = getToolkit().getImage("src/unidad2/pinguino.jpg");
		setIconImage(imagen);
		
		// Invocamos al constructor del canvas
		mc = new MiCanvas(imagen);
		
		mc.setSize(150, 150);
		mc.setBackground(Color.black);
		
		// Añadir los elementos al Frame
		this.add(b1);
		this.add(b2);
		this.add(tf);
		this.add(mc);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}

	public static void main(String[] args)
	{
		Frame frame = new EjemploCanvas("Mi primera ventanita");
		frame.pack();
		frame.setVisible(true);
	}
}
