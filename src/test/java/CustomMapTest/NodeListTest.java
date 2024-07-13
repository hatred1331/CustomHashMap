package CustomMapTest;

import CustomMap.Node;
import CustomMap.NodeList;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
class NodeListTest {
    @Test
    public void testConstructor() {
        NodeList<String, Integer> list = new NodeList<>();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.size());
    }

    @Test
    public void testAdd() {
        NodeList<String, Integer> list = new NodeList<>();
        list.add("key1", 1);
        assertEquals(1, list.size());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
        assertEquals("key1", list.getHead().getKey());
        assertEquals(1, (int) list.getHead().getValue());

        list.add("key2", 2);
        assertEquals(2, list.size());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
        assertEquals("key1", list.getHead().getKey());
        assertEquals(1, (int) list.getHead().getValue());
        assertEquals("key2", list.getTail().getKey());
        assertEquals(2, (int) list.getTail().getValue());
    }

    @Test
    public void testGet() {
        NodeList<String, Integer> list = new NodeList<>();
        list.add("key1", 1);
        list.add("key2", 2);

        Node<String, Integer> node = list.get("key1");
        assertNotNull(node);
        assertEquals("key1", node.getKey());
        assertEquals(1, (int) node.getValue());

        node = list.get("key2");
        assertNotNull(node);
        assertEquals("key2", node.getKey());
        assertEquals(2, (int) node.getValue());

        node = list.get("nonexistent");
        assertNull(node);
    }

    @Test
    public void testRemove() {
        NodeList<String, Integer> list = new NodeList<>();
        list.add("key1", 1);
        list.add("key2", 2);

        Node<String, Integer> node = list.remove("key1");
        assertNotNull(node);
        assertEquals("key1", node.getKey());
        assertEquals(1, (int) node.getValue());
        assertEquals(1, list.size());

        node = list.remove("key2");
        assertNotNull(node);
        assertEquals("key2", node.getKey());
        assertEquals(2, (int) node.getValue());
        assertEquals(0, list.size());

        node = list.remove("nonexistent");
        assertNull(node);
    }

    @Test
    public void testClear() {
        NodeList<String, Integer> list = new NodeList<>();
        list.add("key1", 1);
        list.add("key2", 2);

        list.clear();
        assertEquals(0, list.size());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void testIsEmpty() {
        NodeList<String, Integer> list = new NodeList<>();
        assertTrue(list.isEmpty());

        list.add("key1", 1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testIterator() {
        NodeList<String, Integer> list = new NodeList<>();
        list.add("key1", 1);
        list.add("key2", 2);

        Iterator<Node<String, Integer>> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        Node<String, Integer> node = iterator.next();
        assertEquals("key1", node.getKey());
        assertEquals(1, (int) node.getValue());

        assertTrue(iterator.hasNext());
        node = iterator.next();
        assertEquals("key2", node.getKey());
        assertEquals(2, (int) node.getValue());

        assertFalse(iterator.hasNext());
    }
}
