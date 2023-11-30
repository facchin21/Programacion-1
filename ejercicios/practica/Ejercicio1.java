/*Hacer un programa que dado un arreglo de enteros de tama�o 10 que se encuentra
precargado, invierta el orden del contenido (por ejemplo: el que est� en 0 se intercambia
con el que est� en 9, el que est� en 1 con el que est� en 8...). Este intercambio no se debe
realizar de manera expl�cita, hay que hacer un m�todo que incluya una iteraci�n de
intercambio.*/
public class Ejercicio1 {
	public static final int MAX = 10;

	public static void main(String[] args) {
		int[] arr = new int[MAX];
		cargar_arreglo(arr);
		imprimir_arreglo_int(arr);
		invertir_arreglo(arr);
		imprimir_arreglo_int(arr);

	}

	public static void invertir_arreglo(int[] arr) {
		int aux = 0;
		int posMayor = MAX - 1;
		int posMenor = 0;
		while (posMenor < posMayor) {
			aux = arr[posMenor];
			arr[posMenor] = arr[posMayor];
			arr[posMayor] = aux;
			posMenor++;
			posMayor--;
		}
	}

	public static void cargar_arreglo(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			arr[pos] = pos * 2;
		}
	}

	public static void imprimir_arreglo_int(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.println("nombre_arreglo[" + pos + "]=>: " + arr[pos]);
		}
	}
}
