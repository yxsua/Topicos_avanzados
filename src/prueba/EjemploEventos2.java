package prueba;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class EjemploEventos2 extends Frame implements ActionListener{

	// Declarar variables
	Button b1, b2;
	TextField tf;
	
	EjemploEventos2(String titulo) {
		// Cambiar título del Frame & seleccionar el Layout
		super(titulo);
		setLayout(new FlowLayout());
		setBackground(Color.black); // Color de fondo del frame
		
		// Crear componentes e indicar que la clase escuchadora es esta
		tf = new TextField(15);
		tf.addActionListener(this);
		
		b1 = new Button("Púlsame!");
		b1.addActionListener(this);
		
		b2 = new Button("Borrar");
		b2.addActionListener(this);
		
		// Añadir los objetos al frame
		this.add(b1);
		this.add(tf);
		this.add(b2);
		
		// Indicar que una instancia de CerrarAdapter deberá escuchar el evento de cerrado de la ventana
		addWindowListener(new CerrarAdapter());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Obtener el componente que generó el evento
		Object origen = e.getSource();
		
		// Ejecutar el código correspondiente a cada fuente
		if(origen == tf) {
			setTitle(tf.getText());
		} else if(origen == b1) {
			tf.setText(getTitle());
			setBackground(Color.yellow);
		} else if(origen == b2) {
			tf.setText("");
		}
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

class CerrarAdapter extends WindowAdapter {
	// Método que responde ante el evento del cerrado de ventana
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}