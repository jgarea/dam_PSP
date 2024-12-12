package paquete11;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		String cadena;
		System.out.print("Introduzca la cadena: ");
		cadena = sc.nextLine();

		File directorio = new File(".\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java", "paquete11.Visualiza5Veces", cadena);

		// se establece el directorio donde se encuentra el ejecutable
		pb.directory(directorio);

		// se ejecuta el proceso
		Process p = pb.start();
		
		try {
			//InputStream er = p.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String liner = null;
			while ((liner = brer.readLine()) != null)
				System.out.println("ERROR >" + liner); //ejemplo: no poner el paquete (paquete11) en el ProcessBuilder
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
				System.out.println("FINAL CORRECTO...");
				break;
			case (1):
				System.out.println("FINAL INCORRECTO...");//ejemplo no meter parámetro:ProcessBuilder pb = new ProcessBuilder("java", "Visualiza5Veces");
				break;
			}

		} catch (InterruptedException e){
			e.printStackTrace();
		}

		try {			
			//InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea;
			while ((linea = br.readLine()) != null)
			{
				System.out.println(linea);				
			}
			br.close();			
		} catch (Exception ee) 	{
			ee.printStackTrace();
		}

	}
}
