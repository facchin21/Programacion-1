import java.util.Random;

/*Hacer un programa que cargue un arreglo (sin orden) de
tamaño MAX=10 con números enteros aleatorios entre 0 y 100.
Finalmente imprima por pantalla el arreglo ordenado. Hacerlo para
orden creciente y decreciente*/
public class ejercicio30 {
	public static final int MAX = 10;
	public static final int MINVALOR = 0;
	public static final int MAXVALOR = 100;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arrC = new int[MAX];
		int[] arrD = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arrC);
		cargar_arreglo_aleatorio_secuencias_int(arrD);
		imprimir_arreglo_secuencias_int(arrC);
		imprimir_arreglo_secuencias_int(arrD);
		burbujeoC(arrC);
		burbujeoD(arrD);
		System.out.println("Arreglo modificado");
		imprimir_arreglo_secuencias_int(arrC);
		System.out.println("Arreglo modificado");
		imprimir_arreglo_secuencias_int(arrD);
	}

	public static void burbujeoD(int[] arr) {
		int temp;
		for (int i = 1; i < MAX; i++) {
			for (int j = 0; j < MAX - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void burbujeoC(int[] arr) {
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
