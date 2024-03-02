package prueba;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class EjemploKeyEvent extends Frame {
	TextField tf;
	Button b;
	
	public EjemploKeyEvent(String titulo) {
		super(titulo); // Crear el título del frame
		setLayout(new FlowLayout());
		setBackground(Color.yellow);
		tf = new TextField(15);
		
		// Se usa un "adapter" para evitar tener que trabajar con todos los eventos de la interfaz KeyListener
		tf.addKeyListener(new KeyAdapter() {
			// Evento que se dispara cuando se presiona una tecla
			public void keyTyped(KeyEvent e) {
				System.out.println("Dentro del keypad");
				
				if(e.getKeyChar()=='s') { 
					// Usando el caracter para la comparación
					System.out.println("Has tecleado s");
				} else if(e.getKeyCode() == KeyEvent.VK_CONTROL) { 
					// Usando el código de la tecla para la comparación
					System.out.println("Has pulsado control");
				}
			}
		});
		
		add(tf);
		
		b = new Button("Aceptar");
		b.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					// Para teclas que no tienen un "caracter" se debe utilizar el código de la tecla
					System.out.println("Has pulsado escape teniendo el foco en el botón");
				}
			}
		});
		
		add(b);
		
		// Permite que se cierre el frame
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		// Pasar el título del frame como argumento al constructor que creamos
		Frame frame = new EjemploKeyEvent("Eventos KeyEvent");
		frame.setSize(new Dimension(250, 150)); 
		frame.setVisible(true);
	}
}
