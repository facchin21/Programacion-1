
/*Hacer un programa que dado un arreglo de enteros de tamaño
10 que se encuentra precargado, solicite al usuario un número
entero y elimine todas las ocurrencia de número en el arreglo.
Mientras exista (en cada iteración tiene que buscar la posición
dentro del arreglo) tendrá que usar la posición para realizar un
corrimiento a izquierda (quedarán tantas copias de la última

posición del arreglo como cantidad de ocurrencias del número).*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio11 {
	public static final int MAX = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		int numero;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			cargar_arreglo_int(arr);
			imprimir_arreglo_int(arr);
			System.out.println("Ingrese un numero");
			numero = Integer.valueOf(entrada.readLine());
			eliminar_ocurrencias_igual_num(arr, numero);
			imprimir_arreglo_int(arr);
		} catch (Exception exc) {
			System.out.println(exc);
		}

	}

	public static void eliminar_ocurrencias_igual_num(int[] arr, int numero) {
		int pos = 0;
		while (pos <= MAX - 1) {
			while (arr[pos] == numero) {
				corrimiento_izq(arr, pos);
			}
			pos++;
		}
	}

	public static void corrimiento_izq(int[] arr, int pos) {
		while (pos < MAX - 1) {
			arr[pos] = arr[pos + 1];
			pos++;
		}
		arr[MAX - 1] = - 1;
	}

	public static void cargar_arreglo_int(int[] arr) {
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++) {
			arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
		}
	}

	public static void imprimir_arreglo_int(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.println("nombre_arreglo[" + pos + "]=>: " + arr[pos]);
		}
	}
}
