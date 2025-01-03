// Time Complexity : O(1)
// Space Complexity : O(10^6) ~ O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyHashSet {
    // Direct addressing. No collision so no collision resolution technique is used
    // using boolean to save space
    private boolean[][] storage;
    private int bucket;
    private int bucketItem;

    public MyHashSet() {
        bucket = 1000;    
        bucketItem = 1000;
        storage = new boolean[bucket][]; // imp fn - way of allocation
    }
    
    public void add(int key) { // O(1)
        // calculating hash value
        int hash1 = key % bucket;
        int hash2 = key / bucketItem;
        if(storage[hash1] == null) {
        // to handle the edge case of 1000000, as there are 1000001 items,[0-1000000],0<=key<= 10^6
            if(hash1 == 0) storage[hash1] = new boolean[bucketItem + 1];
            else storage[hash1] = new boolean[bucketItem];
        }
        storage[hash1][hash2] = true;
    }
    
    public void remove(int key) { // O(1)
        int hash1 = key % bucket;
        int hash2 = key / bucketItem;
        // since there is no array mapped to it, it means there is no value stored here
        if(storage[hash1] == null) return;
        storage[hash1][hash2] = false;
    }
    
    public boolean contains(int key) { // O(1)
        int hash1 = key % bucket;
        int hash2 = key / bucketItem;
        if(storage[hash1] == null) return false;
        return storage[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */