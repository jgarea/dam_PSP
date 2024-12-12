package paquete14;

public class Sumar {
	
	private static int suma(int numI,int numF) {
		int resultado = 0;
		for(int i = numI;i<=numF;i++) {
			resultado = resultado+i;
		}
		return resultado;
	}
	public static void main(String[] args) {
		if (args.length==2) {
			int num1 = Integer.valueOf(args[0]); //se meten los argumentos en eclipse : run as->run configurations->arguments
			int num2 = Integer.valueOf(args[1]);
			int resultado = suma(num1,num2);
			System.out.println(resultado);
		} else {
			
		}
	}
	//ejemplo:1,10=>55
}
