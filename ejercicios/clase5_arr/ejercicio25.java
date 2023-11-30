
/*Hacer un programa que dado el arreglo definido y precargado,
y un número entero ingresado por el usuario, copie de forma
continua las secuencias de tamaño igual al número ingresado en

otro arreglo de iguales características e inicializado con 0. La
copia en este último arreglo deben comenzar desde el principio
del mismo.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio25 {
	public static final int MAX = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 9;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		int[] arrCopia = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		int numero = obtener_numeroUser(arr);
		int inicio = 0;
		int fin = -1;
		int posCopia = 0;
		while (inicio < MAX) {
			inicio = obtener_inicio(arr, inicio);
			if (inicio < MAX) {
				fin = obtener_fin(arr, inicio);
				int tamanio = fin - inicio + 1;
				if (tamanio == numero) {
					copiarArreglo(arr, arrCopia, inicio, fin, posCopia);
					posCopia += numero;
				}
				inicio = fin + 1;
			}else {
				inicio = MAX;
			}
		}
		imprimir_arreglo_secuencias_int(arrCopia);
	}

	private static void copiarArreglo(int[] arr, int[] arrCopia, int inicio, int fin, int posCopia) {
		for (int i = inicio; i <= fin; i++) {
			arrCopia[posCopia] = arr[i];
			posCopia++;
		}

	}

	public static int obtener_fin(int[] arr, int pos) {
		while (pos < MAX && arr[pos] != 0) {
			pos++;
		}
		return pos - 1;
	}

	public static int obtener_inicio(int[] arr, int inicio) {
		while (inicio < MAX && arr[inicio] == 0) {
			inicio++;
		}
		return inicio;
	}

	public static int obtener_numeroUser(int[] arr) {
		int numero = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Ingrese un numero entero");
			numero = Integer.valueOf(entrada.readLine());
		} catch (Exception exc) {
			System.out.println(exc);
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
