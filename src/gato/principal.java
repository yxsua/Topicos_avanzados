package gato;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class principal extends Frame 
{
	
	// El turno es true para el círculo, y false para el tache
	private boolean turno = true;
	private Button[][] casillas = new Button[3][3];
	
	public principal()
	{
		super("Gato");
		this.setLayout(new GridLayout(2, 1));
		
		Panel panelJuego = new Panel();
		panelJuego.setLayout(new GridLayout(3, 3));
		
		jugador jugador1 = new jugador(JOptionPane.showInputDialog(getParent(), "Ingresa el nombre del jugador 1:"));
		jugador jugador2 = new jugador(JOptionPane.showInputDialog(getParent(), "Ingresa el nombre del jugador 1:"));
		
		Label nombreJugador1 = new Label(jugador1.getNombre());
		Label nombreJugador2 = new Label(jugador2.getNombre());
		
		Panel panelInformacion = new Panel();
		panelInformacion.setLayout(new FlowLayout());
		
		panelInformacion.add(nombreJugador1);
		panelInformacion.add(nombreJugador2);
		
		if(turno) 
		{
			jugador1.setCaracter("O");
		}
		else 
		{
			jugador2.setCaracter("X");
		} 
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				casillas[i][j] = new Button();
				casillas[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						Button fuente = (Button) e.getSource();
						
						if(fuente.getLabel().equals(""))
						{
							if(turno)
							{
								fuente.setLabel("O");
							}
							else
							{
								fuente.setLabel("X");
							}
							turno = !turno;
							
							// la función regresará "true" si alguien ha ganado y "false" si todavía no hay ganador
							int estado = verificarCasillas(fuente.getLabel());
							if(estado == -1) 
							{
								JOptionPane.showMessageDialog(getParent(), "Es un empate!");
								reiniciarCasillas();
							} 
							else if(estado == 1) 
							{
								if(jugador1.getCaracter().equals(fuente.getLabel()))
								{
									JOptionPane.showMessageDialog(getParent(), "Ha ganado el jugador: "+jugador1.getCaracter()+"!");
									jugador1.setPuntuacion(jugador1.getPuntuacion()+1);
								}
								else if(jugador2.getCaracter().equals(fuente.getLabel()))
								{
									JOptionPane.showMessageDialog(getParent(), "Ha ganado el jugador: "+jugador2.getCaracter()+"!");
									jugador2.setPuntuacion(jugador2.getPuntuacion()+1);
								}
								reiniciarCasillas();
								turno = !turno;
							}
						}
					}
				});
				
				panelJuego.add(casillas[i][j]);
			}
		}
		
		this.add(panelJuego);
		this.add(panelInformacion);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
	
	private int verificarCasillas(String caracter) {
		// Verificamos si la persona que jugó el último turno pudo completar las 3 líneas
		for(int i = 0; i < 3; i++)
		{
			if(casillas[0][i].getLabel().equals(caracter) && casillas[1][i].getLabel().equals(caracter) && casillas[2][i].getLabel().equals(caracter))
			{
				return 1;
			}
			else if(casillas[i][0].getLabel().equals(caracter) && casillas[i][1].getLabel().equals(caracter) && casillas[i][2].getLabel().equals(caracter))
			{
				return 1;
			}
		}
		if(casillas[0][0].getLabel().equals(caracter) && casillas[1][1].getLabel().equals(caracter) && casillas[2][2].getLabel().equals(caracter))
		{
			return 1;
		} 
		else if(casillas[0][2].getLabel().equals(caracter) && casillas[1][1].getLabel().equals(caracter) && casillas[2][0].getLabel().equals(caracter))
		{
			return 1;
		}
		
		// Si todavía hay casillas sin seleccionar y nadie ha ganado, continuamos
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(casillas[i][j].getLabel().equals(""))
				{
					return 0;
				}
			}
		}
		
		return -1;
	}

	private void reiniciarCasillas() 
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				casillas[i][j].setLabel("");
			}
		}
	}
	
	public static void main(String[] args)
	{
		Frame frame = new principal();
		frame.setSize(new Dimension(600, 800));
		frame.setVisible(true);
	}
}
