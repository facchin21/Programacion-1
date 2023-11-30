
/*Cargar un arreglo de tamaño 15, pidiendo el ingreso por teclado
de valores entre 1 y 12. Luego mostrar cómo quedó cargado.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio1 {
	public static final int MINVALOR = 1;
	public static final int MAXVALOR = 12;
	public static final int MAX = 15;
	public static final double probabilidad_numero = 0.4;

	public static void main(String[] args) {
		int numero;
		int arr[] = new int[MAX];
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		cargar_arreglo_aleatorio_secuencias_int(arr);
		imprimir_arreglo_secuencias_int(arr);
		try {
			System.out.println("Ingrese un numero del 1 al 12: ");
			numero = Integer.valueOf(entrada.readLine());
			if((numero >= MINVALOR)&&(numero<= MAXVALOR)){
				imprimir_arreglo_secuencias_int(arr);
			
			}else {
				System.out.println("Ingrese un numero del 1 al 12: ");
				numero = Integer.valueOf(entrada.readLine());
			}
			
		} catch (Exception exc) {
			System.out.println(exc);
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
