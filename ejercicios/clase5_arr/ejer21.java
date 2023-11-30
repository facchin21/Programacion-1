/*
Hacer un programa que elimine de un arreglo todas las
secuencias que tienen orden descendente entre sus elementos.
 * */

public class ejer21 {

	
	final static int MAX = 10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = { 0, 3, 2, 0, 1, 2, 0, 3, 2, 1 };
		
		int ini = 0;
		int fin = -1;

		while (ini < MAX) {
			ini = iniSec(arr, ini);
			if (ini < MAX - 1) {
				fin = finSec(arr, ini);
				if(tieneOrdenDescendente(arr, ini, fin)) {
					for (int i = ini; i <= fin; i++) {
						correrIzq(arr, ini);
					}
					fin = ini;
				}
				ini = fin +1;
			}	
			else {
				ini = MAX;
			}
		}
		
		mostrar(arr);

	}
	
	private static boolean tieneOrdenDescendente(int[] arr, int ini, int fin) {
		
		while(ini < fin && arr[ini] > arr[ini + 1]) {
				ini++;
		}
		if(ini == fin) {
			return true;
		}
		return false;
		
	}

	private static void mostrar(int[] arr) {
		for (int i = 0; i < MAX; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public static void correrIzq(int arr[], int pos) {

		for (int i = pos; i < MAX - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[MAX - 1] = 0;
	}

	public static int finSec(int arr[], int pos) {
		while (pos < MAX && arr[pos] != 0) {
			pos++;
		}
		return pos - 1;
	}

	public static int iniSec(int arr[], int pos) {
		while (pos < MAX - 1 && arr[pos] == 0) {
			pos++;
		}
		return pos;
	}

}