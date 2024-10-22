// java function to design Hashset
// Time Complexity - O(1)
//Space Complexity - worst case  O(BucketSize * Size)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  Implemented using linked list before but then realised not to use any built in Data Structures

class MyHashSet {
    // Size of primary array
    private final int primaryStorage = 1000;
    // Secondary array size to handle collisions
    private final int secondaryStorage = 1001;
    // 2D boolean array
    private boolean[][] bucket;

    // Constructor to initialize the hash set
    public MyHashSet() {
        bucket = new boolean[primaryStorage][];
    }

    // Hash function to calculate index based on the key
    private int hash(int key) {
        return key % primaryStorage;
    }

    // Secondary index to handle collisions within a bucket
    private int pos(int key) {
        return key / primaryStorage;
    }

    // Add a key to the set
    public void add(int key) {
        int primaryIndex = hash(key);
        int secondaryIndex = pos(key);
        // Initialize the secondary array if it hasn't been initialized
        if (bucket[primaryIndex] == null) {
            bucket[primaryIndex] = new boolean[secondaryStorage];
        }
        // Mark the value as present
        bucket[primaryIndex][secondaryIndex] = true;
    }

    // Remove a key from the set
    public void remove(int key) {
        int primaryIndex = hash(key);
        int secondaryIndex = pos(key);
        // Check if the bucket exists before attempting to remove
        if (bucket[primaryIndex] != null) {
            bucket[primaryIndex][secondaryIndex] = false;
        }
    }

    // Check if the set contains a key
    public boolean contains(int key) {
        int primaryIndex = hash(key);
        int secondaryIndex = pos(key);
        // Check if the bucket exists and if the key is marked as present
        return bucket[primaryIndex] != null && bucket[primaryIndex][secondaryIndex];
    }

    // Main method for testing
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1)); // Output: true
        System.out.println(hashSet.contains(3)); // Output: false
        hashSet.add(2);
        System.out.println(hashSet.contains(2)); // Output: true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2)); // Output: false
    }
}
