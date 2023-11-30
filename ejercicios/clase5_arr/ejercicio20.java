
/*Hacer un programa que elimine de un arreglo todas las
ocurrencias de una secuencia patrón dada por otro arreglo.*/
//import java.util.Random;
import java.util.Random;
public class ejercicio20 {
	public static final int MAX = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
//		int[] arr = new int[MAX];
//		int[] patron = new int[MAX];
		int arr[] = { 0, 0, 30, 3, 0, 20, 0, 2, 10, 1 };
		int patron[] = { 0, 30, 3, 0, 0, 0, 0, 0, 0, 0 };
		int inicio = 0;
		int fin = -1;
//		cargar_arreglo_aleatorio_secuencias_int(arr);
//		cargar_arreglo_aleatorio_secuencias_int(patron);
//		imprimir_arreglo_secuencias_int(arr);
//		imprimir_arreglo_secuencias_int(patron);
		int iniPatron = obtener_inicio(patron, inicio);
		int finPatron = obtener_fin(patron, iniPatron);
		int tamanioPatron = finPatron - iniPatron + 1;
		while (inicio < MAX) {
			inicio = obtener_inicio(arr, inicio);
			if (inicio < MAX - 1) {
				fin = obtener_fin(arr, inicio);
				if ((fin - inicio + 1) == tamanioPatron) {
					if (contieneMismosElementos(arr, inicio, fin, patron, iniPatron, finPatron)) {
						for (int i = inicio; i<= fin; i++) {
							corrimiento_izq(arr, inicio);
						}
						fin = inicio;
					}
					inicio = fin + 1;
				} else {
					inicio = MAX;
				}
			}
		}
		imprimir_arreglo_secuencias_int(arr);

	}

	public static boolean contieneMismosElementos(int[] arr, int inicio, int fin, int[] patron, int iniPatron,
			int finPatron) {
		while ((inicio <= fin) && (arr[inicio] == patron[iniPatron])) {
			inicio++;
			iniPatron++;
			if (inicio > fin) {
				return true;
			}
		}
		return false;
	}

	public static void corrimiento_izq(int[] arr, int pos) {
		for (int i = pos; i < MAX - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[MAX - 1] = 0;
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

	public static void imprimir_arreglo_secuencias_int(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print("arr[" + pos + "]= " + arr[pos] + "\n");
		}
	}
}
