// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        // Init hash set rows to null 
        storage = new boolean[buckets][];
    }
    
    // hash function to get place of row
    int getBucket(int key){
        return key%1000;
    }

   // hash function to get place of column
    int getBucketItem(int key){
        return key/1000;
    }

    //set bucketItem to true
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        // If no column is initiated, assign column for hashset
        if (storage[bucket] == null)
        {
            // For Max number 10^6, need one extra storage in 0th bucket
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems+1];
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }
        }

        storage[bucket][bucketItem] = true;
    }

    // Set bucketItem to false
    public void remove(int key) {
       int bucket = getBucket(key);
       int bucketItem = getBucketItem(key);
        
        if (storage[bucket] == null){
            return;
        }

        storage[bucket][bucketItem] = false;
    }

    // Return true if bucketItem present
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        
        if (storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketItem];
    }
}
