package prueba;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

@SuppressWarnings("serial")
public class EjemploEventosTeclado extends Frame {

	TextField tf1, tf2, tf3, tf4;
	
	public EjemploEventosTeclado(String titulo) {
		super(titulo);
		setLayout(new FlowLayout(1));
		
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		tf3 = new TextField(10);
		tf4 = new TextField(25);
		
		tf1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(tf1.hasFocus() && e.getKeyCode() == KeyEvent.VK_Q) {
					tf2.setText(tf1.getText());
					tf4.setText("Se ha presionado q en tf1");
				}
			}
			public void keyReleased(KeyEvent e) {
				if(tf1.hasFocus() && e.getKeyCode() == KeyEvent.VK_Q) {
					ReproducirSonido("src/beep.wav");
					setBackground(Color.pink);
					tf2.requestFocus();
					tf1.setText("");
				}
			}
		});
		tf1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf1.getText().toLowerCase().equals("fin")) {
					System.exit(0);
				}
				System.out.println(tf1.getText());
				tf4.setText("Se ha presionado Enter en tf1");
			}
			
		});
		tf2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(tf2.hasFocus() && e.getKeyCode() == KeyEvent.VK_F6) {
					tf3.setText(tf2.getText().toUpperCase());
					tf3.setForeground(Color.white);
					tf3.setBackground(Color.black);
					tf2.setText("");
					setBackground(Color.cyan);
					tf4.setText("Se ha presionado F6 en tf2");
				}
			}
		});
		tf3.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(tf3.hasFocus() && e.getKeyCode() == KeyEvent.VK_CONTROL) {
					tf3.setText("");
					tf3.setForeground(Color.black);
					tf3.setBackground(Color.white);
					setBackground(Color.black);
					tf4.setText("Se ha presionado Control en tf3");
				}
			}
		});
		tf4.setEditable(false);
		
		tf1.setBackground(Color.cyan);
		tf3.requestFocus();
		tf3.requestFocusInWindow();
		
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	
	public static void main(String[] args) {
		Frame frame = new EjemploEventosTeclado("Eventos de teclado");
		frame.setSize(new Dimension(500, 150));
		frame.setVisible(true);
	}
	
	public void ReproducirSonido(String nombreSonido){
	       try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
	         System.out.println("Error al reproducir el sonido.");
	       }
	     }
}
