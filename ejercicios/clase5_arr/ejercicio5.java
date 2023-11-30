import java.util.Random;

/*Hacer un programa que dado un arreglo de caracteres de tamaño
10 que se encuentra cargado, invierta el orden del contenido. Este
intercambio no se debe realizar de manera explícita, hay que
hacer un método que incluya una iteración de intercambio.*/
public class ejercicio5 {
	public static final int MAX = 10;

	public static void main(String[] args) {
		char[] arr = new char[MAX];
		cargar_arreglo_aleatorio_char(arr);
		imprimir_arreglo_char(arr);
	}
	
	public static void cargar_arreglo_aleatorio_char(char[] arr) {
		Random r = new Random();
		for (int pos = 0; pos < MAX; pos++) {
			arr[pos] = (char) (r.nextInt(26) + 'a');
		}
	}

	public static void imprimir_arreglo_char(char[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.println("nombre_arreglo[" + pos + "]=>: " + arr[pos]);
		}
	}

}
