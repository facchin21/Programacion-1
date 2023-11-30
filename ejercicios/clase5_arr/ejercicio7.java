import java.util.Random;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/*Implementar un método que realice un corrimiento a derecha en
un arreglo ordenado de tamaño MAX=10 a partir de una posición.*/
public class ejercicio7 {
	public static final int MAX = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		int numero;
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Ingrese un numero de posicion: ");
			numero = Integer.valueOf(entrada.readLine());
			cargar_arreglo_aleatorio_int(arr);
			burbujeo(arr);
			imprimir_arreglo_int(arr);
			corrimiento_der(arr, numero);
			imprimir_arreglo_int(arr);
		} catch (Exception exc) {
			System.out.println(exc);
		}
	}

	public static void corrimiento_der(int[] arr, int pos_user) {
		int pos = MAX - 1;
		while(pos >pos_user) {
			arr[pos] = arr[pos -1];
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

	public static void cargar_arreglo_aleatorio_int(int[] arr) {
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
