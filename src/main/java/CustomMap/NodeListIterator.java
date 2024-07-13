package CustomMap;

import java.util.Iterator;
/**
 * Класс итератора для перебора узлов в списке
 */
public class NodeListIterator<K, V> implements Iterator<Node<K, V>> {

    private Node<K, V> current;


    private NodeList<K, V> list;

    /**
     * Создает новый итератор над заданным списком
     *
     * @param list список, над которым происходит итерация
     */
    public NodeListIterator(NodeList<K, V> list) {
        this.list = list;
        this.current = list.head;
    }

    /**
     *Возвращает true, если есть еще элементы для перебора, иначе false
     *@return true, если есть еще элементы, иначе false
     */
    @Override
    public boolean hasNext() {
        return current!= null;
    }

    /**
     *Возвращает следующий элемент в итерации
     *@return следующий элемент
     */
    @Override
    public Node<K, V> next() {
        Node<K, V> node = current;
        current = current.getNext();
        return node;
    }

    /**
     * *Бросает UnsupportedOperationException, потому что удаление не поддерживается.
     *@throws UnsupportedOperationException всегда
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
