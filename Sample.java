// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach

class MyHashSet {

    int buckets;
    int bucketItems;
    boolean[][] storage;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    public int getBucket(int key) {
        return key % buckets;
    }

    public int getBucketItems(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][getBucketItems(key)] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] != null) {
            storage[bucket][getBucketItems(key)] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) {
            return false;
        }
        return storage[bucket][getBucketItems(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */