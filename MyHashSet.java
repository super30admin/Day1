// Time Complexity : add - O(1), remove - O(1), contains - O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//The Hash Set is designed using double hashing with a primary array of size 1000 
//secondary array of 1000 is initialized to the particular index of primary array when needed. 

class MyHashSet {
    boolean[][] storage; 
    int buckets; // Primary Array
    int bucketItems; // Secondary Array

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        //Allocating the matrix with bucket size as we create secondary array only when required
        this.storage = new boolean[buckets][];
    }
    private int primaryHash(int key) {
        return key%buckets;
    }
    private int secondaryHash(int key) {
        return key/bucketItems;
    }
    //if calculated index is null then creates a secondary array of size 1000 at that index of primary array else sets the value to true
    public void add(int key) {
        int hash1 = primaryHash(key);
        if(storage[hash1] == null) {
            if(hash1 == 0) {
                //If primary hash results in index 0, a bucket size of 1001 is created to accommodate 1000000 value
                storage[hash1] = new boolean[bucketItems+1];
            } else {
                storage[hash1] = new boolean[bucketItems];
            }
        }
        int hash2 = secondaryHash(key);
        storage[hash1][hash2] = true;
        
    }
    //if value at calculated index is null does nothing, else sets to false 
    public void remove(int key) {
        int hash1 = primaryHash(key);
        int hash2 = secondaryHash(key);
        if(storage[hash1] == null) return;
        storage[hash1][hash2] = false;
    }
    //if value at calculated index is null returns false, else returns true
    public boolean contains(int key) {
        int hash1 = primaryHash(key);
        if(storage[hash1] == null) return false;
        int hash2 = secondaryHash(key);
        return storage[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
