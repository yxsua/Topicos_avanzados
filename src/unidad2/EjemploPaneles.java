package unidad2;

import java.applet.*;
import java.awt.*;

@SuppressWarnings("serial")
public class EjemploPaneles extends Applet {
	
	// Declaración de variables
	Button bEsteSup, bEsteInf, b1Sur, b2Sur, b3Sur;
	TextField tf1Norte, tf2Norte;
	Panel pNorte, pEste, pOeste, pSur, pCentro;
	
	// Inicializamos el Applet
	public void init()
	{
		this.setLayout(new BorderLayout());
		
		// Botones de la zona este
		bEsteSup = new Button("Boton este sup");
		bEsteInf = new Button("Boton este inf");
		pEste = new Panel(new BorderLayout());
		
		// Agregamos los botones al panel este
		pEste.add(bEsteSup, BorderLayout.NORTH);
		pEste.add(bEsteInf, BorderLayout.SOUTH);
		
		// Botones de la zona sur
		b1Sur = new Button("Boton sur 1");
		b2Sur = new Button("Boton sur 2");
		b3Sur = new Button("Boton sur 3");
		pSur = new Panel();
		
		// Agregamos los botones al panel sur
		pSur.add(b1Sur);
		pSur.add(b2Sur);
		pSur.add(b3Sur);
		
		// Cuadros de texto del norte
		tf1Norte = new TextField(20);
		tf2Norte = new TextField(20);
		pNorte = new Panel();
		
		// Agregamos los botones al panel norte
		pNorte.add(tf1Norte);
		pNorte.add(tf2Norte);
		
		// Creamos el panel oeste
		pOeste = new Panel();
		pOeste.setBackground(Color.cyan);
		
		// Creamos el panel central
		pCentro = new Panel();
		pCentro.setBackground(Color.pink);
		
		// Añadimos todos los paneles en sus respectivas areas
		this.add(pSur, BorderLayout.SOUTH);
		this.add(pNorte, BorderLayout.NORTH);
		this.add(pCentro, BorderLayout.CENTER);
		this.add(pOeste, BorderLayout.WEST);
		this.add(pEste, BorderLayout.EAST);
		
		this.setSize(new Dimension(800, 200));
	}

}
