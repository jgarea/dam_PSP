package paquete13;

import java.io.*;
import java.util.Scanner;

public class Palindromo {

	public static void main(String[] args) {
		System.out.println("Introduce la palabra para ver si es o no un palíndromo");

		Scanner sc = new Scanner(System.in);
		String cadena = sc.nextLine();	
		
		if(cadena.length()==0 ) {
			System.out.println("La cadena introducida está vacía. ");
			System.exit(1);			
		}

		// En cadena2 guardo los caracteres sin espacios
		String cadena2 = "";
		for (int x = 0; x < cadena.length(); x++) {
			if (cadena.charAt(x) != ' ')
				cadena2 += cadena.charAt(x);
		}
		
		cadena=cadena2;
		int inc = 0;
		int des = cadena.length() - 1;
		boolean bError = false;

	    
	    while ((inc<des) && (!bError)){	        
	    	if (cadena.charAt(inc)==cadena.charAt(des)){				
	    		inc++;
	    		des--;
	    	} else 
	    		bError = true;
	    }
	    
	    if (!bError) 
	    	System.out.println(cadena + " =>  es un PALíNDROMO");	    
	    
	    else 
	    	System.out.println(cadena + " => NO es un palíndromo");	    	
	    
		
	    System.exit(0);		
		sc.close();

	}

}
