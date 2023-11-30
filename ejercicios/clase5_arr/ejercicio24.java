
/*Se tiene un arreglo de enteros de tamaño 20 de secuencias de
números entre 1 y 9, separadas por 0. El arreglo está precargado,
y además empieza y termina con uno o más separadores 0. Hacer
un programa que permita obtener a través de métodos la posición
de inicio y la posición de fin de la secuencia ubicada a partir de
una posición entera ingresada por el usuario. Finalmente, si
existen imprima por pantalla ambas posiciones obtenidas*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio24 {
	public static final int MAX = 20;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 9;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		int numero = obtener_numeroUser(arr);
		int inicio = 0;
		int fin = -1;
		if (arr[numero] != 0) {
			inicio = obtener_inicio(arr, numero);
			if (inicio > 0) {
				fin = obtener_fin(arr, inicio);
				System.out.println("Apartir de la posicion: " + numero + " La posicion de inicio es: " + inicio
						+ " Y la posicion de fin es: " + fin);
			}
		} else {
			System.out.println("En la posicion: " + numero + " se encuentra un separador");
		}
	}

	public static int obtener_fin(int[] arr, int pos) {
		while (pos <= MAX && arr[pos] != 0) {
			pos++;
		}
		return pos - 1;
	}

	public static int obtener_inicio(int[] arr, int pos) {
		while (pos > 0 && arr[pos] != 0) {
			pos--;
		}
		return pos + 1;
	}

	public static int obtener_numeroUser(int[] arr) {
		int numero = -1;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		while (numero < 0 || numero > MAX - 1) {

			try {

				System.out.println("Ingrese una posicion entera");
				numero = Integer.valueOf(entrada.readLine());
			} catch (Exception exc) {
				System.out.println(exc);
			}
		}
		return numero;
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
