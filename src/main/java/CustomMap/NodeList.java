package CustomMap;

import java.util.Iterator;

/**
 * Класс CustomHashMap.NodeList - список, хранящий узлы CustomHashMap.Node с парами ключ-значение
 *
 * @param <K> тип ключа
 * @param <V> тип значения
 */
public class NodeList<K, V> implements Iterable<Node<K, V>> {

    /**
     * Голова списка
     */
    Node<K, V> head;

    /**
     * Хвост списка
     */
    Node<K, V> tail;


    private int size;

    /**
     * Создает новый пустой список
     */
    public NodeList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Добавляет новый узел в конец списка
     *
     * @param node узел, который нужно добавить
     */
    public void add(Node<K, V> node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;
    }

    /**
     * Добавляет новый узел в конец списка с заданным ключом и значением
     *
     * @param key   ключ нового узла
     * @param value значение нового узла
     */
    public void add(K key, V value) {
        Node<K, V> existingNode = get(key);
        if (existingNode!= null) {
            existingNode.setValue(value);
        } else {
            Node<K, V> node = new Node<>(key, value);
            add(node);
        }
    }

    /**
     * Возвращает узел с заданным ключом, или null, если такого узла не существует
     *
     * @param key ключ, который нужно найти
     * @return узел с заданным ключом, или null
     */
    public Node<K, V> get(K key) {
        Node<K, V> current = head;
        while (current!= null) {
            if (current.getKey().equals(key)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Удаляет узел с заданным ключом из списка и возвращает его
     *
     * @param key ключ узла, который нужно удалить
     * @return удаленный узел, или null, если такого узла не существует
     */
    public Node<K, V> remove(K key) {
        Node<K, V> current = head;
        Node<K, V> previous = null;
        while (current!= null) {
            if (current.getKey().equals(key)) {
                if (previous!= null) {
                    previous.setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
                if (current.getNext()!= null) {
                    current.getNext().setPrev(previous);
                } else {
                    tail = previous;
                }
                size--;
                return current;
            }
            previous = current;
            current = current.getNext();
        }
        return null;
    }

    /**
     * Возвращает голову списка
     *
     * @return голова списка
     */
    public Node<K, V> getHead(){
        return head;
    }

    /**
     * Возвращает хвост списка
     *
     * @return хвост списка
     */
    public Node<K, V> getTail(){
        return tail;
    }

    /**
     * Возвращает размер списка
     *
     * @return размер списка
     */
    public int size() {
        return size;
    }

    /**
     * Возвращает, является ли список пустым.
     *
     * @return true, если список пуст, false в противном случае
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Очищает список, удаляя все узлы.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Возвращает итератор над узлами в списке
     *
     * @return итератор над узлами в списке
     */
    @Override
    public Iterator<Node<K, V>> iterator() {
        return new NodeListIterator(this);
    }


}
