// Time Complexity : 0(1)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create 2 boolean arrays. Do mod to Primaty Array and div to Secondary Array. Edge Case -- While checking for index 0 in Primary array increase the seconday array size by 1 ie 1000 + 1

class MyHashSet {

    int buckets; //Primary Array
    int bucketItems; // Secndary Array
    boolean storage[][];

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
        
    }

// Adding to Primary Array
    private int getBucket(int key) {
        return key % buckets;
    }

// Adding to Secondary Array
    private int getBucketItem (int key) {
        return key / buckets;
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(storage[bucket]== null)
        {
            //If it is in index 0 increase the size of Secondary Array by total+ 1 == 1000 + 1
            if(bucket == 0)
            {
                storage[bucket] = new boolean[bucketItems + 1];
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    
    }
    
    public void remove(int key) {
       int bucket = getBucket(key);
       int bucketItem = getBucketItem(key);

    //  Checking if if I dont have any key in Primary Array
       if(storage[bucket] == null)
       {
         return;
       } 
       
         storage[bucket][bucketItem] = false;      
    }
    
    public boolean contains(int key) {
       int bucket = getBucket(key);
       int bucketItem = getBucketItem(key);

    //  Checking if if I dont have any key in Primary Array
       if(storage[bucket] == null)
       {
         return false;
       }

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
