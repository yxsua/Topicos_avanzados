package unidad2;

import java.awt.*;
import java.applet.*;

@SuppressWarnings("serial")
public class EjemploGridLayout extends Applet {
	
	public void init()
	{
		setLayout(new GridLayout(3, 2, 10, 10));
		Button b;
		
		for(int i = 0; i < 5; i++)
		{
			b = new Button("Boton "+i);
			this.add(b);
		}
	}
}
