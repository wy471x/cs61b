package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author Your name here
 */
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

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (p == null) return null;
        int cmp = key.compareTo(p.key);
        if (cmp < 0) return getHelper(key, p.left);
        else if (cmp > 0) return getHelper(key, p.right);
        else return p.value;
    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return getHelper(key, root);
    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if (p == null) {
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(p.key);
        if (cmp < 0) p.left = putHelper(key, value, p.left);
        else if (cmp > 0) p.right = putHelper(key, value, p.right);
        else p.value = value;
        return p;
    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (value == null) {
            remove(key);
            return;
        }
        root = putHelper(key, value, root);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        getAllKey(root, keys);
        return keys;
    }

    private void getAllKey(Node node, Set<K> keys) {
        // base case
        if (node == null) return;

        keys.add(node.key);
        getAllKey(node.left, keys);
        getAllKey(node.right, keys);
    }

    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    @Override
    public V remove(K key) {
        return remove(key, root, null);
    }

    private V remove(K key, Node node, Node parent) {
        if (key == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) return remove(key, node.left, node);
        else if (cmp > 0) return remove(key, node.right, node);
        else {
            Node t = node;
            // case 1
            if (node.right == null && node.left != null) {
                if (parent == null) {
                    node.left = null;
                } else {
                    if (node.key.compareTo(parent.key) < 0) {
                        parent.left = node.left;
                    } else {
                        parent.right = node.left;
                    }
                }
            }
            // case 2
            else if (node.left == null && node.right != null) {
                if (parent == null) {
                    node.right = null;
                } else {
                    if (node.key.compareTo(parent.key) < 0) {
                        parent.left = node.right;
                    } else {
                        parent.right = node.right;
                    }
                }
            }
            // case 3
            else if (node.left != null && node.right != null){
                node = min(t.right);
                node.right = deleteMin(t.right);
                node.left = t.left;
            }
            // case 4
            else {
               node = null;
            }
            size--;
            return t.value;
        }
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.right == null) return node.left;
        node.right = deleteMin(node.right);
        return node;
    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        return remove(key, value, root, null);
    }

    private V remove(K key, V value, Node node, Node parent) {
        if (key == null) return null;

        if (value.equals(node.value)) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) return remove(key, value, node.left, node);
            else if (cmp > 0) return remove(key, value, node.right, node);
            else {
                Node t = node;
                // case 1
                if (node.right == null && node.left != null) {
                    if (parent == null) {
                        node.left = null;
                    } else {
                        if (node.key.compareTo(parent.key) < 0) {
                            parent.left = node.left;
                        } else {
                            parent.right = node.left;
                        }
                    }
                }
                // case 2
                else if (node.left == null && node.right != null) {
                    if (parent == null) {
                        node.right = null;
                    } else {
                        if (node.key.compareTo(parent.key) < 0) {
                            parent.left = node.right;
                        } else {
                            parent.right = node.right;
                        }
                    }
                }
                // case 3
                else if (node.right != null && node.left != null){
                    node = min(t.right);
                    node.right = deleteMin(t.right);
                    node.left = t.left;
                }
                // case 4
               else {
                    node = null;
                }
                size--;
                return t.value;
            }
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTMapIterator<>();
    }

    private class BSTMapIterator<K> implements Iterator<K> {
        int pointer;
        K[] keyArray;


        BSTMapIterator() {
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
