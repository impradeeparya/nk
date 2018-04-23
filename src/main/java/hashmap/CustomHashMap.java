package hashmap;

import java.util.Arrays;

public class CustomHashMap<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private Node[] nodes = new Node[DEFAULT_INITIAL_CAPACITY];


    public V put(K key, V value) {

        int hashCode = key.hashCode();

        Node node = nodes[hashCode % DEFAULT_INITIAL_CAPACITY];

        if (node == null) {
            nodes[hashCode % DEFAULT_INITIAL_CAPACITY] = new Node(key, value);
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(key, value);
        }

        return value;
    }

    public V get(K key) {
        Node<K, V> node = nodes[key.hashCode() % DEFAULT_INITIAL_CAPACITY];
        return node == null ? null : node.getValue();
    }

    class Node<K, V> {
        K key;
        V value;

        Node<K, V> next;

        Node() {
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CustomHashMap{" +
                "nodes=" + Arrays.toString(nodes) +
                '}';
    }
}
