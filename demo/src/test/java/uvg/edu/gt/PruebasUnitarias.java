package uvg.edu.gt;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class PruebasUnitarias {

    @Test
    public void testInsertar() {
        BinaryTree<String, Integer> tree = new BinaryTree<>();
        Association<String, Integer> association = new Association<>("key", 123);
        tree.insertar(association);
        assertEquals(Integer.valueOf(123), tree.search("key"));
    }

    @Test
    public void testSearchExistingKey() {
        BinaryTree<String, Integer> tree = new BinaryTree<>();
        Association<String, Integer> association = new Association<>("key", 123);
        tree.insertar(association);
        assertEquals(Integer.valueOf(123), tree.search("key"));
    }

    @Test
    public void testSearchNonExistingKey() {
        BinaryTree<String, Integer> tree = new BinaryTree<>();
        assertNull(tree.search("nonexistent"));
    }

}
