
/*Hacer un programa que dado un arreglo de enteros de tamaño 10
que se encuentra cargado, solicite al usuario un número entero y
lo agregue al principio del arreglo (posición 0). Para ello tendrá
que realizar un corrimiento a derecha (se pierde el último valor del
arreglo) y colocar el número en el arreglo en la posición indicada.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio9 {
	public static final int MAX = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int numero;
		int[] arr = new int[MAX];
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Ingrese un numero posicion: ");
			numero = Integer.valueOf(entrada.readLine());
			cargar_arreglo_int(arr);
			burbujeo(arr);
			imprimir_arreglo_int(arr);
			insertar_num(arr, numero);
			imprimir_arreglo_int(arr);

		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void insertar_num(int[] arr, int numero) {
		for (int pos = 0; pos < MAX; pos++) {
			corrimiento_der(arr, numero);
			arr[0] = numero;
		}
	}

	public static void corrimiento_der(int[] arr, int pos_user) {
		int pos = MAX - 1;
		while (pos > pos_user) {
			arr[pos] = arr[pos - 1];
			pos--;
		}
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
