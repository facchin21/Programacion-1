
/*Hacer un programa que dado un arreglo ordenado creciente de enteros
de tamaño 10 que se encuentra precargado, solicite al usuario un numero
entero y lo inserte en el arreglo manteniendo su orden. Para ello tendrá
que realizar un corrimiento a derecha (se pierde el último valor del arreglo)
y colocar el numero en el arreglo en la posición indicada.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio7 {
	public static int MAX = 10;
	public static int MINVALOR = 1;
	public static int MAXVALOR = 9;
	public static double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		ordenar_arreglo_burbujeo(arr);
		imprimir_arreglo_secuencias_int(arr);
		int numero = obtener_numeroUser(arr);
		insertar_numUser(arr, numero);
		imprimir_arreglo_secuencias_int(arr);
	}

	public static void insertar_numUser(int[] arr, int numero) {
		int pos = 0;
		while (numero > arr[pos] && pos < MAX - 1) {
			pos++;
		}
		corrimiento_der(arr, pos);
		arr[pos] = numero;
	}

	public static void corrimiento_der(int[] arr, int pos) {
		int indice = MAX - 1;
		while (indice < pos) {
			arr[indice] = arr[indice - 1];
			indice--;
		}
	}

	public static int obtener_numeroUser(int[] arr) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
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

	public static void ordenar_arreglo_burbujeo(int[] arr) {
		int temp;
		for (int i = 1; i < MAX; i++) {
			for (int j = 0; j < MAX - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
		}
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
