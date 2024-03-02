package unidad2;

import java.applet.*;
import java.awt.*;

@SuppressWarnings("serial")
public class EjemploCasillasYBotonesOpcion extends Applet {
	
	// Declaración de variables
	Checkbox check1, check2, check3;
	CheckboxGroup checkGroup;
	Checkbox checkbox1, checkbox2, checkbox3;
	
	public void init() {
		
		// Inicializamos las casillas
		check1 = new Checkbox();
		check1.setLabel("Casilla 1");
		check1.setState(true);
		
		check2 = new Checkbox("Casilla 2");
		check2.setState(false);
		
		check3 = new Checkbox("Casilla 3", true);
		
		// Grupo de las opciones
		checkGroup = new CheckboxGroup();
		
		checkbox1 = new Checkbox("Opción 1", checkGroup, true);
		checkbox2 = new Checkbox("Opción 2", checkGroup, false);
		checkbox3 = new Checkbox("Opción 3", checkGroup, false);
		
		// Agregar las casillas
		this.add(check1);
		this.add(check2);
		this.add(check3);
		
		// Agregar las opciones
		this.add(checkbox1);
		this.add(checkbox2);
		this.add(checkbox3);
		
	}
}
