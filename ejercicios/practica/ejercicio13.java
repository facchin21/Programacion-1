import java.util.Random;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/*Hacer un programa que dado el arreglo definido y precargado, y un número entero
ingresado por el usuario, elimine las secuencias de tamaño igual al número ingresado.*/
public class ejercicio13 {
	public static int MAX = 10;
	public static int MINVALOR = 1;
	public static int MAXVALOR = 9;
	public static double probabilidad_numero = 0.4;
	final static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		int numero = obtener_numUser(arr);
		int inicio = 0;
		int fin = -1;
		int tam = 0;
		while (inicio < MAX) {
			inicio = obtener_inicio(arr, inicio);
			if (inicio < MAX - 1) {
				fin = obtener_fin(arr, inicio);
				tam = fin - inicio + 1;
				if (numero == tam) {
					for (int i = inicio; i <= fin; i++) {
						corrimiento_izq(arr, inicio);
					}
					fin = inicio;
				}

				inicio = fin + 1;
			} else {
				inicio = MAX;
			}
		}
		imprimir_arreglo_secuencias_int(arr);
	}

	public static void corrimiento_izq(int[] arr, int inicio) {
		while (inicio < MAX - 1) {
			arr[inicio] = arr[inicio + 1];
			inicio++;
		}
	}

	private static int obtener_fin(int[] arr, int pos) {
		while (pos < MAX && arr[pos] != 0) {
			pos++;
		}
		return pos;
	}

	private static int obtener_inicio(int[] arr, int pos) {
		while (pos < MAX && arr[pos] == 0) {
			pos++;
		}
		return pos;
	}

	public static int obtener_numUser(int[] arr) {
		int numero = -1;
		while (numero < 0 || numero > MAX - 1) {
			try {
				System.out.println("Ingrese un numero: ");
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
