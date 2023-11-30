
/*Hacer un programa que dado un número N ingresado por el
usuario, elimine las secuencias de tamaño N de números distintos
de cero.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio19 {
	public static final int MAX = 20;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		eliminar_secuencias(arr);
		imprimir_arreglo_secuencias_int(arr);

	}

	public static void eliminar_secuencias(int[] arr) {
		int numero = obtener_numero_user(arr);
		int inicio = 0;
		int fin = -1;
		int tamanio = 0;
		while (inicio < MAX) {
			inicio = obtener_inicio(arr, inicio);
			if (inicio < MAX - 1) {
				fin = obtener_fin(arr, inicio);
				tamanio = fin - inicio + 1;
				if (numero == tamanio) {
					int num = 0;
					while (num <= numero) {
						corrimiento_izq(arr, inicio, fin);
						num++;
					}
				}
				inicio = obtener_inicio(arr, fin + 1);
			}
		}
	}


	public static int obtener_numero_user(int[] arr) {
		int numero = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Ingrese un numero: ");
			numero = Integer.valueOf(entrada.readLine());

		} catch (Exception exc) {
			System.out.println(exc);
		}
		return numero;
	}

	public static void corrimiento_izq(int[] arr, int inicio, int fin) {
		while (inicio <= fin) {
			arr[inicio] = arr[inicio + 1];
			inicio++;
		}
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
