// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
    TC - O(1)
    SC - O(n) where n is size of the maximum upper limit
    Approach - I have used the boolean array with the maximum size mentioned in the problem
    and using the index as the key/element for the manipulation of add, remove and contains to return the result.
*/

class MyHashSet {

    int bucket;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000;
        storage = new boolean[bucket][];
    }

    public int getBucket(int key) {
        return (key % bucket);
    }

    public int getBucketItems(int key) {
        return (key / bucketItems);
    }

    public void add(int key) {
        int bucketKey = getBucket(key);
        int bucketItemsKey = getBucketItems(key);
        if(storage[bucketKey] == null) {
            if(bucketKey == 0) {
                storage[bucketKey] = new boolean[bucketItems + 1];
            } else {
                storage[bucketKey] = new boolean[bucketItems];
            }
        }
        storage[bucketKey][bucketItemsKey] = true;
    }

    public void remove(int key) {
        int bucketKey = getBucket(key);
        int bucketItemsKey = getBucketItems(key);
        if(storage[bucketKey] == null) {
            return;
        }
        storage[bucketKey][bucketItemsKey] = false;
    }

    public boolean contains(int key) {
        int bucketKey = getBucket(key);
        int bucketItemsKey = getBucketItems(key);
        if(storage[bucketKey] == null) {
            return false;
        }
        return storage[bucketKey][bucketItemsKey];
    }
}
