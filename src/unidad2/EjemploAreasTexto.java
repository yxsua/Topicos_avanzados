package unidad2;

import java.applet.*;
import java.awt.*;

@SuppressWarnings("serial")
public class EjemploAreasTexto extends Applet{

	// Declaramos variables
	TextArea ta, ta1, ta2, ta3;
	Font miFuente;
	
	public void init() {
		// "Creamos" nuestra fuente y la añadimos al Layout
		miFuente = new Font("Serif", Font.BOLD, 15);
		this.setFont(miFuente);
		
		// Creamos los objetos
		ta = new TextArea();
		ta1 = new TextArea(5, 20);
		System.out.println(ta1.getColumns());
		
		String texto = "Componente utilizado para introducir o mostrar\n"
				+ "texto modificable en varias líneas.\n"
				+ "Además, este componente posee barras de desplazamiento\n"
				+ "horizontal y vertical que permiten"
				+ "desplazar el texto contenido en el área de texto.";
		
		ta2 = new TextArea(texto);
		ta2.setBackground(Color.cyan);
		
		ta3 = new TextArea(texto, 5, 15);
		ta3.setForeground(Color.blue);
		ta3.setBackground(Color.white);
		
		// Añadimos los componentes
		this.add(ta);
		this.add(ta1);
		this.add(ta2);
		this.add(ta3);
		
	}
	
}
