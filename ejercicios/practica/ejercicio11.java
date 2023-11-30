import java.util.Random;

/*Hacer un programa que dado el arreglo definido y precargado permita encontrar la
posición de inicio de la secuencia cuya suma de valores sea mayor.*/
public class ejercicio11 {
	public static int MAX = 10;
	public static int MINVALOR = 1;
	public static int MAXVALOR = 9;
	public static double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		int sumaMayorInicio = obtener_iniSumaMayor(arr);

		System.out.println("El inicio de la secuencia mayor es: " + sumaMayorInicio);
	}

	public static int obtener_iniSumaMayor(int[] arr) {
		int inicio = 0;
		int fin = -1;
		int suma;
		int sumaMayor = 0;
		int sumaMayorInicio = 0;
		while (inicio < MAX) {
			inicio = obtener_inicio(arr, fin + 1);
			if (inicio < MAX) {
				fin = obtener_fin(arr, inicio);
				suma = obtener_sumaMayor(arr, inicio, fin);
				if (suma > sumaMayor) {
					sumaMayor = suma;
					sumaMayorInicio = inicio;
				}
			}
		}
		return sumaMayorInicio;
	}

	private static int obtener_fin(int[] arr, int pos) {
		while (pos < MAX && arr[pos] != 0) {
			pos++;
		}
		return pos - 1;
	}

	public static int obtener_sumaMayor(int[] arr, int inicio, int fin) {
		int suma = 0;
		for (int pos = inicio; pos <= fin; pos++) {
			suma += arr[pos];
		}
		return suma;
	}

	public static int obtener_inicio(int[] arr, int pos) {
		while (pos < MAX && arr[pos] == 0) {
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
