package uvg.edu.gt;

/**
 * En esta clase se representa un nodo en un árbol binario.
 *
 * @param <K> Tipo de la clave del nodo.
 * @param <V> Tipo del valor del nodo.
 */
public class Nodo<K extends Comparable<K>, V> {
    Association<K, V> data;
    Nodo<K, V> left, right;

    /**
     * El constructor que crea un nuevo nodo con la asociación de los datos que se encuentran especificados.
     *
     * @param data La asociación de datos para el nodo.
     */
    public Nodo(Association<K, V> data) {
        this.data = data;
        left = right = null;
    }
}