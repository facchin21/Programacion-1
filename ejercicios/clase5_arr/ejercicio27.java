import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Hacer un programa que dado un arreglo ordenado creciente de
enteros de tamaño 10 que se encuentra precargado, solicite al
usuario un número entero y lo inserte en el arreglo manteniendo
su orden. Para ello tendrá que realizar un corrimiento a derecha
(se pierde el último valor del arreglo) y colocar el número en el
arreglo en la posición indicada.*/
public class ejercicio27 {
	public static final int MAX = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final double probabilidad_numero = 0.4;
	static final BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		burbujeo(arr);
		imprimir_arreglo_secuencias_int(arr);
		int numero = obtener_numUser(arr);
		int pos = obtener_pos(arr, numero);

		if (pos == MAX)
			pos = MAX - 1;
		correr_der(arr, pos, numero);

		System.out.println("Arreglo modificado");
		imprimir_arreglo_secuencias_int(arr);

	}

	public static int obtener_pos(int[] arr, int numero) {
		int pos = 0;
		while (pos < MAX && numero > arr[pos]) {
			pos++;
		}
		return pos;
	}

	public static void correr_der(int[] arr, int pos, int numero) {
		for (int i = MAX - 1; i > pos; i--) {
			arr[i] = arr[i - 1];
		}
		arr[pos] = numero;
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

	public static void burbujeo(int[] arr) {
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
