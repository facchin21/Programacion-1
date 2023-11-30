import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Hacer un programa que dado un arreglo de enteros de tamaño 10 que se
encuentra precargado, solicite al usuario el ingreso de dos números
enteros (posiciones del arreglo) y ordene de forma creciente el arreglo
entre dos posiciones correspondientes a los números ingresados.*/
public class ejercicio9 {
	public static int MAX = 10;
	public static int MINVALOR = 1;
	public static int MAXVALOR = 9;
	public static double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int num1 = -1;
		int num2 = -1;
		while (num1 < 0 || num2 < 0 || num1 > MAX - 1 || num2 > MAX - 1) {
			try {
				System.out.println("Ingrese un numero: ");
				num1 = Integer.valueOf(entrada.readLine());
				System.out.println("Ingrese Otro numero: ");
				num2 = Integer.valueOf(entrada.readLine());
				ordenar_arreglo_entre_num1Ynum2(arr, num1, num2);
				imprimir_arreglo_secuencias_int(arr);
			} catch (Exception exc) {
				System.out.println(exc);
			}
		}
	}

	public static void ordenar_arreglo_entre_num1Ynum2(int[] arr, int num1, int num2) {
		if (num1 < num2) {
			ordenar_arreglo_burbujeo(arr, num1, num2);
		} else {
			ordenar_arreglo_burbujeo(arr, num1, num2);
		}

	}

	public static void ordenar_arreglo_burbujeo(int[] arr, int num1, int num2) {
		int temp;
		for (int i = 1; i < MAX; i++) {
			for (int j = num1; j < num2; j++) {
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
