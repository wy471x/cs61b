package lab9;

import java.util.*;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  @author Your name here
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    private static final int DEFAULT_SIZE = 16;
    private static final double MAX_LF = 0.75;

    private ArrayMap<K, V>[] buckets;
    private int size;

    private int loadFactor() {
        return size / buckets.length;
    }

    public MyHashMap() {
        buckets = new ArrayMap[DEFAULT_SIZE];
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        this.size = 0;
        for (int i = 0; i < this.buckets.length; i += 1) {
            this.buckets[i] = new ArrayMap<>();
        }
    }

    /** Computes the hash function of the given key. Consists of
     *  computing the hashcode, followed by modding by the number of buckets.
     *  To handle negative numbers properly, uses floorMod instead of %.
     */
    private int hash(K key) {
        if (key == null) {
            return 0;
        }

        int numBuckets = buckets.length;
        return Math.floorMod(key.hashCode(), numBuckets);
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return find(key, buckets[hash(key)]);
    }

    private V find(K k, ArrayMap<K, V> bin) {
        if (bin.containsKey(k)) {
            return bin.get(k);
        }
        return null;
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        // specified key if it not exists
        if (!buckets[hash(key)].containsKey(key)) {
            size++;
        }
        buckets[hash(key)].put(key, value);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for(ArrayMap bin : buckets) {
            Set<K> set = bin.keySet();
            for (K key : set) {
                keys.add(key);
            }
        }
        return keys;
    }

    /* Removes the mapping for the specified key from this map if exists.
     * Not required for this lab. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].containsKey(key)) {
                size--;
                return buckets[i].remove(key);
            }
        }
        return null;
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for this lab. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].containsKey(key)) {
                size--;
                return buckets[i].remove(key, value);
            }
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return new MyHashMapIterator<>();
    }

    private class MyHashMapIterator<K> implements Iterator<K> {

        int pointer;
        K[] keyArray;

        MyHashMapIterator() {
            pointer = 0;
            keyArray = (K[]) keySet().toArray();
        }

        @Override
        public boolean hasNext() {
            return pointer != size;
        }

        @Override
        public K next() {
            return keyArray[pointer++];
        }
    }
}
