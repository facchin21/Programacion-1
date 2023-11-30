
/*Tema 1: Se tiene un arreglo A de enteros ordenado ascendente, y un arreglo B de secuencias de enteros donde cada secuencia tiene múltiplos de 2 o múltiplos de 3 o números primos 
(solo divisible por 1 y por sí mismo). 
Además se tiene el siguiente método pre-existente: _un método que permite obtener el índice final de la secuencia con mayor cantidad de números primos de un arreglo de secuencias.
Se pide realizar el programa y los métodos que permitan eliminar de A los números primos de la secuencia de B con mayor cantidad de números primos.
Observaciones: _los arreglos son de tamaño MAX y están precargados,
_las secuencias están separadas por uno o más ceros, empiezan y terminan con uno o más ceros,
_definir el encabezado del método pre-existente (no hay que implementarlo),
_no realizar métodos de carga e impresión de arreglos ni utilizar arreglos auxiliares.
 */
//EL ARREGLO A TIENE NUMERO ENTEROS ORDENEDOS ASENDENTE
//EL ARREGLO B ES DE SECUENCIAS DE ENTEROS, MULTIPLES POR 2, 3 O NUMEROS PRIMOS. SOLO DIVISIBLE X SI MISMO
//YA TENEMOS EL METODO Q RETORNA EL FIN DE LA SECUENCIA CON MAYOR CANTIDAD DE NUM PRIMOS
//NECESITAMOS ELIMINAR(CORRIMIENTO IZQ), NUM PRIMOS DE LA SECUENCIA DE B CON MAYOR NUMS PRIMOS.
import java.util.Random;

public class parcialTema1 {
	public static final int MAX = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 9;
	public static final double probabilidad_numero = 0.4;
	public static final int Numprim2 = 2;
	public static final int Numprim3 = 3;

	public static void main(String[] args) {
		int[] arrA = new int[MAX];
		int[] arrB = new int[MAX];
		cargar_arreglo(arrA);
		burbujeo(arrA);
		cargar_arreglo_aleatorio_secuencias_int(arrB);
		imprimir_arreglo_secuencias_int(arrA);
		imprimir_arreglo_secuencias_int(arrB);
		eliminar_numPrimos_de_A(arrA, arrB);
	}

	public static void eliminar_numPrimos_de_A(int[] arrA, int[] arrB) {
		int inicio = 0;
		int fin = -1;
		while (inicio < MAX) {
			inicio = obtener_inicio(arrB, inicio);
			if (inicio < MAX) {
				fin = obtener_fin_secuenciaMayorCantPrimos(arrB, inicio);
				
			}
		}
	}

	public static int obtener_inicio(int[] arr, int pos) {
		while (pos <= MAX - 1 && arr[pos] == 0) {
			pos++;
		}
		return pos;
	}

	public static int obtener_fin_secuenciaMayorCantPrimos(int[] arr, int pos) {
		return 1;
	}

	public static void burbujeo(int[] arr) {
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

	public static void imprimir_arreglo_secuencias_int(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print("arr[" + pos + "]= " + arr[pos] + "\n");
		}
	}

	public static void cargar_arreglo(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			arr[pos] = pos * 2;
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
}
