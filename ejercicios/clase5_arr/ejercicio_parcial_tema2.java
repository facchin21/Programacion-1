
/*
Tema 2: Se tiene un arreglo A de secuencias de enteros y un arreglo B de enteros ordenado ascendente. Cada secuencia de A tiene números primos (solo divisible por 1 y por sí mismo) 
o múltiplos de 5. 
Además se tiene el siguiente método pre-existente: _un método que permite obtener el índice inicial de la secuencia con menor cantidad de números múltiplos de un valor dado
 para un arreglo de secuencias.
Se pide realizar el programa y los métodos que permitan agregar en B (manteniendo su orden) los números primos de la secuencia de A con menor cantidad de números múltiplos de 5.
Observaciones: _los arreglos son de tamaño MAX y están precargados,
_las secuencias están separadas por uno o más ceros, empiezan y terminan con uno o más ceros,
_definir el encabezado del método pre-existente (no hay que implementarlo),
_no realizar métodos de carga e impresión de arreglos ni utilizar arreglos auxiliares.
 */

public class ejercicio_parcial_tema2 {

	static final int MAX = 10;
	static final int cte5 = 5;

    public static void main(String[] args) {
    	int[] A = new int[MAX];
    	int[] B = new int[MAX];
    	int inicio = indice_inicial_sec_multiplos(A, cte5);
    	int fin = indice_final_sec(A, inicio);
    	agregar_primos_arreglo(A, B, inicio, fin);
    }
    //preexistente
    public static int indice_inicial_sec_multiplos(int[] arr, int valor){
        return 1;//no es necesario poner valor
    }
    //practico 7 ejercicio 10
    public static int indice_final_sec(int[] arr, int pos){
    	while ((pos<MAX)&&(arr[pos]!=0)){
    		pos++;
    	}
    	return pos;

    }
    //Practico 7 ejercicio 7
    public static void corrimiento_der(int[] arr, int pos){
    	int i = MAX-1;
    	while (i>pos){
    		arr[i] = arr[i-1];
    		i--;
    	}
    }
    //Practico 7 ejemplo 6
    public static int obt_pos_valor_ord(int[] arr, int inicio, int fin, int valor){
    	while ((inicio<fin)&&(arr[inicio]<valor)){
    		inicio++;
    	}
    	return inicio;
    }
    //Practico 7 ejercicio 7
    public static void agregar_primos_arreglo(int[] Arr, int[] B, int inicio, int fin){
    	int pos = 0;
    	while (inicio<fin){
    		if (Arr[pos]%cte5!=0){
    			pos = obt_pos_valor_ord(B,inicio,fin,Arr[pos]);
    			if (pos<fin){
    				corrimiento_der(B,pos);
    				B[pos] = Arr[pos];						
    			}
    		}
    		inicio++;
    	}
    }
}