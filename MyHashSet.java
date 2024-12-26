// Time Complexity : O(1) for all operations
// Space Complexity : O(n) where n is the number of elements in the hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Declared Sqrt(1000000) { -> Max Input} of 2d array called buckets an initialised buckets with parent size of 1000 and none for childs. Because I will initiliase child when I try to use them. Defined two hash functions for retrieving bucket in the parent array and bucketItems in child array of that respective bucket.
// 2. Addition() of an item requires bucket and bucketItem and then we toggle it to 1 (true) to indicate it as it exists and also all initial values are 0's which can be treated as false. For maxInput = 1000000, we have handle carefully by taking 1 extra size in child array of bucket 0 as it might throw arrayoutofbounds error.
// 3. Removal() toggles it to zero and Contains() just checks if its 1 for returning true else false.

public class MyHashSet {

    int buckets[][];
    int bucketItems[];

    public MyHashSet() {
        buckets = new int[1000][];
    }

    public int getBucket(int key) {
        return key % 1000;
    }

    public int getBucketItem(int key) {
        return key / 1000;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (buckets[bucket] == null) {
            int extraSize = 0;
            if (bucket == 0)
                extraSize += 1;
            buckets[bucket] = new int[1000 + extraSize];
        }
        buckets[bucket][bucketItem] = 1;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (buckets[bucket] == null) {
            return;
        }
        buckets[bucket][bucketItem] = 0;
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (buckets[bucket] == null) {
            return false;
        }
        return buckets[bucket][bucketItem] == 1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */