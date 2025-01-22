// Time Complexity : O(N/K) - Assuming the elements are evenly distributed, the size of the bucket is N/K.
// In the worst case, we will need to scan the entire bucket
// Space Complexity : O(K+N) - K is the number of predefined buckets , N is the no of elements to be inserted
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Given a value, first we generate a key for this value via the hash function
The generated key serves as the index to locate the bucket
Once the bucket is located, we perform insert,delete,contains
 */

class MyHashSet {
    private Bucket[] bucketArray;
    private int keyRange;

    public MyHashSet() {
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for (int i = 0; i < this.keyRange; ++i) {
            this.bucketArray[i] = new Bucket();
        }
    }

    public int generateHash(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int hashKey = generateHash(key);
        this.bucketArray[hashKey].insert(key);
    }

    public void remove(int key) {
        int hashKey = generateHash(key);
        this.bucketArray[hashKey].delete(key);
    }

    public boolean contains(int key) {
        int hashKey = generateHash(key);
        return this.bucketArray[hashKey].contains(key);
    }
}

class Bucket {
    LinkedList<Integer> container;

    Bucket() {
        container = new LinkedList<Integer>();
    }

    public void insert(Integer key) {
        int index = this.container.indexOf(key);
        if (index == -1) {
            this.container.addFirst(key);
        }
    }

    public void delete(Integer key) {
        this.container.remove(key);
    }

    public boolean contains(Integer key) {
        int index = this.container.indexOf(key);
        return index != -1;
    }
}
