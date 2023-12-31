import java.util.LinkedList;

/*
In this implementation, the MyHashMap class has methods for put, get, remove, and containsKey operations.
*/


public class MyHashMap<K, V> {
	//The code defines a generic class MyHashMap<K, V>, where K represents the type of the keys and V represents the type of the values stored in the HashMap.
	
    private static final int DEFAULT_CAPACITY = 16;
	//The class has a static constant DEFAULT_CAPACITY set to 16, which is the default initial capacity of the HashMap.
	
    private LinkedList<Entry<K, V>>[] table;
	The class has an LinkedList table of type Entry<K, V>[] and an integer capacity to store the underlying data structure of the HashMap.
    private int capacity;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }


    /*
	The MyHashMap class has constructors to create instances of the HashMap. The default constructor sets the capacity to the default value and initializes the table array. The parameterized constructor allows specifying a custom capacity.
	*/
    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
    }

    /*
	
     The put method takes a key and a value as parameters. It calculates the index (bucket) based on the hash code of the key, and then checks if a linked list exists at that index. If not, it creates a new linked list. It then iterates through the linked list to check if the key already exists. If found, it updates the value; otherwise, it adds a new entry to the linked list.

	*/
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

    /*
	The get method retrieves the value associated with the given key. It calculates the index, checks if a linked list exists at that index, and then iterates through the linked list to find the matching key and return its corresponding value.
	*/
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


    /*
	 The remove method removes the entry with the specified key. It calculates the index, checks if a linked list exists at that index, and then iterates through the linked list to find and remove the matching entry.

	*/
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


    //The containsKey method checks if the HashMap contains a specific key. It calculates the index, checks if a linked li

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

     /*
	 The hash method calculates the hash code of a given key using the hashCode() method and applies the modulo operation with the capacity of the HashMap to ensure that the hash value is within the range of the underlying array.
	 */
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }


    /*
	The Entry class is a static nested class within MyHashMap. It represents each key-value pair stored in the HashMap. It has fields for key, value, and a reference to the next entry in case of a hash collision.
	*/
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
