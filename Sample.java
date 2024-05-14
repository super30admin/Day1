// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.LinkedList;

/**
 * Using double hashing method for addition, removal, lookup of elements in a HashSet
 *
 * Time Complexity: O(1) (add, hash, remove, contains)
 * Space Complexity: O(n)
 */class MyHashSet {

    int bucketSize;
    int bucketItemSize;
    boolean[][] storage;

    public MyHashSet() {
        int size = (int) Math.pow(10,3);
        bucketSize = size;
        bucketItemSize = size;
        storage = new boolean[bucketSize][];
    }

    int getBucket(int key){
        return key%bucketSize;
    }

    int getBucketItem(int key){
        return key/bucketItemSize;
    }

    public void add(int key) {

        if(!contains(key)) {
            int bucket = getBucket(key);
            int bucketItem = getBucketItem(key);

            if(storage[bucket] == null){

                if(bucket == 0){
                    storage[bucket] = new boolean[bucketItemSize+1];
                }
                else{
                    storage[bucket] = new boolean[bucketItemSize];
                }
            }
            storage[bucket][bucketItem] = true;
        }

    }

    public void remove(int key) {

        if(contains(key)){

            int bucket = getBucket(key);
            int bucketItem = getBucketItem(key);

            storage[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {

        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(storage[bucket] == null || !storage[bucket][bucketItem]){
            return false;
        }

        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */