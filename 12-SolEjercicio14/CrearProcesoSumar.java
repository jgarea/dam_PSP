package paquete14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CrearProcesoSumar {
	  
	private int numInicial;
	private int numFinal;
	private String ficheroResultado;
	private Process p;
		 
	public CrearProcesoSumar(int numInicial,int numFinal,String ficheroResultado) {
		this.numInicial=numInicial;
		this.numFinal = numFinal;
		this.ficheroResultado = ficheroResultado;
		String clase = "paquete14.Sumar";
		String numI = String.valueOf(numInicial);
		String numF = String.valueOf(numFinal);
		ProcessBuilder pb = new ProcessBuilder("java",clase,numI,numF);
		pb.directory(new File(".\\bin"));//depende de tu IDE, esto es para eclipse. Tienes que ver en donde está el .class de Sumar
		pb.redirectOutput(new File(ficheroResultado));//guarda el resultado en un fichero
		try {
			p = pb.start();
		}catch(IOException ex) {
			
		}
		
		
	}
	public int getResultadoSuma() { //este lo hacemos si queremos que leer el fichero creado y mostrar el resultado por pantalla
		int resultado=0;
		FileReader fr;
		try {
			fr = new FileReader(ficheroResultado);
			BufferedReader br= new BufferedReader(fr);
			String s = br.readLine();
			resultado = Integer.valueOf(s);
		} catch (IOException ex) {
			ex.getMessage();
		}
		return resultado;
	}
	


	public int getNumInicial() {
		return numInicial;
	}

	public void setNumInicial(int numInicial) {
		this.numInicial = numInicial;
	}

	public int getNumFinal() {
		return numFinal;
	}

	public void setNumFinal(int numFinal) {
		this.numFinal = numFinal;
	}

	public String getFicheroResultado() {
		return ficheroResultado;
	}

	public void setFicheroResultado(String ficheroResultado) {
		this.ficheroResultado = ficheroResultado;
	}
	public Process getP() {
		return p;
	}
	public void setP(Process p) {
		this.p = p;
	}
	 
}
