import java.util.Random;

/*Hacer un programa que dado un arreglo ya cargado con 10
enteros, calcule el promedio y lo muestre por la consola.*/
public class ejercicio2 {
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final int MAX = 10;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int arr[] = new int[MAX];
		double promedio;
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		promedio = Calcular_promedio(arr);
		System.out.println("El promedio del arreglo es de: "+promedio);
	}

	public static double Calcular_promedio(int[] arr) {
			double suma = 0;

			for (int pos = 0; pos < MAX; pos++){

			suma+=arr[pos];

			}
			return (suma/MAX);
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
