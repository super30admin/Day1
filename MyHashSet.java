// Time Complexity : add() : O(1), remove() : O(1), contains() : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, in add function to consider the edge scenario for 0th index

//Approach: Used double hashing method

class MyHashSet {

    int buckets; // Index of primary array
    int bucketItems; // Index of secondary array
    boolean[][] storage;

    public MyHashSet() {
        this.buckets = 1000; // Initialzing by taking sqrt of 10^6
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    // Calcualtes the hash for the primary array
    int getOuterHash(int key) {
        return key % buckets;
    }

    // Calcualtes the hash for the secondary array
    int getInnerHash(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = getOuterHash(key);
        int bucketItem = getInnerHash(key);

        if (storage[bucket] == null) {
            if (bucket == 0)
                storage[bucket] = new boolean[bucketItems + 1];
            else
                storage[bucket] = new boolean[bucketItems];
        }

        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getOuterHash(key);
        int bucketItem = getInnerHash(key);

        if (storage[bucket] != null)
            storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = getOuterHash(key);
        int bucketItem = getInnerHash(key);

        if (storage[bucket] == null)
            return false;
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