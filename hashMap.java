import java.util.LinkedList;

/*

In this implementation, the MyHashMap class has methods for put, get, remove, and containsKey operations.

The put method takes a key and a value as parameters. It calculates the index (bucket) based on the hash code of the key, and then checks if a linked list exists at that index. If not, it creates a new linked list. It then iterates through the linked list to check if the key already exists. If found, it updates the value; otherwise, it adds a new entry to the linked list.

The get method retrieves the value associated with the given key. It calculates the index, checks if a linked list exists at that index, and then iterates through the linked list to find the matching key and return its corresponding value.

The remove method removes the entry with the specified key. It calculates the index, checks if a linked list exists at that index, and then iterates through the linked list to find and remove the matching entry.

The containsKey method checks if the HashMap contains a specific key. It calculates the index, checks if a linked list

*/


public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;
    private int capacity;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
    }

    public void put(K key, V value) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);

        if (table[index] != null) {
            LinkedList<Entry<K, V>> bucket = table[index];

            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = hash(key);

        if (table[index] != null) {
            LinkedList<Entry<K, V>> bucket = table[index];

            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    bucket.remove(entry);
                    return;
                }
            }
        }
    }

    public boolean containsKey(K key) {
        int index = hash(key);

        if (table[index] != null) {
            LinkedList<Entry<K, V>> bucket = table[index];

            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    return true;
                }
            }
        }

        return false;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
	
	public static void main(String[] args) {
		MyHashMap<String, Integer> likesPerPost = new MyHashMap<String, Integer>();
		likesPerPost.put("Learning Hash Map", 5);
		System.out.println(likesPerPost.get("Learning Hash Map"));
	}
}
