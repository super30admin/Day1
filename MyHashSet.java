// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Run time error Array.Index.Out.of.Bound


// Your code here along with comments explaining your approach
class MyHashSet {

    int bucket ;
    int bucketItems;
    boolean [][]storage;

    public MyHashSet() {
        this.bucket = 1000;  // initilizing the primary array with size 1000
        this.bucketItems = 1000; // initilizing the secondary array with size 1000
        storage = new boolean[bucket][]; // initilizing the primary array
    }

    public int getBucket(int key){
        // hashing to get the primary array Index
        return key % bucket;
    }

    public int getBucketItems(int key){
        // hashing to get the secondary array Index
        return  key / bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);

        // if primary array is null and index = 0 we need to initilize the secondary array with size bucketItems+1
        // for edge case like 10^6 else we need to initilize the secondary array with size bucketItems.
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[bucketItems + 1];
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        // make the perticular Index of secondary array true if add() is called.
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {

        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);

        // make the Index of secondary array false if remove() is called. If primary array is null return null.

        if(storage[bucket] == null){
            return ;
        }
        else{
            storage[bucket][bucketItem] = false;
        }

    }

    public boolean contains(int key) {

        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);

        // return the secondary array false if remove() is called. If primary array is null return null.

        if(storage[bucket] == null){
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