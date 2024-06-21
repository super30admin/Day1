// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : This code ran successfully except for one test case where the memory exceeded because of too many inputs.
// Any problem you faced while coding this : Had to tweak the code to pass a couple of edge cases. Except for the memory exceeded case dur to too many input.


class MyHashSet {
    int buckets = 1000000;
    int bucketItems = 1000000;
    boolean[][] storage = new boolean[buckets][];
    /** Initialize your data structure here. */
    private int bucket(int key)
    {
        return key%buckets;
    }
    
    private int bucketItem(int key)
    {
        return key/buckets;
    }
    public MyHashSet() {

    }
    
    public void add(int key) {
        if(key <= 1000000) {
            int bucket = bucket(key);
            int bucketItem = bucketItem(key);
    
            if(storage[bucket]==null)
            {
                storage[bucket] = new boolean[bucketItems];  
            }
            storage[bucket][bucketItem] = true;
        }
    }
    
    public void remove(int key) {
        int bucket= bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]!=null)
        {
            storage[bucket][bucketItem] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(key <= 1000000 && storage[bucket]!=null)
        {
            return storage[bucket][bucketItem]==true; 
        }
        else
        {
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */