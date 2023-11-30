
/*Hacer un programa que devuelva la posición de inicio y de fin
de la secuencia de mayor tamaño.*/
import java.util.Random;

public class Ejercicio18 {
	public static final int MAX = 20;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		int inicio = 0;
		int fin = -1;
		int secuenciaMayor = 0;
		int iniAux = 0, finAux = 0;
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		while (inicio < MAX) {
			inicio = obtener_inicio(arr, inicio);
			if (inicio < MAX - 1) {
				fin = obtener_fin(arr, inicio);
				int tamanio = (fin - inicio) + 1;
				if (tamanio > secuenciaMayor) {
					secuenciaMayor = tamanio;
					iniAux = inicio;
					finAux = fin;
				}
				inicio = fin + 1;
			} else {
				inicio = MAX;
			}

		}
		System.out.println("comienza en " + iniAux + " termina en " + finAux);
		System.out.println(secuenciaMayor);
	}

	public static int obtener_fin(int[] arr, int pos) {
		while ((pos <= MAX - 1) && (arr[pos] != 0)) {
			pos++;
		}
		return pos - 1;
	}

	public static int obtener_inicio(int[] arr, int pos) {
		while ((pos <= MAX - 1) && (arr[pos] == 0)) {
			pos++;
		}
		return pos;
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
