/*Buscar un elemento en un arreglo de caracteres ya cargado de
tama�o 10 y mostrar la/s posici�n/es del elemento, en caso de no
estar indicarlo tambi�n.*/
import java.util.Random;
public class ejercicio4 {
	public static final int MAX = 10;
	public static final int MAXVALOR = 10;
	public static final int MINVALOR = 1;

	public static void main(String[] args) {
		char letra;
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
