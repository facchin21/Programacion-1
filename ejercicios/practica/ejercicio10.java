import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Se tiene un arreglo de enteros de tamaño 20 de secuencias de números
entre 1 y 9, separadas por 0. El arreglo esta precargado, y además
empieza y termina con uno o más separadores 0. Hacer un programa que
permita obtener a través de métodos la posición de inicio y la posición de
fin de la secuencia ubicada a partir de una posición entera ingresada por
el usuario. Finalmente, si existen imprima por pantalla ambas posiciones
obtenidas.*/
public class ejercicio10 {
	public static int MAX = 20;
	public static int MINVALOR = 1;
	public static int MAXVALOR = 9;
	public static double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		int numero = obtener_numUser(arr);
		int inicio = 0;
		int fin = -1;
		if (numero != 0) {
			inicio = obtener_inicio(arr, numero);
			if (inicio > 0) {
				fin = obtener_fin(arr, inicio);
				System.out.println("Dada la posición " + numero + ", la secuencia que la contiene empieza en " + inicio
						+ " y finaliza en " + fin);
			} else {
				System.out.println("En la posición " + numero + " del arreglo hay un separador");
			}
		}
	}

	public static int obtener_fin(int[] arr, int pos) {
		while (pos < MAX && arr[pos] != 0) {
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

	public static int obtener_numUser(int[] arr) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int num = -1;
		while (num < 0 || num > MAX - 1) {
			try {
				System.out.println("Ingrese una posicion: ");
				num = Integer.valueOf(entrada.readLine());
			} catch (Exception exc) {
				System.out.println(exc);
			}
		}
		return num;
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
