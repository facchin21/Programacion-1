
/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y lo agregue al principio del arreglo
(posición 0). Para ello tendrá que realizar un corrimiento a derecha (se pierde el último valor
del arreglo) y colocar el numero en el arreglo en la posición indicada.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio4 {
	public static final int MAX = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		int numero = obtener_numero(arr);
		corrimiento_der(arr, numero);
		imprimir_arreglo_secuencias_int(arr);
	}

	public static void corrimiento_der(int[] arr, int numero) {
		for (int pos = MAX - 1; pos > 0; pos--) {
			arr[pos] = arr[pos - 1];
		}
		arr[0] = numero;
	}

	public static int obtener_numero(int[] arr) {
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
