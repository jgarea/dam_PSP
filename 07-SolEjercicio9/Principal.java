package paquete9;

import java.io.*;

public class Principal {
//ejecutas primero actividad2_Sumar para que cree el archivo pertinente en bin
	public static void main(String[] args) throws IOException {

		File directorio = new File(".\\bin");//esto en IDE eclipse. En otros IDEs tendrías que buscar el .class en donde se guarda
		ProcessBuilder pb = new ProcessBuilder("java", "paquete9.Sumar"); //si estuviese en un paquete pondrías mipaq.mipaq2.actividad2_Sumar
		pb.directory(directorio);

		// se ejecuta el proceso
		Process p = pb.start();

		
		// escritura -- envia entrada 
		OutputStream os = p.getOutputStream();
		os.write("10\n".getBytes());//es imprescindible el salto de línea
		os.write("15\n".getBytes());//esto iría por el error (de la otra clase no de esta) a no meter bien el  número
		                             //para ir sin error introduce solo dígitos y el salto de línea
		//error sería os.write("1a5\n".getBytes());
		os.flush();

		// lectura -- obtiene la salida	
		BufferedReader br =  new BufferedReader(new InputStreamReader(p.getInputStream()));
		String linea = null;
		while ((linea=br.readLine())!=null)
			System.out.println(linea);
		 
		 /*LO ANTERIOR ES LO MISMO QUE ESTO, UNO CARaCTER A CARACTER Y OTRO FLUJO A FLUJO*/
		/*InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1)
			System.out.print((char) c);
		is.close();
		*/
		

		// COMPROBACION DE ERROR - 0 bien - 1 mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			//InputStream er = p.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String liner = null;
			while ((liner = brer.readLine()) != null)
				System.out.println("ERROR >" + liner); //POR AQUÍ SOLO ENTRA SI POR EJEMPLO NO EXISTE LA CLASE A LA QUE REFERENCIA (actividad2_Sumar)
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
} 