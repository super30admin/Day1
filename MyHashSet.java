// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;
    public MyHashSet() {
        
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    int getBucket(int key){
        return key % buckets;
    }

    int getBucketItem(int key){
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        //if the bucket is null, then create a new bucket
        if(storage[bucket] == null){
            //if the bucket is 0, then create a bucket of size bucketItems + 1
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1];
            }
            else{
                //else create a bucket of size bucketItems
                storage[bucket] = new boolean[bucketItems];
            }
        }
        //add the key to the bucket by setting the value to true
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            return;
        }
        //remove the key from the bucket by setting it to false
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 */
/**
 * InnerMyHashSet
 */


