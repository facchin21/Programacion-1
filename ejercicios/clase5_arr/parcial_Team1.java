/*
Tema 1: Se tiene un arreglo A de enteros ordenado ascendente, y un arreglo B de secuencias de enteros donde cada secuencia tiene múltiplos de 2 o múltiplos de 3 o números primos 
(solo divisible por 1 y por sí mismo). 
Además se tiene el siguiente método pre-existente: _un método que permite obtener el índice final de la secuencia con mayor cantidad de números primos de un arreglo de secuencias.
Se pide realizar el programa y los métodos que permitan eliminar de A los números primos de la secuencia de B con mayor cantidad de números primos.
Observaciones: _los arreglos son de tamaño MAX y están precargados,
_las secuencias están separadas por uno o más ceros, empiezan y terminan con uno o más ceros,
_definir el encabezado del método pre-existente (no hay que implementarlo),
_no realizar métodos de carga e impresión de arreglos ni utilizar arreglos auxiliares.
 */

public class parcial_Team1 {

	static final int MAX = 10;
	static final int cte2 = 2;
	static final int cte3 = 3;

	public static void main(String[] args) {
		int[] A = new int[MAX];
		int[] B = new int[MAX];
		int fin = indice_final_sec_primos(B);
		int inicio = indice_inicial_sec(B, fin);
		eliminar_primos_arreglo(A, B, inicio, fin);
	}

	// preexistente
	public static int indice_final_sec_primos(int[] arr) {
		return 1;// no es necesario poner valor
	}

	// Practico 7 ejercicio 12
	public static int indice_inicial_sec(int[] arr, int pos) {
		while ((pos > 0) && (arr[pos] != 0)) {
			pos--;
		}
		return pos + 1;
	}

	// Practico 7 ejercicio 8
	public static void corrimiento_izq(int[] arr, int pos) {
		while (pos < MAX - 1) {
			arr[pos] = arr[pos + 1];
			pos++;
		}
	}

	// Practico 7 ejemplo 6
	public static int obt_pos_valor_ord(int[] arr, int inicio, int fin, int valor) {
		while ((inicio < fin) && (arr[inicio] < valor)) {
			inicio++;
		}
		return inicio;
	}

	// Practico 7 ejercicio 8
	public static void eliminar_primos_arreglo(int[] A, int[] B, int inicio, int fin) {
		int pos = 0;
		while (inicio < fin) {
			if ((B[pos] % cte2 != 0) && (B[pos] % cte3 != 0)) {
				pos = obt_pos_valor_ord(A, inicio, fin, B[pos]);
				if ((pos < fin) && (A[pos] == B[pos])) {
					corrimiento_izq(A, pos);
				}
			}
			inicio++;
		}
	}

}


