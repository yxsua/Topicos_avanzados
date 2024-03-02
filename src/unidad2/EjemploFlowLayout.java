package unidad2;

import java.awt.*;
import java.applet.*;

@SuppressWarnings("serial")
public class EjemploFlowLayout extends Applet {
	
	public void init()
	{
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		Button b;
		for(int i = 0; i < 5; i++)
		{
			b = new Button("Boton "+i);
			this.add(b);
		}
	}

}
