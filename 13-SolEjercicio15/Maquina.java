package paquete15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Maquina {
    public static void main(String[] args) throws IOException {

    	Scanner sc = new Scanner(System.in);
        System.out.println("Introduce número");
        String line = "";
        boolean salir = false;
        int numeroElegido = (int) (Math.random()*100+1);
        while(!salir){
           
                int numeroJugador = sc.nextInt();
                if(numeroJugador == -1){
                    salir = true;
                    System.out.println("Era el " + numeroElegido);
                }else if (numeroElegido > numeroJugador){
                    System.out.println("Mayor");
                }else if (numeroElegido < numeroJugador){
                    System.out.println("Menor");
                }else{
                    salir = true;
                    System.out.println(true);
                }
            
        }

        System.exit(0);
    	
    	/*Otra forma
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String line = "";
        boolean salir = false;
        int numeroElegido = (int) (Math.random()*100+1);
        while(!salir){
            if((line = br.readLine()) != null){
                int numeroJugador = (parseInt(line));
                if(numeroJugador == -1){
                    salir = true;
                    System.out.println("Era el " + numeroElegido);
                }else if (numeroElegido > numeroJugador){
                    System.out.println("Mayor");
                }else if (numeroElegido < numeroJugador){
                    System.out.println("Menor");
                }else{
                    salir = true;
                    System.out.println(true);
                }
            }
        }

        System.exit(0);
        */
    }
}