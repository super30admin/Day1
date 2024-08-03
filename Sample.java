import java.util.LinkedList;

class MyHashSet {

    private final int SIZE = 1000; // Define the size of the bucket array
    private final LinkedList<Integer>[] buckets;

    /** Initialize the data structure here. */
    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    /** Computes the hash value for a given key. */
    private int hash(int key) {
        return key % SIZE;
    }

    /** Add a key to the HashSet. */
    public void add(int key) {
        int hashValue = hash(key);
        LinkedList<Integer> bucket = buckets[hashValue];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    /** Remove a key from the HashSet. */
    public void remove(int key) {
        int hashValue = hash(key);
        LinkedList<Integer> bucket = buckets[hashValue];
        bucket.remove((Integer) key);
    }

    /** Returns true if the key exists in the HashSet, false otherwise. */
    public boolean contains(int key) {
        int hashValue = hash(key);
        LinkedList<Integer> bucket = buckets[hashValue];
        return bucket.contains(key);
    }
}

// Example usage:
public class Main {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);                          // set = [1]
        myHashSet.add(2);                          // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // returns true
        System.out.println(myHashSet.contains(3)); // returns false, (not found)
        myHashSet.add(2);                          // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // returns true
        myHashSet.remove(2);                       // set = [1]
        System.out.println(myHashSet.contains(2)); // returns false, (already removed)
    }
}
