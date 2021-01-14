import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyHashMap<K extends Comparable<K>, V> implements Map61B<K, V>{

    private static int bucketSize = 16; // default
    private static double loadF = .75;  // default

    private ArrayList<V> bucket;    // holds all your keys


    public MyHashMap() {
        bucket = new ArrayList<>(bucketSize);
    }
    public MyHashMap(int initialSize) {
        bucketSize = initialSize;
        bucket = new ArrayList<>(bucketSize);
    }
    public MyHashMap(int initialSize, double loadFactor) {
        bucketSize = initialSize;
        bucket = new ArrayList<>(bucketSize);
        loadF = loadFactor;
    }

    @Override
    public void clear() {
        bucket.clear();
    }

    @Override
    public boolean containsKey(K key) {
        return bucket.contains(key);
    }

    @Override
    public V get(K key) {
//        return bucket.get(key);
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("This method is not implemented");
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("This method is not implemented");
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}