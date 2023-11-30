import java.util.Random;

/*Hacer un programa que dado el arreglo definido y precargado permita encontrar la
posición de inicio de la anteúltima secuencia (considerar comenzar a buscarla a
partir de la ultima posición del arreglo).*/
public class ejercicio12 {
	public static int MAX = 10;
	public static int MINVALOR = 1;
	public static int MAXVALOR = 9;
	public static double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		int pos = MAX - 1;
		int inicio = 0;
		int tam = 0;
		int fin = -1;
		while (pos > 0 && tam < 2) {
			inicio = obtener_inicio(arr, pos);
			if (inicio > 0) {
				fin = obtener_fin(arr, inicio);
				tam++;
			}
			if (tam <= 2)
				pos = fin - 1;
		}
		System.out.println(inicio);

	}

	public static int obtener_fin(int[] arr, int pos) {
		while (pos > 0 && arr[pos] != 0) {
			pos--;
		}
		return pos + 1;
	}

	public static int obtener_inicio(int[] arr, int pos) {
		while (pos > 0 && arr[pos] == 0) {
			pos--;
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
