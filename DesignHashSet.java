
// Time Complexity :o(1)
// Space Complexity :o(n) 
// Did this code successfully run on Leetcode : it runs good in leat code
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashSet {
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    private int bucket(int key) {
        return key % buckets;
    }

    private int bucketitems(int key) {
        return key / bucketItems;
    }

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    public void add(int key) {
        int bucket = bucket(key);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        int bucketItem = bucketitems(key);
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        if (storage[bucket] == null) return;
        int bucketItem = bucketitems(key);
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = bucket(key);
        if (storage[bucket] == null) return false;
        int bucketItem = bucketitems(key);
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