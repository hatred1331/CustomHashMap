package CustomMapTest;

import CustomMap.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    public void testConstructor() {
        Node<String, Integer> node = new Node<>("key", 1);
        assertEquals("key", node.getKey());
        assertEquals(1, (int) node.getValue());
        assertNull(node.getNext());
        assertNull(node.getPrev());
    }

    @Test
    public void testSetGetValue() {
        Node<String, Integer> node = new Node<>("key", 1);
        node.setValue(2);
        assertEquals(2, (int) node.getValue());
    }

    @Test
    public void testSetGetNext() {
        Node<String, Integer> node1 = new Node<>("key1", 1);
        Node<String, Integer> node2 = new Node<>("key2", 2);
        node1.setNext(node2);
        assertEquals(node2, node1.getNext());
    }

    @Test
    public void testSetGetPrev() {
        Node<String, Integer> node1 = new Node<>("key1", 1);
        Node<String, Integer> node2 = new Node<>("key2", 2);
        node2.setPrev(node1);
        assertEquals(node1, node2.getPrev());
    }

    @Test
    public void testToString() {
        Node<String, Integer> node = new Node<>("key", 1);
        assertEquals("CustomHashMap.Node{key=key, value=1}", node.toString());
    }
}
