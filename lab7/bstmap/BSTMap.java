package bstmap;
import java.util.Iterator;
import java.util.Set;


public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V> {

    private Node root;
    private int size = 0;

    private class Node {
        public K key;
        public V val;
        public Node left;
        public Node right;
        public Node(K k, V v) {
            key = k;
            val = v;
        }

    }
    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    @Override
    public boolean containsKey(K key) {
        return containsKey(root,key);
    }
    private boolean containsKey(Node node, K key) {
        if (node == null) {
            return false;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return containsKey(node.left, key);
        }
        else if (cmp > 0) {
            return containsKey(node.right, key);
        }
        return true;
    }
    @Override
    public V get(K key) {
        return get(root,key);
    }
    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        }
        else if (cmp > 0) {
            return get(node.right, key);
        }
        return node.val;
    }
    @Override
    public int size() {
        return this.size;
    }
    @Override
    public void put(K key, V value) {
        root = put(root,key,value);
        size += 1;
    }
    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);

        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        }
        else if (cmp > 0) {
            node.right = put(node.right, key, value);
        }
        else {
            node.val = value;
        }
        return node;
    }
    @Override
    public Set<K> keySet(){
        throw new UnsupportedOperationException("Unsupported");
    }
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("Unsupported");
    }
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("Unsupported");
    }
    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("Unsupported");
    }

    public void printInOrder() {
        printInOrder(root);
    }
    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.key.toString() + "->"+ node.val.toString() + '\n');
        printInOrder(node.right);
    }
}
