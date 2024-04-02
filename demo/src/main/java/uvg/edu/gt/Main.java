//Dulce Ambrosio - 231143
//Hoja de trabajo #7
package uvg.edu.gt;


/**
 * Clase principal que contiene el método main para ejecutar el programa de traducción.
 */
public class Main {
    /**
     * Método principal que crea un diccionario, realiza la traducción.
     *
     * @param args Método main
     */
    public static void main(String[] args) {
        // Crea el diccionario a partir del archivo "diccionario.txt"
        BinaryTree<String, String> dictionary = BinaryTree.buildDictionary("diccionario.txt");

        // Imprime el diccionario ya ordenado
        System.out.println("Sorted Dictionary:");
        dictionary.inorderTraversal();

        // Realizar la traducción y lo imprime
        String inputText = "texto.txt";
        String translatedText = BinaryTree.translateText(inputText, dictionary);
        System.out.println("\nTexto Traducido:");
        System.out.println(translatedText);
    }
}