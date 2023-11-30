import java.util.Random;

/*Hacer un programa que devuelva la posición de inicio y fin de la
secuencia de números distintos de ceros cuya suma del contenido
sea mayor.*/
public class Ejercicio16 {
	public static final int MAX = 20;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] Args) {
		int[] arr = new int[MAX];
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		int inicio = 0;
		int fin = -1;
		int auxSuma = 0;
		int iniAux = 0; int finAux = 0;
		while (inicio < MAX) {
			inicio = obtener_inicio_secuencia(arr, inicio);
			if (inicio < MAX - 1) {
				fin = obtener_fin_secuencia(arr, inicio);
				int suma = obtener_suma(arr, inicio, fin);
				if (suma > auxSuma) {
					auxSuma = suma;
					iniAux = inicio;
					finAux = fin;
				}
				inicio = fin + 1;
			} else {
				inicio = MAX;
			}
		}
		System.out.println("La suma mayor es de: "+auxSuma+" su inicio es en la posicion "+iniAux+" y termina en "+finAux);
	}

	private static int obtener_suma(int[] arr, int inicio, int fin) {
		int suma = 0;
		while (inicio <= fin) {
			suma += arr[inicio];
			inicio++;
		}
		return suma;
	}

	public static int obtener_inicio_secuencia(int[] arr,int pos) {
		while ((pos < MAX) && (arr[pos] == 0)) {
			pos++;
		}
		return pos;
	}

	public static int obtener_fin_secuencia(int[] arr, int pos) {
		while ((pos < MAX) && (arr[pos] != 0)) {
			pos++;
		}
		return pos - 1;
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
