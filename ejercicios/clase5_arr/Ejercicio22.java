import java.util.Random;

/*Hacer un programa que reemplace de un arreglo A todas las
ocurrencias de una secuencia patrón dada en un arreglo P, por la
secuencia contenida en el arreglo R de igual tamaño.*/
public class Ejercicio22 {
	public static final int MAX = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
//		Declaro arreglos
		int[] arr = new int[MAX];
		int[] patron = new int[MAX];
		int[] arrR = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		cargar_arreglo_aleatorio_secuencias_int(patron);
		cargar_arreglo_aleatorio_secuencias_int(arrR);
		imprimir_arreglo_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(patron);
		imprimir_arreglo_secuencias_int(arrR);
//		Declaro variables arreglo1
		int inicio = 0;
		int fin = 0;
//		Declaro variables arreglo2
		int ini_patron = obtener_inicio(patron, 0);
		int fin_patron = obtener_fin(patron, ini_patron);
		int tamanio_patron = fin_patron - ini_patron + 1;
//		Declaro variables extra y inicio arr3
		int tamanio = 0;
		int inicio_remplazo = obtener_inicio(arrR, 0);

		while (inicio < MAX) {
			inicio = obtener_inicio(arr, inicio);
			if (inicio < MAX) {
				fin = obtener_fin(arr, inicio);
				tamanio = fin - inicio + 1;
				if ((tamanio == tamanio_patron) && (cumple_patron(arr, inicio, fin, patron, ini_patron, fin_patron))) {
					for (int i = 0; i < tamanio; i++) {
						arr[inicio + 1] = arrR[inicio_remplazo + 1];
					}
					inicio = fin + 1;
				} else {
					inicio = MAX;
				}
			}
		}
		imprimir_arreglo_secuencias_int(arrR);
	}

	public static boolean cumple_patron(int[] arr, int inicio, int fin, int[] patron, int ini_patron, int fin_patron) {
		while (inicio <= fin && arr[inicio] == patron[ini_patron]) {
			inicio++;
			ini_patron++;
		}
		if (inicio > fin) {
			return true;
		}

		return false;

	}

	public static int obtener_fin(int[] arr, int pos) {
		while ((pos < MAX - 1) && (arr[pos] != 0)) {
			pos++;
		}
		return pos - 1;
	}

	public static int obtener_inicio(int[] arr, int pos) {
		while ((pos <= MAX) && (arr[pos] == 0)) {
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
