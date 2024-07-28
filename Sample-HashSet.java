// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

class MyHashSet {
    boolean storage[][];
    int bucket;
    int bucketItem;
    public MyHashSet() {
        bucket = 1000;
        bucketItem = 1000;
        storage = new boolean [bucket][];
    }
    
    int primaryHash(int key){
        return key % 1000;
    }

    int bucketItem(int key){
        return key / 1000;
    }

    public void add(int key) {
        int bucket = primaryHash(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[this.bucket + 1];
            }else{
                storage[bucket] = new boolean[this.bucket];
            }
        }
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = primaryHash(key);
        if(storage[bucket] == null) return;

        int bucketItem = bucketItem(key);
        storage[bucket][bucketItem] = false;

    }
    
    public boolean contains(int key) {
        int bucket = primaryHash(key);
        if(storage[bucket] == null) return false;

        int bucketItem = bucketItem(key);
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