package unidad2;

import java.awt.*;
import java.applet.*;

@SuppressWarnings("serial")
public class EjemploBorderLayout extends Applet {

	public void init()
	{
		this.setLayout(new BorderLayout());
		
		this.add(new Button("Norte"), BorderLayout.NORTH);
		this.add(new Button("Sur"), BorderLayout.SOUTH);
		this.add(new Button("Este"), BorderLayout.EAST);
		this.add(new Button("Oeste"), BorderLayout.WEST);
		this.add(new Button("Centro"), BorderLayout.CENTER);
		
	}
}
