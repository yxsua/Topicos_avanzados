package unidad2;

import java.applet.*;
import java.awt.*;

@SuppressWarnings("serial")
public class EjemploListas extends Applet {
	
	// Declaración de variables
	Choice choice;
	List lista;
	
	public void init() {
		// Creación de componentes
		choice = new Choice();
		lista = new List(4, true);
		
		// Añadimos elementos a la lista
		for(int i = 0; i < 6; i++) 
		{
			choice.add("Elemento " + i);
			lista.add("Elemento " + i);
		}
		
		// Añadimos mas elementos mediante un arreglo
		String[] lenguajes = new String[] {"Java", "C++", "Visual Basic"};
		for(String lenguaje : lenguajes) 
		{
			choice.add(lenguaje);
			lista.add(lenguaje);
		}

		// Añadir los elementos al Layout
		this.add(choice);
		this.add(lista);
	}

}
