
/*Hacer un programa que invierta el orden de la última secuencia
en un arreglo.*/
//import java.util.Random;

public class ejercicio23 {
	public static final int MAX = 10;
//	public static final int MAXVALOR = 10;
//	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int arr[] = { 0, 2, 3, 0, 5, 0, 1, 2, 3, 0 };
//		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		int inicio = 0;
		int fin = -1;
		int pos = MAX - 1;
		int tamanio = 0;
		while ((pos > 0) && (tamanio < 1)) {
			inicio = obtener_inicio(arr, pos);
			if (inicio > 0) {
				fin = obtener_fin(arr, inicio);
				tamanio++;
				invertir_orden(arr, fin, inicio);
				if (tamanio <= 1)
					pos = fin - 1;
			}
		}
		imprimir_arreglo_secuencias_int(arr);
	}

	public static void invertir_orden(int[] arr, int inicio, int fin) {
		while (inicio < fin) {
			int aux = arr[inicio];
			arr[inicio] = arr[fin];
			arr[fin] = aux;
			inicio++;
			fin--;
		}
	}

	public static int obtener_fin(int[] arr, int pos) {
		while ((pos > 0) && (arr[pos] != 0)) {
			pos--;
		}
		return pos + 1;
	}

	public static int obtener_inicio(int[] arr, int pos) {
		while ((pos > 0) && (arr[pos] == 0)) {
			pos--;
		}
		return pos;
	}

//	public static void cargar_arreglo_aleatorio_secuencias_int(int[] arr) {
//		Random r = new Random();
//		arr[0] = 0;
//		arr[MAX - 1] = 0;
//		for (int pos = 1; pos < MAX - 1; pos++) {
//			if (r.nextDouble() > probabilidad_numero) {
//				arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
//			} else {
//				arr[pos] = 0;
//			}
//		}
//	}
//
	public static void imprimir_arreglo_secuencias_int(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print("arr[" + pos + "]= " + arr[pos] + "\n");
		}
	}
}
