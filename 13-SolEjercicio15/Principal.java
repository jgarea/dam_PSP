package paquete15;

import java.io.*;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        ProcessBuilder pb = new ProcessBuilder("java", "paquete15.Maquina");
        pb.directory(new File(".\\bin"));  //Para IDE intellij=>./target/classes/"));
        Process p = pb.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        PrintStream ps = new PrintStream(p.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        int numero;
        int intentos = 1;
        String line = "";

        while(p.isAlive() && Boolean.parseBoolean(line) != true && intentos <=5){
            System.out.println("¿Qué número crees que es? " + intentos + "º intento");
            numero = scanner.nextInt();
            scanner.nextLine();

            ps.println(numero);
            ps.flush();

            if((line = br.readLine()) != null){
                System.out.println(line);
            }
            intentos++;

        }

        if(intentos >= 6 && Boolean.parseBoolean(line) != true){
            ps.println(-1);
            ps.flush();
            System.out.println("Perdiste!");

            if((line = br.readLine()) != null){
                System.out.println(line);
            }

        }else if(Boolean.parseBoolean(line) == true){
            System.out.println("Ganaste!");
        }


        System.out.println("El proceso Máquina ha finalizado con el código " + p.waitFor());
    }
}