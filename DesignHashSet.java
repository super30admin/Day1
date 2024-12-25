//Time Complexity of Operation Add,Remove,Contains: O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Using a 2D boolean array because we do not need to store the actual values, first array (bucket) used to get the hash to find the key.
// Second array(bucketItem) we get the hash to find out the key. Two hashing is used so collision doesn't happen. 
//Hashing : modulo followed by division.

public class DesignHashSet {
	
	int buckets;
    int bucketItems;
    boolean[][] storage;

	public void MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new boolean[this.buckets][];
    }
	//First Hashing
	int getBucket(int key) {
        return key % this.buckets;
    }
	//Second Hashing
    int secongetBucketItem(int key) {
        return key / this.bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = secongetBucketItem(key);
        if (storage[bucket] == null) {
            if(bucket == 0){ // this is done as a part of constraint 10^6,
                storage[bucket] = new boolean[this.bucketItems + 1];
            }else{
                storage[bucket] = new boolean[this.bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = secongetBucketItem(key);
        if (storage[bucket] == null) {
            return;
        }
        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = secongetBucketItem(key);
        if (storage[bucket] == null) {
            return false;
        }
        return storage[bucket][bucketItem];
    }
}
