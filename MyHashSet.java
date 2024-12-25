// Time Complexity : O(1) for all operations add, remove, contains
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach:
class MyHashSet {
    // Declaring the outer array size
    int buckets;
    // Declaring the inner array size
    int bucketItems;
    // Declaring the 2D array for our keys
    boolean[][] storage;

    public MyHashSet() {
        // Setting the buckets value 1000 because taking the square root of 10^6
        this.buckets = 1000;
        // Setting the bucketItems value 1000 because taking the square root of 10^6
        this.bucketItems = 1000;
        // Assigning the space 1000 only to outer array
        storage = new boolean[this.buckets][];
    }

    // First hash function that will perform mod operation with the key
    int getBucket(int key) {
        // performing mod
        return key % this.buckets;
    }

    /*
     * Second hash function that will perform division operation with the key and
     * return integer value
     */
    int getBucketItem(int key) {
        // performing division
        return key / this.bucketItems;
    }

    public void add(int key) {
        // Getting the 2D array indexes using the hash functions declared
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        // Checking if the inner array is not yet initialized then creating one
        if (storage[bucket] == null) {
            if (bucket == 0) {
                // Special case for input 10^6, because after performing hash operation we will
                // get index 1000 which is not present
                // So giving one extra space if the outer array index is 0
                storage[bucket] = new boolean[this.bucketItems + 1];
            } else {
                // Else initializing with normal bucketItems size (0 to 999)
                storage[bucket] = new boolean[this.bucketItems];
            }
        }
        /*
         * Instead of setting the actual key value,
         * setting the value to true at indexes
         * where key is to be added
         */
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        // Getting the 2D array indexes using the hash functions declared
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        // If the outer array itself is having null, that means key is not present
        if (storage[bucket] == null) {
            // Therefore doing nothing
            return;
        }
        /*
         * If outer array is not null, then setting the inner array value to be false to
         * remove the key
         */
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        // Getting the 2D array indexes using the hash functions declared
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        // If the outer array itself is having null, that means key is not present
        if (storage[bucket] == null) {
            // So returning false
            return false;
        }
        // If outer array is not null, then returning the inner array value
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
