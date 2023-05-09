/**
 * My hash table with String keys and values.
 */
public class MyHashTable {
    private static class Node {
        String key;
        String value;
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int TABLE_SIZE = 100;

    private Node[] table;
    private int size;

    /**
     * Constructor with a default table size of 100.
     */
    public MyHashTable() {
        table = new Node[TABLE_SIZE];
        size = 0;
    }

    /**
     * Return the value associated with the given key, or null if the key is not in
     * the table.
     *
     * @param key the key to look up
     * @return the value associated with the key, or null if the key is not in the
     *         table
     */
    public String get(String key) {
        int hash = hash(key);
        Node node = table[hash];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * Associate the given value with the given key in the table. If the key is
     * already in the table, the value is updated.
     *
     * @param key   the key to associate with the value
     * @param value the value to associate with the key
     */
    public void put(String key, String value) {
        int hash = hash(key);
        Node node = table[hash];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = table[hash];
        table[hash] = newNode;
        size++;
    }

    /**
     * Remove the key-value pair with the given key from the table, if it exists.
     *
     * @param key the key to remove
     */
    public void remove(String key) {
        int hash = hash(key);
        Node node = table[hash];
        Node prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    table[hash] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    /**
     * Return true if the table contains the given key, false otherwise.
     *
     * @param key the key to check for
     * @return true if the table contains the key, false otherwise
     */
    public boolean containsKey(String key) {
        int hash = hash(key);
        Node node = table[hash];
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * Return the number of key-value pairs in the table.
     *
     * @return the number of key-value pairs in the table
     */
    public int size() {
        return size;
    }

    /**
     * Use the hashCode() method of the String class to compute the hash code for
     * the key, and then take the absolute value of the hash code modulo the table
     * size to get the index in the table.
     *
     * @param key the key to hash
     * @return the integer value that represents the hash code for the key
     */
    private int hash(String key) {
        return Math.abs(key.hashCode() % TABLE_SIZE);
    }
}
