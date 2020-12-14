import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;
    private int size;

    public void BSTMap() {
        root = null;
        size = 0;
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /* Returns true if this map contains a. mapping for the specified key */
    @Override
    public boolean containsKey(K key) {
        return containKeyH(key, root);
    }

    private boolean containKeyH(K key, Node inNode) {
        if (inNode == null) {
            return false;
        }
        int compResult = key.compareTo(inNode.key);
        if (compResult == 0) {
            return true;
        } else if (compResult < 0) {
            return containKeyH(key, inNode.left);
        }else {
            return containKeyH(key, inNode.right);
        }
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return getH(key, root);
    }

    /* helper method of get */
    private V getH(K key, Node inNode) {
        if (inNode == null) {
            return null;
        }
        int compResult = key.compareTo(inNode.key);
        if (compResult == 0) {
            return inNode.value;
        } else if (compResult < 0) {
            return getH(key, inNode.left);
        }else {
            return getH(key, inNode.right);
        }
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        root = putH(key, value, root);
    }

    /* Helper method for put*/
    private Node putH(K key, V value, Node inNode) {
        if (inNode == null) {
            size+=1;
            return new Node(key,value);
        }
        int compResult = key.compareTo(inNode.key);
        if (compResult < 0) {
            inNode.left = putH(key, value, inNode.left);
        }else if (compResult > 0){
            inNode.right = putH(key, value, inNode.right);
        }
        // compResult == 0
        inNode.value = value;
        return inNode;
    }

    /* prints out your BSTMap in order of increasing Key */
    public void printInOrder() {
        printInOrderH(root, "");
    }

    /* helper method for printInOrder */
    private void printInOrderH(Node inNode, String all) {
        if (inNode == null) {
            return;
        }
        System.out.println(all + " + " + inNode.key);
        printInOrderH(inNode.left , all + " ");
        printInOrderH(inNode.right , all + " ");
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("This method is not been implemented");
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("This method is not been implemented");
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("This method is not been implemented");
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("This method is not been implemented");
    }
}
