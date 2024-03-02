package ProyectoU1;

// Librería para el manejo de audio
import javax.sound.sampled.*;

// Librería para manejo de componentes
import javax.swing.*;

// Librería para manejo de componentes & eventos
import java.awt.*;
import java.awt.event.*;

// Librería para el manejo de archivos
import java.io.*;

@SuppressWarnings("serial")
public class principalApplet extends JFrame {

	// Declaración de variables
	
	// Se crea un arreglo de objetos vacío para almacenar información de los alumnos
	Alumno[] alumnos = new Alumno[]{};
	// El resto de los componentes son del Frame
	List liNombresAlumnos;
	JLabel lbSeleccionAudio, iconImagenAlumno;
	TextArea lbinfoAlumno;
	JRadioButton rbSonido, rbNoSonido;
	JButton btnObtenerInfo;
	JPanel pnGeneral;
	
	public principalApplet(String titulo) {
		// Establecer el título del JFrame
		super(titulo);
		
		// Se crean los objetos del arreglo alumnos con la información de los alumnos
		// Permite crear una cantidad "n" de alumnos, el resto del código se adapta automáticamente
		alumnos = new Alumno[]{
				new Alumno("Yasua", 
						"Hola! Soy Yasua.\nSoy un estudiante de Ingeniería en Sistemas. Me gustan los videojuegos y varias otras actividades, estoy en 4to semestre.", 
						// Los links de drive son links directos de descarga, para sacar las imágenes
						// y audio de la nube
						"https://drive.usercontent.google.com/download?id=1Zn7AqqYX-Lepv_iEHL3UjFh4iOUyNuCs&export=download&authuser=5&confirm=t&uuid=38051c50-a235-4a1f-a328-62498dc7b501&at=APZUnTXXHA9Ept5GR2xQ725W0TRO:1708313599198",
						// También es necesario indicar el nombre y extensión de los archivos de imagen/audio
						"infoYasua.wav", 
						"https://drive.usercontent.google.com/download?id=1pysviuLixqaY-nXZNLURDBjB5-yiTh-N&export=download&authuser=5&confirm=t&uuid=f9f185bb-e167-473c-8ebd-b97ada1ca151&at=APZUnTWkyAQd3W4_L1kxjhnutwch:1708305806807", 
						"fotoYasua.jpg"),
				new Alumno("Andrea", 
						"Hola soy Andrea Macedo Hernandez,\n tengo 20 años estudio Ing. en sistemas computacionales, cuarto semestre. Me gusta bailar vivo en Queretaro, tengo un hermano y estoy solteraa.", 
						"https://drive.usercontent.google.com/download?id=1_wVSipBsIlYiY68_pdrpFvA6okKLazQS&export=download&authuser=5&confirm=t&uuid=b3787e4a-14e0-480f-80c0-03e2b1bc3656&at=APZUnTUVc_mTdT_XuS46rQi-_r7i:1708315232997", 
						"infoAndrea.wav", 
						"https://drive.usercontent.google.com/download?id=18TrDGt7zYkJUDIQ-2jneFRtqkSNoIPqQ&export=download&authuser=5&confirm=t&uuid=7556d2ac-e4f0-4fe1-b5b7-b2f8ae22deb8&at=APZUnTUyzrvc_vPA5FQKUo-sWPV0:1708315183020", 
						"fotoAndy.jpg"),
				new Alumno("Karen", 
						"Mi nombre completito es Dana Karen Jiménez Moreno,\n estoy cursando la ingeniería en sistemas computacionales. Me gusta dibujar, escuchar musica e ir al gym.", 
						"https://drive.usercontent.google.com/download?id=16hmCQwgSYtRE6FN0P39TPjzKrLHExdV5&export=download&authuser=5&confirm=t&uuid=354be8d2-d072-41e5-92c9-2cd47dbe1213&at=APZUnTWOa5XfHn3a2XUzsfHz3fyz:1708314758049", 
						"infoKaren.wav", 
						"https://drive.usercontent.google.com/download?id=1_UqKASrUjlwiWduUDXeB0rGExObArzux&export=download&authuser=5&confirm=t&uuid=c0322ac5-9580-482e-9712-d563f1c54676&at=APZUnTUXum5E3No78K0yIzekFbc5:1708314902131", 
						"fotoKaren.jpg"),
				new Alumno("Brayan", 
						"Hola me llamo Brayan. \nSoy de la carrera de ingenieria en sistemas y me gusta el crack", 
						"https://drive.usercontent.google.com/download?id=1Igxi2jzLE95S-Yvrm_5Loqn1D1QmX8eI&export=download&authuser=5&confirm=t&uuid=eab17c49-b61f-46fc-ae8a-80e2327e229a&at=APZUnTWWS4oipMf9tWzQMNFd9FaV:1708371802970", 
						"infoBrayan.wav", 
						"https://drive.usercontent.google.com/download?id=1huz_fZ2Nw8XlVSdccdZQE8jRVI1C2fl8&export=download&authuser=5&confirm=t&uuid=3067e75a-38d8-4618-9c7f-c782828e746d&at=APZUnTXTdYarx4vBls8mxA94FRqg:1708371752896", 
						"fotoBrayan.jpg"),
				new Alumno("Melina", 
						"Hola, mi nombre es Melina Dannaé Ayala Sandoval. \nTengo 19 años, estudio la carrera de ingeniería en sistemas computacionales y actualmente curso 4to semestre en el instituto tecnológico de Queretaro. Me gusta el sushi y la música", 
						"https://drive.usercontent.google.com/download?id=17oaCGYKJboNLyPBiGwijIvPDdcEnE30z&export=download&authuser=5&confirm=t&uuid=ae75d2ac-1b8e-4b1b-8bb0-1accc078281a&at=APZUnTVy4vtnJ2HsOxuthLZdtG_a:1708372136241", 
						"infoMelina.wav", 
						"https://drive.usercontent.google.com/download?id=1JEFHdgJuCDHNIL5Zm4mtRhdey9i399Ed&export=download&authuser=5&confirm=t&uuid=0285d9bb-b4aa-43c8-ac22-28d2ea38c7cd&at=APZUnTVKehhvz5kkUxQ7xrA8FqT5:1708372262491", 
						"fotoMelina.jpg")
		};
		
		// Inicializar el Label para la selección de si se escuchará el audio
		lbSeleccionAudio = new JLabel("¿Quieres escucharlos?");
		
		// Inicializar los radioButtons para la selección de audio
		rbSonido = new JRadioButton("Con sonido");
		rbNoSonido = new JRadioButton("Sin sonido");
		// Por defecto el sonido estará seleccionado
		rbSonido.setSelected(true);
		
		// Se debe crear un Grupo para los botones, de lo contrario no estarán conectados
		// y se podrán seleccionar ambos
		ButtonGroup grupoRadioButtons = new ButtonGroup();
		grupoRadioButtons.add(rbSonido);
		grupoRadioButtons.add(rbNoSonido);
		
		// Inicializamos la lista, por cada alumno que haya en el arreglo
		// de alumnos, se añade el nombre como elemento a la lista
		liNombresAlumnos = new List();
		for(Alumno alumno : alumnos) {
			liNombresAlumnos.add(alumno.getNombreAlumno());
		}
		
		// Creamos una imagen (label) para mostrar la foto del alumno
		iconImagenAlumno = new JLabel();
		
		// Creamos un campo de texto con un mensaje inicial
		lbinfoAlumno = new TextArea("Sin información cargada", 5, 20);
		// Indicamos con setLineWrap que se debe autoajustar al tamaño de la ventana
		// y con setWrapStyleWord, que se deberá cortar cuando no quepa la palabra completa
		// en vez de cortar las letras (funciona solo con el JTextArea)
		/* lbinfoAlumno.setLineWrap(true);
		lbinfoAlumno.setWrapStyleWord(true);*/
		
		// Inicializamos el botón para obtenet la información y añadimos el handler
		btnObtenerInfo = new JButton("Obtener información");
		btnObtenerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtenemos el nombre del alumno que está seleccionado en la lista
				String alumnoSeleccionado = liNombresAlumnos.getItem(liNombresAlumnos.getSelectedIndex());
				
				// Verificamos que si haya un alumno seleccionado
				if(alumnoSeleccionado != null) {
					// Recorremos el arreglo de alumnos hasta encontrar el alumno con el nombre seleccionado en la lista
					for(Alumno alumno : alumnos) {
						if(alumnoSeleccionado.equals(alumno.getNombreAlumno())) {
							// Primero, establecemos en el campo de texto con setText la info del alumno
							// con el método para obtener la información del alumno
							lbinfoAlumno.setText(alumno.getInfoAlumno());
							
							// Creamos una imagen a partir de un imageIcon, usando el path indicado mediante el constructor
							Image img = new ImageIcon(Alumno.folder+alumno.getNombreImagen()).getImage();
							// Ajustamos la imagen para que no se corte, a un tamaño de 150x150 pixeles
							ImageIcon imgAjustada =new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
							// Mostramos la imagen
							iconImagenAlumno.setIcon(imgAjustada);
							
							// Revisamos que el usuario tenga la opción de sonido seleccionada
							if(rbSonido.isSelected()) {
								try {
									// Obtenemos el audio usando el archivo almacenado en el objeto alumno 
							        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(alumno.getAudioAlumno().getAbsoluteFile());
							        // Conseguimos el clip mediante está entrada de audio
							        Clip audio = AudioSystem.getClip();
							        // Abrimos el archivo del clip y lo reproducimos
							        audio.open(audioInputStream);
							        audio.start();
							        // Arrojar las excepciones pertinentes
							       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
							         System.out.println("Error al reproducir el sonido.");
							       }
							}
							// Si ya se encontró el alumno que corresponde a la opción seleccionada en la lista,
							// detener el ciclo
							break;
						}
					}
				}
			}
		});
		
		// Empezamos a crear el Layout del Panel
		pnGeneral = new JPanel();
		
		// Vamos a trabajar con un GroupLayout
		GroupLayout pnGeneralLayout = new GroupLayout(pnGeneral);
		pnGeneral.setLayout(pnGeneralLayout);
		
		// Indicamos que se deberán crear automáticamente los espacios entre los componentes/contenedor
		pnGeneralLayout.setAutoCreateGaps(true);
		pnGeneralLayout.setAutoCreateContainerGaps(true);
		
		// Creamos el grupo vertical
		GroupLayout.SequentialGroup grupoVertical = pnGeneralLayout.createSequentialGroup();
		// Habrá 3 grupos paralelos verticalmente
		grupoVertical.addGroup(pnGeneralLayout.createParallelGroup()
				// El primer grupo contiene el label para la selección de audio y los radioButtons
						.addComponent(lbSeleccionAudio)
						.addComponent(rbSonido)
						.addComponent(rbNoSonido));
		grupoVertical.addGroup(pnGeneralLayout.createParallelGroup()
				// El segundo grupo contiene la lista de los alumnos, la imagen de los alumnos y la información del alumno
						.addComponent(liNombresAlumnos)
						.addComponent(iconImagenAlumno, 150, 150, 300)
						.addComponent(lbinfoAlumno));
		grupoVertical.addGroup(pnGeneralLayout.createParallelGroup()
				// El último grupo solo contiene el botón para obtener la información
				.addComponent(btnObtenerInfo));
		
		// Creamos el grupo horizontal
		GroupLayout.SequentialGroup grupoHorizontal = pnGeneralLayout.createSequentialGroup();
		// Habrá 3 grupos paralelos horizontalmente
		grupoHorizontal.addGroup(pnGeneralLayout.createParallelGroup()
				// El primer grupo contiene la label para la selección de audio y la lista de alumnos
						.addComponent(lbSeleccionAudio)
						.addComponent(liNombresAlumnos));
		grupoHorizontal.addGroup(pnGeneralLayout.createParallelGroup()
				// El segundo grupo contiene el radio button de sonido, la imagen del alumno y el botón de obtener información
						.addComponent(rbSonido)
						.addComponent(iconImagenAlumno, 150, 150, 300)
						.addComponent(btnObtenerInfo));
		grupoHorizontal.addGroup(pnGeneralLayout.createParallelGroup()
				// El último grupo tiene el radio button de no sonido y la información del alumno
						.addComponent(rbNoSonido)
						.addComponent(lbinfoAlumno));
		
		// Establecemos los grupos en el layout de grupo
		pnGeneralLayout.setVerticalGroup(grupoVertical);
		pnGeneralLayout.setHorizontalGroup(grupoHorizontal);
		
		// Añadimos el panel con el layout al frame
		this.add(pnGeneral);
		
		// Añadir un manejador dentro de una clase interna para el evento de cerrado de la ventana
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// Recorremos el arreglo de alumnos y borramos los archivos de audio e imagen
				// asociado a cada alumno
				for(Alumno alumno : alumnos) {
					alumno.EliminarArchivos();
				}
				System.out.println("\nCerrando el programa...");
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		// Creamos el frame, lo dimensionamos y lo mostramos
		Frame frame = new principalApplet("Proyecto U1");
		frame.setSize(new Dimension(500, 300));
		frame.setVisible(true);
	}
}
