//Problem 1

// Time Complexity : O(1) for all add, remove, contains methods
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// using array of size 1000 for the hashset
// used double hashing to avoid collisions, first mode hash function to sort bucket,
// second division hash function to sort which position in bucket found using first hash function
class MyHashSet {
    int bucketsCount = 1000;
    int bucketSize = 1000;
    boolean[][] bucketItems;

    public MyHashSet() {
        bucketItems = new boolean[bucketsCount][];
    }

    public void add(int key) {
        int bucket = key % bucketsCount;
        if (null == bucketItems[bucket]) {
            if (bucket == 0) {
                bucketItems[bucket] = new boolean[bucketSize + 1];
            } else bucketItems[bucket] = new boolean[bucketsCount];
        }
        int bucketItem = key / bucketSize;
        bucketItems[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = key % bucketsCount;
        if (null != bucketItems[bucket]) {
            int bucketItem = key / bucketSize;
            bucketItems[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        int bucket = key % bucketsCount;
        int bucketItem = key / bucketSize;
        return (null != bucketItems[bucket]) ? bucketItems[bucket][bucketItem] : false;
    }
}