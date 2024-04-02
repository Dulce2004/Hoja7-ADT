package uvg.edu.gt;
import static org.junit.Assert.*;
import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testInsertar() {
        BinaryTree<String, String> tree = new BinaryTree<>();
        Association<String, String> association1 = new Association<>("key1", "value1");
        Association<String, String> association2 = new Association<>("key2", "value2");
        
        // Insertar una asociación en el árbol
        tree.insertar(association1);
        
        // Verificar que el nodo raíz ahora contenga la asociación
        assertEquals("value1", tree.root.data.value);
        
        // Insertar otra asociación y verificar el árbol resultante
        tree.insertar(association2);
        assertEquals("value2", tree.root.right.data.value);
    }

    @Test
    public void testSearch() {
        BinaryTree<String, String> tree = new BinaryTree<>();
        Association<String, String> association1 = new Association<>("key1", "value1");
        Association<String, String> association2 = new Association<>("key2", "value2");
        
        // Insertar asociaciones en el árbol
        tree.insertar(association1);
        tree.insertar(association2);
        
        // Buscar una clave existente y verificar el valor asociado
        assertEquals("value1", tree.search("key1"));
        assertEquals("value2", tree.search("key2"));
        
        // Buscar una clave inexistente y verificar que devuelve null
        assertNull(tree.search("key3"));
    }
}
