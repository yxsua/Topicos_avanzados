package unidad2;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class EjemploMenusSubmenus extends Frame {

	// Declaracion de variables
	MenuBar barraMenu;
	Menu menu1;
	Menu menu2;
	MenuItem[] itemsMenu1;
	MenuItem itemMenu2;
	CheckboxMenuItem checkboxItemMenu2;
	
	public EjemploMenusSubmenus(String titulo) 
	{
		super(titulo);
		
		// Creamos la barra del menu y la enlazamos al frame
		barraMenu = new MenuBar();
		this.setMenuBar(barraMenu);
		
		// Creamos los menús de primer nivel y los añadimos
		menu1 = new Menu("Menu 1");
		menu2 = new Menu("Menu 2");
		
		barraMenu.add(menu1);
		barraMenu.add(menu2);
		
		// Creamos menús de segundo nivel
		itemsMenu1 = new MenuItem[3];
		
		itemsMenu1[0] = new MenuItem("Cucu 1");
		itemsMenu1[1] = new MenuItem("Cucu 2");
		itemsMenu1[2] = new MenuItem("Cucu 3");
		
		itemMenu2 = new MenuItem("Hola");
		// Menu con casillas de verificación
		checkboxItemMenu2 = new CheckboxMenuItem("Adios");
		
		// Añadimos los menuItems a los menus
		for(MenuItem item : itemsMenu1)
		{
			menu1.add(item);
		}
		
		menu2.add(itemMenu2);
		menu2.add(checkboxItemMenu2);
		
		this.addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						System.exit(0);
					}
				});
	}
	
	public static void main(String[] args)
	{
		Frame frame = new EjemploMenusSubmenus("Ventana con dos menus");
		frame.setSize(new Dimension(300, 150));
		frame.setVisible(true);
	}
}
