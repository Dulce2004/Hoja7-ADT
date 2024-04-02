package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * En esta clase se representa un árbol binario de búsqueda (BST).
 *
 * @param <K> Tipo de la clave del nodo.
 * @param <V> Tipo del valor del nodo.
 */
class BinaryTree<K extends Comparable<K>, V> {
    Nodo<K, V> root;

    /**
     * Constructor para crear un árbol binario vacío 
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Método para realizar la asociación en el árbol
     *
     * @param association La asociación a insertar.
     */
    public void insertar(Association<K, V> association) {
        root = insertRecursive(root, association);
    }

    /**
     * Método para insertar una asociación en el árbol.
     *
     * @param root       El nodo raíz
     * @param association La asociación a insertar.
     * @return El nodo raíz actualizado 
     */
    private Nodo<K, V> insertRecursive(Nodo<K, V> root, Association<K, V> association) {
        if (root == null) {
            root = new Nodo<>(association);
            return root;
        }
        if (association.key.compareTo(root.data.key) < 0)
            root.left = insertRecursive(root.left, association);
        else if (association.key.compareTo(root.data.key) > 0)
            root.right = insertRecursive(root.right, association);
        return root;
    }

    /**
     * Método para realizar un recorrido en orden del árbol.
     */
    public void inorderTraversal() {
        inorderTraversalRecursive(root);
    }

    /**
     * Método recursivo para realizar un recorrido en orden del árbol.
     *
     * @param root El nodo raíz 
     */
    private void inorderTraversalRecursive(Nodo<K, V> root) {
        if (root != null) {
            inorderTraversalRecursive(root.left);
            System.out.println("(" + root.data.key + ", " + root.data.value + ")");
            inorderTraversalRecursive(root.right);
        }
    }

    /**
     * Método para buscar un valor con una clave en el arbol
     *
     * @param key La clave para buscar.
     * @return El valor asociado a la clave
     */
    public V search(K key) {
        return searchRecursive(root, key);
    }

    /**
     * Método recursivo para buscar un valor dado una clave en el árbol.
     *
     * @param root El nodo raíz 
     * @param key  La clave para buscar.
     * @return El valor asociado a la clave
     */
    private V searchRecursive(Nodo<K, V> root, K key) {
        if (root == null || root.data.key.equals(key))
            return root != null ? root.data.value : null;
        if (key.compareTo(root.data.key) < 0)
            return searchRecursive(root.left, key);
        else
            return searchRecursive(root.right, key);
    }

    /**
     * Método para construir el diccionario a partir del archivo de texto.
     *
     * @param filePath La ruta del archivo que contiene las asociaciones.
     * @return El diccionario construido.
     */
    public static BinaryTree<String, String> buildDictionary(String filePath) {
        BinaryTree<String, String> dictionary = new BinaryTree<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.substring(1, line.length() - 1).split(", ");
                String key = parts[0].trim();
                String value = parts[1].trim();
                Association<String, String> association = new Association<>(key, value);
                dictionary.insertar(association);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    /**
     * Método estático para traducir el texto utilizando en el diccionario.
     *
     * @param inputFilePath La ruta del archivo de texto que se va a traducir.
     * @param dictionary    El diccionario utilizado para la traducción.
     * @return El texto traducido.
     */
    public static String translateText(String inputFilePath, BinaryTree<String, String> dictionary) {
        StringBuilder translatedText = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String[] parts = word.split("(?<=\\p{Punct})|(?=\\p{Punct})");
                    for (String part : parts) {
                        if (part.matches("\\p{Punct}")) {
                            translatedText.append(part);
                        } else {
                            String translatedPart = dictionary.search(part.toLowerCase());
                            if (translatedPart != null)
                                translatedText.append(translatedPart).append(" ");
                            else
                                translatedText.append("*").append(part).append("* ");
                        }
                    }
                    translatedText.append(" ");
                }
                translatedText.append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return translatedText.toString().trim();
    }
}