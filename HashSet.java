// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class HashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;

    public HashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];    
    }

    int getBucket(int key) {
        return key % buckets;
    }

    int getBucketItem(int key) {
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
            // It wont work if key is 1000 as we have size as 1000
            if(bucket == 0) { // needs to be done only for 0th index
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
            return;
        } else {
            storage[bucket][bucketItem] = false;
        }
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null) {
            return false;
        } 
        return storage[bucket][bucketItem];
    }
}

