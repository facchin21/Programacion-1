
/*Hacer un programa que devuelva la posición de inicio y fin de la
primera secuencia de números distinta de ceros.*/
import java.util.Random;

public class ejercicio15 {
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final int MAX = 10;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		int inicio, fin;
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		inicio = obtener_inicio_secuencia(arr);
		fin = obtener_fin_secuencia(arr, inicio);
		System.out.println("El inicio de la secuencia esta en la pos: " + inicio + " El fin esta en la pos: " + fin);
	}

	public static int obtener_inicio_secuencia(int[] arr) {
		int pos = 0;
		while ((pos < MAX) && (arr[pos] == 0)) {
			pos++;
		}
		return pos;
	}

	public static int obtener_fin_secuencia(int[] arr, int pos) {
		while ((pos < MAX) && (arr[pos] != 0)) {
			pos++;
		}
		return pos - 1;
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
