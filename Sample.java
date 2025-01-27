// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Implementing Hashset using double hashing strategy. Using %length and /length for hashing. Nesting the boolean array to handle
// the collisions. 

class MyHashSet {

    private boolean[][] storage;
    private int bucketSize;
    private int bucketItemsSize;

    private int bucketIndex(int key) {
        return key % bucketSize;
    }

    private int bucketItemIndex(int key) {
        return key / bucketItemsSize;
    }

    public MyHashSet() {
        this.bucketSize = 1000; // square root of possible inputs.
        this.bucketItemsSize = 1000;
        this.storage = new boolean[bucketSize][]; // the nested array is added only if required.
    }

    public void add(int key) {
        int bucket = bucketIndex(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItemsSize + 1];// handling the the collisions at 0th index.
            } else {
                storage[bucket] = new boolean[bucketItemsSize];
            }
        }
        int bucketItem = bucketItemIndex(key);
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = bucketIndex(key);
        if (storage[bucket] == null)
            return;
        int bucketItem = bucketItemIndex(key);
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = bucketIndex(key);
        if (storage[bucket] == null)
            return false;
        int bucketItem = bucketItemIndex(key);
        return storage[bucket][bucketItem];

    }
}
