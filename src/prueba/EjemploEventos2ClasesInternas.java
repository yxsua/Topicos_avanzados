package prueba;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class EjemploEventos2ClasesInternas extends Frame {

	// Declarar variables
	Button b1, b2;
	TextField tf;
	
	EjemploEventos2ClasesInternas(String titulo) {
		// Cambiar título del Frame & seleccionar el Layout
		super(titulo);
		setLayout(new FlowLayout());
		setBackground(Color.black); // Color de fondo del frame
				
		// Crear componentes e indicar que la clase escuchadora es esta
		tf = new TextField(15);
		tf.addActionListener(new ActionListener() {
			// A cada componente añadir una clase interna que maneje el evento que provoca
			public void actionPerformed(ActionEvent e) {
				setTitle(tf.getText());
			}
		});
		
		b1 = new Button("Púlsame!");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf.setText(getTitle());
				setBackground(Color.yellow);
			}
		});
		
		b2 = new Button("Borrar");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf.setText("");
			}
		});
		
		// Añadir los objetos al frame
		this.add(b1);
		this.add(tf);
		this.add(b2);
		
		// Añadir un manejador dentro de una clase interna para el evento de cerrado de la ventana
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		// Crear el Frame y ajustar sus dimensiones
		Frame frame = new EjemploEventos2("Clases adaptadoras");
		frame.setLocation(20, 20);
		frame.setSize(new Dimension(300, 100));
		// Mostrar el frame
		frame.setVisible(true);
	}
}
