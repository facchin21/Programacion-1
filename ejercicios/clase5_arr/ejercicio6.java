import java.util.Random;

/*Hacer un programa que dado un arreglo de enteros de tamaño 10
que se encuentra cargado, obtenga la cantidad de números pares
que tiene y la imprima.*/
public class ejercicio6 {
	public static final int MAX = 10;
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 10;
	public static void main(String[]args) {
		int []arr = new int[MAX];
		int suma;
		cargar_arreglo_aleatorio_int(arr);
		imprimir_arreglo_int(arr);
		suma = encontrar_num_pares(arr);
		System.out.println("La cantidad de numeros pares en el arreglo es de: "+suma);
	}
	public static int encontrar_num_pares(int []arr) {
		int suma = 0;
		for(int pos = 0; pos < MAX; pos++) {
			if(arr[pos] % 2 == 0) {
				suma++;
			}
		}
		return suma;
	}
	public static void cargar_arreglo_aleatorio_int(int[] arr) {
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++) {
			arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
		}
	}

	public static void imprimir_arreglo_int(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.println("nombre_arreglo[" + pos + "]=>: " + arr[pos]);
		}
	}
}
