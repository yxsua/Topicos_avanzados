package unidad2;

import java.awt.*;

@SuppressWarnings("serial")
public class MiCanvas extends Canvas {
	Image imagen;
	
	public MiCanvas(Image imagen)
	{
		this.imagen = imagen;
		System.out.println("Constructor Canvas");
	}
	
	// Se redefine el paint
	public void paint(Graphics g)
	{
		System.out.println("Paint");
		
		// Se muestra la imagen con las dimensiones originales
		g.drawImage(imagen, 0, 0, this);
	}
}
