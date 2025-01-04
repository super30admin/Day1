// Time Complexity: O(1)
// Space Complexity: O(n) where n is the number of items stored in the set.
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach: 
 * This a problem of Design a HashSet without using any built-in hash table libraries. Here I used 2D boolean array,
 * where the first dimension represents primary buckets and the second dimension represents items within each bucket.
 * The add(), remove(), and contains() methods use the modulo and division operations to determine the correct bucket 
 * and position for each key, allowing for fast and efficient storage and search.
 * 
 */ 
class MyHashSet {


    // Indexes in primary array
    private int bucket;
    // Indexes in secondary array
    private int bucketItems;
    // 2D array to store boolean values
    private boolean storage[][];

    // Constructor initializes the storage array
    public MyHashSet() {
        bucket = 1000;
        bucketItems = 1000;
        storage = new boolean[bucket][];
    }

    // Get the primary bucket index
    private int getBucket(int key) {
        return key % bucket;
    }

    // Get the index in the secondary array
    private int getBucketItem(int key) {
        return key / bucketItems;
    }
    
    // Adds the key to the set
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        if (storage[bucket] == null) {
            // initialize an array
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }

        storage[bucket][bucketItem] = true;
    }
    
    // Removes the key from the set
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        if (storage[bucket] == null) return;

        storage[bucket][bucketItem] = false;
    }
    
    // Checks if the key exists in the set
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        if (storage[bucket] == null) return false;

        return storage[bucket][bucketItem] == true;
    }
}