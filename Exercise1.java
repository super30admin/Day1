// Time Complexity : O(1)
// Space Complexity : 0(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : For the coitains I was faing null pointer when I was returning directly


// Your code here along with comments explaining your approach
class MyHashSet {

    int bucket;
    int bucketItems;
    Boolean[][] hashArray;
    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000;
        hashArray = new Boolean[this.bucket][];
    }
    
    int getBucketHash(int key) {
        return key % bucket;
    }

    int getBucketItemsHash(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucketHash = getBucketHash(key);
        int bukcetItemsHash = getBucketItemsHash(key);
        if(hashArray[bucketHash] == null) {
            if(bucketHash == 0) {
                hashArray[bucketHash] = new Boolean[bucketItems+1];
            }
            else {
            hashArray[bucketHash] = new Boolean[bucketItems];
            }
        }
        hashArray[bucketHash][bukcetItemsHash] = true;
    }
    
    public void remove(int key) {
        int bucketHash = getBucketHash(key);
        int bukcetItemsHash = getBucketItemsHash(key);
        if(hashArray[bucketHash] != null) {
            hashArray[bucketHash][bukcetItemsHash] = false;
        }
        
    }
    
    public boolean contains(int key) {
        int bucketHash = getBucketHash(key);
        int bukcetItemsHash = getBucketItemsHash(key);
        return  (hashArray[bucketHash] != null &&  hashArray[bucketHash][bukcetItemsHash] != null 
        && hashArray[bucketHash][bukcetItemsHash]);
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */