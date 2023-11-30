import java.util.Random;

/*Hacer un programa que elimine de un arreglo todas las
secuencias que tienen orden descendente entre sus elementos.*/
public class ejercicio21 {
	public static final int MAX = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
//		int[] arr = new int[MAX];
		int[] arr = { 0, 3, 2, 0, 1, 2, 0, 3, 2, 1 };
		int inicio = 0;
		int fin = 0;
//		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		while (inicio < MAX) {
			inicio = obtener_inicio(arr, inicio);
			if (inicio <= MAX - 1) {
				fin = obtener_fin(arr, inicio);
				if (contiene_orden_decreciente(arr, inicio, fin)) {
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

	public static void corrimiento_izq(int[] arr, int pos) {
		while (pos <= MAX - 1) {
			arr[pos] = arr[pos + 1];
			pos++;
		}
		arr[MAX - 1] = 0;
	}

	public static boolean contiene_orden_decreciente(int[] arr, int inicio, int fin) {
		while ((inicio <= fin) && (arr[inicio] < arr[inicio + 1])) {
			inicio++;
			if (inicio == fin) {
				return true;
			}
		}
		return false;
	}

	public static int obtener_fin(int[] arr, int pos) {
		while ((pos <= MAX) && (arr[pos] != 0)) {
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
