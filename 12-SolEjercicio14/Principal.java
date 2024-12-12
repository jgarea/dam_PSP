package paquete14;

public class Principal {
	
	public static void main(String[] args) {
		int resultadoFinal = 0;
		CrearProcesoSumar cps1 = new CrearProcesoSumar(1,5,"fichero1.txt");
		CrearProcesoSumar cps2 = new CrearProcesoSumar(6,10,"fichero2.txt");
		
		try {
			cps1.getP().waitFor();
			cps2.getP().waitFor();
		} catch (InterruptedException e) {  
			e.printStackTrace();
		}
		
		//leer los resultados de los ficheros y calcular el valor final
		int resultado1 = cps1.getResultadoSuma();
		int resultado2 = cps2.getResultadoSuma();
		resultadoFinal = resultado1+resultado2;
		System.out.println(resultadoFinal);
	}
}
