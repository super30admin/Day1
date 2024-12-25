// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
//we'll be usinng double hashing and for the constraints there is one hack which is taking square root.
class MyHashSet {
    int bucketSize; //bucket of arrays.
    int bucketItemSize; //bucket of items inside array of array.
    boolean[][] storage; // why boolean because no where we're returning the key stored.
    public MyHashSet() {
        bucketSize = 1000; //taking square root of the max constraint i.e 10^6.
        bucketItemSize = 1000;
        storage = new boolean[bucketSize][]; //we've not initalized the array of array so at each index value will be null.
    }

    //1st hashing will do %.
    private int getHashValueOfBucket(int key){
        return key % bucketSize;
    }
    //2nd hashing will do /.
    private int getHashValueOfBucketItem(int key){
        return key / bucketItemSize;
    }

    public void add(int key) {
        //To get which index of array we've to add the key.
        int bucket = getHashValueOfBucket(key);
        //It'll check if the internal array which is array of array is initialized or not.
        if(storage[bucket] == null){
            //why this because the constraints are <= 10^6 (= is the culprit here).
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItemSize+1];
            }
            else{
                storage[bucket] = new boolean[bucketItemSize];
            }
        }
        //which index of array of array we're going in.
        int bucketItem = getHashValueOfBucketItem(key);
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getHashValueOfBucket(key);
        if(storage[bucket] != null){
            int bucketItem = getHashValueOfBucketItem(key);
            storage[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = getHashValueOfBucket(key);
        if(storage[bucket] != null){
            int bucketItem = getHashValueOfBucketItem(key);
            return storage[bucket][bucketItem];
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */