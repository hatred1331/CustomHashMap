package CustomMap;

/**
 * Класс CustomHashMap.Node является узлом в классе CustomHashMap.NodeList, хранящий пару ключ-значение
 *
 * @param <K> тип ключа
 * @param <V> тип значения
 */

public class Node<K, V> {
    /**
     * Ключ узла
     */
    K key;

    /**
     * Значение узла
     */
    V value;

    /**
     * Следующий узел в списке
     */
    Node<K, V> next;

    /**
     * Предыдущий узел в списке
     */
    Node<K, V> prev;

    /**
     * Конструктор создает новый узел с заданным ключом и значением
     *
     * @param key   ключ узла
     * @param value значение узла
     */
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    /**
     * Возвращает ключ узла
     *
     * @return ключ
     */
    public K getKey() {
        return key;
    }

    /**
     * Устанавливает значение узла
     *
     * @param value новое значение
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Возвращает значение узла
     *
     * @return значение
     */
    public V getValue() {
        return value;
    }

    /**
     * Устанавливает следующий узел в списке
     *
     * @param next следующий узел
     */
    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    /**
     * Возвращает следующий узел в списке
     *
     * @return следующий узел
     */
    public Node<K, V> getNext() {
        return next;
    }

    /**
     * Устанавливает предыдущий узел в списке
     *
     * @param prev предыдущий узел
     */
    public void setPrev(Node<K, V> prev) {
        this.prev = prev;
    }

    /**
     * Возвращает предыдущий узел в списке
     *
     * @return предыдущий узел
     */
    public Node<K, V> getPrev() {
        return prev;
    }

    /**
     * Возвращает строковое представление узла
     *
     * @return строковое представление этого узла
     */
    @Override
    public String toString() {
        return "CustomHashMap.Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
