import java.util.Random;

/*Con el mismo arreglo del ejercicio anterior informe por pantalla
cuantos elementos del mismo están por encima del promedio
calculado.*/
public class Ejercicio3 {
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final int MAX = 10;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int arr[] = new int[MAX];
		double promedio;
		double suma;
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		promedio = Calcular_promedio(arr);
		System.out.println("El promedio del arreglo es de: " + promedio);
		suma = Calcular_numMayor_promedio(arr, promedio);
		System.out.println("Los elementos mayor al promedio son : " + suma);
	}

	public static double Calcular_numMayor_promedio(int[] arr, double promedio) {
		int suma = 0;
			for(int pos = 0; pos <= MAX;pos++) {
				while(arr[pos] < promedio) {
					suma++;
			}
		}
		return suma;

	}

	public static double Calcular_promedio(int[] arr) {
		double suma = 0;

		for (int pos = 0; pos < MAX; pos++) {

			suma += arr[pos];

		}
		return (suma / MAX);
	}

	public static void cargar_arreglo_aleatorio_secuencias_int(int[] arr) {
		Random r = new Random();
		arr[0] = 0;
		arr[MAX - 1] = 0;
		for (int pos = 1; pos < MAX - 1; pos++) {
			if (r.nextDouble() > probabilidad_numero) {
				arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
			} else {
				arr[pos] = 0;
			}
		}
	}

	public static void imprimir_arreglo_secuencias_int(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print("arr[" + pos + "]= " + arr[pos] + "\n");
		}
	}
}
