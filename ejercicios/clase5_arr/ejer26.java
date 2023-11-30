
public class ejer26 {

	final static int MAX = 20;

	public static void main(String[] args) {

		char[] A = { ' ', 'f', 'g', '4', ' ', 'g', '9', 'b', ' ', '1', 'h', ' ', 'j', 'k', ' ', 'y', 'u', 'l', 'i',
				' ' };
		char[] B = { ' ', 'g', 'y', 'r', 'h', ' ', 'l', '0', 'h', '1', ' ', '4', 's', 'a', '5', ' ', 'n', 'm', 'p',
				' ' };

		int iniMasRep = indiceInicialSecMasRepetidaA(A);
		int finMasRep = buscarFin(A, iniMasRep);
		int iniSecCaracRep = indiceInicialSecMasCaracteresRepetidosB(B);
		int finSecCaracRep = buscarFin(B, iniSecCaracRep);
		reemplazarSecuencias(A, iniMasRep, finMasRep, B, iniSecCaracRep, finSecCaracRep);
		mostrarArreglo(A);
	}

	public static void reemplazarSecuencias(char[] a, int iniMasRep, int finMasRep, char[] b, int iniSecCaracRep,
			int finSecCaracRep) {
		int tamA = finMasRep - iniMasRep + 1;
		int tamB = finSecCaracRep - iniSecCaracRep + 1;
		int difTam = tamA - tamB;
		if (difTam < 0) {
			// la sec de B es mas grande que la de A, debo hacer lugar o agrandar A
			difTam = -difTam; // hago el valor absoluto, sino se puede hacer con la raiz cuadrada del cuadrado
								// de difTam
			agrandarSecA(a, iniMasRep, difTam);
		} else if (difTam > 0) {
			// la sec de A es mas grande que la de B, debo achicar A
			achicarSecA(a, iniMasRep, difTam);
		}
		tamA = tamB; // porque ya quedaron emparejadas y la que importa es la de B que es la que se
						// copia en A
		// ya teniendo las secuencias emparejadas procedo a hacer el reemplazo
		for (int i = 0; i < tamA; i++) {
			a[iniMasRep + i] = b[iniSecCaracRep + i];
		}
	}

	public static void achicarSecA(char[] a, int iniMasRep, int difTam) {
		for (int i = 0; i < difTam; i++)
			correrIzquierda(a, iniMasRep);
	}

	public static void agrandarSecA(char[] a, int iniMasRep, int difTam) {
		for (int i = 0; i < difTam; i++)
			correrDerecha(a, iniMasRep);
		a[MAX - 1] = ' ';
	}

	// no se implementa, solo pongo un indice de ejemplo para probar
	public static int indiceInicialSecMasCaracteresRepetidosB(char[] b) {
		return 6;
	}

	// no se implementa, solo pongo un indice de ejemplo para probar
	public static int indiceInicialSecMasRepetidaA(char[] a) {
		return 5;
	}

	public static int buscarIni(char[] arr, int ini) {
		while (ini < MAX && arr[ini] == ' ')
			ini++;
		return ini;
	}

	public static int buscarFin(char[] arr, int ini) {
		while (ini < MAX && arr[ini] != ' ')
			ini++;
		return ini - 1;
	}

	public static void correrDerecha(char[] arr, int posicion) {
		int indice = MAX - 1;
		while (indice > posicion) {
			arr[indice] = arr[indice - 1];
			indice--;
		}
	}

	public static void correrIzquierda(char[] arr, int posicion) {
		while (posicion < MAX - 1) {
			arr[posicion] = arr[posicion + 1];
			posicion++;
		}
	}

	public static void mostrarArreglo(char[] arr) {
		for (int i = 0; i < MAX; i++)
			System.out.print(arr[i] + "|");
		System.out.println("");
	}
}