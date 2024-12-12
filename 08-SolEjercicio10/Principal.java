package paquete10;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Principal {

	public static void main(String[] args) throws IOException {

		// creamos objeto File al directorio donde esta el ejecutable
		File directorio = new File(".\\bin");

		// El proceso a ejecutar es Devol
		ProcessBuilder pb = new ProcessBuilder("java", "paquete10.Devol", "-2"); //-2 son los args. Siempre que sean args se puede poner por aquí uno o varios separados por comas

		// se establece el directorio donde se encuentra el ejecutable
		pb.directory(directorio);

		// se ejecuta el proceso
		Process p = pb.start();

		
		try {//Aquí se capturan los errores de por ejemplo que la clase sea Devolf en vez de Devol
			//InputStream er = p.getErrorStream();
			BufferedReader br  = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String linea = null;
			while ((linea = br.readLine()) != null)
				System.out.println("ERROR >" + linea);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// COMPROBACION DE la salida del programa
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
			switch (exitVal) {
			case (0):
				System.out.println("FINAL CORRECTO...");//ProcessBuilder pb = new ProcessBuilder("java", "Devol",1);
				break;
			case (1):
				System.out.println("FALTA UN PARAMETRO...");//ProcessBuilder pb = new ProcessBuilder("java", "Devol"):
				break;
			case (2):
				System.out.println("PARÁMETRO NO NUMÉRICO...");//ProcessBuilder pb = new ProcessBuilder("java", "Devol","e");
				break;
			case (3):
				System.out.println("PARÁMETRO MENOR QUE 0...");//ProcessBuilder pb = new ProcessBuilder("java", "Devol","-3");
				break;
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
