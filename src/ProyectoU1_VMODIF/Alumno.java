package ProyectoU1_VMODIF;

import java.io.*;
import java.net.*;

public class Alumno {

	// Declaramos todos los atributos del objeto, todo va a estar encapsulado y se usarán getters y setters
	private String urlAudio;
	private String nombreAudio;
	private String urlImagen;
	private String nombreImagen;
	private String nombreAlumno;
	private String infoAlumno;
	
	// Estos últimos dos atributos serán los archivos de imagen y sonido
	private File imagenAlumno; 
	private File audioAlumno;
	
	// Guardamos la ruta del folder donde se guardarán temporalmente los archivos
	public static final String folder = "src/temp/";
	// Creamos el directorio si es que no existe; si existe, se sobreescribe
	File dir = new File(folder);
	
	public Alumno(String nombre, String info, String urlAudio, String nombreAudio, String urlImagen, String nombreImagen) {
		// Se construye el objeto con todos los parámetros
		this.setNombreAlumno(nombre);
		this.setInfoAlumno(info);
		this.setUrlAudio(urlAudio);
		this.setNombreAudio(nombreAudio);
		this.setUrlImagen(urlImagen);
		this.setNombreImagen(nombreImagen);
		
		// Para los archivos tenemos que usar el método de obtenerArchivo
		// mediante la url y nombre del archivo se descarga el archivo automáticamente
		this.setImagenAlumno(obtenerArchivo(urlImagen, nombreImagen));
		this.setAudioAlumno(obtenerArchivo(urlAudio, nombreAudio));
	}
	
	private File obtenerArchivo(String url, String nombre) {
		// Primero creamos un objeto File con la dirección de donde se escribirá el archivo
		File archivo = new File(folder + nombre);
		try {
			// Empezamos con conectar con la fuente del archivo
			URLConnection conn = new URL(url).openConnection();
			conn.connect();
			
			// Imprimimos en consola la información de como va la descarga
			System.out.println("\nEmpezando descarga: \n");
			System.out.println(">> Alumno: " + this.getNombreAlumno());
			System.out.println(">> URL: " + url);
			System.out.println(">> Nombre: " + nombre);
			System.out.println(">> Tamaño: " + conn.getContentLength() + " bytes");
			
			// Abrimos el flujo de entrada & salida para escribir en el archivo
			InputStream in = conn.getInputStream();
			OutputStream out = new FileOutputStream(archivo);
			
			// Byte por byte vamos creando el archivo
			int b = 0;
			while (b != -1) {
			  b = in.read();
			  if (b != -1)
			    out.write(b);
			}
			
			// Cerramos el flujo de entrada & salida para evitar filtración de recursos
			out.close();
			in.close();
			
			// Si todo salió bien hasta acá, se regresa el archivo objetivo ya escrito
			return archivo;
		} catch (MalformedURLException e) {
			// Si no se puede encontrar la URL se muestra esto
			System.out.println("la url: " + url + " no es valida!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// En caso de no encontrar la URL no se regresa nada al constructor
		return null;
	}
	
	public void EliminarArchivos() {
		// Empezamos creando un objeto File para poder ejecutar el método delete()
		File archivoAudio = new File(folder + this.getNombreAudio());
		File archivoImagen = new File(folder + this.getNombreImagen());
		
		// El método delete() regresa true si se borrá correctamente el archivo
		if(archivoAudio.delete()) {
			// Si sí se borró el archivo, se muestra el siguiente mensaje en consola
			System.out.println("\nSe ha borrado el archivo de audio del alumno: " + this.getNombreAlumno());
		}
		
		if(archivoImagen.delete()) {
			System.out.println("\nSe ha borrado el archivo de imagen del alumno: " + this.getNombreAlumno());
		}
	}

	// Getters & Setters
	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getUrlAudio() {
		return urlAudio;
	}

	public void setUrlAudio(String urlAudio) {
		this.urlAudio = urlAudio;
	}

	public String getNombreAudio() {
		return nombreAudio;
	}

	public void setNombreAudio(String nombreAudio) {
		this.nombreAudio = nombreAudio;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public File getImagenAlumno() {
		return imagenAlumno;
	}

	public void setImagenAlumno(File imagenAlumno) {
		this.imagenAlumno = imagenAlumno;
	}

	public File getAudioAlumno() {
		return audioAlumno;
	}

	public void setAudioAlumno(File file) {
		this.audioAlumno = file;
	}

	public String getInfoAlumno() {
		return infoAlumno;
	}

	public void setInfoAlumno(String infoAlumno) {
		this.infoAlumno = infoAlumno;
	}
}
