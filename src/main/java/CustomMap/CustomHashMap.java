package CustomMap;

/**
 * Класс CustomHashMap.CustomHashMap - кастомная реализация хеш-таблицы (HashMap) для хранения пар ключ-значение
 *@param <K> тип ключей
 *@param <V> тип значений
 */
public class CustomHashMap<K, V> {
    private NodeList<K, V>[] buckets;
    private int capacity;
    private int size;
    private static final float LOAD_FACTOR = 0.7f;

    /**
     * Создает новый экземпляр карты с начальном емкостью 16.
     */
    public CustomHashMap() {
        this(16);
    }

    /**
     * Создает новый экземпляр CustomHashMap.CustomHashMap с указанной начальном емкостью
     *
     * @param initialCapacity начальная емкость карты
     */
    public CustomHashMap(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.buckets = new NodeList[initialCapacity];
        for (int i = 0; i < initialCapacity; i++) {
            buckets[i] = new NodeList<>();
        }
    }

    /**
     * Добавляет данные в CustomHashMap.CustomHashMap с заданным ключом и значением
     * Если CustomHashMap.CustomHashMap ранее содержал отображение для ключа, старое значение заменяется
     * @param key - ключ
     * @param value - значение
     */
    public void put(K key, V value) {
        if (size >= capacity * LOAD_FACTOR) {
            resize();
        }
        int index = hash(key);
        NodeList<K, V> bucket = buckets[index];
        Node<K, V> node = bucket.get(key);
        if (node!= null) {
            node.setValue(value);
        } else {
            Node<K, V> newNode = new Node<>(key, value);
            bucket.add(newNode);
            size++;
        }
    }

    /**
     * Возвращает значение, связанное с указанным ключом, или null, если CustomHashMap.CustomHashMap не содержит отображения для ключа
     * @param key ключ, значение которого нужно вернуть
     * @return значение, связанное с указанным ключом, или null, если CustomHashMap.CustomHashMap содержит отображения для ключа
     */
    public V get(K key) {
        int index = hash(key);
        NodeList<K, V> bucket = buckets[index];
        Node<K, V> node = bucket.get(key);
        return node!= null? node.getValue() : null;
    }

    /**
     * Удаляет отображение для указанного ключа из CustomHashMap.CustomHashMap если оно присутствует
     * @param key ключ, отображение которого нужно удалить
     * @return значение, которое было связано с указанным ключом, или null, если CustomHashMap.CustomHashMap не содержит отображения для ключа
     */
    public V remove(K key) {
        int index = hash(key);
        NodeList<K, V> bucket = buckets[index];
        Node<K, V> node = bucket.remove(key);
        if (node!= null) {
            size--;
            return node.getValue();
        }
        return null;
    }

    /**
     * Возвращает количество пар ключ-значение в CustomHashMap.CustomHashMap
     *
     * @return количество пар ключ-значение в CustomHashMap.CustomHashMap
     */
    public int size() {
        return size;
    }

    /**
     * Возвращает true, если CustomHashMap.CustomHashMap пустой
     *
     * @return true, если CustomHashMap.CustomHashMap пустой
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Удаляет все отображения из CustomHashMap
     */
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            buckets[i].clear();
        }
        size = 0;
    }
    /**
     * Возвращает размер CustomHashMap
     */
    public int getCapacity(){
        return capacity;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    private void resize() {
        capacity *= 2;
        NodeList<K, V>[] newBuckets = new NodeList[capacity];
        for (int i = 0; i < capacity; i++) {
            newBuckets[i] = new NodeList<>();
        }
        for (NodeList<K, V> bucket : buckets) {
            for (Node<K, V> node : bucket) {
                int newIndex = hash(node.getKey());
                newBuckets[newIndex].add(node);
            }
        }
        buckets = newBuckets;
    }

    private Node<K, V> getNode(NodeList<K, V> bucket, K key) {
        Node<K, V> current = bucket.getHead();
        while (current!= null) {
            if (current.getKey().equals(key)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
}
