
/*Suponer que se tienen dos arreglos A y B de secuencias (de
caracteres separados por uno o más espacio) de tamaño MAX
(cada arreglo empieza y termina con uno o más caracteres
espacio). A y B están precargados y además se tienen los
siguientes métodos (existen y no se tienen que implementar):
a. un método que permite obtener el índice inicial de la
secuencia que más se repite de un arreglo de secuencias de
tamaño MAX (que empieza y termina con o más caracteres
espacios).
b. un método que retorna el índice inicial de la secuencia que
tiene más caracteres repetidos de un arreglo de secuencias
(de caracteres separados por uno o más caracteres espacio)
de tamaño MAX (que empieza y termina con espacio).
Se pide realizar un programa completo que (sin utilizar arreglos
auxiliares/extras a los mencionados):

_reemplace en A la secuencia que más se repite por la secuencia
de B con más caracteres repetidos (la separación previa entre las
secuencias de A debe mantenerse). Considerar poner un
separador al final del arreglo si se desplaza a derecha para
mantener consistencia en la terminación de la secuencia.
En caso de utilizar uno o más de los métodos preexistentes
mencionados en el enunciado definir el o los encabezados de los
mismos. No se requiere hacer métodos de carga e impresión de
arreglos.*/
//import java.util.Random;

public class ejercicio26 {
	public static final int MAX = 10;
	public static final double probabilidad_letra = 0.4;

	public static void main(String[] args) {
//		char[] arr = new char[MAX];
//		char[] arr2 = new char[MAX];
		char[] arr = { ' ', 'f', 'g', '4', ' ', 'g', '9', 'b', ' ', '1', 'h', ' ', 'j', 'k', ' ', 'y', 'u', 'l', 'i',
				' ' };
		char[] arr2 = { ' ', 'g', 'y', 'r', 'h', ' ', 'l', '0', 'h', '1', ' ', '4', 's', 'a', '5', ' ', 'n', 'm', 'p',
				' ' };
//		cargar_arreglo_aleatorio_secuencias_char(arr);
//		cargar_arreglo_aleatorio_secuencias_char(arr2);
		int iniA = indiceInicialSecMasRepetidaA(arr);
		int finA = obtener_fin(arr, iniA);
		int iniB = indiceInicialSecMasCaracteresRepetidosB(arr2);
		int finB = obtener_fin(arr2, iniB);
		remplazar_secuencias(arr, arr2, iniA, finA, iniB, finB);
		imprimir_arreglo_secuencias_char(arr);
	}

	public static void remplazar_secuencias(char[] arr, char[] arr2, int iniA, int finA, int iniB, int finB) {
		int tamA = finA - iniA + 1;
		int tamB = finB - iniB + 1;
		int difTam = tamA - tamB;
		if (difTam < 0) {
			difTam = -difTam;
			agrandarSecA(arr, iniA, difTam);
		} else if (difTam > 0) {
			achicarSecA(arr, iniA, difTam);
		}
		tamA = tamB;
		for (int i = 0; i < tamA; i++) {
			arr[iniA + i] = arr2[iniB + i];
		}
	}

	public static void achicarSecA(char[] arr, int pos, int difTam) {
		for (int i = 0; i < difTam; i++) {
			correr_izq(arr, pos);
		}
	}

	public static void correr_izq(char[] arr, int pos) {
		while (pos < MAX - 1) {
			arr[pos] = arr[pos + 1];
			pos++;
		}

	}

	public static void agrandarSecA(char[] arr, int iniA, int difTam) {
		for (int i = 0; i < difTam; i++) {
			correrDerecha(arr, iniA);
			arr[MAX - 1] = ' ';
		}

	}

	public static void correrDerecha(char[] arr, int pos) {
		for (int i = MAX - 1; i > pos; i++) {
			arr[i] = arr[i - 1];
		}

	}

	public static int obtener_fin(char[] arr, int pos) {
		while (pos < MAX && arr[pos] != ' ') {
			pos++;
		}
		return pos - 1;
	}

	// no se implementa, solo pongo un indice de ejemplo para probar
	public static int indiceInicialSecMasCaracteresRepetidosB(char[] b) {
		return 6;
	}

	// no se implementa, solo pongo un indice de ejemplo para probar
	public static int indiceInicialSecMasRepetidaA(char[] a) {
		return 5;
	}

	public static void imprimir_arreglo_secuencias_char(char[] arr) {
		System.out.print("Arreglo de secuencias char\n|");
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print(arr[pos] + "|");
		}
		System.out.print("\n");
	}

//	public static void cargar_arreglo_aleatorio_secuencias_char(char[] arr) {
//		Random r = new Random();
//		arr[0] = ' ';
//		arr[MAX - 1] = ' ';
//		for (int pos = 1; pos < MAX - 1; pos++) {
//			if (r.nextDouble() > probabilidad_letra) {
//				arr[pos] = (char) (r.nextInt(26) + 'a');
//			} else {
//				arr[pos] = ' ';
//			}
//		}
//	}
}
