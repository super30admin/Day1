// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {

    int buckets;
    int bucketItems;
    boolean storage[][];

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];    
    }
    
    int getBucket(int key){
        return key%buckets;
    }

    int getBucketItem(int key){
        return key/bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            if(bucket != 0){
                storage[bucket] = new boolean[bucketItems];
            }
            else{
                storage[bucket] = new boolean[bucketItems + 1];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            return;
        }
        int bucketItem = getBucketItem(key);
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            return false;
        }
        int bucketItem = getBucketItem(key);
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