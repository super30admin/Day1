// Time Complexity :O(1)
// Space Complexity :2O(n) ~ O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach

class MyHashSet {
    int bucket;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[bucket][];// not to initialize it.
    }
    //O(1)
    public int getBucket(int key){
        return key % bucket;
    }
    //O(1)
    public int getBucketItem(int key){
        return key / bucketItems;
    }
    //O(1)
    public void add(int key) {
          int bkt = getBucket(key);
         int item = getBucketItem(key);

        if(storage[bkt] == null){
            if(bkt == 0){
                 storage[bkt] =  new boolean[bucketItems + 1];
            }else{
                storage[bkt] =  new boolean[bucketItems];
            }           
        }
        storage[bkt][item] = true;

        
    }
    //O(1)
    public void remove(int key) {
         int bkt = getBucket(key);
         int item = getBucketItem(key);

         if(storage[bkt] == null){
            return;
        }else{
            storage[bkt][item] = false;
        }        
    }
    //O(1)
    public boolean contains(int key) {
         int bkt = getBucket(key);
         int item = getBucketItem(key);

         if(storage[bkt] == null){
            return false;
        }
        return storage[bkt][item];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */