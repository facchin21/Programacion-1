
/*Hacer un programa que dado un arreglo de enteros de tamaño
10 que se encuentra precargado, solicite al usuario un número
entero y elimine la primera ocurrencia del número (un número
igual) en el arreglo (si existe). Para ello tendrá que buscar la
posición y si está, realizar un corrimiento a izquierda (queda una
copia de la última posición del arreglo en la anteúltima posición).*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio10 {
	public static final int MAX = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final double probrabilidad_numero = 0.4;

	public static void main(String[] args) {
		int numero;
		int[] arr = new int[MAX];
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			cargar_arreglo_int(arr);
			imprimir_arreglo_int(arr);
			System.out.println("Ingrese un numero entero");
			numero = Integer.valueOf(entrada.readLine());
			eliminar_primer_ocurrencia(arr, numero);
			imprimir_arreglo_int(arr);
		} catch (Exception exc) {
			System.out.println(exc);
		}

	}

	public static void eliminar_primer_ocurrencia(int[] arr, int numero) {
		int pos = 0;
		while (pos <= MAX - 1) {
			if (arr[pos] == numero) {
				corrimiento_izq(arr, pos);
				pos = MAX - 1;
			}
			pos++;
		}
	}

	public static void corrimiento_izq(int[] arr, int pos) {
		while (pos < MAX - 1) {
			arr[pos] = arr[pos + 1];
			pos++;
		}
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
