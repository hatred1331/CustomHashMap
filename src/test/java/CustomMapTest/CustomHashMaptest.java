package CustomMapTest;

import CustomMap.CustomHashMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomHashMapTest {

    @Test
    public void testPutAndGet() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        assertEquals(1, (int) map.get("one"));
        assertEquals(2, (int) map.get("two"));
    }

    @Test
    public void testPutOverride() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("one", 2);
        assertEquals(2, (int) map.get("one"));
    }

    @Test
    public void testGetNull() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        assertNull(map.get("nonexistent"));
    }

    @Test
    public void testRemove() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        assertEquals(1, (int) map.remove("one"));
        assertNull(map.get("one"));
    }

    @Test
    public void testSize() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        assertEquals(2, map.size());
    }

    @Test
    public void testIsEmpty() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        assertTrue(map.isEmpty());
        map.put("one", 1);
        assertFalse(map.isEmpty());
    }

    @Test
    public void testClear() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.clear();
        assertTrue(map.isEmpty());
    }

    @Test
    public void testResize() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(4);
        for (int i = 0; i < 10; i++) {
            map.put("key" + i, i);
        }
        assertEquals(10, map.size());
    }

    @Test
    public void testHashCollision() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        assertEquals(1, (int) map.get("key1"));
        assertEquals(2, (int) map.get("key2"));
    }

    @Test
    public void manyElementsSize(){
        CustomHashMap<Integer, Integer> map = new CustomHashMap<>();
        for(Integer i = 0; i < 100; i++){
            map.put(i, i);
        }
        assertEquals(100, map.size());
        assertEquals(3, map.get(3));
    }
}
