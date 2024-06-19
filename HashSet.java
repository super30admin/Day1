/*
Time Complexity :
add : O(1)
remove : O(1)
contains : O(1)
Space Complexity : 
worst case - O(buckets * bucketItems)
Did this code successfully run on Leetcode : yes
*/ 

class MyHashSet {
    private int buckets;
    private int bucketItems;
    private  boolean[][] storage;
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    int bucketHash(int key) {
        return key % buckets;
    }

    int bucketItemHash(int key) {
        return key / bucketItems;
    }
    
    public void add(int key) {
        int hash1 = bucketHash(key);
        int hash2 = bucketItemHash(key);
        if(storage[hash1] == null) {
            if(hash1 == 0) {
                storage[hash1] = new boolean[bucketItems + 1];
            } else {
                storage[hash1] = new boolean[bucketItems];
            }
        } 
        storage[hash1][hash2] = true;
    }
    
    public void remove(int key) {
        int hash1 = bucketHash(key);
        int hash2 = bucketItemHash(key);
        if(storage[hash1] == null) return;
        storage[hash1][hash2] = false;
    }
    
    public boolean contains(int key) {
        int hash1 = bucketHash(key);
        int hash2 = bucketItemHash(key);
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