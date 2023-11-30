import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Hacer un programa que dado un arreglo ordenado creciente de enteros
de tamaño 10 que se encuentra precargado, solicite al usuario un numero
entero y elimine la primer ocurrencia de numero (un número igual) en el
arreglo (si existe).*/
public class ejercicio8 {
	public static int MAX = 10;
	public static int MINVALOR = 1;
	public static int MAXVALOR = 9;
	public static double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		int numero = obtener_numUser(arr);
		eliminar_primerOcurrencia(arr, numero);
		imprimir_arreglo_secuencias_int(arr);
	}

	public static void eliminar_primerOcurrencia(int[] arr, int numero) {
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

	public static int obtener_numUser(int[] arr) {
		int numero = -1;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		while (numero < 0 || numero > MAX - 1) {
			try {
				System.out.println("Ingrese un numero entero: ");
				numero = Integer.valueOf(entrada.readLine());
			} catch (Exception exc) {
				System.out.println(exc);
			}
		}
		return numero;
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
