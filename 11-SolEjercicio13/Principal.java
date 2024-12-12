package paquete13;

import java.io.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {


        ProcessBuilder pb = new ProcessBuilder("java", "paquete13.Palindromo");
        File directorio = new File(".\\bin");
        pb.directory(directorio);
        Process p = pb.start();

        Scanner sc = new Scanner(System.in);
        System.out.printf("Introduce una cadena a procesar: ");
        String cadena = sc.nextLine();

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        PrintStream ps = new PrintStream(p.getOutputStream());
        ps.println(cadena);
        ps.flush();

        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }


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
            BufferedReader brerr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String linea = null;
            while ((linea = brerr.readLine()) != null)
                System.out.println("ERROR >" + linea);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}