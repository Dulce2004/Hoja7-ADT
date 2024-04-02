package uvg.edu.gt;


/**
 * Esta clase representa la asociación entre la clave y el valor.
 *
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor.
 */
class Association<K, V> {
    K key;
    V value;

    /**
     * Constructor de los parametros key y value.
     *
     * @param key   Clave de la asociación.
     * @param value Valor asociado a la clave.
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }
}