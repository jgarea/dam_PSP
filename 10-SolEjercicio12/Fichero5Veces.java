package paquete12;

public class Fichero5Veces {
	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.println("SE NECESITA UNA CADENA...");
			System.exit(1);
		}
		for (int i = 0; i < 5; i++)
			System.out.println(i + 1 + ". " + args[0]);
	}
}
