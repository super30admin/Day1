// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Explanation: In this approach we are implementing double hashing - first has function is modulus and the second is by division. We are dividing the array size by
// keeping the primary array size to 1000 and each indiviual bucket as 1000
class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        this.buckets = 1000; // 10^3 primary array
        this.bucketItems = 1000; // 10^3 secondary arrays in each bucket
        storage = new boolean[buckets][]; // storage arrays, hashsets
    }

    int getBucket(int key) {
        return key % buckets; // returning bucket index
    }

    int getBucketItems(int key) {
        return key / bucketItems; // returning inner bucket index
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);

        if (storage[bucket] == null) {
            if(bucket == 0){ // edge case, what if we want to store 10^6
                storage[bucket] = new boolean[bucketItems + 1];
            }else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);

        if (storage[bucket] == null) {
            return;
        }

        storage[bucket][bucketItem] = false; // simply making it false where it was true.
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);

        if (storage[bucket] == null) {
            return false;
        }

        return storage[bucket][bucketItem];
    }
}